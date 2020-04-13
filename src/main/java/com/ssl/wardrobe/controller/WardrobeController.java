package com.ssl.wardrobe.controller;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssl.waordrobe.apientities.WardrobeResponse;
import com.ssl.wardrobe.Service.WardrobeService;

@RestController
public class WardrobeController {

	private static final Logger log = LoggerFactory.getLogger(WardrobeController.class);

	private static final String HEADER = "header";

	private static final String LINEITEM = "lineitem";

	private static final String PAYMENTDETAILS = "paymentdetails";

	private static final String CRON_SUCCESS_MSG = " cron was completed succesfully";

	private static final String CRON_FAILURE_MSG = " cron is unable to start!";

	private static final String START_CRON_URL = "/startcron-{cronName}";

	private static final String CRON_NAME = "cronName";

	private static final String FAILURE = "FAILURE";

	@Autowired
	WardrobeService wardrobeService;

	@GetMapping("getMemberTransactions")
	@ResponseBody
	public ResponseEntity<?> getMemberTransactions(@RequestParam(name = "memberId", required = false) String memberId,
			@RequestParam(name = "startdate", required = false) String startdate,
			@RequestParam(name = "enddate", required = false) String enddate,
			@RequestParam(name = "transactionType", required = false) String transactionType,
			@RequestParam(name = "companyCode", required = false) String companyCode,
			@RequestParam(name = "offset", required = false) String offset,
			@RequestParam(name = "count", required = false) String count) {

		log.info(
				"API request parameter are memberid-> {}, startdate-> {}, enddate-> {}, transactionType-> {}, companyCode-> {}, offset-> {}, count-> {}",
				memberId, startdate, enddate, transactionType, companyCode, offset, count);
		WardrobeResponse response = new WardrobeResponse();
		Timestamp fromDate = this.convertStringToTimeStamp(startdate);
		Timestamp toDate = this.convertStringToTimeStamp(enddate);

		if (validateAPIParms(memberId, startdate, enddate, transactionType, companyCode, offset, count)) {
			response.setResponseCode(FAILURE);
			response.setResponseMessage("API request parameters should not be null or empty ");
			return ResponseEntity.ok(response);
		}

		if (Objects.isNull(fromDate) || Objects.isNull(toDate)) {
			response.setResponseCode(FAILURE);
			response.setResponseMessage("Date format should be yyyy-MM-dd format only!");
			return ResponseEntity.ok(response);
		}
		if (fromDate.after(toDate)) {
			response.setResponseCode(FAILURE);
			response.setResponseMessage("Enddate should be greaterthan startdate");
			return ResponseEntity.ok(response);
		}

		try {
			response = wardrobeService.getMemberTransactionDetails(memberId, fromDate, toDate, transactionType,
					companyCode, offset, count);
			log.info("API response--> {}", response);
		} catch (Exception e) {
			log.error("Exception while forming wardrobe object {}", e);
			response.setResponseCode(FAILURE);
			response.setResponseMessage(e.getMessage());
			response.setCustomerID(memberId);
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (response.getResponseCode() != null && !response.getResponseCode().equalsIgnoreCase("SUCCESS")) {
			log.info("Error while processing response");
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return ResponseEntity.ok(response);

	}

	private boolean validateAPIParms(String memberId, String startdate, String enddate, String transactionType,
			String companyCode, String offset, String count) {
		if (StringUtils.isEmpty(memberId) || StringUtils.isEmpty(startdate) || StringUtils.isEmpty(enddate)
				|| StringUtils.isEmpty(transactionType) || StringUtils.isEmpty(companyCode)
				|| StringUtils.isEmpty(offset) || StringUtils.isEmpty(count)) {
			return true;
		}
		return false;

	}

	private Timestamp convertStringToTimeStamp(String startdate) {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Timestamp timestamp = null;
		try {
			timestamp = new Timestamp((formatter.parse(startdate)).getTime());
		} catch (ParseException e) {
			log.warn("Exception while parsing date.{}", e);
		}
		if (!(String.valueOf(timestamp).contains(startdate))) {
			return null;
		}

		return timestamp;
	}

	/*
	 * cron name should be of only "header" or "lineitem" or "paymentdetails"
	 * 
	 * URL should be http://{domainname}/start-{cronname}
	 */
	@RequestMapping(START_CRON_URL)
	public String startCron(@PathVariable(CRON_NAME) String cronName) {

		if (cronName.equalsIgnoreCase(HEADER)) {
			wardrobeService.getHeaderData();
			return cronName + CRON_SUCCESS_MSG;

		} else if (cronName.equalsIgnoreCase(LINEITEM)) {
			wardrobeService.getLineItemsData();
			return cronName + CRON_SUCCESS_MSG;

		} else if (cronName.equalsIgnoreCase(PAYMENTDETAILS)) {
			wardrobeService.getPaymentTranactionData();
			return cronName + CRON_SUCCESS_MSG;
		}

		return cronName + CRON_FAILURE_MSG;
	}
}
