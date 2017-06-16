package com.aiidc.sps.ep.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity(name="EmStandard")
@Table(name="EM_PARK_STANDARD_SPEC")
public class EmStandard implements Serializable{

	private static final long serialVersionUID = -7470294314033286947L;
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="publish_department")
	private String pubDepartment;
	
	@Column(name="publis_date")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date pubDate;
	
	@Column(name="implement_date")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date impDate;
	
	@Column(name="content")
	private String content;
	
	
	public EmStandard(){
		
	}

	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPubDepartment() {
		return pubDepartment;
	}


	public void setPubDepartment(String pubDepartment) {
		this.pubDepartment = pubDepartment;
	}


	public Date getPubDate() {
		return pubDate;
	}


	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}


	public Date getImpDate() {
		return impDate;
	}


	public void setImpDate(Date impDate) {
		this.impDate = impDate;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "EmStandard [id=" + id + ", name=" + name + ", pubDepartment=" + pubDepartment + ", pubDate=" + pubDate
				+ ", impDate=" + impDate + ", content=" + content + "]";
	}
	

}























