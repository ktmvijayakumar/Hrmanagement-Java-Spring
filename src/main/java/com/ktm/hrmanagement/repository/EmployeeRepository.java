package com.ktm.hrmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ktm.hrmanagement.entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer>{

}
