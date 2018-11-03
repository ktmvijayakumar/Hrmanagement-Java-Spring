package com.ktm.hrmanagement.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ktm.hrmanagement.bean.UserBean;
import com.ktm.hrmanagement.dao.UserDao;
@RequestMapping("log")
@Controller
public class LoginController {

	@Autowired
	private UserDao userdao;
	
    @GetMapping("index")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
    	ModelAndView mdv=new ModelAndView("index");
    	mdv.addObject("user",new UserBean());
    	System.out.println("userlogin");
    	return mdv;
    }
    @PostMapping("index")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response,
    		UserBean user) {	
    	return userdao.loginUser(request, user);
    }    
    @GetMapping("profile")
    public ModelAndView getprofile(HttpServletRequest request, HttpServletResponse response) {
    	return userdao.profileDetail(request);
    }
    @GetMapping("logout")
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
    	return userdao.logoutUser(request);
    }

}
