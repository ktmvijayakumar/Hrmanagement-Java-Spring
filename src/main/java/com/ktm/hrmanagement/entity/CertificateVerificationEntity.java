package com.ktm.hrmanagement.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="certificate_verification")
public class CertificateVerificationEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int verification_id;
	private String verification_status;
	private int candidate_id;
	private String verification_date;
	private String verification_description;
	private int created_by;
	private String created_date;
	private int modified_by;
	private String modified_date;
	
	public CertificateVerificationEntity() {
		super();
	}
	
	
	public CertificateVerificationEntity(int verification_id, String verification_status, int candidate_id,
			String verification_date, String verification_description, int created_by, String created_date,
			int modified_by, String modified_date) {
		super();
		this.verification_id = verification_id;
		this.verification_status = verification_status;
		this.candidate_id = candidate_id;
		this.verification_date = verification_date;
		this.verification_description = verification_description;
		this.created_by = created_by;
		this.created_date = created_date;
		this.modified_by = modified_by;
		this.modified_date = modified_date;
	}


	public CertificateVerificationEntity(int verification_id, String verification_status, int candidate_id,
			String verification_date, int created_by, String created_date, int modified_by,
			String modified_date) {
		super();
		this.verification_id = verification_id;
		this.verification_status = verification_status;
		this.candidate_id = candidate_id;
		this.verification_date = verification_date;
		this.created_by = created_by;
		this.created_date = created_date;
		this.modified_by = modified_by;
		this.modified_date = modified_date;
	}

	public String getVerification_description() {
		return verification_description;
	}


	public void setVerification_description(String verification_description) {
		this.verification_description = verification_description;
	}


	public int getVerification_id() {
		return verification_id;
	}
	public void setVerification_id(int verification_id) {
		this.verification_id = verification_id;
	}
	public String getVerification_status() {
		return verification_status;
	}
	public void setVerification_status(String verification_status) {
		this.verification_status = verification_status;
	}
	public int getCandidate_id() {
		return candidate_id;
	}
	public void setCandidate_id(int candidate_id) {
		this.candidate_id = candidate_id;
	}
	public String getVerification_date() {
		return verification_date;
	}
	public void setVerification_date(String verification_date) {
		this.verification_date = verification_date;
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
		return "CertificateVerificationEntity [verification_id=" + verification_id + ", verification_status="
				+ verification_status + ", candidate_id=" + candidate_id + ", verification_date=" + verification_date
				+ ", verification_description=" + verification_description + ", created_by=" + created_by
				+ ", created_date=" + created_date + ", modified_by=" + modified_by + ", modified_date=" + modified_date
				+ "]";
	}
	
	
	
}
