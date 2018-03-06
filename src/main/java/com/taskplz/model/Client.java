package com.taskplz.model;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;

public class Client extends ClientVO implements IModelCRUD {

	private SqlSession sqlSession;

	protected static final String mapperNS = "com.taskplz.mapper.Client.";

	@SuppressWarnings("unused")
	private Client() {
	};

	protected Client(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	};

	protected Client(SqlSession sqlSession, ClientVO clientVO) {
		this.sqlSession = sqlSession;
		this.copy(clientVO);
	};

	protected String getUUID() {
		return this.getClientID();
	}

	protected void setUUID(String uuid) {
		this.setClientID(uuid);
	}

	public void load(String clientID) throws ModelException {
		try {
			ClientVO vo = sqlSession.selectOne(mapperNS + "select", clientID);
			if (vo == null)
				throw new ModelException(null, "310000", "UUID로 해당 Model을 읽어드릴 수 없습니다");
			this.copy(vo);
		} catch (Throwable e) {
			throw new ModelException(e, "300000", "모르겠습니다.");
		}
	}

	public void save() throws ModelException {
		// ClientID의 Null유무로 신규 생성 여부 결정
		if (this.getClientID() == null) {
			// Insert
			try {
				this.setClientID(UUID.randomUUID().toString());
				sqlSession.insert(mapperNS + "signup", this);
			} catch (Throwable e) {
				this.setClientID(null);
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
	// Object Appender
	public EmailVerification appendEmailVerification(){
		EmailVerification ver = new EmailVerification(sqlSession);
		ver.setClientID(this.getClientID());
		return ver;
	}

	public PhoneVerification appendPhoneVerification(){
		PhoneVerification ver = new PhoneVerification(sqlSession);
		ver.setClientID(this.getClientID());
		return ver;
	}

	public ClientPicture appendClientPicture(){
		ClientPicture picture = new ClientPicture(sqlSession);
		picture.setParentID(this.getClientID());
		return picture;
	}
	
	// Object Getter
	// 이메일 인증정보
	public EmailVerification getEmailVerification() throws ModelException{
		EmailVerification ver = new EmailVerification(sqlSession);
		EmailVerificationVO clientInfo = new EmailVerificationVO();
		clientInfo.setClientID(this.getClientID());
		try {
			clientInfo = sqlSession.selectOne(EmailVerification.mapperNS + "selectByClientID", clientInfo);
			if(clientInfo != null)
				ver.copy(clientInfo);
			else
				ver = null;
		} catch (Throwable e) {
			throw new ModelException(e, "300010", "인증 정보 로드 실패");
		}
		return ver;
	}
	// 휴대폰 인증정보
	public PhoneVerification getPhoneVerification() throws ModelException{
		PhoneVerification ver = new PhoneVerification(sqlSession);
		PhoneVerificationVO clientInfo = new PhoneVerificationVO();
		clientInfo.setClientID(this.getClientID());
		try {
			clientInfo = sqlSession.selectOne(PhoneVerification.mapperNS + "selectByClientID", clientInfo);
			if(clientInfo != null)
				ver.copy(clientInfo);
			else
				ver = null;
		} catch (Throwable e) {
			throw new ModelException(e, "300010", "인증 정보 로드 실패");
		}
		return ver;
	}

	public ClientPicture getClientPicture() throws ModelException{
		ClientPicture picture = new ClientPicture(sqlSession);
		FileVO pictureVO = new FileVO();
		pictureVO.setParentID(this.getClientID());
		pictureVO = sqlSession.selectOne(ClientPicture.mapperNS + "selectByClientID", pictureVO);

		try {
			if(pictureVO != null)
				picture.copy(pictureVO);
			else
				picture = null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return picture;
	}
	
	// Bringer
}
