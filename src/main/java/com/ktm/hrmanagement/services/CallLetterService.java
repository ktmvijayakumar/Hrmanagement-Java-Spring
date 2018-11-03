package com.ktm.hrmanagement.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktm.hrmanagement.bean.InterviewCandidateBean;
import com.ktm.hrmanagement.entity.CallLetterEntity;
import com.ktm.hrmanagement.repository.CallLetterRepository;

@Service
public class CallLetterService{

	@Autowired
	private CallLetterRepository callletterrepository;
	
	public CallLetterService(CallLetterRepository callletterrepository){
		this.callletterrepository=callletterrepository;
	}
	
	

	public void save(CallLetterEntity callletterentity) {
		// TODO Auto-generated method stub
		callletterrepository.save(callletterentity);
		
	}



	public List<InterviewCandidateBean> findAcceptedCandidates(String date) {
		// TODO Auto-generated method stub
		List<InterviewCandidateBean> candidate= new ArrayList<InterviewCandidateBean>();
		for(Object[] candidates: callletterrepository.findAcceptedCandidates()){
			InterviewCandidateBean icb=new InterviewCandidateBean();
			icb.setCandidate_id((int) candidates[0]);
			icb.setCandidate_name((String) candidates[1]);
			candidate.add(icb);
		}
		return candidate;
	}



	public void update(int candidate_id, int i, int created_by, String created_date) {
		// TODO Auto-generated method stub
		System.out.println(candidate_id+" "+i);
		callletterrepository.update(i,candidate_id,created_by,created_date);
		
	}

}
