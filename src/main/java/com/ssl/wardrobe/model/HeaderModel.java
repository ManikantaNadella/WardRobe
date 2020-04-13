package com.ssl.wardrobe.model;

import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "header")
public class HeaderModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pk")
	private Long pk;

	@Column(name = "creationtime", nullable = false)
	private Date creationTime;

	@Column(name = "modifiedtime", nullable = false)
	private Date modifiedTime;

	@Column(name = "memberid", nullable = false)
	private String memberId;

	@Column(name = "bitreference", nullable = false)
	private String bitReference;

	@Column(name = "offerid")
	private String offerId;

	@Column(name = "bitdate")
	private Timestamp bitDate;

	@Column(name = "bittype")
	private String bitType;

	@Column(name = "programid")
	private String programId;

	@Column(name = "sponsorid")
	private String sponsorId;

	@Column(name = "bitcategory")
	private String bitCategory;

	@Column(name = "location")
	private String location;

	@Column(name = "bitcurrency")
	private String bitCurrency;

	@Column(name = "bitsourcegeneratedid")
	private String bitSourceGeneratedId;

	@Column(name = "century")
	private String century;

	@Column(name = "posid")
	private String posId;

	@Column(name = "transactionnumber")
	private String transactionNumber;

	@Column(name = "orderconfirmationnumber")
	private String orderConfirmationNumber;

	@Column(name = "bitoriginalsourcegeneratedid")
	private String bitOriginalSourceGeneratedId;

	@Column(name = "rollovernumber")
	private String rollOverNumber;

	@Column(name = "originalbitamount")
	private String originalBitAmount;

	@Column(name = "bitamount")
	private String bitAmount;

	@Column(name = "tendertotal")
	private String tenderTotal;

	@Column(name = "payinamount")
	private String payInAmount;

	@Column(name = "poscashierid")
	private String posCashierId;

	@Column(name = "promotionid")
	private String promotionId;

	@Column(name = "customerid")
	private String customerId;

	@Column(name = "sponsor")
	private String sponsor;

	@Column(name = "locationname")
	private String locationName;

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

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getBitReference() {
		return bitReference;
	}

	public void setBitReference(String bitReference) {
		this.bitReference = bitReference;
	}

	public String getOfferId() {
		return offerId;
	}

	public void setOfferId(String offerId) {
		this.offerId = offerId;
	}

	public Timestamp getBitDate() {
		return bitDate;
	}

	public void setBitDate(Timestamp bitDate) {
		this.bitDate = bitDate;
	}

	public String getBitType() {
		return bitType;
	}

	public void setBitType(String bitType) {
		this.bitType = bitType;
	}

	public String getProgramId() {
		return programId;
	}

	public void setProgramId(String programId) {
		this.programId = programId;
	}

	public String getSponsorId() {
		return sponsorId;
	}

	public void setSponsorId(String sponsorId) {
		this.sponsorId = sponsorId;
	}

	public String getBitCategory() {
		return bitCategory;
	}

	public void setBitCategory(String bitCategory) {
		this.bitCategory = bitCategory;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getBitCurrency() {
		return bitCurrency;
	}

	public void setBitCurrency(String bitCurrency) {
		this.bitCurrency = bitCurrency;
	}

	public String getBitSourceGeneratedId() {
		return bitSourceGeneratedId;
	}

	public void setBitSourceGeneratedId(String bitSourceGeneratedId) {
		this.bitSourceGeneratedId = bitSourceGeneratedId;
	}

	public String getCentury() {
		return century;
	}

	public void setCentury(String century) {
		this.century = century;
	}

	public String getPosId() {
		return posId;
	}

	public void setPosId(String posId) {
		this.posId = posId;
	}

	public String getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

	public String getOrderConfirmationNumber() {
		return orderConfirmationNumber;
	}

	public void setOrderConfirmationNumber(String orderConfirmationNumber) {
		this.orderConfirmationNumber = orderConfirmationNumber;
	}

	public String getBitOriginalSourceGeneratedId() {
		return bitOriginalSourceGeneratedId;
	}

	public void setBitOriginalSourceGeneratedId(String bitOriginalSourceGeneratedId) {
		this.bitOriginalSourceGeneratedId = bitOriginalSourceGeneratedId;
	}

	public String getRollOverNumber() {
		return rollOverNumber;
	}

	public void setRollOverNumber(String rollOverNumber) {
		this.rollOverNumber = rollOverNumber;
	}

	public String getOriginalBitAmount() {
		return originalBitAmount;
	}

	public void setOriginalBitAmount(String originalBitAmount) {
		this.originalBitAmount = originalBitAmount;
	}

	public String getBitAmount() {
		return bitAmount;
	}

	public void setBitAmount(String bitAmount) {
		this.bitAmount = bitAmount;
	}

	public String getTenderTotal() {
		return tenderTotal;
	}

	public void setTenderTotal(String tenderTotal) {
		this.tenderTotal = tenderTotal;
	}

	public String getPayInAmount() {
		return payInAmount;
	}

	public void setPayInAmount(String payInAmount) {
		this.payInAmount = payInAmount;
	}

	public String getPosCashierId() {
		return posCashierId;
	}

	public void setPosCashierId(String posCashierId) {
		this.posCashierId = posCashierId;
	}

	public String getPromotionId() {
		return promotionId;
	}

	public void setPromotionId(String promotionId) {
		this.promotionId = promotionId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getSponsor() {
		return sponsor;
	}

	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	@Override
	public String toString() {
		return "HeaderModel [pk=" + pk + ", creationTime=" + creationTime + ", modifiedTime=" + modifiedTime
				+ ", memberId=" + memberId + ", bitReference=" + bitReference + ", offerId=" + offerId
				+ ", bitDate=" + bitDate + ", bitType=" + bitType + ", programId=" + programId + ", sponsorId="
				+ sponsorId + ", bitCategory=" + bitCategory + ", location=" + location + ", bitCurrency=" + bitCurrency
				+ ", bitSourceGeneratedId=" + bitSourceGeneratedId + ", century=" + century + ", posId=" + posId
				+ ", transactionNumber=" + transactionNumber + ", orderConfirmationNumber=" + orderConfirmationNumber
				+ ", bitOriginalSourceGeneratedId=" + bitOriginalSourceGeneratedId + ", rollOverNumber="
				+ rollOverNumber + ", originalBitAmount=" + originalBitAmount + ", bitAmount=" + bitAmount
				+ ", tenderTotal=" + tenderTotal + ", payInAmount=" + payInAmount + ", posCashierId=" + posCashierId
				+ ", promotionId=" + promotionId + ", customerId=" + customerId + ", sponsor=" + sponsor
				+ ", locationName=" + locationName + "]";
	}
}
