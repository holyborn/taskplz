package com.taskplz.model;

import java.sql.Timestamp;

public class CommentVO extends ModelVO {
	
	private String commentID;
	private String targetID;
	private String clientID;
	private String content;
	private Timestamp createDate;
	private Timestamp modifyDate;
	private Timestamp deleteDate;
	
	public void copy(CommentVO vo) {
		this.commentID = vo.commentID;
		this.targetID = vo.targetID;
		this.clientID = vo.clientID;
		this.content = vo.content;
		this.createDate = vo.createDate;
		this.modifyDate = vo.modifyDate;
		this.deleteDate = vo.deleteDate;
	}
	public String getCommentID() {
		return commentID;
	}
	public void setCommentID(String commentID) {
		this.commentID = commentID;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
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
		return this.commentID;
	}
	@Override
	protected void setUUID(String uuid) {
		// TODO Auto-generated method stub
		this.commentID = uuid;
	}
}
