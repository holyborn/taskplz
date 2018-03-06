package com.taskplz.model;

public class ModelException extends Exception {
	private static final long serialVersionUID = 7348705084926217604L;
	public String errorCode = null;
	public String errorMessage = null;

	public ModelException(Throwable arg0) {
		super(arg0);
	}
	public ModelException(Throwable arg0, String errorCode) {
		super(arg0);
		this.errorCode = errorCode;
	}
	public ModelException(Throwable arg0, String errorCode, String errorMessage) {
		super(arg0);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
}
