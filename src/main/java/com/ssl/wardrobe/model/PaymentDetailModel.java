package com.ssl.wardrobe.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "paymentdetail")
public class PaymentDetailModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pk")
	private Long pk;

	@Column(name = "creationtime", nullable = false)
	private Date creationTime;

	@Column(name = "modifiedtime", nullable = false)
	private Date modifiedTime;

	@Column(name = "bitreference", nullable = false)
	private String bitReference;

	@Column(name = "memeberid", nullable = false)
	private String memberid;
	
	@Column(name = "sequence")
	private String sequence;
	
	@Column(name = "tendertype")
	private String tenderType;
	
	@Column(name = "amount")
	private String amount;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "discount")
	private String discount;
	
	@Column(name = "unitamount")
	private String unitAmount;

	public Long getPk() {
		return pk;
	}

	public void setPk(Long pk) {
		this.pk = pk;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Date getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public String getBitReference() {
		return bitReference;
	}

	public void setBitReference(String bitReference) {
		this.bitReference = bitReference;
	}

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getUnitAmount() {
		return unitAmount;
	}

	public void setUnitAmount(String unitAmount) {
		this.unitAmount = unitAmount;
	}

	@Override
	public String toString() {
		return "PaymentDetailModel [pk=" + pk + ", creationTime=" + creationTime + ", modifiedTime=" + modifiedTime
				+ ", bitReference=" + bitReference + ", memberid=" + memberid + ", sequence=" + sequence
				+ ", tenderType=" + tenderType + ", amount=" + amount + ", code=" + code + ", discount=" + discount
				+ ", unitAmount=" + unitAmount + "]";
	}
	
	
	
}
