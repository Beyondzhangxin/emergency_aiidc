package com.aiidc.sps.ep.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity(name="EmMaterial")
@Table(name="EM_RESOURCE_MATERIAL")
public class EmMaterial implements Serializable{

	private static final long serialVersionUID = -1648934738590385763L;
	
	@Id
	@Column(name="company_id")
	private String companyId;
	
	@Column(name="material_id")
	private String materialId;
	
	@Column(name="material_name")
	private String materialName;
	
	@Column(name="team_id")
	private String teamId;
	
	@Column(name="area_id")
	private String areaId;

	@Column(name="material_classify_id")
	private String materialClassifyId;
	
	@Column(name="material_type_id")
	private String materialTypeId;
	
	@Column(name="material_source_id")
	private String materialSourceId;

	@Column(name="num")
	private Integer num;

	@Column(name="type")
	private String type;

	@Column(name="spec")
	private String spec;

	@Column(name="unit")
	private String unit;

	@Column(name="current_status")
	private String currentStatus;

	@Column(name="storage_place")
	private String storagePlace;

	@Column(name="manufacturer")
	private String manufacturer;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="purchase_date")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date purchaseDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="product_date")
	private Date productDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="expiry_date")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date expiryDate;
	
	@Column(name="useful_life")
	private Integer usefulLife;
	
	@Column(name="performance")
	private String performance;
	
	@Column(name="purpose")
	private String purpose;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_time")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="change_time")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date changeTime;
	
	public EmMaterial(){
		
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getMaterialId() {
		return materialId;
	}

	public void setMaterialId(String materialId) {
		this.materialId = materialId;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
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

	public String getMaterialSourceId() {
		return materialSourceId;
	}

	public void setMaterialSourceId(String materialSourceId) {
		this.materialSourceId = materialSourceId;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}

	public String getStoragePlace() {
		return storagePlace;
	}

	public void setStoragePlace(String storagePlace) {
		this.storagePlace = storagePlace;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Date getProductDate() {
		return productDate;
	}

	public void setProductDate(Date productDate) {
		this.productDate = productDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Integer getUsefulLife() {
		return usefulLife;
	}

	public void setUsefulLife(Integer usefulLife) {
		this.usefulLife = usefulLife;
	}

	public String getPerformance() {
		return performance;
	}

	public void setPerformance(String performance) {
		this.performance = performance;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getChangeTime() {
		return changeTime;
	}

	public void setChangeTime(Date changeTime) {
		this.changeTime = changeTime;
	}

	

}


















