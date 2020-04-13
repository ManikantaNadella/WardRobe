package com.ssl.wardrobe.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import com.ssl.waordrobe.apientities.Payment;
import com.ssl.waordrobe.apientities.Product;
import com.ssl.waordrobe.apientities.Transaction;
import com.ssl.waordrobe.apientities.WardrobeResponse;
import com.ssl.wardrobe.dao.HeaderDao;
import com.ssl.wardrobe.dao.LineItemDao;
import com.ssl.wardrobe.dao.PaymentDetailDao;
import com.ssl.wardrobe.model.HeaderModel;
import com.ssl.wardrobe.model.LineItemModel;
import com.ssl.wardrobe.model.PaymentDetailModel;
import com.ssl.wardrobe.utils.PrcocessFileDetails;

@Service
public class WardrobeService {

	private static final Logger log = LoggerFactory.getLogger(WardrobeService.class);
	
	private static final String STRICT_HOST_KEY_CHECKING = "StrictHostKeyChecking";
	
	private static final String NO = "no";
	
	private static final String SFTP = "sftp";
	
	private static final String WORKING_DIR = "/sftp-apm20/ssl/outbound";
	
	private static final String HEADERFOLDER = "/bits_header/";
	
	private static final String LINESITEMSFOLDER = "/bits_lines/";
	
	private static final String PAYMENTSFOLDER = "/bits_payment/";
	
	private static final String STAR = "*";
	
	private static final String ALL = "All";
	
	private static final String SALES = "Sales";
	
	private static final String RETURNS = "Returns";
	
	private static final List<String> SALESLIST = Arrays.asList("1", "4", "01", "04");
	
	private static final List<String> RETURNATTRIBUTES = Arrays.asList("11", "14", "88");
	
	private static final int MAX_TOTALCOUNT = 1000;
	
	private static final String FAILURE = "FAILURE";


	@Autowired
	private Environment environment;

	@Autowired
	private HeaderDao headerDao;

	@Autowired
	private LineItemDao lineItemDao;

	@Autowired
	private PaymentDetailDao paymentDetailDao;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Scheduled(cron = "0 0 6 * * *")
	public void getHeaderData() {

		log.info("Processing Header file on {}" , new Date());
		ChannelSftp channelSftp = this.getSFTPChannelConnection();
		String workingPath = WORKING_DIR + HEADERFOLDER + this.getSuffixExecutionPath();
		try {
			if (channelSftp != null) {
				channelSftp.cd(workingPath);
				List<ChannelSftp.LsEntry> filesList = channelSftp.ls(STAR);
				if (filesList != null) {
					List<HeaderModel> headerList = new ArrayList();
					for (ChannelSftp.LsEntry entry : filesList) {

						log.info("Header file name:-->{}", entry.getFilename());
						PrcocessFileDetails.headerFileProcessing(channelSftp.get(entry.getFilename()), headerList);

					}
					headerDao.saveAll(headerList);
					log.info("{} records were processed from header file", headerList.size());
				}
			} else {

				log.info("The SFTP channel is null");
			}
		} catch (SftpException e) {
			log.warn("Location does not exist ({}) and exception is ", workingPath, e);
		} finally {
			this.disconnectSFTPChannelConnection(channelSftp);
		}

	}

	@SuppressWarnings("unchecked")
	@Scheduled(cron = "0 15 6 * * *")
	public void getLineItemsData() {
		log.info("Processing LineItem file on {}", new Date());

		ChannelSftp channelSftp = this.getSFTPChannelConnection();
		String workingPath = WORKING_DIR + LINESITEMSFOLDER + this.getSuffixExecutionPath();
		try {
			channelSftp.cd(workingPath);

			List<ChannelSftp.LsEntry> filesList = channelSftp.ls(STAR);
			if (filesList != null) {
				List<LineItemModel> lineItemList = new ArrayList<LineItemModel>();
				for (ChannelSftp.LsEntry entry : filesList) {

					log.info("Line file name:-->{}", entry.getFilename());
					PrcocessFileDetails.lineItemFileProcessing(channelSftp.get(entry.getFilename()), lineItemList);

				}

				lineItemDao.saveAll(lineItemList);
				log.info("{} records were processed from Lineitems file", lineItemList.size());
			}
		} catch (SftpException e) {
			log.warn("Location does not exist ({}) and exception is", workingPath, e);
		} finally {
			this.disconnectSFTPChannelConnection(channelSftp);
		}
	}

	@SuppressWarnings("unchecked")
	@Scheduled(cron = "0 30 6 * * *")
	public void getPaymentTranactionData() {

		log.info("Processing Payments file on {}", new Date());
		ChannelSftp channelSftp = this.getSFTPChannelConnection();
		String workingPath = WORKING_DIR + PAYMENTSFOLDER + this.getSuffixExecutionPath();
		try {
			channelSftp.cd(workingPath);
			List<ChannelSftp.LsEntry> filesList = channelSftp.ls(STAR);
			if (filesList != null) {
				List<PaymentDetailModel> paymentDetailList = new ArrayList<PaymentDetailModel>();
				for (ChannelSftp.LsEntry entry : filesList) {
					log.info("Payments file name:-->{}", entry.getFilename());
					PrcocessFileDetails.paymentDetailFileProcessing(channelSftp.get(entry.getFilename()),
							paymentDetailList);

				}

				paymentDetailDao.saveAll(paymentDetailList);
				log.info("{} records were processed from Payments file", paymentDetailList.size());
			}
		} catch (SftpException e) {
			log.warn("Location does not exist ({}) and exception is", workingPath, e);
		} finally {
			this.disconnectSFTPChannelConnection(channelSftp);
		}
	}

	public String getSuffixExecutionPath() {
		Calendar calender = Calendar.getInstance();
		return (String.valueOf(calender.get(Calendar.YEAR)) + "/"
				+ String.format("%02d", calender.get(Calendar.MONTH) + 1) + "/"
				+ String.format("%02d", calender.get(Calendar.DAY_OF_MONTH)) + "/");

	}

	public ChannelSftp getSFTPChannelConnection() {
		JSch jsch = new JSch();
		Session session = null;
		Channel channel = null;
		ChannelSftp channelSftp = null;

		try {
			jsch.addIdentity(environment.getProperty("sftp.ppk-filepath"));
			session = jsch.getSession(environment.getProperty("sftp.user"), environment.getProperty("sftp.host.name"),
					Integer.parseInt(environment.getProperty("sftp.host.port", "22")));
			Properties config = new Properties();
			config.put(STRICT_HOST_KEY_CHECKING, NO);
			session.setConfig(config);
			session.connect();
			channel = session.openChannel(SFTP);
			channel.connect();
			channelSftp = (ChannelSftp) channel;
			log.info("Sftp connection has been acquired.");

		} catch (JSchException e) {
			log.info("Exception while creating JSCH object {}", e);
			return null;
		}

		return channelSftp;
	}

	public void disconnectSFTPChannelConnection(ChannelSftp channelSftp) {
		if (channelSftp != null) {
			channelSftp.disconnect();
			log.info("SFTP connection was disconnected.");
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public WardrobeResponse getMemberTransactionDetails(String memberId, Timestamp fromDate, Timestamp toDate,
			String transactionType, String companyCode, String offset, String count) {

		WardrobeResponse response = new WardrobeResponse();
		response.setCustomerID(memberId);
		response.setOffset(offset);
		response.setCount(count);

		Pageable pageable = PageRequest.of(Integer.parseInt(offset), Integer.parseInt(count));
		if (Integer.parseInt(count) > 1000) {
			pageable = PageRequest.of(Integer.parseInt(offset), MAX_TOTALCOUNT);
			log.info("Count maximum value is :{}", MAX_TOTALCOUNT);
		}
		List<HeaderModel> headerList = null;
		List<Transaction> transactionList = new ArrayList();
		try {
			if (transactionType.equals(ALL) && Objects.nonNull(fromDate) && Objects.nonNull(toDate)) {
				headerList = headerDao.findMemberByMemberId(memberId, fromDate, toDate, pageable);
			} else if (transactionType.equals(SALES) && Objects.nonNull(fromDate) && Objects.nonNull(toDate)) {
				headerList = headerDao.findMemberByMemberId(memberId, SALESLIST, fromDate, toDate, pageable);
			} else if (transactionType.equals(RETURNS) && Objects.nonNull(fromDate) && Objects.nonNull(toDate)) {
				headerList = headerDao.findMemberByMemberId(memberId, RETURNATTRIBUTES, fromDate, toDate, pageable);
			}
			response.setResponseCode("SUCCESS");
			response.setResponseMessage(null);
			response.setTotalCount(String.valueOf(headerDao.getTotalCountOfTranactions(memberId, fromDate, toDate)));
			try {

				if (!(CollectionUtils.isEmpty(headerList))) {
					transactionList = this.prepareMemberTransactionData(headerList);

				}
				response.setTransactionList(transactionList);
			} catch (Exception e) {
				response.setResponseCode(FAILURE);
				response.setResponseMessage(e.getMessage());
				return response;

			}

		} catch (Exception e) {
			response.setResponseCode(FAILURE);
			response.setResponseMessage(e.getMessage());
			return response;
		}

		return response;

	}

	private List<Transaction> prepareMemberTransactionData(List<HeaderModel> headerList) {
		List<Transaction> transactionList = new ArrayList<Transaction>();

		for (HeaderModel header : headerList) {
			Transaction transaction = new Transaction();
			transaction.setReferenceNumber(header.getBitReference());
			transaction.setTransactionDate(String.valueOf(header.getBitDate()));
			transaction.setTransactionType(header.getBitType());
			transaction.setCategory(header.getBitCategory());
			transaction.setTransactionNumber(header.getTransactionNumber());
			transaction.setSponser(header.getSponsor());
			transaction.setLocation(header.getLocationName());
			transaction.setAmountWithoutTax(header.getBitAmount());
			transaction.setTotalAmountIncTax(header.getOriginalBitAmount());
			List<Product> productList = new ArrayList<Product>();
			for (LineItemModel lineitem : lineItemDao.getLineItemsByBitReferenceID(header.getBitReference())) {
				Product product = new Product();
				product.setId(lineitem.getExternalProductId());
				product.setRegualrPrice(lineitem.getRegularUnitPrice());
				product.setActualPrice(lineitem.getActualUnitPrice());
				product.setExtendedPrice(lineitem.getExtendedAmount());
				product.setDepartmentCode(lineitem.getDepartmentCode());
				product.setSubDepartmentCode(lineitem.getSubDepartmentCodeClassCode());
				product.setPromotionCode(lineitem.getPromotionId());
				product.setPromotionAmount(lineitem.getPromotionAmount());
				productList.add(product);

			}

			List<Payment> paymentsList = new ArrayList<Payment>();
			for (PaymentDetailModel paymentDetail : paymentDetailDao
					.getPaymentDetailsByBitReferenceID(header.getBitReference())) {
				Payment payment = new Payment();
				payment.setSequenceNumber(paymentDetail.getSequence());
				payment.setTenderType(paymentDetail.getTenderType());
				payment.setAmount(paymentDetail.getAmount());
				paymentsList.add(payment);
			}
			transaction.setProductList(productList);
			transaction.setPayments(paymentsList);
			transactionList.add(transaction);
		}

		return transactionList;
	}

}