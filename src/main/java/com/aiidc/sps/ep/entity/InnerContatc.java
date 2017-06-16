package com.aiidc.sps.ep.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity(name="InnerContatc")
@Table(name="EM_PARK_CONTACTS")
public class InnerContatc implements Serializable{

	private static final long serialVersionUID = 5916644773761419660L;
	
		@Id
		@Column(name="id")
		private int id;
		
		@Column(name = "contacts")
	    private String contacts;

	    @Column(name = "company_name")
	    private String companyName;

	    @Column(name = "department")
	    private String department;
	    
	    @Column(name = "post")
	    private String post;
	    
	    @Column(name = "telephone")
	    private String telephone;
	    
	    @Column(name = "mobile_phone")
	    private String mobilePhone;

	    @Column(name = "home_phone")
	    private String homePhone;
	    
	    @Column(name = "fax")
	    private String fax;
	    
	    @Column(name = "email")
	    private String email;
	    
	    @Column(name = "wechat")
	    private String wechat;
	    
	    @Column(name = "qq")
	    private String qq;

		@Temporal(TemporalType.TIMESTAMP)
	    @Column(name = "change_time")
		@DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date changeTime;
	    
	    public InnerContatc(){
	    	
	    }

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
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

		public String getDepartment() {
			return department;
		}

		public void setDepartment(String department) {
			this.department = department;
		}

		public String getPost() {
			return post;
		}

		public void setPost(String post) {
			this.post = post;
		}

		public String getTelephone() {
			return telephone;
		}

		public void setTelephone(String telephone) {
			this.telephone = telephone;
		}

		public String getMobilePhone() {
			return mobilePhone;
		}

		public void setMobilePhone(String mobilePhone) {
			this.mobilePhone = mobilePhone;
		}

		public String getHomePhone() {
			return homePhone;
		}

		public void setHomePhone(String homePhone) {
			this.homePhone = homePhone;
		}

		public String getFax() {
			return fax;
		}

		public void setFax(String fax) {
			this.fax = fax;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getWechat() {
			return wechat;
		}

		public void setWechat(String wechat) {
			this.wechat = wechat;
		}

		public String getQq() {
			return qq;
		}

		public void setQq(String qq) {
			this.qq = qq;
		}

		public Date getChangeTime() {
			return changeTime;
		}

		public void setChangeTime(Date changeTime) {
			this.changeTime = changeTime;
		}

		@Override
		public String toString() {
			return "InnerContatc [id=" + id + ", contacts=" + contacts + ", companyName=" + companyName
					+ ", department=" + department + ", post=" + post + ", telephone=" + telephone + ", mobilePhone="
					+ mobilePhone + ", homePhone=" + homePhone + ", fax=" + fax + ", email=" + email + ", wechat="
					+ wechat + ", qq=" + qq + ", changeTime=" + changeTime + "]";
		}
	    

}
