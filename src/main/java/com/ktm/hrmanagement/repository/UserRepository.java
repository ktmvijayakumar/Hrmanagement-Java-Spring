package com.ktm.hrmanagement.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ktm.hrmanagement.entity.UserEntity;


public interface UserRepository extends JpaRepository<UserEntity, Integer>{

	//userEntity findByHrEmailidAndHrPassword(String emailid, String password);


	@Query(value = "SELECT * FROM hr_detail u WHERE u.hr_emailid = ?1 and u.hr_password = ?2",nativeQuery = true)
	UserEntity getHrs(String emailid, String password);
	
	
}
