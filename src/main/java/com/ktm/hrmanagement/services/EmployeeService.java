package com.ktm.hrmanagement.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktm.hrmanagement.entity.EmployeeEntity;
import com.ktm.hrmanagement.repository.EmployeeRepository;

@Service
public class EmployeeService{

	@Autowired
	private final EmployeeRepository employeerepository;
	public EmployeeService(EmployeeRepository employeerepository){
		this.employeerepository=employeerepository;
	}
	
	
	public void save(EmployeeEntity employeeentity) {
		// TODO Auto-generated method stub
		employeerepository.save(employeeentity);
	}
	

	public List<EmployeeEntity> findAll() {
		// TODO Auto-generated method stub
		List<EmployeeEntity> candidate= new ArrayList<>();
		for(EmployeeEntity candidates: employeerepository.findAll()){
			candidate.add(candidates);
		}
		return candidate;
	}


	public EmployeeEntity findUser(int candidate_id) {
		// TODO Auto-generated method stub
		return employeerepository.getOne(candidate_id);
	}

}
