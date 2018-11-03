package com.ktm.hrmanagement.bean;

public class UserBean {
	
	String hr_emailid="";
	String hr_password="";
	
	public UserBean(String emailId, String hrPassword) {
		super();
		this.hr_emailid = emailId;
		this.hr_password = hrPassword;
	}
	
	public UserBean() {
		// TODO Auto-generated constructor stub
	}

	
	public String getHr_emailid() {
		return hr_emailid;
	}

	public void setHr_emailid(String hr_emailid) {
		this.hr_emailid = hr_emailid;
	}

	public String getHr_password() {
		return hr_password;
	}

	public void setHr_password(String hr_password) {
		this.hr_password = hr_password;
	}

	@Override
	public String toString() {
		return "UserBean [hr_emailid=" + hr_emailid + ", hr_password=" + hr_password + "]";
	}

	
}
