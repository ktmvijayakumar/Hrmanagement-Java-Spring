package com.ktm.hrmanagement.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktm.hrmanagement.bean.InterviewCandidateBean;
import com.ktm.hrmanagement.entity.InterviewProcessEntity;
import com.ktm.hrmanagement.repository.InteviewProcessRepository;

@Service
public class InterviewProcessService{

	@Autowired
	private InteviewProcessRepository interviewprocessRepository;
	
	public InterviewProcessService(InteviewProcessRepository interviewprocessRepository){
		this.interviewprocessRepository=interviewprocessRepository;
	}
	
	public void save(InterviewProcessEntity interviewprocessentity) {
		// TODO Auto-generated method stub
		interviewprocessRepository.save(interviewprocessentity);
	}

	public List<InterviewCandidateBean> getSearchResult(String date,int round_id) {
		// TODO Auto-generated method stub
		List<InterviewCandidateBean> candidate= new ArrayList<InterviewCandidateBean>();
		for(Object[] candidates: interviewprocessRepository.findByDate(date,round_id)){
			InterviewCandidateBean icb=new InterviewCandidateBean();
			icb.setCandidate_id((int) candidates[0]);
			icb.setCandidate_name((String) candidates[1]);
			candidate.add(icb);
		}
		return candidate;
	}
	public List<InterviewCandidateBean> findInterviewUserRoundResult(int candidate_id, int round_id, String format) {
		// TODO Auto-generated method stub
		List<InterviewCandidateBean> candidate= new ArrayList<InterviewCandidateBean>();
		for(Object[] candidates: interviewprocessRepository.findInterviewUserRoundResult(candidate_id,round_id,format)){
			InterviewCandidateBean icb=new InterviewCandidateBean();
			icb.setCandidate_id((int) candidates[0]);
			icb.setCandidate_name((String) candidates[1]);
			icb.setRound_name((String)candidates[2]);
			icb.setRound_status_name((String)candidates[3]);
			icb.setComments((String)candidates[4]);
			icb.setInterviewer_name((String)candidates[5]);
			candidate.add(icb);
		}
		return candidate;
	}

	public List<InterviewCandidateBean> findSelectedCandidates(int round_id, int round_statusid,String date) {
		// TODO Auto-generated method stub
		List<InterviewCandidateBean> candidate= new ArrayList<InterviewCandidateBean>();
		for(Object[] candidates: interviewprocessRepository.findSelectedCandidates(round_id,round_statusid,date)){
			InterviewCandidateBean icb=new InterviewCandidateBean();
			icb.setCandidate_id((int) candidates[0]);
			icb.setCandidate_name((String) candidates[1]);
			icb.setRound_name((String)candidates[2]);
			icb.setRound_status_name((String)candidates[3]);
			icb.setComments((String)candidates[4]);
			candidate.add(icb);
		}
		return candidate;
	}
	
	public List<InterviewCandidateBean> findSelectedCandidateProfileDetails(int candidate_id) {
		// TODO Auto-generated method stub
		List<InterviewCandidateBean> candidate= new ArrayList<InterviewCandidateBean>();
		for(Object[] candidates: interviewprocessRepository.findSelectedCandidateProfileDetails(candidate_id)){
			InterviewCandidateBean icb=new InterviewCandidateBean();
			icb.setCandidate_id((int) candidates[0]);
			icb.setCandidate_name((String) candidates[1]);
			icb.setRound_name((String)candidates[2]);
			icb.setRound_status_name((String)candidates[3]);
			icb.setComments((String)candidates[4]);
			icb.setCandidate_age((int) candidates[5]);
			icb.setCandidate_emailid((String)candidates[6]);
			icb.setCandidate_phoneno((String)candidates[7]);
			icb.setCandidate_address((String)candidates[8]);
			candidate.add(icb);
		}
		return candidate;
	}

	public InterviewProcessEntity findInterviewDetail(int candidate_id, int round_id, String interview_date) {
		// TODO Auto-generated method stub
		return interviewprocessRepository.findInterviewDetail(candidate_id, round_id, interview_date);
	}

	public List<InterviewCandidateBean> findInterviewUser(int ncandidate_id) {
		// TODO Auto-generated method stub
		List<InterviewCandidateBean> candidate= new ArrayList<InterviewCandidateBean>();
		for(Object[] candidates: interviewprocessRepository.findInterviewUser(ncandidate_id)){
			InterviewCandidateBean icb=new InterviewCandidateBean();
			icb.setCandidate_id((int) candidates[0]);
			icb.setCandidate_name((String) candidates[1]);
			icb.setRound_name((String)candidates[2]);
			icb.setRound_status_name((String)candidates[3]);
			icb.setComments((String)candidates[4]);
			icb.setCandidate_age((int) candidates[5]);
			icb.setCandidate_emailid((String)candidates[6]);
			icb.setCandidate_phoneno((String)candidates[7]);
			icb.setCandidate_address((String)candidates[8]);
			icb.setInterview_date((Date)candidates[9]);
			candidate.add(icb);
		}
		return candidate;
	
	}
	
}
