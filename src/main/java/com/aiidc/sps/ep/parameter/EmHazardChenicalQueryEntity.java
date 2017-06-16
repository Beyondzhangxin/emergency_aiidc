package com.aiidc.sps.ep.parameter;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity(name="EmHazardChenicalQueryEntity")
public class EmHazardChenicalQueryEntity implements Serializable {

	private static final long serialVersionUID = 6607845218999638370L;
	private Integer page;
	private Integer rows;
	private String chineseName;
	private String englishName;
	private String casCode;
	
	
	public EmHazardChenicalQueryEntity(){
		
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


	public String getChineseName() {
		return chineseName;
	}


	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}


	public String getEnglishName() {
		return englishName;
	}


	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}


	public String getCasCode() {
		return casCode;
	}


	public void setCasCode(String casCode) {
		this.casCode = casCode;
	}


	@Override
	public String toString() {
		return "EmHazardChenicalQueryEntity [page=" + page + ", rows=" + rows + ", chineseName=" + chineseName
				+ ", englishName=" + englishName + ", casCode=" + casCode + "]";
	}
	
	
}
