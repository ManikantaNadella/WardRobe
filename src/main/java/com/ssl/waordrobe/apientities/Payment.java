package com.ssl.waordrobe.apientities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "payments")
public class Payment {

	@JsonProperty("sequenceNumber")
	private String sequenceNumber;

	@JsonProperty("tenderType")
	private String tenderType;

	@JsonProperty("amount")
	private String amount;

	public String getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(String sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public String getTenderType() {
		return tenderType;
	}

	public void setTenderType(String tenderType) {
		this.tenderType = tenderType;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Payment [sequenceNumber=" + sequenceNumber + ", tenderType=" + tenderType + ", amount=" + amount + "]";
	}

}
