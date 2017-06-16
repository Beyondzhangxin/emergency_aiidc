package com.aiidc.sps.ep.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="EM_PARK_IMPORTANT_LIBRARY")
@Table(name="EM_PARK_IMPORTANT_LIBRARY")
public class EmParkImportantLibrary implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8228101974077802862L;
	@Id
	@Column(name="FILE_ID")
	private int fileId;
	@Column(name="FILE_NAME")
	private String fileName;
	@Column(name="FILE_SIZE")
	private long fileSize;
	@Column(name="UPLOADER")
	private String uploader;
	@Column(name="UPLOAD_DATE")
	private Date uploadDate;
	
	
	

	public int getFileId() {
		return fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public long getFileSize() {
		return fileSize;
	}

	public String getUploader() {
		return uploader;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public void setUploader(String uploader) {
		this.uploader = uploader;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	

	
	
	
	
}
