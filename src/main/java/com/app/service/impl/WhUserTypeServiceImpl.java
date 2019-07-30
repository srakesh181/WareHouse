package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IWhUserTypeDao;
import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;

@Service
public class WhUserTypeServiceImpl implements IWhUserTypeService {

	//Has-a relation with IWhUserTypeDao
	@Autowired
	private IWhUserTypeDao dao;
	
	//save operation
	@Transactional
	public Integer saveWhUserType(WhUserType whUser) {
		return dao.saveWhUserType(whUser);
	}

	//update operation
	@Transactional
	public void updateWhUserType(WhUserType whUser) {
		dao.updateWhUserType(whUser);
	}

	//delete operation
	@Transactional
	public void deleteWhUserType(Integer whUserTypeId) {
		dao.deleteWhUserType(whUserTypeId);
	}

	//get operation
	@Transactional(readOnly=true)
	public WhUserType getOneWhUserType(Integer whUserTypeId) {
		return dao.getOneWhUserType(whUserTypeId);
	}

	//load operation
	@Transactional(readOnly=true)
	public List<WhUserType> getAllWhUserTypes() {
		return dao.getAllWhUserTypes();
	}

	@Override
	public List<Object[]> getWhUserTypesCount() {
		List<Object[]> list = dao.getWhUserTypesCount();
		
		return list;
	}

}
