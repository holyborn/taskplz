package com.taskplz.model;

public abstract class ModelVO {
	/**
	 * 20180213이찬영
	 * UUID를 이용하기 위한 기본 Method
	 */
	
	abstract protected String getUUID();
	abstract protected void setUUID(String uuid);
}
