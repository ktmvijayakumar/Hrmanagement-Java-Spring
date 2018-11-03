package com.ktm.hrmanagement.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="candidate_callstatus")
public class CallInfoEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int s_no;
	private int candidate_id;
	private int status_id;
	private int candidate_status;
	private String interview_date;
	private String interview_description;
	private int created_by;
	private String created_date;
	private int modified_by;
	private String modified_date;
	public CallInfoEntity() {
		super();
	}
	
	public CallInfoEntity(int s_no, int candidate_id, int status_id, int candidate_status, String interview_date,
			String interview_description, int created_by, String created_date, int modified_by,
			String modified_date) {
		super();
		this.s_no = s_no;
		this.candidate_id = candidate_id;
		this.status_id = status_id;
		this.candidate_status = candidate_status;
		this.interview_date = interview_date;
		this.interview_description = interview_description;
		this.created_by = created_by;
		this.created_date = created_date;
		this.modified_by = modified_by;
		this.modified_date = modified_date;
	}

	public CallInfoEntity(int s_no, int candidate_id, int status_id, int candidate_status, String interview_date,
			int created_by, String created_date, int modified_by, String modified_date) {
		super();
		this.s_no = s_no;
		this.candidate_id = candidate_id;
		this.status_id = status_id;
		this.candidate_status = candidate_status;
		this.interview_date = interview_date;
		this.created_by = created_by;
		this.created_date = created_date;
		this.modified_by = modified_by;
		this.modified_date = modified_date;
	}

	public CallInfoEntity(int candidate_id, int status_id, String interview_date) {
		super();
		this.candidate_id = candidate_id;
		this.status_id = status_id;
		this.interview_date = interview_date;
	}

	public String getInterview_description() {
		return interview_description;
	}

	public void setInterview_description(String interview_description) {
		this.interview_description = interview_description;
	}

	public int getS_no() {
		return s_no;
	}

	public void setS_no(int s_no) {
		this.s_no = s_no;
	}

	public int getCandidate_status() {
		return candidate_status;
	}

	public void setCandidate_status(int candidate_status) {
		this.candidate_status = candidate_status;
	}

	public int getsNo() {
		return s_no;
	}
	public void setsNo(int sNo) {
		this.s_no = sNo;
	}
	public int getCandidate_id() {
		return candidate_id;
	}
	public void setCandidate_id(int candidate_id) {
		this.candidate_id = candidate_id;
	}
	public int getStatus_id() {
		return status_id;
	}
	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}
	public String getInterview_date() {
		return interview_date;
	}
	public void setInterview_date(String interview_date) {
		this.interview_date = interview_date;
	}
	public int getCreated_by() {
		return created_by;
	}
	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}
	public String getCreated_date() {
		return created_date;
	}
	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}
	public int getModified_by() {
		return modified_by;
	}
	public void setModified_by(int modified_by) {
		this.modified_by = modified_by;
	}
	public String getModified_date() {
		return modified_date;
	}
	public void setModified_date(String modified_date) {
		this.modified_date = modified_date;
	}

	@Override
	public String toString() {
		return "CallInfoEntity [s_no=" + s_no + ", candidate_id=" + candidate_id + ", status_id=" + status_id
				+ ", candidate_status=" + candidate_status + ", interview_date=" + interview_date
				+ ", interview_description=" + interview_description + ", created_by=" + created_by + ", created_date="
				+ created_date + ", modified_by=" + modified_by + ", modified_date=" + modified_date + "]";
	}

	
	
	
	
}
