package com;

import java.io.Serializable;

public class Customer implements Serializable{
	
	private String name;
	private int age;
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Customer() {
		
	}
	
	public Customer(String name, int age) {
		this.name=name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}

