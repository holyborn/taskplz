package com.taskplz.model;

public class FileVO extends ModelVO {
	
	private String fileID;
	private String parentID;
	private String filePath;
	
	public void copy(FileVO vo) {
		this.fileID = vo.fileID;
		this.parentID = vo.parentID;
		this.filePath = vo.filePath;
	}

	public String getFileID() {
		return fileID;
	}

	public void setFileID(String fileID) {
		this.fileID = fileID;
	}

	public String getParentID() {
		return parentID;
	}

	public void setParentID(String parentID) {
		this.parentID = parentID;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	@Override
	protected String getUUID() {
		// TODO Auto-generated method stub
		return this.fileID;
	}
	@Override
	protected void setUUID(String uuid) {
		// TODO Auto-generated method stub
		this.fileID = uuid;
	}
}
