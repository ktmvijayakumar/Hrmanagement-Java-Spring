package com.ktm.hrmanagement.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity(name="hr_detail")
public class UserEntity implements Serializable{
	
	private static final long serialVersionUID = 7786222898553043366L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="hr_id")
	private int hr_id;
	
	@Column(name="hr_name")
	private String hr_name;
	
	@Column(name="hr_age")
	private int hr_age;
	
	@Column(name="hr_emailid")
	private String hr_emailid;
	
	@Column(name="hr_phoneno")
	private String hr_phoneno;
	
	@Column(name="hr_address")
	private String hr_address;
	
	@Column(name="hr_password")
	private String hr_password;

	private int created_by;
	private String created_date;
	private int modified_by;
	private String modified_date;
	
	public UserEntity(int hr_id, String hr_name, int hr_age, String hr_emailid, String hr_phoneno, String hr_address,
			String hr_password, int created_by, String created_date, int modified_by, String modified_date) {
		super();
		this.hr_id = hr_id;
		this.hr_name = hr_name;
		this.hr_age = hr_age;
		this.hr_emailid = hr_emailid;
		this.hr_phoneno = hr_phoneno;
		this.hr_address = hr_address;
		this.hr_password = hr_password;
		this.created_by = created_by;
		this.created_date = created_date;
		this.modified_by = modified_by;
		this.modified_date = modified_date;
	}

	public UserEntity(int hr_id, String hr_name, int hr_age, String hr_emailid, String hr_phoneno, String hr_address,
			String hr_password) {
		super();
		this.hr_id = hr_id;
		this.hr_name = hr_name;
		this.hr_age = hr_age;
		this.hr_emailid = hr_emailid;
		this.hr_phoneno = hr_phoneno;
		this.hr_address = hr_address;
		this.hr_password = hr_password;
	}

	public UserEntity() {
		super();
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

	public int getHr_id() {
		return hr_id;
	}

	public void setHr_id(int hr_id) {
		this.hr_id = hr_id;
	}

	public String getHr_name() {
		return hr_name;
	}

	public void setHr_name(String hr_name) {
		this.hr_name = hr_name;
	}

	public int getHr_age() {
		return hr_age;
	}

	public void setHr_age(int hr_age) {
		this.hr_age = hr_age;
	}

	public String getHr_emailid() {
		return hr_emailid;
	}

	public void setHr_emailid(String hr_emailid) {
		this.hr_emailid = hr_emailid;
	}

	public String getHr_phoneno() {
		return hr_phoneno;
	}

	public void setHr_phoneno(String hr_phoneno) {
		this.hr_phoneno = hr_phoneno;
	}

	public String getHr_address() {
		return hr_address;
	}

	public void setHr_address(String hr_address) {
		this.hr_address = hr_address;
	}

	public String getHr_password() {
		return hr_password;
	}

	public void setHr_password(String hr_password) {
		this.hr_password = hr_password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "userEntity [hr_id=" + hr_id + ", hr_name=" + hr_name + ", hr_age=" + hr_age + ", hr_emailid="
				+ hr_emailid + ", hr_phoneno=" + hr_phoneno + ", hr_address=" + hr_address + ", hr_password="
				+ hr_password + "]";
	}

	
	
		
}
