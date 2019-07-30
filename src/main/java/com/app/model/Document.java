package com.app.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="document_tab")
public class Document {
	
	@Id
	@GeneratedValue
	@Column(name="file_id")
	private Integer fileId;
	@Column(name="file_name")
	private String fileName;
	@Lob
	@Column(name="file_data")
	private byte[] fileData;
	
	public Document() {
		super();
	}

	public Document(Integer fileId) {
		super();
		this.fileId = fileId;
	}

	public int getFileId() {
		return fileId;
	}

	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getFileData() {
		return fileData;
	}

	public void setFiledata(byte[] fileData) {
		this.fileData = fileData;
	}

	@Override
	public String toString() {
		return "Document [fileId=" + fileId + ", fileName=" + fileName + ", fileData=" + Arrays.toString(fileData)
				+ "]";
	}
	
	
	


}
