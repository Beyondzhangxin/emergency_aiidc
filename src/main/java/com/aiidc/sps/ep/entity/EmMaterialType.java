package com.aiidc.sps.ep.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 物资装备类别
 * @author gkr
 *
 */
@Entity(name="EmMaterialType")
@Table(name="EM_RESOURCE_MATERIAL_ CLASSIFY")
public class EmMaterialType implements Serializable{

	private static final long serialVersionUID = 3456117913662703618L;
	
	@Column(name="type_id")
	private String typeId;
	@Column(name="type_name")
	private String typeName;
	

	public EmMaterialType() {

	}
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	@Override
	public String toString() {
		return "EmMaterialType [typeId=" + typeId + ", typeName=" + typeName + "]";
	}
	
}
