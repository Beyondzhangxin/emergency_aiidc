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

@Entity(name="EmResponsePlan")
@Table(name="EM_RESPONSE_PLAN")
public class EmResponsePlan implements Serializable{

	private static final long serialVersionUID = -8557742867077391590L;

	@Column(name="company_id")
	private String companyId;
	
	@Id
	@Column(name="plan_id")
	private int planId;
	
	@Column(name="plan_name")
	private String planName;
	
	@Column(name="plan_type")
	private String planType;
	
	@Column(name="usage_scope")
	private String usageScope;
	
	@Column(name="plan_content")
	private String planContent;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="reporting_time")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date reportingTime;

	public EmResponsePlan() {

	}

	public String getCompanyId() {
		return companyId;
	}



	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}



	public int getPlanId() {
		return planId;
	}



	public void setPlanId(int planId) {
		this.planId = planId;
	}



	public String getPlanName() {
		return planName;
	}



	public void setPlanName(String planName) {
		this.planName = planName;
	}



	public String getPlanType() {
		return planType;
	}



	public void setPlanType(String planType) {
		this.planType = planType;
	}



	public String getUsageScope() {
		return usageScope;
	}



	public void setUsageScope(String usageScope) {
		this.usageScope = usageScope;
	}



	public String getPlanContent() {
		return planContent;
	}



	public void setPlanContent(String planContent) {
		this.planContent = planContent;
	}



	public Date getReportingTime() {
		return reportingTime;
	}



	public void setReportingTime(Date reportingTime) {
		this.reportingTime = reportingTime;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public String toString() {
		return "EmResponsePlan [companyId=" + companyId + ", planId=" + planId + ", planName=" + planName
				+ ", planType=" + planType + ", usageScope=" + usageScope + ", planContent=" + planContent
				+ ", reportingTime=" + reportingTime + "]";
	}

}
