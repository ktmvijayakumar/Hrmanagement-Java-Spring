package com.ktm.hrmanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktm.hrmanagement.entity.CertificateVerificationEntity;
import com.ktm.hrmanagement.repository.CertificateVerificationRepository;

@Service
public class CertificateVerificationService{

	@Autowired
	private final CertificateVerificationRepository certificateVerificationRepository;
	
	public CertificateVerificationService(CertificateVerificationRepository callinforepository){
		this.certificateVerificationRepository=callinforepository;
	}

	public void save(CertificateVerificationEntity call) {
		// TODO Auto-generated method stub
		System.out.println("save "+call.getCandidate_id());
		certificateVerificationRepository.save(call);
		
	}

	public void insertsave(int candidate_id, String callstatus, String date) {
		// TODO Auto-generated method stub
		certificateVerificationRepository.insertcall(callstatus,candidate_id,date);
	}

	
}
