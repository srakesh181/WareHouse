package com.app.dao;

import java.util.List;

import com.app.model.Document;

public interface IDocumentDao {

	public List<Object[]> getFileIdAndNames();
	
	public Document getOneDocument(Integer fileId);
	public void saveDocument(Document document);
}
