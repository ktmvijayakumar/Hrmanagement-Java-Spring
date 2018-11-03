package com.ktm.hrmanagement.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="link_designation")
public class DesignationEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int designation_id;
	private String designation_name;
	private int created_by;
	private String created_date;
	private int modified_by;
	private String modified_date;
	
	public DesignationEntity() {
		super();
	}
	public DesignationEntity(int designation_id, String designation_name, int created_by, String created_date,
			int modified_by, String modified_date) {
		super();
		this.designation_id = designation_id;
		this.designation_name = designation_name;
		this.created_by = created_by;
		this.created_date = created_date;
		this.modified_by = modified_by;
		this.modified_date = modified_date;
	}
	public int getDesignation_id() {
		return designation_id;
	}
	public void setDesignation_id(int designation_id) {
		this.designation_id = designation_id;
	}
	public String getDesignation_name() {
		return designation_name;
	}
	public void setDesignation_name(String designation_name) {
		this.designation_name = designation_name;
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
		return "DesignationEntity [designation_id=" + designation_id + ", designation_name=" + designation_name
				+ ", created_by=" + created_by + ", created_date=" + created_date + ", modified_by=" + modified_by
				+ ", modified_date=" + modified_date + "]";
	}
	
	
}
