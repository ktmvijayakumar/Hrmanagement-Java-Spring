package com.ktm.hrmanagement.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="call_letter")
public class CallLetterEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int call_letter_id;
	private String accept_status;
	private int candidate_id;
	private String call_letter_accepteddate;
	private int call_letter_status;
	private String call_letter_description;
	private int created_by;
	private String created_date;
	private int modified_by;
	private String modified_date;
	
	public CallLetterEntity() {
		super();
	}
	
	public CallLetterEntity(int call_letter_id, String accept_status, int candidate_id, String call_letter_accepteddate,
			int call_letter_status, String call_letter_description, int created_by, String created_date,
			int modified_by, String modified_date) {
		super();
		this.call_letter_id = call_letter_id;
		this.accept_status = accept_status;
		this.candidate_id = candidate_id;
		this.call_letter_accepteddate = call_letter_accepteddate;
		this.call_letter_status = call_letter_status;
		this.call_letter_description = call_letter_description;
		this.created_by = created_by;
		this.created_date = created_date;
		this.modified_by = modified_by;
		this.modified_date = modified_date;
	}

	public CallLetterEntity(int call_letter_id, String accept_status, int candidate_id, String call_letter_accepteddate,
			String call_letter_description, int created_by, String created_date, int modified_by,
			String modified_date) {
		super();
		this.call_letter_id = call_letter_id;
		this.accept_status = accept_status;
		this.candidate_id = candidate_id;
		this.call_letter_accepteddate = call_letter_accepteddate;
		this.call_letter_description = call_letter_description;
		this.created_by = created_by;
		this.created_date = created_date;
		this.modified_by = modified_by;
		this.modified_date = modified_date;
	}

	public CallLetterEntity(int call_letter_id, String accept_status, int candidate_id, String call_letter_accepteddate,
			int created_by, String created_date, int modified_by, String modified_date) {
		super();
		this.call_letter_id = call_letter_id;
		this.accept_status = accept_status;
		this.candidate_id = candidate_id;
		this.call_letter_accepteddate = call_letter_accepteddate;
		this.created_by = created_by;
		this.created_date = created_date;
		this.modified_by = modified_by;
		this.modified_date = modified_date;
	}

	
	public int getCall_letter_status() {
		return call_letter_status;
	}

	public void setCall_letter_status(int call_letter_status) {
		this.call_letter_status = call_letter_status;
	}

	public String getCall_letter_description() {
		return call_letter_description;
	}

	public void setCall_letter_description(String call_letter_description) {
		this.call_letter_description = call_letter_description;
	}

	public int getCall_letter_id() {
		return call_letter_id;
	}

	public void setCall_letter_id(int call_letter_id) {
		this.call_letter_id = call_letter_id;
	}

	public String getAccept_status() {
		return accept_status;
	}

	public void setAccept_status(String accept_status) {
		this.accept_status = accept_status;
	}

	public int getCandidate_id() {
		return candidate_id;
	}

	public void setCandidate_id(int candidate_id) {
		this.candidate_id = candidate_id;
	}

	public String getCall_letter_accepteddate() {
		return call_letter_accepteddate;
	}

	public void setCall_letter_accepteddate(String call_letter_accepteddate) {
		this.call_letter_accepteddate = call_letter_accepteddate;
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
		return "CallLetterEntity [call_letter_id=" + call_letter_id + ", accept_status=" + accept_status
				+ ", candidate_id=" + candidate_id + ", call_letter_accepteddate=" + call_letter_accepteddate
				+ ", call_letter_description=" + call_letter_description + ", created_by=" + created_by
				+ ", created_date=" + created_date + ", modified_by=" + modified_by + ", modified_date=" + modified_date
				+ "]";
	}

	
}
