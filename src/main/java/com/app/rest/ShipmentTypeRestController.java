package com.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.ShipmentType;
import com.app.service.IShipmentService;

@RestController
@RequestMapping("/rest/shipment")
public class ShipmentTypeRestController {

	@Autowired
	private IShipmentService service;
	
	// 1. To Show all Records in DB
	@GetMapping("/all")
	public ResponseEntity<?> getAll(){
		ResponseEntity<?> resp = null;
		
		// call service layer
		List<ShipmentType> obs = service.getAllShipmentTypes();
		
		if( obs != null && !obs.isEmpty()) {
		// if data exist in DB
			resp = new ResponseEntity<List<ShipmentType>>(obs,HttpStatus.OK);
		}
		else {
			//no data found then
			resp = new ResponseEntity<String>("No Records found in App"	, HttpStatus.OK);
		}
		return resp;
	}
	
	// 2. To Fetch one Row data
	@GetMapping("/one/{shipmentTypeId}")
	public ResponseEntity<?> getOne(@PathVariable Integer shipmentTypeId){
		ResponseEntity<?> resp = null;
		
		//call service layer
		ShipmentType st = service.getOneShipmentType(shipmentTypeId);
		
		if(st != null ) {  // if Row Exist
			resp = new ResponseEntity<ShipmentType>(st,HttpStatus.OK);
		}
		else {   // Row not Exist
			resp = new ResponseEntity<String>("Your ' "+shipmentTypeId+" ' is not exist",HttpStatus.BAD_REQUEST);
		}
		
			return resp;
	}
	
	// 3.Delete Based on Id
	@DeleteMapping("/delete/{shipmentTypeId}")
	public ResponseEntity<String> delete(@PathVariable Integer shipmentTypeId){
		ResponseEntity<String> resp = null;
		try {
		service.deleteShipmentType(shipmentTypeId);
		resp = new ResponseEntity<String>("Record ' "+shipmentTypeId+" ' deleted successfully",HttpStatus.OK);
		}catch(Exception ae) {
			resp = new ResponseEntity<String>("Record ' "+shipmentTypeId+" ' is Not Found",HttpStatus.BAD_REQUEST);
			ae.printStackTrace();
		}
		return resp;
	}
	
	// 4. save data in DB
	@PostMapping("/save")
	public ResponseEntity<String> saveData(@RequestBody ShipmentType shipmentType){
		
		//perform insert operation
		Integer shipmentTypeId = service.saveShipmentType(shipmentType);
		ResponseEntity<String> resp = new ResponseEntity<String>("successfully shipmentType  Id : ' "+shipmentTypeId +" 'saved ",HttpStatus.OK);

			return resp;
	}
	
	//5.Update data based on Pk if Exist
	@PutMapping("/modify")
	public ResponseEntity<String> updateData(@RequestBody ShipmentType shipmentType){
		ResponseEntity<String> resp = null;
		try {
			service.updateShipmentType(shipmentType);
			resp = new ResponseEntity<String>(" ShipmentType Id :' "+shipmentType.getShipmentTypeId()+" ' Updated successfully ", HttpStatus.OK);
		}catch(Exception ae) {
			resp = new ResponseEntity<String>("shipmentType Id : ' "+shipmentType.getShipmentTypeId()+" '   Not Found ",HttpStatus.BAD_REQUEST);
			ae.printStackTrace();
		}
		
		return resp;
	}
}

