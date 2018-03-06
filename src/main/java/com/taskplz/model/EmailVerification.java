package com.taskplz.model;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;

public class EmailVerification extends EmailVerificationVO implements IModelCRUD {

	private SqlSession sqlSession;

	protected static final String mapperNS = "com.taskplz.mapper.EmailVerification.";

	@SuppressWarnings("unused")
	private EmailVerification() {
	};

	protected EmailVerification(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	};

	protected EmailVerification(SqlSession sqlSession, EmailVerificationVO vo) {
		this.sqlSession = sqlSession;
		this.copy(vo);
	};

	protected String getUUID() {
		return this.getVerificationID();
	}

	protected void setUUID(String uuid) {
		this.setVerificationID(uuid);
	}

	public void load(String verificationID) throws ModelException {
		try {
			EmailVerificationVO vo = sqlSession.selectOne(mapperNS + "select", verificationID);
			if (vo == null)
				throw new ModelException(null, "310000", "UUID로 해당 Model을 읽어드릴 수 없습니다");
			this.copy(vo);
		} catch (Throwable e) {
			throw new ModelException(e, "300000", "모르겠습니다.");
		}
	}

	public void save() throws ModelException {
		// ClientID의 Null유무로 신규 생성 여부 결정
		if (this.getVerificationID() == null) {
			// Insert
			try {
				this.setVerificationID(UUID.randomUUID().toString());
				sqlSession.insert(mapperNS + "insert", this);
			} catch (Throwable e) {
				this.setVerificationID(null);
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
			sqlSession.delete(mapperNS + "delete", this.getClientID());
		} catch (Throwable e) {
			throw new ModelException(e, "300000", "모르겠습니다.");
		}
	}
}
