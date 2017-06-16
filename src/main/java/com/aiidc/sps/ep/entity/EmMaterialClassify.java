
package com.aiidc.sps.ep.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 物资装备分类
 * @author gkr
 *
 */
@Entity(name="EmMaterialClassify")
@Table(name="EM_RESOURCE_MATERIAL_ CLASSIFY")
public class EmMaterialClassify implements Serializable{

	private static final long serialVersionUID = -8587047861048848375L;
	
	@Column(name="classify_id")
	private String classifyId;
	@Column(name="classify_name")
	private String classifyName;
	
	
	public String getClassifyId() {
		return classifyId;
	}
	public void setClassifyId(String classifyId) {
		this.classifyId = classifyId;
	}
	public String getClassifyName() {
		return classifyName;
	}
	public void setClassifyName(String classifyName) {
		this.classifyName = classifyName;
	}
	@Override
	public String toString() {
		return "EmMaterialClassify [classifyId=" + classifyId + ", classifyName=" + classifyName + "]";
	}
	
	
}
