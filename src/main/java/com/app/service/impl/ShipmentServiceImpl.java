package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IShipmentTypeDao;
import com.app.model.ShipmentType;
import com.app.service.IShipmentService;
@Service
public class ShipmentServiceImpl implements IShipmentService {
	@Autowired
	private IShipmentTypeDao dao;

	@Transactional
	public Integer saveShipmentType(ShipmentType shipmentType) {
		return dao.saveShipmentType(shipmentType);
	}

	@Transactional
	public void updateShipmentType(ShipmentType shipmentType) {
		dao.updateShipmentType(shipmentType);
	}
	
	@Transactional
	public void deleteShipmentType(Integer shipmentTypeId) {
		dao.deleteShipmentType(shipmentTypeId);
	}
	
	@Transactional(readOnly=true)
	public ShipmentType getOneShipmentType(Integer shipmentTypeId) {
		return dao.getOneShipmentType(shipmentTypeId);
	}

	@Transactional(readOnly=true)
	public List<ShipmentType> getAllShipmentTypes() {
		return dao.getAllShipmentTypes();
	}
	@SuppressWarnings("deprecation")
	@Override
	public List<Object[]> getShipmentsModeCount() {
		

			List<Object[]> list = dao.getShipmentsModeCount();
		
			return list;
	}

}
