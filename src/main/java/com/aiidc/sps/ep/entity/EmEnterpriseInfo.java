package com.aiidc.sps.ep.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name="emEnterpriseInfo")
@Table(name="EM_ENTERPRISE_INFO")
public class EmEnterpriseInfo implements Serializable{
	
	private static final long serialVersionUID = 2384775153560073330L;

	@Column(name="id")
	private String id;
	
	@Column(name="name")
	private String name;
	
	public EmEnterpriseInfo(){
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "emEnterpriseInfo [id=" + id + ", name=" + name + "]";
	}
	
	
}
