package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IShipmentTypeDao;
import com.app.model.ShipmentType;
@Repository
public class ShipmentTypeDaoImpl implements IShipmentTypeDao {
	@Autowired
	private HibernateTemplate ht;

	public Integer saveShipmentType(ShipmentType shipmentType) {
		return (Integer) ht.save(shipmentType);
	}

	public void updateShipmentType(ShipmentType shipmentType) {
		ht.update(shipmentType);
	}

	public void deleteShipmentType(Integer shipmentTypeId) {
		ht.delete(new ShipmentType(shipmentTypeId));
	}

	public ShipmentType getOneShipmentType(Integer shipmentTypeId) {
		return ht.get(ShipmentType.class, shipmentTypeId);
	}

	@Override
	public List<ShipmentType> getAllShipmentTypes() {
		return ht.loadAll(ShipmentType.class);
	}
	@SuppressWarnings("deprecation")
	@Override
	public List<Object[]> getShipmentsModeCount() {
		
		String hql=" select shipmentMode,count(shipmentMode) from com.app.model.ShipmentType group by shipmentMode ";

		List<Object[]> list = (List<Object[]>)ht.find(hql);
		
			return list;
	}
	

}
