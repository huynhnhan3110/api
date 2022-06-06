package com.springAPI.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFound extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	private String resourceName;
	private String fieldName;
	private Object valueName;
	public ResourceNotFound(String resourceName, String fieldName, Object valueName) {
		super(String.format("%s not found with %s : '%s'", resourceName, fieldName, valueName));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.valueName = valueName;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public Object getValueName() {
		return valueName;
	}
	public void setValueName(Object valueName) {
		this.valueName = valueName;
	}
	
	

}
