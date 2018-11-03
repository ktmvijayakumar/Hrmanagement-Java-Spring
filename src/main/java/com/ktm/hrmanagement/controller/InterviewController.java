package com.ktm.hrmanagement.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ktm.hrmanagement.dao.CallInfoDao;
import com.ktm.hrmanagement.entity.CallInfoEntity;
import com.ktm.hrmanagement.entity.InterviewProcessEntity;
import com.ktm.hrmanagement.entity.UserEntity;
import com.ktm.hrmanagement.utils.Myutils;
@RequestMapping("interview")
@Controller
public class InterviewController {
	
	@Autowired
	private CallInfoDao callinfodao;
		
	@GetMapping("callInfo")
	public ModelAndView getCandidateProfile(@RequestParam int candidate_id,HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mdv=new ModelAndView();
		// Check User has logged on
		HttpSession session = request.getSession();
		UserEntity loginedUser = Myutils.getLoginedUser(session);
		if(loginedUser == null){
			System.out.println("CallInfo Illegal access....");
				mdv.addObject("errorString", "Please Login...");
				mdv.setViewName("index");
		}else{
			mdv = callinfodao.getCandidateProfileDetails(candidate_id);
		}
		return mdv;
	}
	@PostMapping("callInfoStatus")
	public ModelAndView getcallInfoStatus(CallInfoEntity callinfoentity,HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mdv=new ModelAndView();
		// Check User has logged on
		HttpSession session = request.getSession();
		UserEntity loginedUser = Myutils.getLoginedUser(session);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    Date dateobj = new Date();
	    String date=df.format(dateobj);
		if(loginedUser == null){
			System.out.println("CallInfo Illegal access....");
			mdv.addObject("errorString", "Please Login...");
			mdv.setViewName("index");
		}else{
			callinfoentity.setCreated_by(loginedUser.getHr_id());
			callinfoentity.setCreated_date(date);
			System.out.println(callinfoentity.toString());
			mdv = callinfodao.getcallInfoStatusDetails(callinfoentity);
		}
		return mdv;
	}

	@PostMapping("modalcallInfoStatus")
	public ModelAndView getmodalcallInfoStatus(CallInfoEntity callinfoentity,HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mdv=new ModelAndView();
		// Check User has logged on
		HttpSession session = request.getSession();
		UserEntity loginedUser = Myutils.getLoginedUser(session);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    Date dateobj = new Date();
	    String date=df.format(dateobj);
		if(loginedUser == null){
			System.out.println("CallInfo Illegal access....");
			mdv.addObject("errorString", "Please Login...");
			mdv.setViewName("index");
		}else{
			callinfoentity.setCreated_by(loginedUser.getHr_id());
			callinfoentity.setCreated_date(date);
			System.out.println(callinfoentity.toString());
			mdv = callinfodao.getmodalcallInfoStatusDetails(callinfoentity);
		}
		return mdv;
	}

	@GetMapping("reAllocateInterview")
	public ModelAndView getreAllocateInterviewProfile(@RequestParam int candidate_id,HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mdv=new ModelAndView();
		// Check User has logged on
		HttpSession session = request.getSession();
		UserEntity loginedUser = Myutils.getLoginedUser(session);
		if(loginedUser == null){
			System.out.println("CallInfo Illegal access....");
				mdv.addObject("errorString", "Please Login...");
				mdv.setViewName("index");
		}else{
			mdv = callinfodao.getreAllocateInterviewInfoStatus(candidate_id);
		}
		return mdv;
	}
	@PostMapping("reAllocateInterview")
	public ModelAndView getreAllocateInterviewInfoStatus(CallInfoEntity callinfoentity,HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mdv=new ModelAndView();
		// Check User has logged on
		HttpSession session = request.getSession();
		UserEntity loginedUser = Myutils.getLoginedUser(session);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    Date dateobj = new Date();
	    String date=df.format(dateobj);
		if(loginedUser == null){
			System.out.println("CallInfo Illegal access....");
			mdv.addObject("errorString", "Please Login...");
			mdv.setViewName("index");
		}else{
			callinfoentity.setCreated_by(loginedUser.getHr_id());
			callinfoentity.setCreated_date(date);
			mdv = callinfodao.getreAllocateInterviewInfoStatus(callinfoentity);
		}
		return mdv;
	}

	@GetMapping("interview")
	public ModelAndView getinterview(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mdv=new ModelAndView();
		// Check User has logged on
		HttpSession session = request.getSession();
		UserEntity loginedUser = Myutils.getLoginedUser(session);	    
		if(loginedUser == null){
			System.out.println("View interview Illegal access....");
			mdv.addObject("errorString", "Please Login...");
			mdv.setViewName("index");
	    }else{
	    	mdv = callinfodao.getinterviewDetails();
		}
		return mdv;
	}
	
	@GetMapping("interviewDetail")
	public ModelAndView getInterviewDetail(@RequestParam int candidate_id,HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mdv=new ModelAndView();
		// Check User has logged on
		HttpSession session = request.getSession();
		UserEntity loginedUser = Myutils.getLoginedUser(session);
		if(loginedUser == null){
			System.out.println("CandidateDetail Illegal access....");
				mdv.addObject("errorString", "Please Login...");
				mdv.setViewName("index");
		}else{
			mdv = callinfodao.getInterivewDetail(candidate_id);				
		}
		return mdv;
	}
	
	@PostMapping("interviewprocesssave")
	public ModelAndView setInterviewDetail(InterviewProcessEntity interviewprocessentity,HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mdv=new ModelAndView();
		// Check User has logged on
		HttpSession session = request.getSession();
		UserEntity loginedUser = Myutils.getLoginedUser(session);	   
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    Date dateobj = new Date();
	    String date=df.format(dateobj);
		if(loginedUser == null){
			System.out.println("CallInfo Illegal access....");
			mdv.addObject("errorString", "Please Login...");
			mdv.setViewName("index");
		}else{
			interviewprocessentity.setCreated_by(loginedUser.getHr_id());
			interviewprocessentity.setCreated_date(date);
			mdv = callinfodao.setInterviewDetails(interviewprocessentity);
		}
		return mdv;
	}
	
	
}
