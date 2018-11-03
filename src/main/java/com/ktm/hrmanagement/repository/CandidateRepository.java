package com.ktm.hrmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ktm.hrmanagement.entity.CandidateEntity;

public interface CandidateRepository extends JpaRepository<CandidateEntity, Integer>{
	
	@Query(value = "SELECT * FROM candidate_detail u WHERE u.candidate_designation = ?1 ORDER BY candidate_id DESC",nativeQuery = true)
	List<CandidateEntity> getSearch(String name);

	@Query(value = "SELECT * FROM candidate_detail ORDER BY candidate_id DESC",nativeQuery = true)
	List<CandidateEntity> findAllCandidates();

	@Query(value = "SELECT * FROM candidate_detail where candidate_emailid=?",nativeQuery = true)
	CandidateEntity getUserByEmailid(String ncandidate_emailid);
}
