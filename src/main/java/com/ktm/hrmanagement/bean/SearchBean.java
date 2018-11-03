package com.ktm.hrmanagement.bean;

public class SearchBean {
	
	String name="";

	public SearchBean(String name) {
		super();
		this.name = name;
	}

	public SearchBean() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "SearchBean [name=" + name + "]";
	}
	
}
