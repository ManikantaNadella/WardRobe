package com.ssl.wardrobe.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ssl.wardrobe.model.LineItemModel;

public interface LineItemDao extends JpaRepository<LineItemModel, Long> {

	@Query("Select l From LineItemModel l Where l.bitReference=?1")
	public List<LineItemModel> getLineItemsByBitReferenceID(String bitReference);

}
