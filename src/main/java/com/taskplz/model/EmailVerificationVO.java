package com.taskplz.model;

import java.sql.Timestamp;

public class EmailVerificationVO extends ModelVO {
	
	private String verificationID;
	private String clientID;
	private Timestamp verDate;
	private String hashNumber;
	private String verified;
	
	public void copy(EmailVerificationVO vo) {
		this.verificationID = vo.verificationID;
		this.clientID = vo.clientID;
		this.verDate = vo.verDate;
		this.hashNumber = vo.hashNumber;
		this.verified = vo.verified;
	}
	
	public String getVerificationID() {
		return verificationID;
	}

	public void setVerificationID(String verificationID) {
		this.verificationID = verificationID;
	}

	public String getClientID() {
		return clientID;
	}

	public void setClientID(String clientID) {
		this.clientID = clientID;
	}

	public Timestamp getVerDate() {
		return verDate;
	}

	public void setVerDate(Timestamp verDate) {
		this.verDate = verDate;
	}

	public String getHashNumber() {
		return hashNumber;
	}


	public void setHashNumber(String hashNumber) {
		this.hashNumber = hashNumber;
	}


	public String getVerified() {
		return verified;
	}


	public void setVerified(String verified) {
		this.verified = verified;
	}


	@Override
	protected String getUUID() {
		// TODO Auto-generated method stub
		return this.verificationID;
	}
	@Override
	protected void setUUID(String uuid) {
		// TODO Auto-generated method stub
		this.verificationID = uuid;
	}
}
