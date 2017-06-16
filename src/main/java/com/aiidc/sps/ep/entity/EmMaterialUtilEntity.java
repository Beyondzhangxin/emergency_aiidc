package com.aiidc.sps.ep.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

@Entity(name="EmMaterialUtilEntity")
public class EmMaterialUtilEntity implements Serializable{

	private static final long serialVersionUID = 6240950329379234660L;

	private String materialId;
	
	private String typeName;
	
	private String classifyName;
	
	private String materialName;
	
	private String num;
	
	private Date expiryDate;
	
	private Date changeTime;
	
	private String companyName;
	
	private Date createTime;
	
	private String companyId;

	public String getMaterialId() {
		return materialId;
	}

	public void setMaterialId(String materialId) {
		this.materialId = materialId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getClassifyName() {
		return classifyName;
	}

	public void setClassifyName(String classifyName) {
		this.classifyName = classifyName;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Date getChangeTime() {
		return changeTime;
	}

	public void setChangeTime(Date changeTime) {
		this.changeTime = changeTime;
	}

	
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	
	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	@Override
	public String toString() {
		return "EmMaterialUtilEntity [materialId=" + materialId + ", typeName=" + typeName + ", classifyName="
				+ classifyName + ", materialName=" + materialName + ", num=" + num + ", expiryDate=" + expiryDate
				+ ", changeTime=" + changeTime + ", companyName=" + companyName + ", createTime=" + createTime
				+ ", companyId=" + companyId + "]";
	}
	
}
