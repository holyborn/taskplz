package com.taskplz.model;

import java.sql.Timestamp;

public class QuestionVO extends ModelVO {
	
	private String questionID;
	private String clientID;
	private String taplerID;
	private String title;
	private String description;
	private String caution;
	private String expectedForm;
	private int reword;
	private String status;
	private String questionConfirmed;
	private String profileHidden;
	private String questionHidden;
	private Timestamp dueDate;
	private Timestamp createDate;
	private Timestamp modifyDate;
	private Timestamp deleteDate;
	
	
	public void copy(QuestionVO vo) {
		this.questionID = vo.questionID;
		this.clientID = vo.clientID;
		this.taplerID = vo.taplerID;
		this.title = vo.title;
		this.description = vo.description;
		this.caution = vo.caution;
		this.expectedForm = vo.expectedForm;
		this.reword = vo.reword;
		this.status = vo.status;
		this.questionConfirmed = vo.questionConfirmed;
		this.profileHidden = vo.profileHidden;
		this.questionHidden = vo.questionHidden;
		this.dueDate = vo.dueDate;
		this.createDate = vo.createDate;
		this.modifyDate = vo.modifyDate;
		this.deleteDate = vo.deleteDate;
	}
	
	public String getQuestionID() {
		return questionID;
	}

	public void setQuestionID(String questionID) {
		this.questionID = questionID;
	}

	public String getClientID() {
		return clientID;
	}

	public void setClientID(String clientID) {
		this.clientID = clientID;
	}

	public String getTaplerID() {
		return taplerID;
	}

	public void setTaplerID(String taplerID) {
		this.taplerID = taplerID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCaution() {
		return caution;
	}

	public void setCaution(String caution) {
		this.caution = caution;
	}

	public String getExpectedForm() {
		return expectedForm;
	}

	public void setExpectedForm(String expectedForm) {
		this.expectedForm = expectedForm;
	}

	public int getReword() {
		return reword;
	}

	public void setReword(int reword) {
		this.reword = reword;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getQuestionConfirmed() {
		return questionConfirmed;
	}

	public void setQuestionConfirmed(String questionConfirmed) {
		this.questionConfirmed = questionConfirmed;
	}

	public String getProfileHidden() {
		return profileHidden;
	}

	public void setProfileHidden(String profileHidden) {
		this.profileHidden = profileHidden;
	}

	public String getQuestionHidden() {
		return questionHidden;
	}

	public void setQuestionHidden(String questionHidden) {
		this.questionHidden = questionHidden;
	}

	public Timestamp getDueDate() {
		return dueDate;
	}

	public void setDueDate(Timestamp dueDate) {
		this.dueDate = dueDate;
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
		return this.questionID;
	}
	@Override
	protected void setUUID(String uuid) {
		// TODO Auto-generated method stub
		this.questionID = uuid;
	}
}
