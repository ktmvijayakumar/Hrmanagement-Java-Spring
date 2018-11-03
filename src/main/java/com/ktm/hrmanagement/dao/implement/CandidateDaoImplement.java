package com.ktm.hrmanagement.dao.implement;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.ktm.hrmanagement.bean.SearchBean;
import com.ktm.hrmanagement.dao.CandidateDao;
import com.ktm.hrmanagement.entity.CandidateEntity;
import com.ktm.hrmanagement.entity.DesignationEntity;
import com.ktm.hrmanagement.entity.InterviewrRoundEntity;
import com.ktm.hrmanagement.entity.NcandidateEntity;
import com.ktm.hrmanagement.services.CandidateService;
import com.ktm.hrmanagement.services.DesignationService;
import com.ktm.hrmanagement.services.InterviewRoundService;
import com.ktm.hrmanagement.services.NcandidateService;
@Service
public class CandidateDaoImplement implements CandidateDao{

	@Autowired
	private CandidateService candidateService;
	@Autowired 
	private NcandidateService ncandidateService;
	@Autowired
	private DesignationService designationService;
	@Autowired
	private InterviewRoundService interviewroundService;
	@Override
	public ModelAndView viewCandidateDetails() {
		ModelAndView mdv=new ModelAndView();
		String errorString = "";
		List<NcandidateEntity> list= null;
		// Check User has logged on
			System.out.println("View Candidate");
			try{
				list= ncandidateService.findAll();
				System.out.println(list.toString());
			}catch(Exception e){
				errorString="Error occured...";
				System.out.println(e);
			}
		if(errorString.equals("")){
			mdv.addObject("candidateDetail", list);
			mdv.addObject("search",new SearchBean());
			mdv.setViewName("viewCandidate");
		}else{
			mdv.addObject("errorString",errorString);
			mdv.setViewName("index");
		}	
		return mdv;
	}
	
	@Override
	public ModelAndView searchDetails(SearchBean search) {
		// TODO Auto-generated method stub
		ModelAndView mdv=new ModelAndView();
		String errorString = "";
		List<NcandidateEntity> ub=null;
			System.out.println("Search");
			System.out.println("Designation Name: "+search.getName());
			if(search.getName().isEmpty()){
				mdv.setViewName("viewCandidate");
			}else{
		    	try{
		    		ub=ncandidateService.getSearch(search.getName());
		    		System.out.println(ub.toString());
		    		if(ub.equals(null)){
		    			errorString ="Not Found...";
		    		}
				}catch(NullPointerException e){
					errorString = "Not Found...";
				}
			}
			if(errorString.equals("")){
				mdv.addObject("candidateDetail", ub);
				mdv.setViewName("viewCandidate");
			}else{
				mdv.addObject("errorString",errorString);
				mdv.setViewName("viewCandidate");
			}
		
		return mdv;
	}
	@Override
	public ModelAndView getCandidateProfileDetails(int candidate_id) {
		ModelAndView mdv=new ModelAndView();
		String errorString = "";
		NcandidateEntity ce=null;
			System.out.println("Candidate Detail");
			try{
				ce=ncandidateService.findUser(candidate_id);
			}catch(Exception e){
				errorString = "Error occured...";
				System.out.println(e);
			}
			if(errorString.equals("")){
				mdv.addObject("candidateDetail", ce);
				mdv.setViewName("candidateDetail");
			}else{
				mdv.addObject("errorString",errorString);
				mdv.setViewName("viewCandidate");
			}
		return mdv;
	}
	
	@Override
	public ModelAndView fileDetails(int candidate_id) {
		ModelAndView mdv=new ModelAndView();
		String errorString = "";
		NcandidateEntity ce=null;
		System.out.println("Candidate Resume");	
			try{
				ce=ncandidateService.findUser(candidate_id);
			}catch(Exception e){
				errorString = "Error occured...";
				System.out.println(e);
			}	
		if(errorString.equals("")){
			mdv.addObject("candidateDetail", ce);
			mdv.setViewName("file");
		}else{
			mdv.addObject("errorString",errorString);
			mdv.setViewName("index");
		}	
		return mdv;
	}

	@Override
	public ModelAndView getCandidateProfileDetailsAcceptance(int candidate_id) {
		// TODO Auto-generated method stub
		ModelAndView mdv=new ModelAndView();
		String errorString = "";
		CandidateEntity ce=null;
			System.out.println("Candidate Detail");
			try{
				ce=candidateService.findUser(candidate_id);
			}catch(Exception e){
				errorString = "Error occured...";
				System.out.println(e);
			}
			if(errorString.equals("")){
				mdv.addObject("candidateDetail", ce);
				mdv.setViewName("candidateDetailAcceptance");
			}else{
				mdv.addObject("errorString",errorString);
				mdv.setViewName("viewCandidate");
			}
		return mdv;
	}

	@Override
	public ModelAndView setaddCandidates(HttpServletRequest request, NcandidateEntity user) {
		// TODO Auto-generated method stub
		ModelAndView mdv=new ModelAndView();
		String errorString = "";
		List<DesignationEntity> list1= null;
		System.out.println("Call Info");
		try{
			System.out.println(user.getNcandidate_id());
			String split=user.getNcandidate_designation();
			System.out.println(split);
			String[] arrSplit = split.split(",");
		    for (int i=0; i < arrSplit.length; i++)
		    {
		      System.out.println(arrSplit[i]);
		      user.setNcandidate_designation(arrSplit[i]);
		      ncandidateService.save(user);
		    }
		    list1= designationService.findAll();
			System.out.println("Interview registered.");
		}catch(Exception e){
			errorString = "Error occured...";
			System.out.println(e);
		}
		if(errorString.equals("")){
			mdv.addObject("DesignationDetail", list1);
			//ce=candidatedao.findUser(callinfoentity.getCandidate_id());
			mdv.addObject("successMessage", "Candidate registered...");
			mdv.setViewName("addCandidate");
		}else{
			mdv.addObject("successMessage",errorString);
			mdv.setViewName("addCandidate");
		}
	return mdv;
	}

	@Override
	public ModelAndView setaddDesignation(HttpServletRequest request, DesignationEntity user) {
		// TODO Auto-generated method stub
		ModelAndView mdv=new ModelAndView();
		String errorString = "";
		System.out.println("Designation detail");
		try{
			System.out.println(user.getDesignation_name());
			designationService.save(user);
		    System.out.println("Designation registered.");
		}catch(Exception e){
			errorString = "Error occured...";
			System.out.println(e);
		}
		if(errorString.equals("")){
			//ce=candidatedao.findUser(callinfoentity.getCandidate_id());
			mdv.addObject("successMessage", "Domain registered...");
			mdv.setViewName("addDesignation");
		}else{
			mdv.addObject("successMessage",errorString);
			mdv.setViewName("addDesignation");
		}
	return mdv;
	}

	@Override
	public ModelAndView getaddDesignation() {
		// TODO Auto-generated method stub
		ModelAndView mdv=new ModelAndView();
		String errorString = "";
		List<DesignationEntity> list= null;
		// Check User has logged on
			System.out.println("View Candidate");
			try{
				list= designationService.findAll();
				System.out.println(list.toString());
			}catch(Exception e){
				errorString="Error occured...";
				System.out.println(e);
			}
		if(errorString.equals("")){
			mdv.addObject("DesignationDetail", list);
			mdv.addObject("search",new SearchBean());
			mdv.setViewName("addCandidate");
		}else{
			mdv.addObject("errorString",errorString);
			mdv.setViewName("index");
		}	
		return mdv;
	}

	@Override
	public ModelAndView setaddInterviewrounds(HttpServletRequest request, InterviewrRoundEntity user) {
		// TODO Auto-generated method stub
		ModelAndView mdv=new ModelAndView();
		String errorString = "";
		System.out.println("Designation detail");
		try{
			System.out.println(user.getRound_name());
			interviewroundService.save(user);
		    System.out.println("Designation registered.");
		}catch(Exception e){
			errorString = "Error occured...";
			System.out.println(e);
		}
		if(errorString.equals("")){
			//ce=candidatedao.findUser(callinfoentity.getCandidate_id());
			mdv.addObject("successMessageround", "Round registered...");
			mdv.setViewName("addDesignation");
		}else{
			mdv.addObject("successMessageround",errorString);
			mdv.setViewName("addDesignation");
		}
	return mdv;
	}

	
	
}
