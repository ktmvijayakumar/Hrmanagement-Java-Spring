package com.ktm.hrmanagement.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktm.hrmanagement.entity.NcandidateEntity;
import com.ktm.hrmanagement.repository.NcandidateRepository;

@Service
public class NcandidateService {

	@Autowired
	private final NcandidateRepository ncandidateRepository;
	
	public NcandidateService(NcandidateRepository ncandidateRepository){
		this.ncandidateRepository=ncandidateRepository;
	}
	
	public void save(NcandidateEntity Ncandidateentity) {
		// TODO Auto-generated method stub
		System.out.println("save "+Ncandidateentity.toString());
		
		ncandidateRepository.save(Ncandidateentity.getNcandidate_name(),Ncandidateentity.getNcandidate_age(),Ncandidateentity.getNcandidate_emailid()
				,Ncandidateentity.getNcandidate_phoneno(),Ncandidateentity.getNcandidate_address(),Ncandidateentity.getNcandidate_qualification(),Ncandidateentity.getNcandidate_designation()
				,Ncandidateentity.getNcandidate_resume(),Ncandidateentity.getNcandidate_filepath(),Ncandidateentity.getCreated_by()
				,Ncandidateentity.getCreated_date(),Ncandidateentity.getModified_by(),Ncandidateentity.getModified_date());
	}
	
	public List<NcandidateEntity> findAll() {
		// TODO Auto-generated method stub
		List<NcandidateEntity> candidate= new ArrayList<>();
		for(NcandidateEntity candidates: ncandidateRepository.findAllCandidates()){
			candidate.add(candidates);
		}
		return candidate;

	}

	public NcandidateEntity findUser(int candidate_id) {
		// TODO Auto-generated method stub
		return ncandidateRepository.getOne(candidate_id);
	}
	
	public void delete(String emailid) {
		// TODO Auto-generated method stub
		ncandidateRepository.deleteByNcandidate_emailid(emailid);
	}
	
	public List<NcandidateEntity> getSearch(String name) {
		// TODO Auto-generated method stub
		List<NcandidateEntity> candidate= new ArrayList<>();
		for(NcandidateEntity candidates: ncandidateRepository.getSearch(name)){
			candidate.add(candidates);
		}
		return candidate;
	}

}
