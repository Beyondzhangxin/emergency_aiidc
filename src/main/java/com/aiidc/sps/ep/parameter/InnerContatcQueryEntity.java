package com.aiidc.sps.ep.parameter;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity(name="InnerContatcQueryEntity")
public class InnerContatcQueryEntity implements Serializable {
	
	private static final long serialVersionUID = -8135750668041298786L;
	private Integer page;
	private Integer rows;
	private String contacts;
	private String companyName;
	private String mobilePhone;
	private String email;

	public InnerContatcQueryEntity(){
		
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "InnerContatcQueryEntity [page=" + page + ", rows=" + rows + ", contacts=" + contacts + ", companyName="
				+ companyName + ", mobilePhone=" + mobilePhone + ", email=" + email + "]";
	}
	
}
