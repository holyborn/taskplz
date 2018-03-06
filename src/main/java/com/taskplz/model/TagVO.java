package com.taskplz.model;

import java.sql.Timestamp;

public class TagVO extends ModelVO {
	
	private String tagID;
	private String parentID;
	private String type;
	private String tag;
	
	public void copy(TagVO vo) {
		this.tagID = vo.tagID;
		this.parentID = vo.parentID;
		this.type = vo.type;
		this.tag = vo.tag;
	}
	
	public String getTagID() {
		return tagID;
	}

	public void setTagID(String tagID) {
		this.tagID = tagID;
	}

	public String getParentID() {
		return parentID;
	}

	public void setParentID(String parentID) {
		this.parentID = parentID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	@Override
	protected String getUUID() {
		// TODO Auto-generated method stub
		return this.tagID;
	}
	@Override
	protected void setUUID(String uuid) {
		// TODO Auto-generated method stub
		this.tagID = uuid;
	}
}
