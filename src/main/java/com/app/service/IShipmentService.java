package com.app.service;

import java.util.List;

import com.app.model.ShipmentType;

public interface IShipmentService {
	public Integer saveShipmentType(ShipmentType shipmentType);
	public void updateShipmentType(ShipmentType shipmentType);
	public void deleteShipmentType(Integer shipmentTypeId);
	
	public ShipmentType getOneShipmentType(Integer shipmentTypeId);
	public List<ShipmentType> getAllShipmentTypes();
	
	public List<Object[]> getShipmentsModeCount();

	

}
