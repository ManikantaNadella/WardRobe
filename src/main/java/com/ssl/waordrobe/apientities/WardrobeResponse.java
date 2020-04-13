package com.ssl.waordrobe.apientities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WardrobeResponse {

	@JsonProperty("responseCode")
	private String responseCode;
	
	@JsonProperty("responseMessage")
	private String responseMessage;
	
	@JsonProperty("customerID")
	private String customerID;
	
	@JsonProperty("transactionList")
	private List<Transaction> transactionList;
	
	@JsonProperty("offset")
	private String offset;
	
	@JsonProperty("count")
	private String count;
	
	@JsonProperty("totalCount")
	private String totalCount;

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public List<Transaction> getTransactionList() {
		return transactionList;
	}

	public void setTransactionList(List<Transaction> transactionList) {
		this.transactionList = transactionList;
	}

	public String getOffset() {
		return offset;
	}

	public void setOffset(String offset) {
		this.offset = offset;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}

	@Override
	public String toString() {
		return "WardrobeResponse [responseCode=" + responseCode + ", responseMessage=" + responseMessage
				+ ", customerID=" + customerID + ", transactionList=" + transactionList + ", offset=" + offset
				+ ", count=" + count + ", totalCount=" + totalCount + "]";
	}
	

}
