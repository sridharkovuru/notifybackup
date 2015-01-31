package com.notify.model;

import java.io.Serializable;

public class JsonResponseModel implements Serializable{ 
	private static final long serialVersionUID = -7788619177798333712L;
	
	private String status;
	private String message;
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
