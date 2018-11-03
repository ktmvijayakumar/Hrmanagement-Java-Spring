package com.ktm.hrmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.ktm.hrmanagement.entity.CallLetterEntity;

public interface CallLetterRepository extends JpaRepository<CallLetterEntity, Integer>{

	@Query(value = "select ca.candidate_id, cd.candidate_name from call_letter ca, candidate_detail cd where ca.candidate_id = cd.candidate_id and ca.call_letter_status=0 and ca.accept_status ='Accepted'",nativeQuery = true)
	List<Object[]> findAcceptedCandidates();

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "Update call_letter set call_letter_status=?1,modified_by=?3,modified_date=?4 where candidate_id = ?2",nativeQuery = true)
	int update(int i, int candidate_id, int modified_by, String modified_date);

}
