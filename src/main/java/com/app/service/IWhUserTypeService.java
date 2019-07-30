package com.app.service;

import java.util.List;

import com.app.model.WhUserType;

public interface IWhUserTypeService {

	public Integer saveWhUserType(WhUserType whUser);
	public void updateWhUserType(WhUserType whUser);
	public void deleteWhUserType(Integer whUserTypeId);
	
	public WhUserType getOneWhUserType(Integer whUserTypeId);
	public List<WhUserType> getAllWhUserTypes();
	
	public List<Object[]> getWhUserTypesCount();



}
