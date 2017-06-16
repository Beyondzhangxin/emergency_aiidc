package com.aiidc.sps.ep.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="EM_PARK_IMPORTANT_LIBRARY")
@Table(name="EM_PARK_IMPORTANT_LIBRARY")
public class EmFileContent implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4404611762137577620L;


	@Id
	@Column(name="FILE_ID")
	private int fileId;
	
	@Column(name="FILE_NAME")
	private String fileName;
	
	
	@Column(name="CONTENT")
	private byte[] content;


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public int getFileId() {
		return fileId;
	}


	public String getFileName() {
		return fileName;
	}


	public byte[] getContent() {
		return content;
	}


	public void setFileId(int fileId) {
		this.fileId = fileId;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public void setContent(byte[] content) {
		this.content = content;
	}
	
	

	

	

	
	
	
}
