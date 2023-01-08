package com.example.BankingAPI.DataModelLayer;

public class ExceptionEntity 
{
	
	private String message;
	public String path;
	public String getMessage() {
		return message;
	}
	public void setMessage(String messagel) {
		this.message = messagel;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	@Override
	public String toString() {
		return "ExceptionEntity [messagel=" + message + ", path=" + path + "]";
	}

}
