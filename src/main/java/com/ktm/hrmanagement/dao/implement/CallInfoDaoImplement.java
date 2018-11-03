package com.ktm.hrmanagement.dao.implement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.ktm.hrmanagement.bean.SearchBean;
import com.ktm.hrmanagement.dao.CallInfoDao;
import com.ktm.hrmanagement.bean.CallInfoBean;
import com.ktm.hrmanagement.bean.InterviewCandidateBean;
import com.ktm.hrmanagement.entity.CallInfoEntity;
import com.ktm.hrmanagement.entity.CandidateEntity;
import com.ktm.hrmanagement.entity.InterviewProcessEntity;
import com.ktm.hrmanagement.entity.NcandidateEntity;
import com.ktm.hrmanagement.services.CallInfoService;
import com.ktm.hrmanagement.services.CandidateService;
import com.ktm.hrmanagement.services.InterviewProcessService;
import com.ktm.hrmanagement.services.NcandidateService;

@Service
public class CallInfoDaoImplement implements CallInfoDao {
	
	@Autowired
	private CandidateService candidateImplement;
	@Autowired 
	private NcandidateService ncandidateImplement;
	@Autowired
	private CallInfoService callinfoImplement;
	@Autowired
	private InterviewProcessService interviewprocessImplement;
	
	@Override
	public ModelAndView getCandidateProfileDetails(int candidate_id) {
		ModelAndView mdv=new ModelAndView();
		String errorString = "";
		NcandidateEntity ce=null;
			System.out.println("Call Info");
			try{
				ce=ncandidateImplement.findUser(candidate_id);
			}catch(Exception e){
				errorString = "Error occured...";
				System.out.println(e);
			}
			if(errorString.equals("")){
				mdv.addObject("candidateDetail", ce);
				mdv.addObject("call",new CallInfoBean());
				mdv.setViewName("callInfo");
			}else{
				mdv.addObject("errorString",errorString);
				mdv.setViewName("candidateDetail");
			}
		
		return mdv;
	}

	@Override
	public ModelAndView getcallInfoStatusDetails(CallInfoEntity callinfoentity) throws Exception {
		ModelAndView mdv=new ModelAndView();
		String errorString = "";
		NcandidateEntity ce=null;
		CandidateEntity candidateentity=null;
		List<NcandidateEntity> list= null;
		List<InterviewCandidateBean> list1= null;
		System.out.println("Call Info");
		try{
			System.out.println(callinfoentity.getCandidate_id());
			ce=ncandidateImplement.findUser(callinfoentity.getCandidate_id());
			System.out.println(ce.toString());
			CandidateEntity cae=new CandidateEntity();
			cae.setCandidate_id(ce.getNcandidate_id());
			cae.setCandidate_name(ce.getNcandidate_name());
			cae.setCandidate_age(ce.getNcandidate_age());
			cae.setCandidate_address(ce.getNcandidate_address());
			cae.setCandidate_emailid(ce.getNcandidate_emailid());
			cae.setCandidate_phoneno(ce.getNcandidate_phoneno());
			cae.setCandidate_qualification(ce.getNcandidate_qualification());
			cae.setCandidate_designation(ce.getNcandidate_designation());
			cae.setCandidate_resume(ce.getNcandidate_resume());
			cae.setCandidate_filepath(ce.getNcandidate_filepath());
			cae.setCreated_by(callinfoentity.getCreated_by());
			cae.setCreated_date(ce.getCreated_date());
			System.out.println(cae.toString());
			candidateentity=candidateImplement.findUserByEmailid(ce.getNcandidate_emailid());
			System.out.println(candidateentity.toString());
			if(candidateentity == null){
				System.out.println("Interview registered.");
				candidateImplement.save(cae);
				callinfoImplement.save(callinfoentity);
				ncandidateImplement.delete(ce.getNcandidate_emailid());
				list= ncandidateImplement.findAll();
				list1 = interviewprocessImplement.findInterviewUser(ce.getNcandidate_id());
				System.out.println("Interview registered.");
			}else{
				errorString="Already interview attened by candidate "+ce.getNcandidate_name();
				System.out.println(ce.getNcandidate_id());
				list1 = interviewprocessImplement.findInterviewUser(candidateentity.getCandidate_id());
				System.out.println(list1.toString());
				list= ncandidateImplement.findAll();
			}
			
		}catch(Exception e){
			errorString = "Error occured...";
			System.out.println(e);
		}
		if(errorString.equals("")){
			//ce=candidatedao.findUser(callinfoentity.getCandidate_id());
			mdv.addObject("successMessage", "Interview registered...");
			mdv.addObject("candidateDetail", list);
			mdv.setViewName("viewCandidate");
		}else{
			//throw new Exception("Already interview attened by candidate");
			mdv.addObject("successMessage",errorString);
			mdv.addObject("candidateDetail", ce);
			mdv.addObject("interviewDetail", list1);
			mdv.addObject("callinfoentity",callinfoentity);
			mdv.setViewName("modalCandidateDetail");
		}
	return mdv;
	}
	
	@Override
	public ModelAndView getmodalcallInfoStatusDetails(CallInfoEntity callinfoentity) {
		ModelAndView mdv=new ModelAndView();
		String errorString = "";
		NcandidateEntity ce=null;
		CandidateEntity candidateentity=null;
		List<NcandidateEntity> list= null;
		
		System.out.println("Call Info");
		try{
			System.out.println(callinfoentity.getCandidate_id());
			ce=ncandidateImplement.findUser(callinfoentity.getCandidate_id());
			System.out.println(ce.toString());
			CandidateEntity cae=new CandidateEntity();
			cae.setCandidate_id(ce.getNcandidate_id());
			cae.setCandidate_name(ce.getNcandidate_name());
			cae.setCandidate_age(ce.getNcandidate_age());
			cae.setCandidate_address(ce.getNcandidate_address());
			cae.setCandidate_emailid(ce.getNcandidate_emailid());
			cae.setCandidate_phoneno(ce.getNcandidate_phoneno());
			cae.setCandidate_qualification(ce.getNcandidate_qualification());
			cae.setCandidate_designation(ce.getNcandidate_designation());
			cae.setCandidate_resume(ce.getNcandidate_resume());
			cae.setCandidate_filepath(ce.getNcandidate_filepath());
			cae.setCreated_by(callinfoentity.getCreated_by());
			cae.setCreated_date(ce.getCreated_date());
			System.out.println(cae.toString());
			candidateImplement.save(cae);
			callinfoImplement.save(callinfoentity);
			ncandidateImplement.delete(ce.getNcandidate_emailid());
			list= ncandidateImplement.findAll();
			System.out.println("Interview registered.");
			
		}catch(Exception e){
			errorString = "Error occured...";
			System.out.println(e);
		}
		if(errorString.equals("")){
			//ce=candidatedao.findUser(callinfoentity.getCandidate_id());
			mdv.addObject("successMessage", "Interview registered...");
			mdv.addObject("candidateDetail", list);
			mdv.setViewName("viewCandidate");
		}else{
			//throw new Exception("Already interview attened by candidate");
			mdv.addObject("successMessage",errorString);
			mdv.addObject("candidateDetail", list);
			mdv.addObject("callinfoentity",callinfoentity);
			mdv.setViewName("viewCandidate");
		}
	return mdv;
	}
	@Override
	public ModelAndView getreAllocateInterviewInfoStatus(int candidate_id) {
		// TODO Auto-generated method stub
		ModelAndView mdv=new ModelAndView();
		String errorString = "";
		CandidateEntity ce=null;
			System.out.println("reAllocateInterview");
			try{
				ce=candidateImplement.findUser(candidate_id);
			}catch(Exception e){
				errorString = "Error occured...";
				System.out.println(e);
			}
			if(errorString.equals("")){
				mdv.addObject("candidateDetail", ce);
				mdv.addObject("call",new CallInfoBean());
				mdv.setViewName("reallocateInterview");
			}else{
				mdv.addObject("errorString",errorString);
				mdv.setViewName("candidateDetail");
			}
		
		return mdv;
	}

	@Override
	public ModelAndView getreAllocateInterviewInfoStatus(CallInfoEntity callinfoentity) {
		// TODO Auto-generated method stub
		ModelAndView mdv=new ModelAndView();
		String errorString = "";
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    Date dateobj = new Date();
	    String date=df.format(dateobj);
	    List<InterviewCandidateBean> list= null;
		System.out.println("reAllocateInterviewInfo");
		try{
			System.out.println(callinfoentity.getCandidate_id());
			System.out.println(callinfoentity.toString());
			callinfoImplement.delete(callinfoentity.getCandidate_id());
			System.out.println(callinfoentity.toString());
			callinfoentity.setCandidate_status(0);
			callinfoImplement.save(callinfoentity);
			list = callinfoImplement.findInterview(df.format(dateobj));
			System.out.println("Interview registered.");
		}catch(Exception e){
			errorString = "Error occured...";
			System.out.println(e);
		}
		if(errorString.equals("")){
			mdv.addObject("successMessage", "Interview registered...");
			mdv.addObject("interviewDetail", list);
			mdv.addObject("dates",date);
			mdv.setViewName("interview");
		}else{
			mdv.addObject("successMessage", "Interview registered...");
			mdv.addObject("interviewDetail", list);
			mdv.addObject("errorString",errorString);
			mdv.setViewName("interview");
		}
	return mdv;
	}
	
	
	@Override
	public ModelAndView getinterviewDetails() {
		ModelAndView mdv=new ModelAndView();
		String errorString = "";
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    Date dateobj = new Date();
	    String date=df.format(dateobj);
	    
		List<InterviewCandidateBean> list= null;
			System.out.println("View Interview");
			try{
			    System.out.println(df.format(dateobj));
			    list = callinfoImplement.findInterview(df.format(dateobj));
			    System.out.println(list.toString());
			}catch(Exception e){
				errorString="Error occured...";
				System.out.println(e);
				mdv.addObject("errorString",errorString);
				mdv.setViewName("profile");
			}
		
		if(errorString.equals("")){
			mdv.addObject("dates",date);
			mdv.addObject("interviewDetail", list);
			mdv.addObject("search",new SearchBean());
			mdv.setViewName("interview");
		}else{
			mdv.addObject("errorString",errorString);
			mdv.setViewName("index");
		}	
		return mdv;
	}

	@Override
	public ModelAndView getInterivewDetail(int candidate_id) {
		ModelAndView mdv=new ModelAndView();
		String errorString = "";
		List<InterviewCandidateBean> ce=null;
			System.out.println("Call Info");
			try{
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			    Date dateobj = new Date();
			    System.out.println(df.format(dateobj));
				ce=callinfoImplement.findInterviewUser(candidate_id,df.format(dateobj));
				System.out.println(ce);
			}catch(Exception e){
				errorString = "Error occured...";
				System.out.println(e);
			}
			if(errorString.equals("")){
				mdv.addObject("candidateDetail", ce);
				mdv.addObject("call",new CallInfoBean());
				mdv.setViewName("interviewround");
			}else{
				mdv.addObject("errorString",errorString);
				mdv.setViewName("interview");
			}
		return mdv;
	}

	@Override
	public ModelAndView setInterviewDetails(InterviewProcessEntity interviewprocessentity) {
		ModelAndView mdv=new ModelAndView();
		String errorString = "";
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    Date dateobj = new Date();
	    String date=df.format(dateobj);
		List<InterviewCandidateBean> list=null;
		List<InterviewCandidateBean> ce=null;
		System.out.println("interview Process");
		System.out.println(interviewprocessentity.toString());
		System.out.println(df.format(dateobj)+"  "+date);
		try{
			interviewprocessentity.setInterview_date(df.format(dateobj));
			InterviewProcessEntity ipe=interviewprocessImplement.findInterviewDetail(interviewprocessentity.getCandidate_id(),interviewprocessentity.getRound_id(),interviewprocessentity.getInterview_date());
			if(ipe == null){
				interviewprocessImplement.save(interviewprocessentity);
				if(interviewprocessentity.getRound_statusid()==2){
					callinfoImplement.update(interviewprocessentity.getCandidate_id(),1);
				}
				if(interviewprocessentity.getRound_id()==3){
					callinfoImplement.update(interviewprocessentity.getCandidate_id(),1);
				}
			}else{
				errorString = "Already round details registered...";
			}
			System.out.println(interviewprocessentity.getCandidate_id());
			list = callinfoImplement.findInterview(df.format(dateobj));
			System.out.println(list);
		}catch(Exception e){
			errorString = "Error occured...";
			System.out.println(e);
		}
		if(errorString.equals("")){
			mdv.addObject("successMessage", "Registered...");
			mdv.addObject("dates",date);
			mdv.addObject("interviewDetail", list);
			mdv.setViewName("interview");
		}else{
			ce=callinfoImplement.findInterviewUser(interviewprocessentity.getCandidate_id(),df.format(dateobj));
			mdv.addObject("candidateDetail", ce);
			mdv.addObject("successMessage",errorString);
			mdv.setViewName("interviewround");
		}
		return mdv;
	}

	@Override
	public ModelAndView searchDetails(String date) {
		// TODO Auto-generated method stub
		ModelAndView mdv=new ModelAndView();
		String errorString = "";
		List<InterviewCandidateBean> rob=null;
		List<InterviewCandidateBean> rtb=null;
		List<InterviewCandidateBean> rthb=null;
		List<InterviewCandidateBean> rfb=null;
		System.out.println("SearchResults");
		System.out.println("Designation Name: "+date);
		   	try{
		  		rob=interviewprocessImplement.getSearchResult(date,1);
		  		rtb=interviewprocessImplement.getSearchResult(date,2);
		  		rthb=interviewprocessImplement.getSearchResult(date,3);
		  		rfb=interviewprocessImplement.getSearchResult(date,4);
		   		if(rob.equals(null)){
		    			errorString ="Not Found...";
		   		}
		   	}catch(NullPointerException e){
				errorString = "Not Found...";
			}
		
		if(errorString.equals("")){
			mdv.addObject("searchdate", date);
			mdv.addObject("roundOneDetail", rob);
			mdv.addObject("roundTwoDetail", rtb);
			mdv.addObject("roundThreeDetail", rthb);
			mdv.addObject("roundFourDetail", rfb);
			mdv.setViewName("viewResultDate");
		}else{
			mdv.addObject("errorString",errorString);
			mdv.setViewName("viewCandidate");
		}
		return mdv;
	}


	
	
}
