package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUomDao;
import com.app.model.Uom;
import com.app.service.IUomService;

@Service
public class UomServiceImpl implements IUomService {
	
	//HAS-A Relation with IUomDao
	@Autowired
	private IUomDao dao;
	
	//save operation
	@Transactional
	public Integer saveUom(Uom uom) {
		return dao.saveUom(uom);
	}

	//update operation
	@Transactional
	public void updateUom(Uom uom) {
		dao.updateUom(uom);
	}

	//delete operation
	@Transactional
	public void deleteUom(Integer uomId) {
		dao.deleteUom(uomId);
	}

	//fetching one row
	@Transactional(readOnly=true)
	public Uom getOneUom(Integer uomId) {
		return dao.getOneUom(uomId);
	}

	//fetching all rows
	@Transactional(readOnly=true)
	public List<Uom> getAllUoms() {
		return dao.getAllUoms();
	}

	@Transactional(readOnly=true)
	public List<Object[]> getUomTypesCount() {

		List<Object[]> list = dao.getUomTypesCount();
	
		return list;
	}

	@Transactional(readOnly=true)
	public boolean isUomModelExist(String uomModel) {
		return dao.isUomModelExist(uomModel);
	}

}
