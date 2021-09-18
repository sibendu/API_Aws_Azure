package com.sd.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RatePlan implements Serializable {

    private String id;
    private String status;
    private String name;
    private String description;
    
    @JsonProperty("AutoRenew__c")
    private String autoRenew;
    
    @JsonProperty("InitialTerm__c")
    private int initialTerm;

    @JsonProperty("productRatePlanCharges")
    private RatePlanCharge[] productRatePlanCharges;
    
    public RatePlan() {
		super();
	}
    
	public RatePlan(String id, String status, String name, String description, String autoRenew,
			int initialTerm) {
		super();
		this.id = id;
		this.status = status;
		this.name = name;
		this.description = description;
		this.autoRenew = autoRenew;
		this.initialTerm = initialTerm;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAutoRenew() {
		return autoRenew;
	}

	public void setAutoRenew(String autoRenew) {
		this.autoRenew = autoRenew;
	}

	public int getInitialTerm() {
		return initialTerm;
	}

	public void setInitialTerm(int initialTerm) {
		this.initialTerm = initialTerm;
	}
    
    
    
}
