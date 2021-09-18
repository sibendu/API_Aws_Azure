package com.sd.model;

import java.io.Serializable;

public class PricingModel implements Serializable {
	private String currency;
	private Double price;
	private Double includedUnits;
	private Double overagePrice;
	private Double discountPercentage;
	private Double discountAmount;
	private PriceTier[] tiers;
	
	public PricingModel() {
		super();
	}
	
	public PricingModel(String currency, Double price, Double includedUnits, Double overagePrice,
			Double discountPercentage, Double discountAmount, PriceTier[] tiers) {
		super();
		this.currency = currency;
		this.price = price;
		this.includedUnits = includedUnits;
		this.overagePrice = overagePrice;
		this.discountPercentage = discountPercentage;
		this.discountAmount = discountAmount;
		this.tiers = tiers;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getIncludedUnits() {
		return includedUnits;
	}
	public void setIncludedUnits(Double includedUnits) {
		this.includedUnits = includedUnits;
	}
	public Double getOveragePrice() {
		return overagePrice;
	}
	public void setOveragePrice(Double overagePrice) {
		this.overagePrice = overagePrice;
	}
	public Double getDiscountPercentage() {
		return discountPercentage;
	}
	public void setDiscountPercentage(Double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	public Double getDiscountAmount() {
		return discountAmount;
	}
	public void setDiscountAmount(Double discountAmount) {
		this.discountAmount = discountAmount;
	}
	public PriceTier[] getTiers() {
		return tiers;
	}
	public void setTiers(PriceTier[] tiers) {
		this.tiers = tiers;
	}
	
	
}
