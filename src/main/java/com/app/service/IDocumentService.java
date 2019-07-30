package com.app.service;

import java.util.List;

import com.app.model.Document;

public interface IDocumentService {
	

	public List<Object[]> getFileIdAndNames();
	
	public Document getOneDocument(Integer fileId);
	public void saveDocument(Document document);

}
