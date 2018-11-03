package com.ktm.hrmanagement.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktm.hrmanagement.entity.UserEntity;
import com.ktm.hrmanagement.repository.UserRepository;

@Service
public class UserService{

	@Autowired
	private final UserRepository userrepository;
	
	
	public UserService(UserRepository userrepository){
		this.userrepository=userrepository;
	}
	
	public List<UserEntity> findAll(){
		List<UserEntity> user= new ArrayList<>();
		
		for(UserEntity users: userrepository.findAll()){
			user.add(users);
		}
		return user;
	}
	
	public UserEntity getHrs(String emailid,String password){
		return userrepository.getHrs(emailid, password);
	}
	
	public UserEntity findUser(int hrid){
		return userrepository.getOne(hrid);
	}
	
	public void save(UserEntity user){
		System.out.println("save "+user.getHr_emailid());
		userrepository.save(user);
	}
	public void update(UserEntity user){
		System.out.println("save "+user.getHr_emailid());
		userrepository.save(user);
	}
	public void delete(int id){
		userrepository.deleteById(id);
	}

	
	

}
