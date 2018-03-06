package com.taskplz.model;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;

public class QuestionDescriptionFile extends FileVO implements IModelCRUD {

	private SqlSession sqlSession;

	protected static final String mapperNS = "com.taskplz.mapper.QuestionDescriptionFile.";

	@SuppressWarnings("unused")
	private QuestionDescriptionFile() {
	};

	protected QuestionDescriptionFile(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	};

	protected QuestionDescriptionFile(SqlSession sqlSession, FileVO FileVO) {
		this.sqlSession = sqlSession;
		this.copy(FileVO);
	};

	protected String getUUID() {
		return this.getFileID();
	}

	protected void setUUID(String uuid) {
		this.setFileID(uuid);
	}

	public void load(String fileID) throws ModelException {
		try {
			FileVO vo = sqlSession.selectOne(mapperNS + "select", fileID);
			if (vo == null)
				throw new ModelException(null, "310000", "UUID로 해당 Model을 읽어드릴 수 없습니다");
			this.copy(vo);
		} catch (Throwable e) {
			throw new ModelException(e, "300000", "모르겠습니다.");
		}
	}

	public void save() throws ModelException {
		// ClientID의 Null유무로 신규 생성 여부 결정
		if (this.getFileID() == null) {
			// Insert
			try {
				this.setFileID(UUID.randomUUID().toString());
				sqlSession.insert(mapperNS + "insert", this);
			} catch (Throwable e) {
				this.setFileID(null);
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
			sqlSession.delete(mapperNS + "delete", this);
		} catch (Throwable e) {
			throw new ModelException(e, "300000", "모르겠습니다.");
		}
	}
}
