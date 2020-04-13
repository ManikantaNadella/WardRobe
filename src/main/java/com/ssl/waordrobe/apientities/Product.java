package com.ssl.waordrobe.apientities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "productList")
public class Product {

	@JsonProperty("id")
	private String id;

	@JsonProperty("title")
	private String title;

	@JsonProperty("brandName")
	private String brandName;

	@JsonProperty("imageURL")
	private String imageURL;

	@JsonProperty("PDPUrl")
	private String pdpUrl;

	@JsonProperty("quantity")
	private String quantity;

	@JsonProperty("regualrPrice")
	private String regualrPrice;

	@JsonProperty("actualPrice")
	private String actualPrice;

	@JsonProperty("extendedPrice")
	private String extendedPrice;

	@JsonProperty("departmentCode")
	private String departmentCode;

	@JsonProperty("subDepartmentCode")
	private String subDepartmentCode;

	@JsonProperty("promotionCode")
	private String promotionCode;

	@JsonProperty("promotionAmount")
	private String promotionAmount;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getPdpUrl() {
		return pdpUrl;
	}

	public void setPdpUrl(String pdpUrl) {
		this.pdpUrl = pdpUrl;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getRegualrPrice() {
		return regualrPrice;
	}

	public void setRegualrPrice(String regualrPrice) {
		this.regualrPrice = regualrPrice;
	}

	public String getActualPrice() {
		return actualPrice;
	}

	public void setActualPrice(String actualPrice) {
		this.actualPrice = actualPrice;
	}

	public String getExtendedPrice() {
		return extendedPrice;
	}

	public void setExtendedPrice(String extendedPrice) {
		this.extendedPrice = extendedPrice;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getSubDepartmentCode() {
		return subDepartmentCode;
	}

	public void setSubDepartmentCode(String subDepartmentCode) {
		this.subDepartmentCode = subDepartmentCode;
	}

	public String getPromotionCode() {
		return promotionCode;
	}

	public void setPromotionCode(String promotionCode) {
		this.promotionCode = promotionCode;
	}

	public String getPromotionAmount() {
		return promotionAmount;
	}

	public void setPromotionAmount(String promotionAmount) {
		this.promotionAmount = promotionAmount;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", brandName=" + brandName + ", imageURL=" + imageURL
				+ ", pdpUrl=" + pdpUrl + ", quantity=" + quantity + ", regualrPrice=" + regualrPrice + ", actualPrice="
				+ actualPrice + ", extendedPrice=" + extendedPrice + ", departmentCode=" + departmentCode
				+ ", subDepartmentCode=" + subDepartmentCode + ", promotionCode=" + promotionCode + ", promotionAmount="
				+ promotionAmount + "]";
	}

}
