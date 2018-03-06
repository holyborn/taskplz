package com.taskplz.model;

import java.sql.Timestamp;

public class ClientVO extends ModelVO {
	
	private String clientID;
	private String email;
	private String password;
	private String nickname;
	private String introduce;
	private String majorDescription;
	private int averageAnswerTime;
	private int cash;
	private String origin;
	private Timestamp joinDate;
	private Timestamp loginDate;
	private Timestamp modifyDate;
	private Timestamp deleteDate;
	
	public void copy(ClientVO vo) {
		this.clientID = vo.clientID;
		this.email = vo.email;
		this.password = vo.password;
		this.nickname = vo.nickname;
		this.introduce = vo.introduce;
		this.majorDescription = vo.majorDescription;
		this.averageAnswerTime = vo.averageAnswerTime;
		this.cash = vo.cash;
		this.origin = vo.origin;
		this.joinDate = vo.joinDate;
		this.loginDate = vo.loginDate;
		this.modifyDate = vo.modifyDate;
		this.deleteDate = vo.deleteDate;
	}
	
	public String getClientID() {
		return clientID;
	}
	public void setClientID(String clientID) {
		this.clientID = clientID;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getMajorDescription() {
		return majorDescription;
	}
	public void setMajorDescription(String majorDescription) {
		this.majorDescription = majorDescription;
	}
	public int getAverageAnswerTime() {
		return averageAnswerTime;
	}
	public void setAverageAnswerTime(int averageAnswerTime) {
		this.averageAnswerTime = averageAnswerTime;
	}
	public int getCash() {
		return cash;
	}
	public void setCash(int cash) {
		this.cash = cash;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public Timestamp getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Timestamp joinDate) {
		this.joinDate = joinDate;
	}
	public Timestamp getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(Timestamp loginDate) {
		this.loginDate = loginDate;
	}
	public Timestamp getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}
	public Timestamp getDeleteDate() {
		return deleteDate;
	}
	public void setDeleteDate(Timestamp deleteDate) {
		this.deleteDate = deleteDate;
	}

	@Override
	protected String getUUID() {
		// TODO Auto-generated method stub
		return this.clientID;
	}
	@Override
	protected void setUUID(String uuid) {
		// TODO Auto-generated method stub
		this.clientID = uuid;
	}
}
