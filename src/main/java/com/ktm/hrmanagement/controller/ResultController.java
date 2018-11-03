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
import com.ktm.hrmanagement.dao.CandidateDao;
import com.ktm.hrmanagement.dao.ResultDao;
import com.ktm.hrmanagement.entity.CallLetterEntity;
import com.ktm.hrmanagement.entity.CertificateVerificationEntity;
import com.ktm.hrmanagement.entity.UserEntity;
import com.ktm.hrmanagement.utils.Myutils;
@RequestMapping("res")
@Controller
public class ResultController {

	@Autowired
	private CallInfoDao callinfodao;
	@Autowired
	private CandidateDao candidatedao;
	@Autowired
	private ResultDao resultdao;
	
	@GetMapping("viewResult")
	public ModelAndView getInterviewResults(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mdv=new ModelAndView();
		// Check User has logged on
		HttpSession session = request.getSession();
		UserEntity loginedUser = Myutils.getLoginedUser(session);
		if(loginedUser == null){
			System.out.println("InterviewResults Illegal access....");
				mdv.addObject("errorString", "Please Login...");
				mdv.setViewName("index");
		}else{
			mdv.setViewName("viewInterviewResult");				
		}
		return mdv;
	}
	
	@GetMapping("searchResult")
	public ModelAndView searchresult(HttpServletRequest request, HttpServletResponse response) {
			ModelAndView mdv=new ModelAndView();
			// Check User has logged on
			HttpSession session = request.getSession();
			UserEntity loginedUser = Myutils.getLoginedUser(session);
			if(loginedUser == null){
				System.out.println("Search Illegal access....");
				mdv.addObject("errorString", "Please Login...");
				mdv.setViewName("index");
		    }else{
		    	String date=request.getParameter("date");
		    	if(date.isEmpty()){
		    		mdv.setViewName("viewInterviewResult");
		    	}else{
		    		mdv = callinfodao.searchDetails(date);
		    	}
		    }
		return mdv;
	}
	
	@GetMapping("resultDetail")
	public ModelAndView getInterviewResultDetail(@RequestParam int candidate_id,@RequestParam int round_id,@RequestParam String date,HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mdv=new ModelAndView();
		// Check User has logged on
		HttpSession session = request.getSession();
		UserEntity loginedUser = Myutils.getLoginedUser(session);
		if(loginedUser == null){
			System.out.println("InterviewResultDetail Illegal access....");
				mdv.addObject("errorString", "Please Login...");
				mdv.setViewName("index");
		}else{
			mdv = resultdao.getresultDetail(candidate_id,round_id,date);				
		}
		return mdv;
	}
	
	@GetMapping("selectedCandidates")
	public ModelAndView getSelectedCandidatesDetail(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mdv=new ModelAndView();
		// Check User has logged on
		HttpSession session = request.getSession();
		UserEntity loginedUser = Myutils.getLoginedUser(session);
		if(loginedUser == null){
			System.out.println("SelectedCandidatesDetail Illegal access....");
				mdv.addObject("errorString", "Please Login...");
				mdv.setViewName("index");
		}else{
			mdv = resultdao.getSelectedCandidatesDetail(3,1);				
		}
		return mdv;
	}
	
	@GetMapping("searchSelectedCandidateResult")
	public ModelAndView searchSelectedCandidateResult(HttpServletRequest request, HttpServletResponse response) {
			ModelAndView mdv=new ModelAndView();
			// Check User has logged on
			HttpSession session = request.getSession();
			UserEntity loginedUser = Myutils.getLoginedUser(session);
			if(loginedUser == null){
				System.out.println("Search Illegal access....");
				mdv.addObject("errorString", "Please Login...");
				mdv.setViewName("index");
		    }else{
		    	String date=request.getParameter("date");
		    	if(date.isEmpty()){
		    		mdv.setViewName("viewInterviewResult");
		    	}else{
		    		mdv = resultdao.searchSelectedCandidateResultDetails(date);
		    	}
		    }
		return mdv;
	}
	
	@GetMapping("selectedCandidateDetail")
	public ModelAndView getSelectedCandidateProfile(@RequestParam int candidate_id,HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mdv=new ModelAndView();
		// Check User has logged on
		HttpSession session = request.getSession();
		UserEntity loginedUser = Myutils.getLoginedUser(session);
		if(loginedUser == null){
			System.out.println("SelectedCandidateProfile Illegal access....");
				mdv.addObject("errorString", "Please Login...");
				mdv.setViewName("index");
		}else{
			mdv = resultdao.getSelectedCandidateProfileDetails(candidate_id);
		}
		return mdv;
	}
	
	@GetMapping("callLetterReleaseDetail")
	public ModelAndView setcallLetterReleaseDetail(@RequestParam int candidate_id,HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mdv=new ModelAndView();
		// Check User has logged on
		HttpSession session = request.getSession();
		UserEntity loginedUser = Myutils.getLoginedUser(session);
		if(loginedUser == null){
			System.out.println("callLetterReleaseDetail Illegal access....");
				mdv.addObject("errorString", "Please Login...");
				mdv.setViewName("index");
		}else{
			mdv = resultdao.setcallLetterReleaseDetail(candidate_id,loginedUser.getHr_id());
		}
		return mdv;
	}
	
	@GetMapping("callLetterAcceptedDetail")
	public ModelAndView setcallLetterAcceptedDetail(@RequestParam int candidate_id,HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mdv=new ModelAndView();
		// Check User has logged on
		HttpSession session = request.getSession();
		UserEntity loginedUser = Myutils.getLoginedUser(session);
		if(loginedUser == null){
			System.out.println("callLetterReleaseDetail Illegal access....");
				mdv.addObject("errorString", "Please Login...");
				mdv.setViewName("index");
		}else{
			mdv = resultdao.setcallLetterAcceptedDetail(candidate_id);
		}
		return mdv;
	}
	
	@PostMapping("callLetterAcceptanceInfoStatus")
	public ModelAndView getcallLetterAcceptanceInfoStatus(CallLetterEntity callletterentity,HttpServletRequest request, HttpServletResponse response) {
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
			callletterentity.setCreated_by(loginedUser.getHr_id());
			callletterentity.setCreated_date(date);
			mdv = resultdao.getcallLetterAcceptanceInfoStatus(callletterentity);
		}
		return mdv;
	}

	@GetMapping("acceptedCandidates")
	public ModelAndView getAcceptedCandidatesDetail(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mdv=new ModelAndView();
		// Check User has logged on
		HttpSession session = request.getSession();
		UserEntity loginedUser = Myutils.getLoginedUser(session);
		if(loginedUser == null){
			System.out.println("SelectedCandidatesDetail Illegal access....");
				mdv.addObject("errorString", "Please Login...");
				mdv.setViewName("index");
		}else{
			mdv = resultdao.getAcceptedCandidatesDetail();				
		}
		return mdv;
	}
	
	@GetMapping("candidateDetailAcceptance")
	public ModelAndView getCandidateProfileAcceptance(@RequestParam int candidate_id,HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mdv=new ModelAndView();
		// Check User has logged on
		HttpSession session = request.getSession();
		UserEntity loginedUser = Myutils.getLoginedUser(session);
		if(loginedUser == null){
			System.out.println("CandidateDetail Illegal access....");
				mdv.addObject("errorString", "Please Login...");
				mdv.setViewName("index");
		}else{
			mdv = candidatedao.getCandidateProfileDetailsAcceptance(candidate_id);				
		}
		return mdv;
	}
	
	@GetMapping("callLetterRelease")
	public ModelAndView getCallLetterRelease(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mdv=new ModelAndView();
		// Check User has logged on
		HttpSession session = request.getSession();
		UserEntity loginedUser = Myutils.getLoginedUser(session);
		if(loginedUser == null){
			System.out.println("SelectedCandidateProfile Illegal access....");
				mdv.addObject("errorString", "Please Login...");
				mdv.setViewName("index");
		}else{
			mdv = resultdao.getCallLetterRelease();
		}
		return mdv;
	}
	
	@GetMapping("releaseCandidateDetail")
	public ModelAndView getReleaseCandidateProfile(@RequestParam int candidate_id,HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mdv=new ModelAndView();
		// Check User has logged on
		HttpSession session = request.getSession();
		UserEntity loginedUser = Myutils.getLoginedUser(session);
		if(loginedUser == null){
			System.out.println("SelectedCandidateProfile Illegal access....");
				mdv.addObject("errorString", "Please Login...");
				mdv.setViewName("index");
		}else{
			mdv = resultdao.getReleaseCandidateProfileDetails(candidate_id);
		}
		return mdv;
	}
	
	@GetMapping("certificateVerify")
	public ModelAndView getcertificateVerify(@RequestParam int candidate_id,HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mdv=new ModelAndView();
		// Check User has logged on
		HttpSession session = request.getSession();
		UserEntity loginedUser = Myutils.getLoginedUser(session);
		if(loginedUser == null){
			System.out.println("certificateVerify Illegal access....");
				mdv.addObject("errorString", "Please Login...");
				mdv.setViewName("index");
		}else{
			mdv = resultdao.getCertificateVerifyDetails(candidate_id);
		}
		return mdv;
	}
	@PostMapping("certificateVerifyStatus")
	public ModelAndView setcertificateVerifyStatus(CertificateVerificationEntity certificateVerifyentity,HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mdv=new ModelAndView();
		// Check User has logged on
		HttpSession session = request.getSession();
		UserEntity loginedUser = Myutils.getLoginedUser(session);	   
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    Date dateobj = new Date();
	    String date=df.format(dateobj);
		if(loginedUser == null){
			System.out.println("certificateVerify Illegal access....");
			mdv.addObject("errorString", "Please Login...");
			mdv.setViewName("index");
		}else{
			certificateVerifyentity.setCreated_by(loginedUser.getHr_id());
			certificateVerifyentity.setCreated_date(date);
			mdv = resultdao.setCertificateVerifyStatusDetails(certificateVerifyentity);
		}
		return mdv;
	}
	@GetMapping("employee")
	public ModelAndView getemployee(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mdv=new ModelAndView();
		// Check User has logged on
		HttpSession session = request.getSession();
		UserEntity loginedUser = Myutils.getLoginedUser(session);
		
		if(loginedUser == null){
			System.out.println("employeeProfile Illegal access....");
				mdv.addObject("errorString", "Please Login...");
				mdv.setViewName("index");
		}else{
			mdv = resultdao.getemployee();
		}
		return mdv;
	}
	
	@GetMapping("employeeDetail")
	public ModelAndView getEmployeeProfile(@RequestParam int candidate_id,HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mdv=new ModelAndView();
		// Check User has logged on
		HttpSession session = request.getSession();
		UserEntity loginedUser = Myutils.getLoginedUser(session);
		if(loginedUser == null){
			System.out.println("employeeDetail Illegal access....");
				mdv.addObject("errorString", "Please Login...");
				mdv.setViewName("index");
		}else{
			mdv = resultdao.getemployeeProfileDetails(candidate_id);				
		}
		return mdv;
	}
}
