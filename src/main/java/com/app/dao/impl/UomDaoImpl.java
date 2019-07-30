package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IUomDao;
import com.app.model.Uom;

@Repository
public class UomDaoImpl implements IUomDao {
	
	//HAS-A Relation with HibernateTemplate
	@Autowired
	private HibernateTemplate ht;
	
	//save operation
	public Integer saveUom(Uom uom) {
		return (Integer)ht.save(uom);
	}

	//update operation
	public void updateUom(Uom uom) {
		ht.update(uom);
	}

	//delete operation
	public void deleteUom(Integer uomId) {
		ht.delete(new Uom(uomId));
	}

	//fetching one row
	public Uom getOneUom(Integer uomId) {
		return ht.get(Uom.class, uomId);
	}

	//fetching all rows
	public List<Uom> getAllUoms() {
		return ht.loadAll(Uom.class);
	}

	@Override
	public List<Object[]> getUomTypesCount() {
		String hql=" select shipmentMode , count(shipmentMode) from "+ getClass().getName() +" group by shipmentMode ";

		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>)ht.find(hql);
		
			return list;
		
	}

	@SuppressWarnings("deprecation")
	public boolean isUomModelExist(String uomModel) {
		long count=0;
		String hql = "select count(uomModel) from com.app.model.Uom where uomModel=?0";
		List<Long>  list=(List<Long>) ht.find(hql, uomModel);
		if(list != null // avoids NullPointerException
				&&
				!list.isEmpty()) {
			count = list.get(0);
		}
		return count!=0?true:false;
	}
	
	
	
}
