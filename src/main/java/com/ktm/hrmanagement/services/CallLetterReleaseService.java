package com.ktm.hrmanagement.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktm.hrmanagement.bean.InterviewCandidateBean;
import com.ktm.hrmanagement.entity.CallLetterReleaseEntity;
import com.ktm.hrmanagement.repository.CallLetterReleaseRepository;

@Service
public class CallLetterReleaseService{

	@Autowired
	private CallLetterReleaseRepository callletterreleaserepository;
	
	public CallLetterReleaseService(CallLetterReleaseRepository callletterreleaserepository){
		this.callletterreleaserepository=callletterreleaserepository;
	}
	
	public void setcallLetterReleaseDetail(int candidate_id,String date,int created_by,String dates) {
		CallLetterReleaseEntity clre=new CallLetterReleaseEntity();
		clre.setCandidate_id(candidate_id);
		clre.setRelease_status("CallLetter Released");
		clre.setCall_letter_releasedate(date);
		clre.setCreated_by(created_by);
		clre.setCreated_date(dates);
		System.out.println(clre.getCall_letter_releasedate()+" "+clre.getCandidate_id()+" "+clre.getRelease_status());
		callletterreleaserepository.save(clre);
		
	}

	
	public List<InterviewCandidateBean> getCallLetterRelease(String date) {
		// TODO Auto-generated method stub
		List<InterviewCandidateBean> candidate= new ArrayList<InterviewCandidateBean>();
		for(Object[] candidates: callletterreleaserepository.getCallLetterRelease()){
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
		callletterreleaserepository.update(i,candidate_id,created_by,created_date);
		
	}

}
