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

import com.app.model.Uom;
import com.app.service.IShipmentService;
import com.app.service.IUomService;

@RestController
@RequestMapping("/rest/uom")
public class UomRestController {

	@Autowired
	private IUomService service;
	
	// 1. To Show all Records in DB
	@GetMapping("/all")
	public ResponseEntity<?> getAll(){
		ResponseEntity<?> resp = null;
		
		// call service layer
		List<Uom> obs = service.getAllUoms();
		
		if( obs != null && !obs.isEmpty()) {
		// if data exist in DB
			resp = new ResponseEntity<List<Uom>>(obs,HttpStatus.OK);
		}
		else {
			//no data found then
			resp = new ResponseEntity<String>("No Records found in App"	, HttpStatus.OK);
		}
		return resp;
	}
	
	// 2. To Fetch one Row data
	@GetMapping("/one/{uomId}")
	public ResponseEntity<?> getOne(@PathVariable Integer uomId){
		ResponseEntity<?> resp = null;
		
		//call service layer
		Uom u = service.getOneUom(uomId);
		
		if(u != null ) {  // if Row Exist
			resp = new ResponseEntity<Uom>(u,HttpStatus.OK);
		}
		else {   // Row not Exist
			resp = new ResponseEntity<String>("Your ' "+uomId+" ' is not exist",HttpStatus.BAD_REQUEST);
		}
		
			return resp;
	}
	
	// 3.Delete Based on Id
	@DeleteMapping("/delete/{uomId}")
	public ResponseEntity<String> delete(@PathVariable Integer uomId){
		ResponseEntity<String> resp = null;
		try {
		service.deleteUom(uomId);
		resp = new ResponseEntity<String>("Record ' "+uomId+" ' deleted successfully",HttpStatus.OK);
		}catch(Exception ae) {
			resp = new ResponseEntity<String>("Record ' "+uomId+" ' is Not Found",HttpStatus.BAD_REQUEST);
			ae.printStackTrace();
		}
		return resp;
	}
	
	// 4. save data in DB
	@PostMapping("/save")
	public ResponseEntity<String> saveData(@RequestBody Uom uom){
		
		//perform insert operation
		Integer uomId = service.saveUom(uom);
		ResponseEntity<String> resp = new ResponseEntity<String>("successfully Uom  Id : ' "+uomId +" 'saved ",HttpStatus.OK);

			return resp;
	}
	
	//5.Update data based on Pk if Exist
	@PutMapping("/modify")
	public ResponseEntity<String> updateData(@RequestBody Uom uom){
		ResponseEntity<String> resp = null;
		try {
			service.updateUom(uom);
			resp = new ResponseEntity<String>(" Uom Id :' "+uom.getUomId()+" ' Updated successfully ", HttpStatus.OK);
		}catch(Exception ae) {
			resp = new ResponseEntity<String>("Uom Id : ' "+uom.getUomId()+" '   Not Found ",HttpStatus.BAD_REQUEST);
			ae.printStackTrace();
		}
		
		return resp;
	}
}

