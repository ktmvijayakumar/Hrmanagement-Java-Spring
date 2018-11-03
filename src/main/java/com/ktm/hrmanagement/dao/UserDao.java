package com.ktm.hrmanagement.dao;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.ktm.hrmanagement.bean.UserBean;

public interface UserDao {
	
	ModelAndView loginUser(HttpServletRequest request,UserBean user);
	ModelAndView profileDetail(HttpServletRequest request);
	ModelAndView logoutUser(HttpServletRequest request);

}
