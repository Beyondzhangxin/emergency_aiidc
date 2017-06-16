package com.aiidc.sps.ep.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name="EmMaterialSource")
@Table(name="EM_RESOURCE_MATERIAL_SOURCE")
public class EmMaterialSource implements Serializable{

	private static final long serialVersionUID = 7652507815269780056L;

	private EmMaterialSource(){
		
	}
	
	@Column(name="source_id")
	private String sourceId;
	
	@Column(name="source_name")
	private String sourceName;

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	@Override
	public String toString() {
		return "EmMaterialSource [sourceId=" + sourceId + ", sourceName=" + sourceName + "]";
	}
	
}
