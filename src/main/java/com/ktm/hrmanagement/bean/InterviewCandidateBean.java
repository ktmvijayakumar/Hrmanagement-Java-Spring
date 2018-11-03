package com.ktm.hrmanagement.bean;

import java.util.Date;

public class InterviewCandidateBean {

	int candidate_id=0;
	String candidate_name="";
	String interviewer_name="";
	int candidate_age=0;
	String candidate_emailid="";
	String candidate_phoneno="";
	String candidate_address="";
	String round_status_name="";
	String round_name="";
	String comments="";
	Date interview_date;
	
	public InterviewCandidateBean() {
		super();
	}
	
	
	public InterviewCandidateBean(int candidate_id, String candidate_name, String interviewer_name, int candidate_age,
			String candidate_emailid, String candidate_phoneno, String candidate_address, String round_status_name,
			String round_name, String comments, Date interview_date) {
		super();
		this.candidate_id = candidate_id;
		this.candidate_name = candidate_name;
		this.interviewer_name = interviewer_name;
		this.candidate_age = candidate_age;
		this.candidate_emailid = candidate_emailid;
		this.candidate_phoneno = candidate_phoneno;
		this.candidate_address = candidate_address;
		this.round_status_name = round_status_name;
		this.round_name = round_name;
		this.comments = comments;
		this.interview_date = interview_date;
	}


	public InterviewCandidateBean(int candidate_id, String candidate_name, String interviewer_name, int candidate_age,
			String candidate_emailid, String candidate_phoneno, String candidate_address, String round_status_name,
			String round_name, String comments) {
		super();
		this.candidate_id = candidate_id;
		this.candidate_name = candidate_name;
		this.interviewer_name = interviewer_name;
		this.candidate_age = candidate_age;
		this.candidate_emailid = candidate_emailid;
		this.candidate_phoneno = candidate_phoneno;
		this.candidate_address = candidate_address;
		this.round_status_name = round_status_name;
		this.round_name = round_name;
		this.comments = comments;
	}


	public InterviewCandidateBean(int candidate_id, String candidate_name, int candidate_age, String candidate_emailid,
			String candidate_phoneno, String candidate_address, String round_status_name, String round_name,
			String comments) {
		super();
		this.candidate_id = candidate_id;
		this.candidate_name = candidate_name;
		this.candidate_age = candidate_age;
		this.candidate_emailid = candidate_emailid;
		this.candidate_phoneno = candidate_phoneno;
		this.candidate_address = candidate_address;
		this.round_status_name = round_status_name;
		this.round_name = round_name;
		this.comments = comments;
	}

	public InterviewCandidateBean(int candidate_id, String candidate_name, String round_status_name, String round_name,
			String comments) {
		super();
		this.candidate_id = candidate_id;
		this.candidate_name = candidate_name;
		this.round_status_name = round_status_name;
		this.round_name = round_name;
		this.comments = comments;
	}

	public InterviewCandidateBean(int candidate_id, String candidate_name) {
		super();
		this.candidate_id = candidate_id;
		this.candidate_name = candidate_name;
	}

	
	public String getInterviewer_name() {
		return interviewer_name;
	}


	public Date getInterview_date() {
		return interview_date;
	}


	public void setInterview_date(Date candidates) {
		this.interview_date = candidates;
	}


	public void setInterviewer_name(String interviewer_name) {
		this.interviewer_name = interviewer_name;
	}


	public String getRound_status_name() {
		return round_status_name;
	}

	public void setRound_status_name(String round_status_name) {
		this.round_status_name = round_status_name;
	}

	public String getRound_name() {
		return round_name;
	}

	public void setRound_name(String round_name) {
		this.round_name = round_name;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getCandidate_id() {
		return candidate_id;
	}
	public void setCandidate_id(int candidate_id) {
		this.candidate_id = candidate_id;
	}
	public String getCandidate_name() {
		return candidate_name;
	}
	public void setCandidate_name(String candidate_name) {
		this.candidate_name = candidate_name;
	}
	
	
	public int getCandidate_age() {
		return candidate_age;
	}

	public void setCandidate_age(int candidate_age) {
		this.candidate_age = candidate_age;
	}

	public String getCandidate_emailid() {
		return candidate_emailid;
	}

	public void setCandidate_emailid(String candidate_emailid) {
		this.candidate_emailid = candidate_emailid;
	}

	public String getCandidate_phoneno() {
		return candidate_phoneno;
	}

	public void setCandidate_phoneno(String candidate_phoneno) {
		this.candidate_phoneno = candidate_phoneno;
	}

	public String getCandidate_address() {
		return candidate_address;
	}

	public void setCandidate_address(String candidate_address) {
		this.candidate_address = candidate_address;
	}


	@Override
	public String toString() {
		return "InterviewCandidateBean [candidate_id=" + candidate_id + ", candidate_name=" + candidate_name
				+ ", interviewer_name=" + interviewer_name + ", candidate_age=" + candidate_age + ", candidate_emailid="
				+ candidate_emailid + ", candidate_phoneno=" + candidate_phoneno + ", candidate_address="
				+ candidate_address + ", round_status_name=" + round_status_name + ", round_name=" + round_name
				+ ", comments=" + comments + ", interview_date=" + interview_date + "]";
	}


	
	
	
}
