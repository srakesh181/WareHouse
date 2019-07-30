package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IDocumentDao;
import com.app.model.Document;
@Repository
public class DocumentDaoImpl implements IDocumentDao {

	@Autowired
	private HibernateTemplate ht;
	
	@SuppressWarnings("deprecation")
	public List<Object[]> getFileIdAndNames() {
		
		String hql = " select fileId,fileName form com.app.model.Document" ;
		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) ht.find(hql);

		return list;
	}
	
	@Override
	public Document getOneDocument(Integer fileId) {

		
		return ht.get(Document.class, fileId);
	}
	
	public void saveDocument(Document document) {
		
		ht.save(document);
	}

}
