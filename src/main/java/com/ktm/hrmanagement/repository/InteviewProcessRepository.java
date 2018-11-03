package com.ktm.hrmanagement.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ktm.hrmanagement.entity.InterviewProcessEntity;

public interface InteviewProcessRepository extends JpaRepository<InterviewProcessEntity, Integer>{

	@Query(value = "select ca.candidate_id, cd.candidate_name from interview_process ca, candidate_detail cd where ca.candidate_id = cd.candidate_id and interview_date = ? and round_id = ?",nativeQuery = true)
	List<Object[]> findByDate(String date,int round_id);
	 
	@Query(value = "SELECT cd.candidate_id,cd.candidate_name,SD.round_name,SD.round_status_name,SD.comments,SD.interviewer_name FROM candidate_detail cd LEFT OUTER JOIN ( SELECT ip.interview_date,ir.round_id,rs.round_statusid,ip.candidate_id,rs.round_status_name,ir.round_name,ip.comments,ip.interviewer_name FROM interview_process ip INNER JOIN interview_round ir ON ip.round_id=ir.round_id INNER JOIN round_status rs ON ip.round_statusid=rs.round_statusid) SD ON SD.candidate_id=cd.candidate_id WHERE SD.candidate_id = ? and SD.round_id = ? and SD.interview_date = ? ORDER BY cd.candidate_id",nativeQuery = true)
	List<Object[]> findInterviewUserRoundResult(int candidate_id, int round_id, String format);
	
	@Query(value = "SELECT cd.candidate_id,cd.candidate_name,SD.round_name,SD.round_status_name,SD.comments,SD.interview_date FROM candidate_detail cd LEFT OUTER JOIN ( SELECT ip.interview_date,ir.round_id,rs.round_statusid,ip.candidate_id,rs.round_status_name,ir.round_name,ip.comments FROM interview_process ip INNER JOIN interview_round ir ON ip.round_id=ir.round_id INNER JOIN round_status rs ON ip.round_statusid=rs.round_statusid) SD ON SD.candidate_id=cd.candidate_id WHERE SD.round_id = ? and SD.round_statusid=? and SD.interview_date=? ORDER BY cd.candidate_id",nativeQuery = true)
	List<Object[]> findSelectedCandidates(int round_id, int round_statusid,String date);

	@Query(value = "SELECT cd.candidate_id,cd.candidate_name,SD.round_name,SD.round_status_name,SD.comments,cd.candidate_age,cd.candidate_emailid,cd.candidate_phoneno,cd.candidate_address FROM candidate_detail cd LEFT OUTER JOIN (SELECT ip.interview_date,ir.round_id,rs.round_statusid,ip.candidate_id,rs.round_status_name,ir.round_name,ip.comments,ip.interviewer_name FROM interview_process ip INNER JOIN interview_round ir ON ip.round_id=ir.round_id INNER JOIN round_status rs ON ip.round_statusid=rs.round_statusid) SD ON SD.candidate_id=cd.candidate_id WHERE SD.candidate_id=? and SD.round_id=3 and SD.round_statusid=1 ",nativeQuery = true)
	List<Object[]> findSelectedCandidateProfileDetails(int candidate_id);
	
	@Query(value = "SELECT * from interview_process WHERE candidate_id=? and round_id=? and interview_date=? ",nativeQuery = true)
	InterviewProcessEntity findInterviewDetail(int candidate_id, int round_id, String interview_date);

	@Query(value = "SELECT cd.candidate_id,cd.candidate_name,SD.round_name,SD.round_status_name,SD.comments,cd.candidate_age,cd.candidate_emailid,cd.candidate_phoneno,cd.candidate_address,SD.interview_date FROM candidate_detail cd LEFT OUTER JOIN (SELECT ip.interview_date,ir.round_id,rs.round_statusid,ip.candidate_id,rs.round_status_name,ir.round_name,ip.comments,ip.interviewer_name FROM interview_process ip INNER JOIN interview_round ir ON ip.round_id=ir.round_id INNER JOIN round_status rs ON ip.round_statusid=rs.round_statusid) SD ON SD.candidate_id=cd.candidate_id WHERE SD.candidate_id=?",nativeQuery = true)
	List<Object[]> findInterviewUser(int ncandidate_id);

}
