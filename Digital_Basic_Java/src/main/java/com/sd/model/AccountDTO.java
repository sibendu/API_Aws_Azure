package com.sd.model;

import java.io.Serializable;

public class AccountDTO implements Serializable {
	private String id;
	private String number;
	
	public AccountDTO() {
		super();
	}
	
	
	public AccountDTO(String id, String number) {
		super();
		this.id = id;
		this.number = number;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	
}
