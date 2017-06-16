package com.aiidc.sps.ep.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="EmHazardChenical")
@Table(name="EM_PARK_HAZARD_CHEMICAL")
public class EmHazardChenical implements Serializable {

	private static final long serialVersionUID = -3666857368892777346L;
	
	@Id
	@Column(name="id")
	private int id;
	//中文名称
	@Column(name="chinese_name")
	private String chineseName;
	//英文名称
	@Column(name="english_name")
	private String englishName;
	//CAS号
	@Column(name="cas_code")
	private String casCode;
	//内容
	@Column(name="content")
	private String content;
	
	public EmHazardChenical(){
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "EmHazardChenical [id=" + id + ", chineseName=" + chineseName + ", englishName=" + englishName
				+ ", casCode=" + casCode + ", content=" + content + "]";
	}

}
