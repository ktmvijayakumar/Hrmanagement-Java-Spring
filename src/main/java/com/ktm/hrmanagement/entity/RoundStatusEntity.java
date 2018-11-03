package com.ktm.hrmanagement.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="round_status")
public class RoundStatusEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int round_statusid;
	private String round_status_name;
	private int created_by;
	private String created_date;
	private int modified_by;
	private String modified_date;
	public RoundStatusEntity(int round_statusid, String round_status_name, int created_by, String created_date,
			int modified_by, String modified_date) {
		super();
		this.round_statusid = round_statusid;
		this.round_status_name = round_status_name;
		this.created_by = created_by;
		this.created_date = created_date;
		this.modified_by = modified_by;
		this.modified_date = modified_date;
	}
	public int getRound_statusid() {
		return round_statusid;
	}
	public void setRound_statusid(int round_statusid) {
		this.round_statusid = round_statusid;
	}
	public String getRound_status_name() {
		return round_status_name;
	}
	public void setRound_status_name(String round_status_name) {
		this.round_status_name = round_status_name;
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
		return "RoundStatusEntity [round_statusid=" + round_statusid + ", round_status_name=" + round_status_name
				+ ", created_by=" + created_by + ", created_date=" + created_date + ", modified_by=" + modified_by
				+ ", modified_date=" + modified_date + "]";
	}
	
	
	
}
