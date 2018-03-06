package com.taskplz.model;

import java.util.HashMap;

public class PagingParameters extends HashMap {

	/**
	 */
	
	private static final long serialVersionUID = 4919783836739504619L;

	public PagingParameters(){
		super();
		this.put("_limitOffsetRow", 0);
		this.put("_limitRowCount",  Long.MAX_VALUE);
	};
	
	public void setLimitRowCount(long value){
		this.put("_limitRowCount",  value);
	}
	public void setLimitOffsetRow(long value){
		this.put("_limitOffsetRow", value);
	}
}
