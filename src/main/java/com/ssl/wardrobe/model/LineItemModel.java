package com.ssl.wardrobe.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lineitem")
public class LineItemModel {
	
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

	@Column(name = "status")
	private String status;

	@Column(name = "type")
	private String type;

	@Column(name = "externalproductid")
	private String externalProductId;

	@Column(name = "quantity")
	private String quantity;

	@Column(name = "regularunitprice")
	private String regularUnitPrice;

	@Column(name = "actualunitprice")
	private String actualUnitPrice;

	@Column(name = "extendedamount")
	private String extendedAmount;

	@Column(name = "linetax")
	private String lineTax;

	@Column(name = "departmentcode")
	private String departmentCode;

	@Column(name = "subdepartmentcodeclasscode")
	private String subDepartmentCodeClassCode;

	@Column(name = "subclasscode")
	private String subClassCode;

	@Column(name = "promotionid")
	private String promotionId;

	@Column(name = "promotioninfo")
	private String promotionInfo;

	@Column(name = "promotionamount")
	private String promotionAmount;

	@Column(name = "promotionreasoncode")
	private String promotionReasonCode;

	@Column(name = "linediscount")
	private String lineDiscount;

	@Column(name = "discountcode")
	private String discountCode;

	@Column(name = "discountreasontype")
	private String discountReasonType;

	@Column(name = "disountreason")
	private String disountReason;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getExternalProductId() {
		return externalProductId;
	}

	public void setExternalProductId(String externalProductId) {
		this.externalProductId = externalProductId;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getRegularUnitPrice() {
		return regularUnitPrice;
	}

	public void setRegularUnitPrice(String regularUnitPrice) {
		this.regularUnitPrice = regularUnitPrice;
	}

	public String getActualUnitPrice() {
		return actualUnitPrice;
	}

	public void setActualUnitPrice(String actualUnitPrice) {
		this.actualUnitPrice = actualUnitPrice;
	}

	public String getExtendedAmount() {
		return extendedAmount;
	}

	public void setExtendedAmount(String extendedAmount) {
		this.extendedAmount = extendedAmount;
	}

	public String getLineTax() {
		return lineTax;
	}

	public void setLineTax(String lineTax) {
		this.lineTax = lineTax;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getSubDepartmentCodeClassCode() {
		return subDepartmentCodeClassCode;
	}

	public void setSubDepartmentCodeClassCode(String subDepartmentCodeClassCode) {
		this.subDepartmentCodeClassCode = subDepartmentCodeClassCode;
	}

	public String getSubClassCode() {
		return subClassCode;
	}

	public void setSubClassCode(String subClassCode) {
		this.subClassCode = subClassCode;
	}

	public String getPromotionId() {
		return promotionId;
	}

	public void setPromotionId(String promotionId) {
		this.promotionId = promotionId;
	}

	public String getPromotionInfo() {
		return promotionInfo;
	}

	public void setPromotionInfo(String promotionInfo) {
		this.promotionInfo = promotionInfo;
	}

	public String getPromotionAmount() {
		return promotionAmount;
	}

	public void setPromotionAmount(String promotionAmount) {
		this.promotionAmount = promotionAmount;
	}

	public String getPromotionReasonCode() {
		return promotionReasonCode;
	}

	public void setPromotionReasonCode(String promotionReasonCode) {
		this.promotionReasonCode = promotionReasonCode;
	}

	public String getLineDiscount() {
		return lineDiscount;
	}

	public void setLineDiscount(String lineDiscount) {
		this.lineDiscount = lineDiscount;
	}

	public String getDiscountCode() {
		return discountCode;
	}

	public void setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
	}

	public String getDiscountReasonType() {
		return discountReasonType;
	}

	public void setDiscountReasonType(String discountReasonType) {
		this.discountReasonType = discountReasonType;
	}

	public String getDisountReason() {
		return disountReason;
	}

	public void setDisountReason(String disountReason) {
		this.disountReason = disountReason;
	}

	@Override
	public String toString() {
		return "LineItemsModel [pk=" + pk + ", creationTime=" + creationTime + ", modifiedTime=" + modifiedTime
				+ ", bitReference=" + bitReference + ", memberid=" + memberid + ", sequence=" + sequence + ", status="
				+ status + ", type=" + type + ", externalProductId=" + externalProductId + ", quantity=" + quantity
				+ ", regularUnitPrice=" + regularUnitPrice + ", actualUnitPrice=" + actualUnitPrice
				+ ", extendedAmount=" + extendedAmount + ", lineTax=" + lineTax + ", departmentCode=" + departmentCode
				+ ", subDepartmentCodeClassCode=" + subDepartmentCodeClassCode + ", subClassCode=" + subClassCode
				+ ", promotionId=" + promotionId + ", promotionInfo=" + promotionInfo + ", promotionAmount="
				+ promotionAmount + ", promotionReasonCode=" + promotionReasonCode + ", lineDiscount=" + lineDiscount
				+ ", discountCode=" + discountCode + ", discountReasonType=" + discountReasonType + ", disountReason="
				+ disountReason + "]";
	}

}
