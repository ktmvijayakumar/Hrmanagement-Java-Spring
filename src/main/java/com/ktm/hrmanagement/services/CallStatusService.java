package com.ktm.hrmanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktm.hrmanagement.entity.CallStatusEntity;
import com.ktm.hrmanagement.repository.CallStatusRepository;

@Service
public class CallStatusService{

	@Autowired
	private final CallStatusRepository callStatusRepository;
	
	public CallStatusService(CallStatusRepository callStatusRepository){
		this.callStatusRepository=callStatusRepository;
	}

	
	public void save(CallStatusEntity callstatusentity) {
		// TODO Auto-generated method stub
		System.out.println("callstatusentity"+callstatusentity);
		callStatusRepository.save(callstatusentity);
	}

}
