package com.taskplz.model;

import java.sql.Timestamp;

public class PhoneVerificationVO extends ModelVO {
	
	private String verificationID;
	private String clientID;
	private Timestamp verDate;
	private String name;
	private String phone;
	private String birthday;
	private String gender;
	
	public void copy(PhoneVerificationVO vo) {
		this.verificationID = vo.verificationID;
		this.clientID = vo.clientID;
		this.verDate = vo.verDate;
		this.name = vo.name;
		this.phone = vo.phone;
		this.birthday = vo.birthday;
		this.gender = vo.gender;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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
