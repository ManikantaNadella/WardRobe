package com.ssl.waordrobe.apientities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "transactionList")
public class Transaction {

	@JsonProperty("referenceNumber")
	private String referenceNumber;

	@JsonProperty("transactionDate")
	private String transactionDate;

	@JsonProperty("transactionType")
	private String transactionType;

	@JsonProperty("location")
	private String location;

	@JsonProperty("category")
	private String category;

	@JsonProperty("transactionNumber")
	private String transactionNumber;

	@JsonProperty("sponser")
	private String sponser;

	@JsonProperty("amountWithoutTax")
	private String amountWithoutTax;

	@JsonProperty("totalAmountIncTax")
	private String totalAmountIncTax;

	@JsonProperty("productList")
	private List<Product> productList;

	@JsonProperty("payments")
	private List<Payment> payments;

	public String getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

	public String getSponser() {
		return sponser;
	}

	public void setSponser(String sponser) {
		this.sponser = sponser;
	}

	public String getAmountWithoutTax() {
		return amountWithoutTax;
	}

	public void setAmountWithoutTax(String amountWithoutTax) {
		this.amountWithoutTax = amountWithoutTax;
	}

	public String getTotalAmountIncTax() {
		return totalAmountIncTax;
	}

	public void setTotalAmountIncTax(String totalAmountIncTax) {
		this.totalAmountIncTax = totalAmountIncTax;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	@Override
	public String toString() {
		return "Transaction [referenceNumber=" + referenceNumber + ", transactionDate=" + transactionDate
				+ ", transactionType=" + transactionType + ", location=" + location + ", category=" + category
				+ ", transactionNumber=" + transactionNumber + ", sponser=" + sponser + ", amountWithoutTax="
				+ amountWithoutTax + ", totalAmountIncTax=" + totalAmountIncTax + ", productList=" + productList
				+ ", payments=" + payments + "]";
	}
	
	
}
