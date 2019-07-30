package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IWhUserTypeDao;
import com.app.model.WhUserType;

@Repository
public class WhUserTypeDaoImpl implements IWhUserTypeDao {
	
	//Has-a Relation with HibermateTemplate
	@Autowired
	private HibernateTemplate ht;
	
	//save operation
	public Integer saveWhUserType(WhUserType whUser) {
		return (Integer)ht.save(whUser);
	}

	//update operation
	public void updateWhUserType(WhUserType whUser) {
		ht.update(whUser);
	}

	//delete operation 
	public void deleteWhUserType(Integer whUserTypeId) {
		ht.delete(new WhUserType(whUserTypeId));
		
	}

	//get operation
	public WhUserType getOneWhUserType(Integer whUserTypeId) {
		return ht.get(WhUserType.class, whUserTypeId);
	}

	//loadAll operation
	public List<WhUserType> getAllWhUserTypes() {
		return ht.loadAll(WhUserType.class);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public List<Object[]> getWhUserTypesCount() {
		
		String hql=" select whUserType , count(whUserType) from "+ getClass().getName() +" group by whUserType ";

		List<Object[]> list = (List<Object[]>)ht.find(hql);
		
			return list;
	}

}
