package com.sd.model;

import java.io.Serializable;

public class RatePlanList implements Serializable {
	
	private RatePlan[] productRatePlans;
	
	public RatePlanList() {
		super();
	}

	public RatePlanList(RatePlan[] records) {
		super();
		this.productRatePlans = records;
	}

	public RatePlan[] getProductRatePlans() {
		return productRatePlans;
	}

	public void setProductRatePlans(RatePlan[] productRatePlans) {
		this.productRatePlans = productRatePlans;
	}

	
	
	
	
}
