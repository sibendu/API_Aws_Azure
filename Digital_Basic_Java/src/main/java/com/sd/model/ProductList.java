package com.sd.model;

import java.io.Serializable;

public class ProductList implements Serializable {
	
	private Product[] records;
	
	public ProductList() {
		super();
	}

	public ProductList(Product[] records) {
		super();
		this.records = records;
	}

	public Product[] getRecords() {
		return records;
	}

	public void setRecords(Product[] records) {
		this.records = records;
	}
	
	
	
}
