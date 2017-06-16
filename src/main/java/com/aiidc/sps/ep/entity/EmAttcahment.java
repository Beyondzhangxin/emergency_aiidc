package com.aiidc.sps.ep.entity;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="EmAttcahment")
@Table(name="EM_ATTACHMENT")
public class EmAttcahment implements Serializable {

	private static final long serialVersionUID = -7907455369970977148L;
	
	@Id
	@Column(name="ATTACHMENT_ID")
	private int attachmentId;
	
	@Column(name="LIBRARY_CODE")
	private String libraryCode;
	
	@Column(name="DOC_ID")
	private int docId;
	
	@Column(name="ATTACHMENT_CONTENT")
	private byte[] attachmentContent;
	
	@Column(name="ATTACHMENT_NAME")
	public String attachmentName;
	
	public EmAttcahment(){
		
	}

	public int getAttachmentId() {
		return attachmentId;
	}

	public void setAttachmentId(int attachmentId) {
		this.attachmentId = attachmentId;
	}

	public int getDocId() {
		return docId;
	}

	public void setDocId(int docId) {
		this.docId = docId;
	}

	public byte[] getAttachmentContent() {
		return attachmentContent;
	}

	public void setAttachmentContent(byte[] attachmentContent) {
		this.attachmentContent = attachmentContent;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getAttachmentName() {
		return attachmentName;
	}

	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}

	public String getLibraryCode() {
		return libraryCode;
	}

	public void setLibraryCode(String libraryCode) {
		this.libraryCode = libraryCode;
	}

	@Override
	public String toString() {
		return "EmAttcahment [attachmentId=" + attachmentId + ", libraryCode=" + libraryCode + ", docId=" + docId
				+ ", attachmentContent=" + Arrays.toString(attachmentContent) + ", attachmentName=" + attachmentName
				+ "]";
	}
}
