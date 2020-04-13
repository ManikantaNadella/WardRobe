package com.ssl.wardrobe.dao;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ssl.wardrobe.model.HeaderModel;

@Repository
public interface HeaderDao extends PagingAndSortingRepository<HeaderModel, Long> {

	@Query("Select count(h) From HeaderModel h Where h.memberId=?1 and (creationtime BETWEEN ?2 AND ?3 )")
	public int getTotalCountOfTranactions(String memberId, Timestamp fromDate, Timestamp toDate);

	@Query(value = "Select h From HeaderModel h Where h.memberId=?1 and (h.creationTime BETWEEN ?2 AND ?3 ) ORDER BY h.creationTime")
	public List<HeaderModel> findMemberByMemberId(String memberId, Timestamp fromDate, Timestamp toDate,
			Pageable pageable);

	@Query("Select h From HeaderModel h Where h.memberId=?1 and h.bitType in (?2) and (creationtime BETWEEN ?3 AND ?4 ) ORDER BY creationtime")
	public List<HeaderModel> findMemberByMemberId(String memberId, List<String> salesattribute, Timestamp fromDate,
			Timestamp toDate, Pageable pageable);
}
