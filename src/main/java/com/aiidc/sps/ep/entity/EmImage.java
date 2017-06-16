package com.aiidc.sps.ep.entity;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="EmMaterial")
@Table(name="EM_IMAGE")
public class EmImage implements Serializable{

	private static final long serialVersionUID = -7548979922104207126L;
	
	@Id
	@Column(name="IMAGE_ID")
	private int imageId;
	
	@Column(name="LIBRARY_CODE")
	private String libraryCode;
	
	@Column(name="DOC_ID")
	private int docId;
	
	@Column(name="IMAGE_CONTENT")
	private byte[] imageContent;
	
	public EmImage(){
		
	}

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public int getDocId() {
		return docId;
	}

	public void setDocId(int docId) {
		this.docId = docId;
	}

	public byte[] getImageContent() {
		return imageContent;
	}

	public void setImageContent(byte[] imageContent) {
		this.imageContent = imageContent;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	public String getLibraryCode() {
		return libraryCode;
	}

	public void setLibraryCode(String libraryCode) {
		this.libraryCode = libraryCode;
	}

	@Override
	public String toString() {
		return "EmImage [imageId=" + imageId + ", libraryCode=" + libraryCode + ", docId=" + docId + ", imageContent="
				+ Arrays.toString(imageContent) + "]";
	}
	
}








































