package com.taskplz.model;

public class NotifyVO extends ModelVO {
	
	private String exampleID;
	
	public void copy(NotifyVO vo) {
		this.exampleID = vo.exampleID;
	}
	
	public String getExampleID() {
		return exampleID;
	}

	public void setExampleID(String exampleID) {
		this.exampleID = exampleID;
	}

	@Override
	protected String getUUID() {
		// TODO Auto-generated method stub
		return this.exampleID;
	}
	@Override
	protected void setUUID(String uuid) {
		// TODO Auto-generated method stub
		this.exampleID = uuid;
	}
}