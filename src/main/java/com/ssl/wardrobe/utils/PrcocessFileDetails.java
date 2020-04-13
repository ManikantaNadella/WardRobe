package com.ssl.wardrobe.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ssl.wardrobe.model.HeaderModel;
import com.ssl.wardrobe.model.LineItemModel;
import com.ssl.wardrobe.model.PaymentDetailModel;

public class PrcocessFileDetails {
	private static final Logger log = LoggerFactory.getLogger(PrcocessFileDetails.class);

	private static final String HEADER1 = "member_id|bit_reference|h_offer_id|h_bit_date|h_bit_type|h_program_id|h_sponsor_id|h_bit_category|h_location|h_bit_currency|h_bit_source_generated_id|h_century|h_pos_id|h_transaction_number|h_order_confirmation_number|h_bit_original_source_generated_id|h_roll_over_number|h_original_bit_amount|h_bit_amount|h_tender_total|h_pay_in_amount|h_pos_cashier_id|h_promotion_id|h_customer_id|sponsor|location_name";

	private static final String LINEITEMHEADER = "bit_reference|member_id|sequence|status|type|l_product_external_id|l_quantity|l_regular_unit_price|l_actual_unit_price|l_extended_amount|l_line_tax|l_department_code|l_sub_department_codel_class_code|l_subclass_code|l_promotion_id|l_promotion_info|l_promotion_amount|l_promotion_reason_code|l_line_discount|l_discount_code|l_discount_reason_type|l_discount_reason";

	private static final String PAYMENTDETAILSHEADER = "bit_reference|member_id|sequence|tender_type|amount|code|discount|unit_amount";

	private static final String SEPERATOR = "\\|";

	public static void headerFileProcessing(InputStream inputStream, List<HeaderModel> headerList) {

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
			String line = reader.readLine();
			
			if (HEADER1.equals(line)) {

				int headingLine = 1;
				while ((line) != null) {
					if (headingLine == 1) {
						line = reader.readLine();
						headingLine = 2;
						continue;
					}
					String[] row = line.split(SEPERATOR,-1);
					HeaderModel header = new HeaderModel();
					UtilsPopulator.populateHeader(row, header, headerList);
					line = reader.readLine();

				}
			} else {
				log.info("Header file not processed because of file header issue");
			}

		} catch (Exception e) {
			log.warn("Exception while processing header file {}", e);

		}

	}

	public static void lineItemFileProcessing(InputStream inputStream, List<LineItemModel> lineItemList) {

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
			String line = reader.readLine();
			if (LINEITEMHEADER.equals(line)) {

				int headingLine = 1;
				while ((line) != null) {
					if (headingLine == 1) {
						line = reader.readLine();
						headingLine = 2;
						continue;
					}
					String[] row = line.split(SEPERATOR,-1);
					LineItemModel lineItem = new LineItemModel();
					UtilsPopulator.populateLineItem(row, lineItem, lineItemList);
					line = reader.readLine();

				}
			} else {
				log.info("Lineitems file not processed because of file header issue");
			}

		} catch (Exception e) {
			log.warn("Exception while processing lineitems file {}", e);
		}

	}

	public static void paymentDetailFileProcessing(InputStream inputStream,
			List<PaymentDetailModel> paymentDetailList) {

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
			String line = reader.readLine();

			if (PAYMENTDETAILSHEADER.equals(line)) {

				int headingLine = 1;
				while ((line) != null) {
					if (headingLine == 1) {
						line = reader.readLine();
						headingLine = 2;
						continue;
					}
					String[] row = line.split(SEPERATOR,-1);
					PaymentDetailModel paymentDetail = new PaymentDetailModel();
					UtilsPopulator.populatePaymentDetail(row, paymentDetail, paymentDetailList);

					line = reader.readLine();

				}
			} else {
				log.info("Payments file not processed because of file header issue");
			}

		} catch (Exception e) {
			log.warn("Exception while processing payments file {}", e);
		}

	}

}
