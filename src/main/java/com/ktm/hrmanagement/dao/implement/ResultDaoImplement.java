package com.ktm.hrmanagement.dao.implement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.ktm.hrmanagement.bean.CallInfoBean;
import com.ktm.hrmanagement.bean.InterviewCandidateBean;
import com.ktm.hrmanagement.bean.SearchBean;
import com.ktm.hrmanagement.dao.ResultDao;
import com.ktm.hrmanagement.entity.CallLetterEntity;
import com.ktm.hrmanagement.entity.CandidateEntity;
import com.ktm.hrmanagement.entity.CertificateVerificationEntity;
import com.ktm.hrmanagement.entity.EmployeeEntity;
import com.ktm.hrmanagement.services.CallLetterService;
import com.ktm.hrmanagement.services.CallLetterReleaseService;
import com.ktm.hrmanagement.services.CandidateService;
import com.ktm.hrmanagement.services.CertificateVerificationService;
import com.ktm.hrmanagement.services.EmployeeService;
import com.ktm.hrmanagement.services.InterviewProcessService;

@Service
public class ResultDaoImplement implements ResultDao{
	@Autowired
	private CandidateService candidateImplement;
	@Autowired
	private InterviewProcessService interviewprocessImplement;
	@Autowired
	private CallLetterReleaseService callletterreleaseImplement;
	@Autowired
	private CallLetterService callletterImplement;
	@Autowired
	private EmployeeService employeeImplement;
	@Autowired
	private CertificateVerificationService certificateverificationImplement;
	@Override
	public ModelAndView getresultDetail(int candidate_id,int round_id,String date) {
		ModelAndView mdv=new ModelAndView();
		String errorString = "";
		List<InterviewCandidateBean> ce=null;
			System.out.println("Call Info");
			try{
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			    Date dateobj = new Date();
			    System.out.println(df.format(dateobj));
				ce=interviewprocessImplement.findInterviewUserRoundResult(candidate_id,round_id,date);
				System.out.println(ce.toString());
			}catch(Exception e){
				errorString = "Error occured...";
				System.out.println(e);
			}
			if(errorString.equals("")){
				mdv.addObject("roundResultDetail", ce);
				
				mdv.addObject("call",new CallInfoBean());
				mdv.setViewName("roundComments");
			}else{
				mdv.addObject("errorString",errorString);
				mdv.setViewName("interview");
			}
		return mdv;
	}

	@Override
	public ModelAndView getSelectedCandidatesDetail(int round_id, int round_statusid) {
		// TODO Auto-generated method stub
		ModelAndView mdv=new ModelAndView();
		String errorString = "";
		List<InterviewCandidateBean> ce=null;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    Date dateobj = new Date();
	    System.out.println(df.format(dateobj));
			System.out.println("Selected Candidates");
			try{
				ce=interviewprocessImplement.findSelectedCandidates(round_id,round_statusid,df.format(dateobj));
				System.out.println(ce);
			}catch(Exception e){
				errorString = "Error occured...";
				System.out.println(e);
			}
			if(errorString.equals("")){
				mdv.addObject("dates", df.format(dateobj));
				mdv.addObject("selectedCandidatesDetail", ce);
				mdv.addObject("call",new CallInfoBean());
				mdv.setViewName("selectedCandidates");
			}else{
				mdv.addObject("errorString",errorString);
				mdv.setViewName("interview");
			}
		return mdv;
	}

	@Override
	public ModelAndView getSelectedCandidateProfileDetails(int candidate_id) {
		// TODO Auto-generated method stub
		ModelAndView mdv=new ModelAndView();
		String errorString = "";
		List<InterviewCandidateBean> ce=null;
			System.out.println("Call Info");
			try{
				ce=interviewprocessImplement.findSelectedCandidateProfileDetails(candidate_id);
			}catch(Exception e){
				errorString = "Error occured...";
				System.out.println(e);
			}
			if(errorString.equals("")){
				mdv.addObject("selectedCandidateDetail", ce);
				mdv.setViewName("selectedCandidateProfile");
			}else{
				mdv.addObject("errorString",errorString);
				mdv.setViewName("candidateDetail");
			}		
		return mdv;
	}

	@Override
	public ModelAndView setcallLetterReleaseDetail(int candidate_id,int created_by) {
		// TODO Auto-generated method stub
		ModelAndView mdv=new ModelAndView();
		String errorString = "";
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date dateobj = new Date();
		System.out.println(df.format(dateobj));
		List<InterviewCandidateBean> ce=null;
			System.out.println("Call Info");
			try{
				
				callletterreleaseImplement.setcallLetterReleaseDetail(candidate_id,df.format(dateobj),created_by,df.format(dateobj));
				ce=interviewprocessImplement.findSelectedCandidates(3,1,df.format(dateobj));
			}catch(Exception e){
				errorString = "Error occured...";
				System.out.println(e);
			}
			if(errorString.equals("")){
				System.out.println(ce);
				mdv.addObject("dates", df.format(dateobj));
				mdv.addObject("successMessage", "Call Letter Released...");
				mdv.addObject("selectedCandidatesDetail", ce);
				mdv.setViewName("selectedCandidates");
			}else{
				ce=interviewprocessImplement.findSelectedCandidateProfileDetails(candidate_id);
				mdv.addObject("successMessage"," Allready Call Letter Released...");
				mdv.addObject("selectedCandidateDetail", ce);
				mdv.setViewName("selectedCandidateProfile");
			}		
		return mdv;
	}

	@Override
	public ModelAndView setcallLetterAcceptedDetail(int candidate_id) {
		ModelAndView mdv=new ModelAndView();
		String errorString = "";
		CandidateEntity ce=null;
			System.out.println("Call Info");
			try{
				ce=candidateImplement.findUser(candidate_id);
			}catch(Exception e){
				errorString = "Error occured...";
				System.out.println(e);
			}
			if(errorString.equals("")){
				mdv.addObject("candidateDetail", ce);
				mdv.addObject("call",new CallInfoBean());
				mdv.setViewName("callLetterAcceptanceInfo");
			}else{
				mdv.addObject("errorString",errorString);
				mdv.setViewName("candidateDetail");
			}
		return mdv;
	}

	@Override
	public ModelAndView getcallLetterAcceptanceInfoStatus(CallLetterEntity callletterentity) {
			ModelAndView mdv=new ModelAndView();
			String errorString = "";
			List<InterviewCandidateBean> ce=null;
			System.out.println("Call Letter Acceptance");
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Date dateobj = new Date();
			System.out.println(df.format(dateobj));
			try{
				System.out.println(callletterentity.getCandidate_id());
				callletterImplement.save(callletterentity);
				callletterreleaseImplement.update(callletterentity.getCandidate_id(),1,callletterentity.getCreated_by(),callletterentity.getCreated_date());
				System.out.println("Interview registered.");
			}catch(Exception e){
				errorString = "Error occured...";
				System.out.println(e);
			}
			if(errorString.equals("")){
				ce=callletterreleaseImplement.getCallLetterRelease(df.format(dateobj));
				mdv.addObject("successMessage", "Success...");
				mdv.addObject("selectedCandidatesDetail", ce);
				mdv.setViewName("callLetterReleaseCandidates");
			}else{
				mdv.addObject("errorString",errorString);
				mdv.setViewName("candidateDetail");
			}
		return mdv;
		
	}

	@Override
	public ModelAndView getAcceptedCandidatesDetail() {
		// TODO Auto-generated method stub
		ModelAndView mdv=new ModelAndView();
		String errorString = "";
		List<InterviewCandidateBean> ce=null;
			System.out.println("Accepted Candidates");
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		    Date dateobj = new Date();
		    System.out.println(df.format(dateobj));
			try{
				ce=callletterImplement.findAcceptedCandidates(df.format(dateobj));
				System.out.println(ce);
			}catch(Exception e){
				errorString = "Error occured...";
				System.out.println(e);
			}
			if(errorString.equals("")){
				mdv.addObject("selectedCandidatesDetail", ce);
				mdv.addObject("call",new CallInfoBean());
				mdv.setViewName("acceptedCandidates");
			}else{
				mdv.addObject("errorString",errorString);
				mdv.setViewName("interview");
			}
		return mdv;
	}

	@Override
	public ModelAndView getCallLetterRelease() {
		// TODO Auto-generated method stub
		ModelAndView mdv=new ModelAndView();
		String errorString = "";
		List<InterviewCandidateBean> ce=null;
			System.out.println("Selected Candidates");
			try{
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				Date dateobj = new Date();
				System.out.println(df.format(dateobj));
				ce=callletterreleaseImplement.getCallLetterRelease(df.format(dateobj));
				System.out.println(ce);
			}catch(Exception e){
				errorString = "Error occured...";
				System.out.println(e);
			}
			if(errorString.equals("")){
				mdv.addObject("selectedCandidatesDetail", ce);
				mdv.addObject("call",new CallInfoBean());
				mdv.setViewName("callLetterReleaseCandidates");
			}else{
				mdv.addObject("errorString",errorString);
				mdv.setViewName("interview");
			}
		return mdv;
	}

	@Override
	public ModelAndView getReleaseCandidateProfileDetails(int candidate_id) {
		// TODO Auto-generated method stub
		ModelAndView mdv=new ModelAndView();
		String errorString = "";
		List<InterviewCandidateBean> ce=null;
			System.out.println("Call Info");
			try{
				ce=interviewprocessImplement.findSelectedCandidateProfileDetails(candidate_id);
			}catch(Exception e){
				errorString = "Error occured...";
				System.out.println(e);
			}
			if(errorString.equals("")){
				mdv.addObject("selectedCandidateDetail", ce);
				mdv.setViewName("releaseCandidateProfile");
			}else{
				mdv.addObject("errorString",errorString);
				mdv.setViewName("candidateDetail");
			}		
		return mdv;
	}

	@Override
	public ModelAndView getemployee() {
		// TODO Auto-generated method stub
		ModelAndView mdv=new ModelAndView();
		String errorString = "";
		List<EmployeeEntity> list= null;
		// Check User has logged on
			System.out.println("View Candidate");
			try{
				list= employeeImplement.findAll();
				System.out.println(list.toString());
			}catch(Exception e){
				errorString="Error occured...";
				System.out.println(e);
			}
		if(errorString.equals("")){
			mdv.addObject("CandidateDetail", list);
			mdv.addObject("search",new SearchBean());
			mdv.setViewName("employee");
		}else{
			mdv.addObject("errorString",errorString);
			mdv.setViewName("index");
		}	
		return mdv;
	}

	@Override
	public ModelAndView getCertificateVerifyDetails(int candidate_id) {
		// TODO Auto-generated method stub
		ModelAndView mdv=new ModelAndView();
		String errorString = "";
		CandidateEntity ce=null;
			System.out.println("Call Info");
			try{
				ce=candidateImplement.findUser(candidate_id);
			}catch(Exception e){
				errorString = "Error occured...";
				System.out.println(e);
			}
			if(errorString.equals("")){
				mdv.addObject("candidateDetail", ce);
				mdv.addObject("call",new CallInfoBean());
				mdv.setViewName("certificateVerify");
			}else{
				mdv.addObject("errorString",errorString);
				mdv.setViewName("candidateDetail");
			}
		
		return mdv;
	}

	@Override
	public ModelAndView setCertificateVerifyStatusDetails(CertificateVerificationEntity certificateVerifyentity) {
		ModelAndView mdv=new ModelAndView();
		String errorString = "";
		List<InterviewCandidateBean> ce2=null;
		EmployeeEntity ee=new EmployeeEntity();
		CandidateEntity ce1=null;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    Date dateobj = new Date();
	    System.out.println(df.format(dateobj));
		System.out.println("Certificate Verify");
		try{
			System.out.println(certificateVerifyentity.getCandidate_id());
			certificateverificationImplement.save(certificateVerifyentity);
			ce1=candidateImplement.findUser(certificateVerifyentity.getCandidate_id());
			ee.setEmployee_name(ce1.getCandidate_name());
			ee.setEmployee_age(ce1.getCandidate_age());
			ee.setEmployee_address(ce1.getCandidate_address());
			ee.setEmployee_emailid(ce1.getCandidate_emailid());
			ee.setEmployee_phoneno(ce1.getCandidate_phoneno());
			ee.setEmployee_qualification(ce1.getCandidate_qualification());
			ee.setEmployee_designation(ce1.getCandidate_designation());
			ee.setEmployee_resume(ce1.getCandidate_resume());
			ee.setEmployee_filepath(ce1.getCandidate_filepath());
			ee.setCreated_by(certificateVerifyentity.getCreated_by());
			ee.setCreated_date(certificateVerifyentity.getCreated_date());
			employeeImplement.save(ee);
			System.out.println(ee);
			callletterImplement.update(certificateVerifyentity.getCandidate_id(),1,certificateVerifyentity.getCreated_by(),certificateVerifyentity.getCreated_date());
			ce2=callletterImplement.findAcceptedCandidates(df.format(dateobj));
			System.out.println("Verification registered.");
		}catch(Exception e){
			errorString = "Error occured...";
			System.out.println(e);
		}
		if(errorString.equals("")){
			mdv.addObject("successMessage", "Verification registered...");
			mdv.addObject("selectedCandidatesDetail", ce2);
			mdv.setViewName("acceptedCandidates");
		}else{
			mdv.addObject("errorString",errorString);
			mdv.setViewName("candidateDetail");
		}
	return mdv;
}

	@Override
	public ModelAndView getemployeeProfileDetails(int candidate_id) {
		// TODO Auto-generated method stub
		ModelAndView mdv=new ModelAndView();
		String errorString = "";
		EmployeeEntity ce=null;
			System.out.println("Candidate Detail");
			try{
				ce=employeeImplement.findUser(candidate_id);
			}catch(Exception e){
				errorString = "Error occured...";
				System.out.println(e);
			}
			if(errorString.equals("")){
				mdv.addObject("candidateDetail", ce);
				mdv.setViewName("employeeDetail");
			}else{
				mdv.addObject("errorString",errorString);
				mdv.setViewName("viewCandidate");
			}
		return mdv;
	}

	@Override
	public ModelAndView searchSelectedCandidateResultDetails(String date) {
		// TODO Auto-generated method stub
			ModelAndView mdv=new ModelAndView();
			String errorString = "";
			List<InterviewCandidateBean> rob=null;
			System.out.println("searchSelectedCandidateResultDetails");
			System.out.println("Designation Name: "+date);
			   	try{
			  		rob=interviewprocessImplement.findSelectedCandidates(3,1,date);
			   		if(rob.equals(null)){
			    			errorString ="Not Found...";
			   		}
			   	}catch(NullPointerException e){
					errorString = "Not Found...";
				}
			
			if(errorString.equals("")){
				mdv.addObject("dates", date);
				mdv.addObject("selectedCandidatesDetail", rob);
				mdv.addObject("call",new CallInfoBean());
				mdv.setViewName("selectedCandidates");
			}else{
				mdv.addObject("errorString",errorString);
				mdv.setViewName("viewCandidate");
			}
			return mdv;

	}

}
