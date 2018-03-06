package com.taskplz.model;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;

public class QuestionLike extends LikeVO implements IModelCRUD {

	private SqlSession sqlSession;

	protected static final String mapperNS = "com.taskplz.mapper.QuestionLike.";

	@SuppressWarnings("unused")
	private QuestionLike() {
	};

	protected QuestionLike(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	};

	protected QuestionLike(SqlSession sqlSession, LikeVO vo) {
		this.sqlSession = sqlSession;
		this.copy(vo);
	};

	protected String getUUID() {
		return this.getLikeID();
	}

	protected void setUUID(String uuid) {
		this.setLikeID(uuid);
	}

	public void load(String LikeID) throws ModelException {
		try {
			LikeVO vo = sqlSession.selectOne(mapperNS + "select", LikeID);
			if (vo == null)
				throw new ModelException(null, "310000", "UUID로 해당 Model을 읽어드릴 수 없습니다");
			this.copy(vo);
		} catch (Throwable e) {
			throw new ModelException(e, "300000", "모르겠습니다.");
		}
	}

	public void save() throws ModelException {
		// ClientID의 Null유무로 신규 생성 여부 결정
		if (this.getLikeID() == null) {
			// Insert
			try {
				this.setLikeID(UUID.randomUUID().toString());
				sqlSession.insert(mapperNS + "insert", this);
			} catch (Throwable e) {
				this.setLikeID(null);
				throw new ModelException(e, "300000", "모르겠습니다.");
			}
		} else {
			// Update
			try {
				sqlSession.update(mapperNS + "update", this);
			} catch (Throwable e) {
				throw new ModelException(e, "300000", "모르겠습니다.");
			}
		}
	}

	public void delete() throws ModelException {
		try {
			sqlSession.delete(mapperNS + "delete", this.getLikeID());
		} catch (Throwable e) {
			throw new ModelException(e, "300000", "모르겠습니다.");
		}
	}
}
