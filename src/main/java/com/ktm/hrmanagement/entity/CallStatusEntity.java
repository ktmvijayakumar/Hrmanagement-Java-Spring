package com.ktm.hrmanagement.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.ktm.hrmanagement.dao.implement.MainDaoImplement;

@Entity(name="call_status")
public class CallStatusEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int status_id=0;
	private String status_name="";
	private int created_by=0;
	private String created_date="";
	private int modified_by=0;
	private String modified_date="";
	
	public CallStatusEntity(int status_id, String status_name, int created_by, String created_date,
			int modified_by, String modified_date) {
		super();
		this.status_id = status_id;
		this.status_name = status_name;
		this.created_by = created_by;
		this.created_date = created_date;
		this.modified_by = modified_by;
		this.modified_date = modified_date;
	}
	public CallStatusEntity(int status_id, String status_name) {
		super();
		this.status_id = status_id;
		this.status_name = status_name;
	}
	public CallStatusEntity() {
		super();
	}
	public int getStatus_id() {
		return status_id;
	}
	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}
	public String getStatus_name() {
		return status_name;
	}
	public void setStatus_name(String status_name) {
		this.status_name = status_name;
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
		return "CallStatusEntity [status_id=" + status_id + ", status_name=" + status_name + ", created_by="
				+ created_by + ", created_date=" + created_date + ", modified_by=" + modified_by + ", modified_date="
				+ modified_date + "]";
	}
	
	
	
	
	
}
