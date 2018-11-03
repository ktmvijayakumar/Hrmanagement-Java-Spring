package com.ktm.hrmanagement.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="interview_round")
public class InterviewrRoundEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int round_id;
	private String round_name;
	private int created_by;
	private String created_date;
	private int modified_by;
	private String modified_date;
	
	
	public InterviewrRoundEntity() {
		super();
	}
	public InterviewrRoundEntity(int round_id, String round_name, int created_by, String created_date,
			int modified_by, String modified_date) {
		super();
		this.round_id = round_id;
		this.round_name = round_name;
		this.created_by = created_by;
		this.created_date = created_date;
		this.modified_by = modified_by;
		this.modified_date = modified_date;
	}
	public int getRound_id() {
		return round_id;
	}
	public void setRound_id(int round_id) {
		this.round_id = round_id;
	}
	public String getRound_name() {
		return round_name;
	}
	public void setRound_name(String round_name) {
		this.round_name = round_name;
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
		return "InterviewrRoundEntity [round_id=" + round_id + ", round_name=" + round_name + ", created_by="
				+ created_by + ", created_date=" + created_date + ", modified_by=" + modified_by + ", modified_date="
				+ modified_date + "]";
	}
	
	
}
