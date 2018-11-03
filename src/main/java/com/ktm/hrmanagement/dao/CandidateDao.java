package com.ktm.hrmanagement.dao;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;
import com.ktm.hrmanagement.bean.SearchBean;
import com.ktm.hrmanagement.entity.DesignationEntity;
import com.ktm.hrmanagement.entity.InterviewrRoundEntity;
import com.ktm.hrmanagement.entity.NcandidateEntity;

public interface CandidateDao {

	ModelAndView viewCandidateDetails();
	ModelAndView searchDetails(SearchBean search);
	ModelAndView getCandidateProfileDetails(int candidate_id);
	ModelAndView fileDetails(int candidate_id);
	ModelAndView getCandidateProfileDetailsAcceptance(int candidate_id);
	ModelAndView setaddCandidates(HttpServletRequest request, NcandidateEntity user);
	ModelAndView setaddDesignation(HttpServletRequest request, DesignationEntity user);
	ModelAndView getaddDesignation();
	ModelAndView setaddInterviewrounds(HttpServletRequest request, InterviewrRoundEntity user);

	
}
