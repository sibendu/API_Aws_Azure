package com.sd.model;

import java.io.Serializable;

public class RatePlanCharge implements Serializable {
	private String id;
	private String name;
	private String type;
	private String model;
	private String uom;
	private PricingModel[] pricing;
	
	public RatePlanCharge() {
		super();
	}
	
	public RatePlanCharge(String id, String name, String type, String model, String uom,PricingModel[] pricing) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.model = model;
		this.uom = uom;
		this.pricing=pricing;
	}
	public PricingModel[] getPricing() {
		return pricing;
	}

	public void setPricing(PricingModel[] pricing) {
		this.pricing = pricing;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getUom() {
		return uom;
	}
	public void setUom(String uom) {
		this.uom = uom;
	}
	
	
}
