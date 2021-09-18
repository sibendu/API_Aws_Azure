package com.sd.model;

import java.io.Serializable;

public class PriceTier implements Serializable {

	private Integer tier;
	private Double startingUnit;
	private Double endingUnit;
	private Double price;
	private String priceFormat;
	
	public PriceTier() {
		super();
	}
	
	public PriceTier(Integer tier, Double startingUnit, Double endingUnit, Double price, String priceFormat) {
		super();
		this.tier = tier;
		this.startingUnit = startingUnit;
		this.endingUnit = endingUnit;
		this.price = price;
		this.priceFormat = priceFormat;
	}
	public Integer getTier() {
		return tier;
	}
	public void setTier(Integer tier) {
		this.tier = tier;
	}
	public Double getStartingUnit() {
		return startingUnit;
	}
	public void setStartingUnit(Double startingUnit) {
		this.startingUnit = startingUnit;
	}
	public Double getEndingUnit() {
		return endingUnit;
	}
	public void setEndingUnit(Double endingUnit) {
		this.endingUnit = endingUnit;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getPriceFormat() {
		return priceFormat;
	}
	public void setPriceFormat(String priceFormat) {
		this.priceFormat = priceFormat;
	}
	
	
}
