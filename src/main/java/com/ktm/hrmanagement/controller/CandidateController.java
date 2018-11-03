package com.ktm.hrmanagement.controller;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ktm.hrmanagement.bean.SearchBean;
import com.ktm.hrmanagement.bean.UserBean;
import com.ktm.hrmanagement.dao.CandidateDao;
import com.ktm.hrmanagement.dao.UserDao;
import com.ktm.hrmanagement.entity.DesignationEntity;
import com.ktm.hrmanagement.entity.InterviewrRoundEntity;
import com.ktm.hrmanagement.entity.NcandidateEntity;
import com.ktm.hrmanagement.entity.UserEntity;
import com.ktm.hrmanagement.utils.Myutils;

@RequestMapping("candidate")
@Controller
public class CandidateController {
	    
	@Autowired
	private CandidateDao candidatedao;
	@Autowired
	private UserDao userdao;
	@PostMapping("index")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response,
    		UserBean user) {	
    	return userdao.loginUser(request, user);
    } 
	@GetMapping("addCandidate")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mdv=new ModelAndView();
    	HttpSession session = request.getSession();
		UserEntity loginedUser = Myutils.getLoginedUser(session);

		if(loginedUser == null){
			System.out.println("Search Illegal access....");
			mdv.addObject("errorString", "Please Login...");
			mdv.setViewName("index");
	    }else{
	    	mdv= candidatedao.getaddDesignation();
			
	    }
    	return mdv;
    }
    @PostMapping("addCandidates")
    public ModelAndView setaddCandidates(HttpServletRequest request, HttpServletResponse response,
    		NcandidateEntity user) {	
    	HttpSession session = request.getSession();
		UserEntity loginedUser = Myutils.getLoginedUser(session);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    Date dateobj = new Date();
	    String date=df.format(dateobj);
    	try{
    	System.out.println("addcandidates");
    	Part part =request.getPart("resume");
		// getting filename
		String fileName = extractFileName(part);
		File f = new File(fileName);
		System.out.println(f.getName());
		// getting savepath
		String savepath = "D:\\workspace\\Hrmanagement\\src\\main\\webapp\\resources\\files\\" + f.getName();
		// writing savepath in images folder
		part.write(savepath + File.separator);
		user.setNcandidate_resume(f.getName());
		user.setNcandidate_filepath(savepath);
		user.setCreated_by(loginedUser.getHr_id());
		user.setCreated_date(date);
    	}catch(Exception e){
    		System.out.println(e);
    	}
    	System.out.println(user.toString());
    	return candidatedao.setaddCandidates(request, user);
    }  
    
    @GetMapping("addDesignation")
    public ModelAndView getaddDesignation(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mdv=new ModelAndView();
    	HttpSession session = request.getSession();
    	System.out.println("addDesignation");
		UserEntity loginedUser = Myutils.getLoginedUser(session);
		if(loginedUser == null){
			System.out.println("Search Illegal access....");
			mdv.addObject("errorString", "Please Login...");
			mdv.setViewName("index");
	    }else{
			mdv.setViewName("addDesignation");
			System.out.println("addDesignation");
	    }
    	return mdv;
    }
    @PostMapping("addDesignations")
    public ModelAndView setaddDesignation(HttpServletRequest request, HttpServletResponse response) {	
    	HttpSession session = request.getSession();
		UserEntity loginedUser = Myutils.getLoginedUser(session);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    Date dateobj = new Date();
	    String date=df.format(dateobj);
	    System.out.println("addDesignation");
	    DesignationEntity user=new DesignationEntity();
	    user.setDesignation_name(request.getParameter("designation_name"));
    	user.setCreated_by(loginedUser.getHr_id());
		user.setCreated_date(date);
	    System.out.println(user.toString());
    	return candidatedao.setaddDesignation(request, user);
    }  
    @PostMapping("addInterviewrounds")
    public ModelAndView setaddInterviewrounds(HttpServletRequest request, HttpServletResponse response) {	
    	HttpSession session = request.getSession();
		UserEntity loginedUser = Myutils.getLoginedUser(session);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    Date dateobj = new Date();
	    String date=df.format(dateobj);
	    System.out.println("addDesignation");
	    InterviewrRoundEntity user=new InterviewrRoundEntity();
	    user.setRound_name(request.getParameter("round_name"));
    	user.setCreated_by(loginedUser.getHr_id());
		user.setCreated_date(date);
	    System.out.println(user.toString());
    	return candidatedao.setaddInterviewrounds(request, user);
    }  
    
	@GetMapping("viewCandidates")
	public ModelAndView viewCandidates(HttpServletRequest request, HttpServletResponse response) {	
		ModelAndView mdv=new ModelAndView();
		// Check User has logged on
			HttpSession session = request.getSession();
			UserEntity loginedUser = Myutils.getLoginedUser(session);
			if(loginedUser == null){
				System.out.println("Search Illegal access....");
				mdv.addObject("errorString", "Please Login...");
				mdv.setViewName("index");
		    }else{
				mdv= candidatedao.viewCandidateDetails();
		    }
		return mdv;
	}
	
	@GetMapping("search")
	public ModelAndView search(HttpServletRequest request, HttpServletResponse response,
		@ModelAttribute("search") SearchBean search) {
			ModelAndView mdv=new ModelAndView();
			// Check User has logged on
			HttpSession session = request.getSession();
			UserEntity loginedUser = Myutils.getLoginedUser(session);
			if(loginedUser == null){
				System.out.println("Search Illegal access....");
				mdv.addObject("errorString", "Please Login...");
				mdv.setViewName("index");
		    }else{
				mdv= candidatedao.searchDetails(search);
		    }
		return mdv;
	}

	@GetMapping("candidateDetail")
	public ModelAndView getCandidateProfile(@RequestParam int candidate_id,HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mdv=new ModelAndView();
		// Check User has logged on
		HttpSession session = request.getSession();
		UserEntity loginedUser = Myutils.getLoginedUser(session);
		if(loginedUser == null){
			System.out.println("CandidateDetail Illegal access....");
				mdv.addObject("errorString", "Please Login...");
				mdv.setViewName("index");
		}else{
			mdv = candidatedao.getCandidateProfileDetails(candidate_id);				
		}
		return mdv;
	}
	
	
	@GetMapping("files")
	public ModelAndView files(@RequestParam int candidate_id,HttpServletRequest request, HttpServletResponse response) {
	ModelAndView mdv=new ModelAndView();
	// Check User has logged on
	HttpSession session = request.getSession();
	UserEntity loginedUser = Myutils.getLoginedUser(session);
	
	if(loginedUser == null){
		System.out.println("Files Illegal access....");
		mdv.addObject("errorString", "Please Login...");
		mdv.setViewName("index");
	}else{
		mdv = candidatedao.fileDetails(candidate_id);
	}
	return mdv;
	}
	
	// extarctiting filename from the request header
			private String extractFileName(Part p) {
				// TODO Auto-generated method stub
				System.out.println("its in extractfilename");
				String contnt = p.getHeader("Content-Disposition");
				String[] items = contnt.split(";");
				for (String s : items) {
					if (s.trim().startsWith("filename")) {
						return s.substring(s.indexOf("=") + 2, s.length() - 1);
					}
				}
				return "";
			}

}

