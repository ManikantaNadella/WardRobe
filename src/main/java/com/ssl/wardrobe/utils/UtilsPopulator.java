package com.ssl.wardrobe.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ssl.wardrobe.model.HeaderModel;
import com.ssl.wardrobe.model.LineItemModel;
import com.ssl.wardrobe.model.PaymentDetailModel;

public class UtilsPopulator {

	private static final Logger log = LoggerFactory.getLogger(UtilsPopulator.class);

	public static void populateHeader(String[] row, HeaderModel header, List<HeaderModel> headerList) {
		try {
			header.setCreationTime(new Date());
			header.setModifiedTime(new Date());
			header.setMemberId(String.valueOf(row[0]));
			header.setBitReference(String.valueOf(row[1]));
			header.setOfferId(String.valueOf(row[2]));
			try {
				DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				header.setBitDate(new Timestamp((formatter.parse(String.valueOf(row[3]))).getTime()));
			} catch (ParseException e) {
				log.warn("Parse exception parsing date", String.valueOf(row[3]));
				try {
					DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
					header.setBitDate(new Timestamp((formatter.parse(String.valueOf(row[3]))).getTime()));
				} catch (ParseException e1) {
					log.warn("parse excpetion {}", e1);
				}
			}
			header.setBitType(String.valueOf(row[4]));
			header.setProgramId(String.valueOf(row[5]));
			header.setSponsorId(String.valueOf(row[6]));
			header.setBitCategory(String.valueOf(row[7]));
			header.setLocation(String.valueOf(row[8]));
			header.setBitCurrency(String.valueOf(row[9]));
			header.setBitSourceGeneratedId(String.valueOf(row[10]));
			header.setCentury(String.valueOf(row[11]));
			header.setPosId(String.valueOf(row[12]));
			header.setTransactionNumber(String.valueOf(row[13]));
			header.setOrderConfirmationNumber(String.valueOf(row[14]));
			header.setBitOriginalSourceGeneratedId(String.valueOf(row[15]));
			header.setRollOverNumber(String.valueOf(row[16]));
			header.setOriginalBitAmount(String.valueOf(row[17]));
			header.setBitAmount(String.valueOf(row[18]));
			header.setTenderTotal(String.valueOf(row[19]));
			header.setPayInAmount(String.valueOf(row[20]));
			header.setPosCashierId(String.valueOf(row[21]));
			header.setPromotionId(String.valueOf(row[22]));
			header.setCustomerId(String.valueOf(row[23]));
			header.setSponsor(String.valueOf(row[24]));
			// for some iterations locationname attribute is not present in csv file
			if (row.length == 26) {
				header.setLocationName(String.valueOf(row[25]));
			}
			headerList.add(header);
		} catch (ArrayIndexOutOfBoundsException e) {
			log.warn("Array index out of bound exception in header data and bit refrence id is {} and exception is {}",
					header.getBitReference(), e);

		}

	}

	public static void populateLineItem(String[] row, LineItemModel lineItem, List<LineItemModel> lineItemList) {

		try {

			lineItem.setCreationTime(new Date());
			lineItem.setModifiedTime(new Date());
			lineItem.setBitReference(String.valueOf(row[0]));
			lineItem.setMemberid(String.valueOf(row[1]));
			lineItem.setSequence(String.valueOf(row[2]));
			lineItem.setStatus(String.valueOf(row[3]));
			lineItem.setType(String.valueOf(row[4]));
			lineItem.setExternalProductId(String.valueOf(row[5]));
			lineItem.setQuantity(String.valueOf(row[6]));
			lineItem.setRegularUnitPrice(String.valueOf(row[7]));
			lineItem.setActualUnitPrice(String.valueOf(row[8]));
			lineItem.setExtendedAmount(String.valueOf(row[9]));
			lineItem.setLineTax(String.valueOf(row[10]));
			lineItem.setDepartmentCode(String.valueOf(row[11]));
			lineItem.setSubDepartmentCodeClassCode(String.valueOf(row[12]));
			lineItem.setSubClassCode(String.valueOf(row[13]));
			lineItem.setPromotionId(String.valueOf(row[14]));
			lineItem.setPromotionInfo(String.valueOf(row[15]));
			lineItem.setPromotionAmount(String.valueOf(row[16]));
			lineItem.setPromotionReasonCode(String.valueOf(row[17]));
			lineItem.setLineDiscount(String.valueOf(row[18]));
			lineItem.setDiscountCode(String.valueOf(row[19]));
			lineItem.setDiscountReasonType(String.valueOf(row[20]));
			lineItem.setDisountReason(String.valueOf(row[21]));

			lineItemList.add(lineItem);

		} catch (ArrayIndexOutOfBoundsException e) {
			log.warn(
					"Array index out of bound exception in lineitem data and bit refrence id is {} and exception is {}",
					lineItem.getBitReference(), e);
		}

	}

	public static void populatePaymentDetail(String[] row, PaymentDetailModel paymentDetail,
			List<PaymentDetailModel> paymentDetailList) {

		try {
			paymentDetail.setCreationTime(new Date());
			paymentDetail.setModifiedTime(new Date());
			paymentDetail.setBitReference(String.valueOf(row[0]));
			paymentDetail.setMemberid(String.valueOf(row[1]));
			paymentDetail.setSequence(String.valueOf(row[2]));
			paymentDetail.setTenderType(String.valueOf(row[3]));
			paymentDetail.setAmount(String.valueOf(row[4]));
			paymentDetail.setCode(String.valueOf(row[5]));
			paymentDetail.setDiscount(String.valueOf(row[6]));
			paymentDetail.setUnitAmount(String.valueOf(row[7]));
			paymentDetailList.add(paymentDetail);
		} catch (ArrayIndexOutOfBoundsException e) {
			log.warn(
					"Array index out of bound exception in payments data and bit refrence id is {} and exception is {}",
					paymentDetail.getBitReference(), e);
		}

	}

}
