package com.aiidc.sps.ep.parameter;

import java.io.Serializable;

import javax.persistence.Entity;
@Entity(name="EmMaterialParameter")
public class EmMaterialParameter implements Serializable{

	private static final long serialVersionUID = 8498602263948891992L;
	
	private Integer page;
	private Integer rows;
	private String materialName;
	private String areaId;
	private String materialClassifyId;
	private String materialTypeId;
	private String isExpire;
	private String companyName;
	
	public EmMaterialParameter(){
		
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

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public String getMaterialClassifyId() {
		return materialClassifyId;
	}

	public void setMaterialClassifyId(String materialClassifyId) {
		this.materialClassifyId = materialClassifyId;
	}

	public String getMaterialTypeId() {
		return materialTypeId;
	}

	public void setMaterialTypeId(String materialTypeId) {
		this.materialTypeId = materialTypeId;
	}

	public String getIsExpire() {
		return isExpire;
	}

	public void setIsExpire(String isExpire) {
		this.isExpire = isExpire;
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

	@Override
	public String toString() {
		return "EmMaterialParameter [page=" + page + ", rows=" + rows + ", materialName=" + materialName + ", areaId="
				+ areaId + ", materialClassifyId=" + materialClassifyId + ", materialTypeId=" + materialTypeId
				+ ", isExpire=" + isExpire + ", companyName=" + companyName + "]";
	}
	
}
