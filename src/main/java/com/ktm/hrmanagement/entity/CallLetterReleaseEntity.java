package com.ktm.hrmanagement.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="call_letter_release")
public class CallLetterReleaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int call_letter_releaseid;
	private String release_status;
	private int candidate_id;
	private int call_letter_releasestatus;
	private String call_letter_releasedate;
	private int created_by;
	private String created_date;
	private int modified_by;
	private String modified_date;
	
	
	public CallLetterReleaseEntity() {
		super();
	}

	public CallLetterReleaseEntity(int call_letter_releaseid, String release_status, int candidate_id,
			int call_letter_releasestatus, String call_letter_releasedate, int created_by, String created_date,
			int modified_by, String modified_date) {
		super();
		this.call_letter_releaseid = call_letter_releaseid;
		this.release_status = release_status;
		this.candidate_id = candidate_id;
		this.call_letter_releasestatus = call_letter_releasestatus;
		this.call_letter_releasedate = call_letter_releasedate;
		this.created_by = created_by;
		this.created_date = created_date;
		this.modified_by = modified_by;
		this.modified_date = modified_date;
	}

	public CallLetterReleaseEntity(int call_letter_releaseid, String release_status, int candidate_id,
			String call_letter_releasedate, int created_by, String created_date, int modified_by,
			String modified_date) {
		super();
		this.call_letter_releaseid = call_letter_releaseid;
		this.release_status = release_status;
		this.candidate_id = candidate_id;
		this.call_letter_releasedate = call_letter_releasedate;
		this.created_by = created_by;
		this.created_date = created_date;
		this.modified_by = modified_by;
		this.modified_date = modified_date;
	}

	
	public int getCall_letter_releasestatus() {
		return call_letter_releasestatus;
	}

	public void setCall_letter_releasestatus(int call_letter_releasestatus) {
		this.call_letter_releasestatus = call_letter_releasestatus;
	}

	public int getCall_letter_releaseid() {
		return call_letter_releaseid;
	}

	public void setCall_letter_releaseid(int call_letter_releaseid) {
		this.call_letter_releaseid = call_letter_releaseid;
	}

	public String getRelease_status() {
		return release_status;
	}

	public void setRelease_status(String release_status) {
		this.release_status = release_status;
	}

	public int getCandidate_id() {
		return candidate_id;
	}

	public void setCandidate_id(int candidate_id) {
		this.candidate_id = candidate_id;
	}

	public String getCall_letter_releasedate() {
		return call_letter_releasedate;
	}

	public void setCall_letter_releasedate(String call_letter_releasedate) {
		this.call_letter_releasedate = call_letter_releasedate;
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
		return "CallLetterReleaseEntity [call_letter_releaseid=" + call_letter_releaseid + ", release_status="
				+ release_status + ", candidate_id=" + candidate_id + ", call_letter_releasedate="
				+ call_letter_releasedate + ", created_by=" + created_by + ", created_date=" + created_date
				+ ", modified_by=" + modified_by + ", modified_date=" + modified_date + "]";
	}
	
	
	
	
}
