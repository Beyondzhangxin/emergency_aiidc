package com.aiidc.sps.ep.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name="Area")
@Table(name="AREA")
public class Area implements Serializable {

	private static final long serialVersionUID = 2283476141023822062L;
	
	@Column(name="AREA_ID")
	private String areaId;
	
	@Column(name="AREA_NM")
	private String areaName;
	
	@Column(name="PROV_ID")
	private String provId;
	
	@Column(name="CITY_ID")
	private String cityId;
	
	@Column(name="COUNTY_ID")
	private String countyId;
	
	@Column(name="FULL_NM")
	private String fullName;
	
	public Area(){
		
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getProvId() {
		return provId;
	}

	public void setProvId(String provId) {
		this.provId = provId;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getCountyId() {
		return countyId;
	}

	public void setCountyId(String countyId) {
		this.countyId = countyId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Override
	public String toString() {
		return "Area [areaId=" + areaId + ", areaName=" + areaName + ", provId=" + provId + ", cityId=" + cityId
				+ ", countyId=" + countyId + ", fullName=" + fullName + "]";
	}
	
}
