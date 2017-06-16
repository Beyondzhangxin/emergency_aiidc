package com.aiidc.sps.ep.parameter;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

@Entity(name="EmPlanListParameter")
public class EmPlanListParameter implements Serializable{
		
	private static final long serialVersionUID = -5755266484399454614L;
	//预案编号
	private String planId;
	//预案名称
	private String planName;
	//预案类别
	private String planTypeName;
	//适用领域
	private String usageName;
	//填报时间
	private Date reportingTime;
	//填报单位
	private String companyName;
	
	public EmPlanListParameter(){
		
	}

	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getPlanTypeName() {
		return planTypeName;
	}

	public void setPlanTypeName(String planTypeName) {
		this.planTypeName = planTypeName;
	}

	public String getUsageName() {
		return usageName;
	}

	public void setUsageName(String usageName) {
		this.usageName = usageName;
	}

	public Date getReportingTime() {
		return reportingTime;
	}

	public void setReportingTime(Date reportingTime) {
		this.reportingTime = reportingTime;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Override
	public String toString() {
		return "EmPlanListParameter [planId=" + planId + ", planName=" + planName + ", planTypeName=" + planTypeName
				+ ", usageName=" + usageName + ", reportingTime=" + reportingTime + ", companyName=" + companyName
				+ "]";
	}
	
}
