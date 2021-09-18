package com.sd.model;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class Product implements Serializable {		
			
	@SerializedName("Id")
	private String id;
	
	@SerializedName(value = "Name")
	private String name;
	
	@SerializedName("Category")
	private String category;
	
	@SerializedName("Description")
	private String description;
	
	@SerializedName("SKU")
	private String sku;
	
	@SerializedName("CreatedById")
	private String createdById;
	
	@SerializedName("CreatedDate")
	private String createdDate;
	
	@SerializedName("UpdatedById")
	private String updatedById;
	
	@SerializedName("UpdatedDate")
	private String updatedDate;
	
	@SerializedName("EffectiveStartDate")
	private String effectiveStartDate;
	
	@SerializedName("EffectiveEndDate")
	private String effectiveEndDate;
	
	@SerializedName("AppName__c")
	private String appName;
	
	@SerializedName("SellerAccountNumber__c")
	private String sellerAccountNumber;
	
	@SerializedName("Type__c")
	private String type;
	
	@SerializedName("DealType__c")
	private String dealType;
	
	@SerializedName("AppKeyFeatures__c")
	private String appKeyFeatures;
	
	@SerializedName("AppRegulatoryStatus__c")
	private String appRegulatoryStatus;
	
	@SerializedName("AppTerms__c")
	private String appTerms;
	
	@SerializedName("AppSupport__c")
	private String appSupport;
	
	@SerializedName("AppTraining__c")
	private String appTraining;
	
	public Product() {
		super();
	}

	public Product(String id, String name, String category, String description, String sku, String createdById,
			String createdDate, String updatedById, String updatedDate, String effectiveStartDate,
			String effectiveEndDate, String appName, String sellerAccountNumber, String type, String dealType,
			String appKeyFeatures, String appRegulatoryStatus, String appTerms, String appSupport, String appTraining) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.description = description;
		this.sku = sku;
		this.createdById = createdById;
		this.createdDate = createdDate;
		this.updatedById = updatedById;
		this.updatedDate = updatedDate;
		this.effectiveStartDate = effectiveStartDate;
		this.effectiveEndDate = effectiveEndDate;
		this.appName = appName;
		this.sellerAccountNumber = sellerAccountNumber;
		this.type = type;
		this.dealType = dealType;
		this.appKeyFeatures = appKeyFeatures;
		this.appRegulatoryStatus = appRegulatoryStatus;
		this.appTerms = appTerms;
		this.appSupport = appSupport;
		this.appTraining = appTraining;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getCreatedById() {
		return createdById;
	}

	public void setCreatedById(String createdById) {
		this.createdById = createdById;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedById() {
		return updatedById;
	}

	public void setUpdatedById(String updatedById) {
		this.updatedById = updatedById;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getEffectiveStartDate() {
		return effectiveStartDate;
	}

	public void setEffectiveStartDate(String effectiveStartDate) {
		this.effectiveStartDate = effectiveStartDate;
	}

	public String getEffectiveEndDate() {
		return effectiveEndDate;
	}

	public void setEffectiveEndDate(String effectiveEndDate) {
		this.effectiveEndDate = effectiveEndDate;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getSellerAccountNumber() {
		return sellerAccountNumber;
	}

	public void setSellerAccountNumber(String sellerAccountNumber) {
		this.sellerAccountNumber = sellerAccountNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDealType() {
		return dealType;
	}

	public void setDealType(String dealType) {
		this.dealType = dealType;
	}

	public String getAppKeyFeatures() {
		return appKeyFeatures;
	}

	public void setAppKeyFeatures(String appKeyFeatures) {
		this.appKeyFeatures = appKeyFeatures;
	}

	public String getAppRegulatoryStatus() {
		return appRegulatoryStatus;
	}

	public void setAppRegulatoryStatus(String appRegulatoryStatus) {
		this.appRegulatoryStatus = appRegulatoryStatus;
	}

	public String getAppTerms() {
		return appTerms;
	}

	public void setAppTerms(String appTerms) {
		this.appTerms = appTerms;
	}

	public String getAppSupport() {
		return appSupport;
	}

	public void setAppSupport(String appSupport) {
		this.appSupport = appSupport;
	}

	public String getAppTraining() {
		return appTraining;
	}

	public void setAppTraining(String appTraining) {
		this.appTraining = appTraining;
	}
}
