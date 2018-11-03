package com.ktm.hrmanagement.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktm.hrmanagement.bean.InterviewCandidateBean;
import com.ktm.hrmanagement.entity.CallInfoEntity;
import com.ktm.hrmanagement.repository.CallInfoRepository;


@Service
public class CallInfoService {

	@Autowired
	private final CallInfoRepository callinforepository;
	
	public CallInfoService(CallInfoRepository callinforepository){
		this.callinforepository=callinforepository;
	}
	
	
	public void save(CallInfoEntity call) {
		// TODO Auto-generated method stub
		System.out.println("save "+call.getCandidate_id());
		callinforepository.save(call);
		
	}

	public void insertsave(int candidate_id,int callstatus, String date) {
		// TODO Auto-generated method stub
		callinforepository.insertcall(candidate_id,callstatus,date);
	}

	public List<InterviewCandidateBean> findInterview(String format) {
		// TODO Auto-generated method stub
		List<InterviewCandidateBean> candidate= new ArrayList<InterviewCandidateBean>();
		for(Object[] candidates: callinforepository.findInterview(format)){
			InterviewCandidateBean icb=new InterviewCandidateBean();
			icb.setCandidate_id((int) candidates[0]);
			icb.setCandidate_name((String) candidates[1]);
			candidate.add(icb);
		}
		return candidate;
	}
	public List<InterviewCandidateBean> findInterviewUser(int candidate_id, String format) {
		// TODO Auto-generated method stub
		List<InterviewCandidateBean> candidate= new ArrayList<InterviewCandidateBean>();
		for(Object[] candidates: callinforepository.findInterviewUser(candidate_id,format)){
			InterviewCandidateBean icb=new InterviewCandidateBean();
			icb.setCandidate_id((int) candidates[0]);
			icb.setCandidate_name((String) candidates[1]);
			candidate.add(icb);
		}
		return candidate;
	}


	public void update(int candidate_id, int i) {
		// TODO Auto-generated method stub
		System.out.println(candidate_id+" "+i);
		callinforepository.update(i,candidate_id);
	}


	public void delete(int candidate_id) {
		// TODO Auto-generated method stub
		System.out.println(candidate_id);
		callinforepository.delete(candidate_id);
	}


	
	
	
}
