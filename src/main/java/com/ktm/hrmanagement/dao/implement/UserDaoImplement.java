package com.ktm.hrmanagement.dao.implement;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.ktm.hrmanagement.bean.UserBean;
import com.ktm.hrmanagement.dao.UserDao;
import com.ktm.hrmanagement.entity.DesignationEntity;
import com.ktm.hrmanagement.entity.NcandidateEntity;
import com.ktm.hrmanagement.entity.UserEntity;
import com.ktm.hrmanagement.services.DesignationService;
import com.ktm.hrmanagement.services.NcandidateService;
import com.ktm.hrmanagement.services.UserService;
import com.ktm.hrmanagement.utils.Myutils;

@Service
public class UserDaoImplement implements UserDao{

	@Autowired
	private UserService userImplement;
	@Autowired 
	private NcandidateService ncandidateImplement;
	@Autowired
	private DesignationService designationImplement;
	@Override
	public ModelAndView loginUser(HttpServletRequest request,UserBean user) {
		// TODO Auto-generated method stub
		System.out.println("login");
    	ModelAndView mdv=new ModelAndView();
    	String errorString = "";
    	List<DesignationEntity> list1= null;
    	List<NcandidateEntity> list= null;
    	System.out.println("emailid "+user.getHr_emailid()+"\t"+"password "+user.getHr_password());
    	UserEntity ub=null;
    	if(user.getHr_emailid().equals("") || user.getHr_password().equals("")){
    		errorString = "Enter all fields...";
    	}else{
        	try{
	    		ub=(UserEntity) userImplement.getHrs(user.getHr_emailid(),user.getHr_password());
	    		list= ncandidateImplement.findAll();
	    		list1= designationImplement.findAll();
	    		System.out.println(list.toString());
	    		if(ub.equals(null)){
	    			errorString ="Invalid Emailid and Password...";
	    		}
    		}catch(NullPointerException e){
    			errorString = "Invalid Emailid and Password...";
    		}
    	}
    	if(errorString.equals("")){
    		HttpSession session = request.getSession();
            Myutils.storeLoginedUser(session, ub);
            mdv.addObject("DesignationDetail", list1);
            mdv.addObject("candidateDetail", list);
    		mdv.addObject("userDetail", ub);
    		mdv.setViewName("addCandidate");
    	}else{
    		mdv.addObject("errorString",errorString);
			mdv.setViewName("index");
    	}
    	return mdv;
	}
	
	@Override
	public ModelAndView profileDetail(HttpServletRequest request){
		ModelAndView mdv=new ModelAndView();  	
    	String errorString = "";
    	UserEntity ub=null;
    	// Check User has logged on
    	HttpSession session = request.getSession();
		UserEntity loginedUser = Myutils.getLoginedUser(session);
	    
    	if(loginedUser == null){
    		System.out.println("Profile Illegal access....");
	    	errorString="Please Login...";
	    }else{
	    	System.out.println("profile");
		    System.out.println("logined user: "+loginedUser.getHr_emailid());
    		
	    	try{
	    		ub= userImplement.findUser(loginedUser.getHr_id());
	    		System.out.println("profile "+ub.getHr_emailid());
	    	}catch(Exception e){
	    		System.out.println(e);
	    	}
	    }
    	if(errorString.equals("")){
    		mdv.addObject("userDetail", ub);
    		mdv.setViewName("profile");
    	}else{
    		mdv.addObject("errorString",errorString);
			mdv.setViewName("index");
    	}
	    return mdv;
	}
	
	@Override
	public ModelAndView logoutUser(HttpServletRequest request) {
    	ModelAndView mdv=new ModelAndView();
    	try{
	    	System.out.println("logout");
	    	HttpSession session=request.getSession();
	        UserEntity loginedUser = Myutils.getLoginedUser(session);
	        session.removeAttribute(loginedUser.getHr_name());
	        session.invalidate();
	    	mdv.addObject("user",new UserBean());
	    	mdv.setViewName("index");
    	}catch(Exception e){
    		System.out.println(e);
    		try{
    			mdv.setViewName("index");
    		}catch(Exception e1){
    			System.out.println(e1);
    		}
    	}
    	return mdv;
    }
	

}
