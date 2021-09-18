package com.sd.model;

import java.io.Serializable;

public class Subscripion implements Serializable {
	
	private String id;
	private String subscriptionNumber;
	private int initialTerm;
	private int currentTerm;
	
	public Subscripion() {
		super();
	}
	
	public Subscripion(String id, String subscriptionNumber, int initialTerm, int currentTerm) {
		super();
		this.id = id;
		this.subscriptionNumber = subscriptionNumber;
		this.initialTerm = initialTerm;
		this.currentTerm = currentTerm;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getSubscriptionNumber() {
		return subscriptionNumber;
	}

	public void setSubscriptionNumber(String subscriptionNumber) {
		this.subscriptionNumber = subscriptionNumber;
	}

	public int getInitialTerm() {
		return initialTerm;
	}
	public void setInitialTerm(int initialTerm) {
		this.initialTerm = initialTerm;
	}
	public int getCurrentTerm() {
		return currentTerm;
	}
	public void setCurrentTerm(int currentTerm) {
		this.currentTerm = currentTerm;
	}

	
}
