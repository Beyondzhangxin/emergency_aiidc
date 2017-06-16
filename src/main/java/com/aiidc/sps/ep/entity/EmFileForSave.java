package com.aiidc.sps.ep.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name="EM_PARK_IMPORTANT_LIBRARY")
@Table(name="EM_PARK_IMPORTANT_LIBRARY")
public class EmFileForSave extends EmParkImportantLibrary{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8520999373569437488L;
	@Column(name="CONTENT")
	private byte[] content;

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}
}
