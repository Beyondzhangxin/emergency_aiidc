package com.aiidc.sps.ep.parameter;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity(name="EmPlanParameter")
public class EmPlanParameter implements Serializable{

	private static final long serialVersionUID = 1010848513396615429L;
	
	private Integer page;
	private Integer rows;
	//单位名称
	private String companyName;
	//预案名称
	private String planName;
	//预案类别
	private String planType;
	//适用领域
	private String usageScope;
	
	public EmPlanParameter(){
		
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

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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

	@Override
	public String toString() {
		return "EmPlanParameter [page=" + page + ", rows=" + rows + ", companyName=" + companyName + ", planName="
				+ planName + ", planType=" + planType + ", usageScope=" + usageScope + "]";
	}

}
