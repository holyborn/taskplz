package com.taskplz.model;

import java.sql.Timestamp;

public class LikeVO extends ModelVO {
	
	private String likeID;
	private String targetID;
	private String clientID;
	private Timestamp likeDate;
	
	public void copy(LikeVO vo) {
		this.likeID = vo.likeID;
		this.targetID = vo.targetID;
		this.clientID = vo.clientID;
		this.likeDate = vo.likeDate;
	}

	public String getLikeID() {
		return likeID;
	}

	public void setLikeID(String likeID) {
		this.likeID = likeID;
	}

	public String getTargetID() {
		return targetID;
	}

	public void setTargetID(String targetID) {
		this.targetID = targetID;
	}

	public String getClientID() {
		return clientID;
	}

	public void setClientID(String clientID) {
		this.clientID = clientID;
	}

	public Timestamp getLikeDate() {
		return likeDate;
	}

	public void setLikeDate(Timestamp likeDate) {
		this.likeDate = likeDate;
	}

	@Override
	protected String getUUID() {
		// TODO Auto-generated method stub
		return this.likeID;
	}
	@Override
	protected void setUUID(String uuid) {
		// TODO Auto-generated method stub
		this.likeID = uuid;
	}
}
