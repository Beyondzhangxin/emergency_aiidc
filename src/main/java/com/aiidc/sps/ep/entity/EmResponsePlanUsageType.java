package com.aiidc.sps.ep.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name="EmResponsePlanUsageType")
@Table(name="EM_RESPONSE_PLAN_USAGE_TYPE")
public class EmResponsePlanUsageType implements Serializable{

	private static final long serialVersionUID = -6257245118889880590L;

	@Column(name="usage_id")
	private String usageId;
	
	@Column(name="usage_name")
	private String usageName;
	
	
	public EmResponsePlanUsageType(){
		
	}

	public String getUsageId() {
		return usageId;
	}


	public void setUsageId(String usageId) {
		this.usageId = usageId;
	}


	public String getUsageName() {
		return usageName;
	}


	public void setUsageName(String usageName) {
		this.usageName = usageName;
	}
	
}
