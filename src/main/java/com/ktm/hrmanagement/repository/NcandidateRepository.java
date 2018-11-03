package com.ktm.hrmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.ktm.hrmanagement.entity.NcandidateEntity;

public interface NcandidateRepository extends JpaRepository<NcandidateEntity, Integer>{

	@Query(value = "SELECT * FROM n_candidate_detail ORDER BY ncandidate_id DESC",nativeQuery = true)
	List<NcandidateEntity> findAllCandidates();

	@Query(value = "SELECT * FROM n_candidate_detail u WHERE u.ncandidate_designation = ?1 ORDER BY ncandidate_id DESC",nativeQuery = true)
	List<NcandidateEntity> getSearch(String name);

	@Transactional
	@Modifying
	@Query(value = "insert into n_candidate_detail (ncandidate_name,ncandidate_age,ncandidate_emailid,ncandidate_phoneno,ncandidate_address,ncandidate_qualification,ncandidate_designation,ncandidate_resume,ncandidate_filepath,created_by,created_date,modified_by,modified_date)values (?,?,?,?,?,?,?,?,?,?,?,?,?)",nativeQuery = true)
	int save(String ncandidate_name, int ncandidate_age, String ncandidate_emailid, String ncandidate_phoneno,
			String ncandidate_address, String ncandidate_qualification, String ncandidate_designation,
			String ncandidate_resume, String ncandidate_filepath,int created_by,String created_date,int modified_by,String modified_date);

	@Transactional
	@Modifying
	@Query(value = "Delete from n_candidate_detail Where ncandidate_emailid=?",nativeQuery = true)
	int deleteByNcandidate_emailid(String emailid);
}
