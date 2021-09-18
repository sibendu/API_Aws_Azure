package com.sd.model;

import java.io.Serializable;

public class ProductQuery implements Serializable {
	
	private String queryString;

	public String getQueryString() {
		return queryString;
	}

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}

	public ProductQuery(String queryString) {
		super();
		this.queryString = queryString;
	}
	
	public ProductQuery() {
		super();
	}
	
}
