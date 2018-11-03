package com.ktm.hrmanagement.dao;

import org.springframework.web.servlet.ModelAndView;

import com.ktm.hrmanagement.entity.CallInfoEntity;
import com.ktm.hrmanagement.entity.InterviewProcessEntity;

public interface CallInfoDao {

	ModelAndView getCandidateProfileDetails(int candidate_id);
	ModelAndView getcallInfoStatusDetails(CallInfoEntity callinfoentity) throws Exception;
	ModelAndView getinterviewDetails();
	ModelAndView getInterivewDetail(int candidate_id);
	ModelAndView setInterviewDetails(InterviewProcessEntity interviewprocessentity);
	ModelAndView searchDetails(String date);
	ModelAndView getreAllocateInterviewInfoStatus(int candidate_id);
	ModelAndView getreAllocateInterviewInfoStatus(CallInfoEntity callinfoentity);
	ModelAndView getmodalcallInfoStatusDetails(CallInfoEntity callinfoentity);
	
	
}
