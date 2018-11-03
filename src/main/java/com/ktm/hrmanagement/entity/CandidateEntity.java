package com.ktm.hrmanagement.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="candidate_detail")
public class CandidateEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private int candidate_id;
	private String candidate_name;
	private int candidate_age;
	private String candidate_emailid;
	private String candidate_phoneno;
	private String candidate_address;
	private String candidate_qualification;
	private String candidate_designation;
	private String candidate_resume;
	private String candidate_filepath;
	private int created_by;
	private String created_date;
	private int modified_by;
	private String modified_date;
	public CandidateEntity() {
		super();
	}
	
	public CandidateEntity(int candidate_id, String candidate_name, int candidate_age, String candidate_emailid,
			String candidate_phoneno, String candidate_address, String candidate_qualification,
			String candidate_designation, String candidate_resume, String candidate_filepath, int created_by,
			String created_date, int modified_by, String modified_date) {
		super();
		this.candidate_id = candidate_id;
		this.candidate_name = candidate_name;
		this.candidate_age = candidate_age;
		this.candidate_emailid = candidate_emailid;
		this.candidate_phoneno = candidate_phoneno;
		this.candidate_address = candidate_address;
		this.candidate_qualification = candidate_qualification;
		this.candidate_designation = candidate_designation;
		this.candidate_resume = candidate_resume;
		this.candidate_filepath = candidate_filepath;
		this.created_by = created_by;
		this.created_date = created_date;
		this.modified_by = modified_by;
		this.modified_date = modified_date;
	}

	public CandidateEntity(int candidate_id, String candidate_name, int candidate_age, String candidate_emailid,
			String candidate_phoneno, String candidate_address, String candidate_qualification,
			String candidate_designation, String candidate_resume, String candidate_filepath) {
		super();
		this.candidate_id = candidate_id;
		this.candidate_name = candidate_name;
		this.candidate_age = candidate_age;
		this.candidate_emailid = candidate_emailid;
		this.candidate_phoneno = candidate_phoneno;
		this.candidate_address = candidate_address;
		this.candidate_qualification = candidate_qualification;
		this.candidate_designation = candidate_designation;
		this.candidate_resume = candidate_resume;
		this.candidate_filepath = candidate_filepath;
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
	public String getCandidate_qualification() {
		return candidate_qualification;
	}
	public void setCandidate_qualification(String candidate_qualification) {
		this.candidate_qualification = candidate_qualification;
	}
	public String getCandidate_designation() {
		return candidate_designation;
	}
	public void setCandidate_designation(String candidate_designation) {
		this.candidate_designation = candidate_designation;
	}
	public String getCandidate_resume() {
		return candidate_resume;
	}
	public void setCandidate_resume(String candidate_resume) {
		this.candidate_resume = candidate_resume;
	}
	public String getCandidate_filepath() {
		return candidate_filepath;
	}
	public void setCandidate_filepath(String candidate_filepath) {
		this.candidate_filepath = candidate_filepath;
	}
	@Override
	public String toString() {
		return "CandidateEntity [candidate_id=" + candidate_id + ", candidate_name=" + candidate_name
				+ ", candidate_age=" + candidate_age + ", candidate_emailid=" + candidate_emailid
				+ ", candidate_phoneno=" + candidate_phoneno + ", candidate_address=" + candidate_address
				+ ", candidate_qualification=" + candidate_qualification + ", candidate_designation="
				+ candidate_designation + ", candidate_resume=" + candidate_resume + ", candidate_filepath="
				+ candidate_filepath + "]";
	}
	
	
	
	
}
