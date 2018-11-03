package com.ktm.hrmanagement.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="interview_process")
public class InterviewProcessEntity implements Serializable{
		
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int interview_processid;
	private int candidate_id;
	private int round_id;
	private int round_statusid;
	private String interviewer_name;
	private String comments;
	private String interview_date;
	private int created_by;
	private String created_date;
	private int modified_by;
	private String modified_date;
	
	public InterviewProcessEntity() {
		super();
	}
	public int getInterview_processid() {
		return interview_processid;
	}
	public void setInterview_processid(int interview_processid) {
		this.interview_processid = interview_processid;
	}
	public int getCandidate_id() {
		return candidate_id;
	}
	public void setCandidate_id(int candidate_id) {
		this.candidate_id = candidate_id;
	}
	public int getRound_id() {
		return round_id;
	}
	public void setRound_id(int round_id) {
		this.round_id = round_id;
	}
	public int getRound_statusid() {
		return round_statusid;
	}
	public void setRound_statusid(int round_statusid) {
		this.round_statusid = round_statusid;
	}
	public String getInterviewer_name() {
		return interviewer_name;
	}
	public void setInterviewer_name(String interviewer_name) {
		this.interviewer_name = interviewer_name;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
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
		return "InterviewProcessEntity [interview_processid=" + interview_processid + ", candidate_id=" + candidate_id
				+ ", round_id=" + round_id + ", round_statusid=" + round_statusid + ", interviewer_name="
				+ interviewer_name + ", comments=" + comments + ", interview_date=" + interview_date + ", created_by="
				+ created_by + ", created_date=" + created_date + ", modified_by=" + modified_by + ", modified_date="
				+ modified_date + "]";
	}
	
	
	
}
