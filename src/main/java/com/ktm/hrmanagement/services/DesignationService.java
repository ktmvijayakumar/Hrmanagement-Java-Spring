package com.ktm.hrmanagement.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktm.hrmanagement.entity.DesignationEntity;
import com.ktm.hrmanagement.repository.DesignationRepository;

@Service
public class DesignationService{

	@Autowired
	private final DesignationRepository designationRepository;
	
	public DesignationService(DesignationRepository designationRepository){
		this.designationRepository=designationRepository;
	}

	public void save(DesignationEntity user) {
		// TODO Auto-generated method stub
		designationRepository.save(user);
	}

	public List<DesignationEntity> findAll() {
		// TODO Auto-generated method stub
		List<DesignationEntity> candidate= new ArrayList<>();
		for(DesignationEntity candidates: designationRepository.findAll()){
			candidate.add(candidates);
		}
		return candidate;
	}

}
