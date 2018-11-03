package com.ktm.hrmanagement.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="employee_detail")
public class EmployeeEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int employee_id;
	private String employee_name;
	private int employee_age;
	private String employee_emailid;
	private String employee_phoneno;
	private String employee_address;
	private String employee_qualification;
	private String employee_designation;
	private String employee_resume;
	private String employee_filepath;
	private int created_by;
	private String created_date;
	private int modified_by;
	private String modified_date;
	public EmployeeEntity() {
		super();
	}

	public EmployeeEntity(int employee_id, String employee_name, int employee_age, String employee_emailid,
			String employee_phoneno, String employee_address, String employee_qualification,
			String employee_designation, String employee_resume, String employee_filepath, int created_by,
			String created_date, int modified_by, String modified_date) {
		super();
		this.employee_id = employee_id;
		this.employee_name = employee_name;
		this.employee_age = employee_age;
		this.employee_emailid = employee_emailid;
		this.employee_phoneno = employee_phoneno;
		this.employee_address = employee_address;
		this.employee_qualification = employee_qualification;
		this.employee_designation = employee_designation;
		this.employee_resume = employee_resume;
		this.employee_filepath = employee_filepath;
		this.created_by = created_by;
		this.created_date = created_date;
		this.modified_by = modified_by;
		this.modified_date = modified_date;
	}

	public EmployeeEntity(int employee_id, String employee_name, int employee_age, String employee_emailid,
			String employee_phoneno, String employee_address, String employee_qualification,
			String employee_designation, String employee_resume, String employee_filepath) {
		super();
		this.employee_id = employee_id;
		this.employee_name = employee_name;
		this.employee_age = employee_age;
		this.employee_emailid = employee_emailid;
		this.employee_phoneno = employee_phoneno;
		this.employee_address = employee_address;
		this.employee_qualification = employee_qualification;
		this.employee_designation = employee_designation;
		this.employee_resume = employee_resume;
		this.employee_filepath = employee_filepath;
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

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public int getEmployee_age() {
		return employee_age;
	}

	public void setEmployee_age(int employee_age) {
		this.employee_age = employee_age;
	}

	public String getEmployee_emailid() {
		return employee_emailid;
	}

	public void setEmployee_emailid(String employee_emailid) {
		this.employee_emailid = employee_emailid;
	}

	public String getEmployee_phoneno() {
		return employee_phoneno;
	}

	public void setEmployee_phoneno(String employee_phoneno) {
		this.employee_phoneno = employee_phoneno;
	}

	public String getEmployee_address() {
		return employee_address;
	}

	public void setEmployee_address(String employee_address) {
		this.employee_address = employee_address;
	}

	public String getEmployee_qualification() {
		return employee_qualification;
	}

	public void setEmployee_qualification(String employee_qualification) {
		this.employee_qualification = employee_qualification;
	}

	public String getEmployee_designation() {
		return employee_designation;
	}

	public void setEmployee_designation(String employee_designation) {
		this.employee_designation = employee_designation;
	}

	public String getEmployee_resume() {
		return employee_resume;
	}

	public void setEmployee_resume(String employee_resume) {
		this.employee_resume = employee_resume;
	}

	public String getEmployee_filepath() {
		return employee_filepath;
	}

	public void setEmployee_filepath(String employee_filepath) {
		this.employee_filepath = employee_filepath;
	}

	@Override
	public String toString() {
		return "EmployeeEntity [employee_id=" + employee_id + ", employee_name=" + employee_name + ", employee_age="
				+ employee_age + ", employee_emailid=" + employee_emailid + ", employee_phoneno=" + employee_phoneno
				+ ", employee_address=" + employee_address + ", employee_qualification=" + employee_qualification
				+ ", employee_designation=" + employee_designation + ", employee_resume=" + employee_resume
				+ ", employee_filepath=" + employee_filepath + "]";
	}	
	
	
	
	
}
