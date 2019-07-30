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

import com.app.model.WhUserType;
import com.app.service.IShipmentService;
import com.app.service.IWhUserTypeService;

@RestController
@RequestMapping("/rest/whuser")
public class WhUserTypeRestController {

	@Autowired
	private IWhUserTypeService service;
	
	// 1. To Show all Records in DB
	@GetMapping("/all")
	public ResponseEntity<?> getAll(){
		ResponseEntity<?> resp = null;
		
		// call service layer
		List<WhUserType> obs = service.getAllWhUserTypes();
		
		if( obs != null && !obs.isEmpty()) {
		// if data exist in DB
			resp = new ResponseEntity<List<WhUserType>>(obs,HttpStatus.OK);
		}
		else {
			//no data found then
			resp = new ResponseEntity<String>("No Records found in App"	, HttpStatus.OK);
		}
		return resp;
	}
	
	// 2. To Fetch one Row data
	@GetMapping("/one/{whUserTypeId}")
	public ResponseEntity<?> getOne(@PathVariable Integer whUserTypeId){
		ResponseEntity<?> resp = null;
		
		//call service layer
		WhUserType ut = service.getOneWhUserType(whUserTypeId);
		
		if(ut != null ) {  // if Row Exist
			resp = new ResponseEntity<WhUserType>(ut,HttpStatus.OK);
		}
		else {   // Row not Exist
			resp = new ResponseEntity<String>("Your ' "+whUserTypeId+" ' is not exist",HttpStatus.BAD_REQUEST);
		}
		
			return resp;
	}
	
	// 3.Delete Based on Id
	@DeleteMapping("/delete/{whUserTypeId}")
	public ResponseEntity<String> delete(@PathVariable Integer whUserTypeId){
		ResponseEntity<String> resp = null;
		try {
		service.deleteWhUserType(whUserTypeId);
		resp = new ResponseEntity<String>("Record ' "+whUserTypeId+" ' deleted successfully",HttpStatus.OK);
		}catch(Exception ae) {
			resp = new ResponseEntity<String>("Record ' "+whUserTypeId+" ' is Not Found",HttpStatus.BAD_REQUEST);
			ae.printStackTrace();
		}
		return resp;
	}
	
	// 4. save data in DB
	@PostMapping("/save")
	public ResponseEntity<String> saveData(@RequestBody WhUserType whUserType){
		
		//perform insert operation
		Integer whUserTypeId = service.saveWhUserType(whUserType);
		ResponseEntity<String> resp = new ResponseEntity<String>("successfully WhUserType  Id : ' "+whUserTypeId +" 'saved ",HttpStatus.OK);

			return resp;
	}
	
	//5.Update data based on Pk if Exist
	@PutMapping("/modify")
	public ResponseEntity<String> updateData(@RequestBody WhUserType whUserType){
		ResponseEntity<String> resp = null;
		try {
			service.updateWhUserType(whUserType);
			resp = new ResponseEntity<String>(" WhUserType Id :' "+whUserType.getWhUserTypeId()+" ' Updated successfully ", HttpStatus.OK);
		}catch(Exception ae) {
			resp = new ResponseEntity<String>("WhUserType Id : ' "+whUserType.getWhUserTypeId()+" '   Not Found ",HttpStatus.BAD_REQUEST);
			ae.printStackTrace();
		}
		
		return resp;
	}
}

