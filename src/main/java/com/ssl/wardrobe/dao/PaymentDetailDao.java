package com.ssl.wardrobe.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ssl.wardrobe.model.PaymentDetailModel;

public interface PaymentDetailDao extends JpaRepository<PaymentDetailModel, Long> {

	@Query("Select p FROM PaymentDetailModel p WHERE p.bitReference=?1")
	public List<PaymentDetailModel> getPaymentDetailsByBitReferenceID(String bitReference);

}
