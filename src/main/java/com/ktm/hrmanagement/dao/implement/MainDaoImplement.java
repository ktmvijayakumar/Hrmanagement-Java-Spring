package com.ktm.hrmanagement.dao.implement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.ktm.hrmanagement.entity.CallStatusEntity;
import com.ktm.hrmanagement.entity.InterviewrRoundEntity;
import com.ktm.hrmanagement.entity.UserEntity;
import com.ktm.hrmanagement.services.CallStatusService;
import com.ktm.hrmanagement.services.InterviewRoundService;
import com.ktm.hrmanagement.services.UserService;

public class MainDaoImplement {

	@Autowired
	private CallStatusService callstatusImplement;
	@Autowired
	private InterviewRoundService interviewroundImplement;
	@Autowired
	private UserService userImplement;
	public void mainStaticDataCallStatusEntity(){
		try{
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		    Date dateobj = new Date();
		    String date=df.format(dateobj);
		    
			CallStatusEntity callstatusentity=new CallStatusEntity();
			callstatusentity.setStatus_id(1);
			callstatusentity.setStatus_name("Willing");
			callstatusentity.setCreated_by(0);
			callstatusentity.setCreated_date(date);
			callstatusentity.setModified_by(0);
			callstatusentity.setModified_date(date);
			System.out.println(callstatusentity);
			callstatusImplement.save(callstatusentity);
			System.out.println(date);
			callstatusentity.setStatus_id(2);
			callstatusentity.setStatus_name("Not willing");
			callstatusentity.setCreated_by(0);
			callstatusentity.setCreated_date(date);
			callstatusentity.setModified_by(0);
			callstatusentity.setModified_date(date);
			callstatusImplement.save(callstatusentity);
			}catch(Exception e){
				System.out.println(e);
			}
	}
	public void mainStaticDataInterviewrRoundEntity(){
		try{
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		    Date dateobj = new Date();
		    String date=df.format(dateobj);
		    InterviewrRoundEntity ire=new InterviewrRoundEntity();
			ire.setRound_id(1);
			ire.setRound_name("Apptitude");
			ire.setCreated_by(0);
			ire.setCreated_date(date);
			ire.setModified_by(0);
			ire.setModified_date(date);
			interviewroundImplement.save(ire);
			ire.setRound_id(4);
			ire.setRound_name("GD");
			ire.setCreated_by(0);
			ire.setCreated_date(date);
			ire.setModified_by(0);
			ire.setModified_date(date);
			interviewroundImplement.save(ire);
			ire.setRound_id(2);
			ire.setRound_name("Technical");
			ire.setCreated_by(0);
			ire.setCreated_date(date);
			ire.setModified_by(0);
			ire.setModified_date(date);
			interviewroundImplement.save(ire);
			ire.setRound_id(3);
			ire.setRound_name("HR");
			ire.setCreated_by(0);
			ire.setCreated_date(date);
			ire.setModified_by(0);
			ire.setModified_date(date);
			interviewroundImplement.save(ire);
		}catch(Exception e){
			System.out.println(e);
		}
	}
	public void mainStaticDataUserEntity(){
		try{
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		    Date dateobj = new Date();
		    String date=df.format(dateobj);
			
			UserEntity ue=new UserEntity();
			ue.setHr_age(22);
			ue.setHr_emailid("praveen@gmail.com");
			ue.setHr_phoneno("9842553236");
			ue.setHr_name("praveen");
			ue.setHr_password("1234");
			ue.setHr_address("1234, Madurai Veeran Street, Bodinayakanur");
			ue.setCreated_by(0);
			ue.setCreated_date(date);
			ue.setModified_by(0);
			ue.setModified_date(date);
			userImplement.save(ue);
			ue.setHr_age(22);
			ue.setHr_emailid("vijay@gmail.com");
			ue.setHr_phoneno("9842553236");
			ue.setHr_name("vijay");
			ue.setHr_password("1234");
			ue.setHr_address("1234, Madurai Veeran Street, Bodinayakanur");
			ue.setCreated_by(0);
			ue.setCreated_date(date);
			ue.setModified_by(0);
			ue.setModified_date(date);
			userImplement.save(ue);
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
