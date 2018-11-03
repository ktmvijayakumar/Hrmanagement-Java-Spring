package com.ktm.hrmanagement.bean;

public class CallInfoBean {

	String candidate_id="";
	String status_id="";
	String interview_date="";
	
	public CallInfoBean() {
		super();
	}

	public String getCandidate_id() {
		return candidate_id;
	}

	public void setCandidate_id(String candidate_id) {
		this.candidate_id = candidate_id;
	}

	public String getStatus_id() {
		return status_id;
	}

	public void setStatus_id(String status_id) {
		this.status_id = status_id;
	}

	public String getInterview_date() {
		return interview_date;
	}

	public void setInterview_date(String interview_date) {
		this.interview_date = interview_date;
	}

	@Override
	public String toString() {
		return "CallInfoBean [candidate_id=" + candidate_id + ", status_id=" + status_id + ", interview_date="
				+ interview_date + "]";
	}
	
	
}
