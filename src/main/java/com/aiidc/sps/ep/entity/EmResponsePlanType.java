package com.aiidc.sps.ep.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name="EmResponsePlanType")
@Table(name="EM_RESPONSE_PLAN_TYPE")
public class EmResponsePlanType implements Serializable{
	
	private static final long serialVersionUID = 5718746568100565794L;
	
	@Column(name="plan_type_id")
	private String planTypeId;
	
	@Column(name="plan_type_name")
	private String planTypeName;

	public EmResponsePlanType(){
		
	}
	
	public String getPlanTypeId() {
		return planTypeId;
	}

	public void setPlanTypeId(String planTypeId) {
		this.planTypeId = planTypeId;
	}

	public String getPlanTypeName() {
		return planTypeName;
	}

	public void setPlanTypeName(String planTypeName) {
		this.planTypeName = planTypeName;
	}
	
	
	

}
