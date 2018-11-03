package com.ktm.hrmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.ktm.hrmanagement.entity.CallInfoEntity;

public interface CallInfoRepository extends JpaRepository<CallInfoEntity, Integer>{

	@Query(value = "INSERT INTO candidate_callstatus(candidate_id,status_id,interview_date) values (?,?,?); ",nativeQuery = true)
	void insertcall(int candidate_id,int callstatus, String date);

	
	@Query(value = "select ca.candidate_id, cd.candidate_name from candidate_callstatus ca, candidate_detail cd where ca.candidate_id = cd.candidate_id and interview_date = ? and status_id=1 and ca.candidate_status=0",nativeQuery = true)
	List<Object[]> findInterview(String string);

	@Query(value = "select ca.candidate_id, cd.candidate_name from candidate_callstatus ca, candidate_detail cd where ca.candidate_id = cd.candidate_id and ca.candidate_id= ? and interview_date = ?",nativeQuery = true)
	List<Object[]> findInterviewUser(int candidate_id, String format);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "Update candidate_callstatus set candidate_status=? where candidate_id = ?",nativeQuery = true)
	int update(int i,int candidate_id);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "delete from candidate_callstatus where candidate_id = ?",nativeQuery = true)
	void delete(int candidate_id);



	

}
