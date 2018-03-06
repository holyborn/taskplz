package com.taskplz.model;

public interface IModelCRUD {
	
	public void load(String uuid) throws ModelException;
	public void save() throws ModelException;
	public void delete() throws ModelException;
}
