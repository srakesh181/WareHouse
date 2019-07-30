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

import com.app.model.OrderMethod;
import com.app.service.IOrderMethodService;
import com.app.service.IShipmentService;

@RestController
@RequestMapping("/rest/order")
public class OrderMethodRestController {

	@Autowired
	private IOrderMethodService service;
	
	// 1. To Show all Records in DB
	@GetMapping("/all")
	public ResponseEntity<?> getAll(){
		ResponseEntity<?> resp = null;
		
		// call service layer
		List<OrderMethod> obs = service.getAllOrderMethods();
		
		if( obs != null && !obs.isEmpty()) {
		// if data exist in DB
			resp = new ResponseEntity<List<OrderMethod>>(obs,HttpStatus.OK);
		}
		else {
			//no data found then
			resp = new ResponseEntity<String>("No Records found in App"	, HttpStatus.OK);
		}
		return resp;
	}
	
	// 2. To Fetch one Row data
	@GetMapping("/one/{orderMethodId}")
	public ResponseEntity<?> getOne(@PathVariable Integer orderMethodId){
		ResponseEntity<?> resp = null;
		
		//call service layer
		OrderMethod om = service.getOneOrderMethod(orderMethodId);
		
		if(om != null ) {  // if Row Exist
			resp = new ResponseEntity<OrderMethod>(om,HttpStatus.OK);
		}
		else {   // Row not Exist
			resp = new ResponseEntity<String>("Your ' "+orderMethodId+" ' is not exist",HttpStatus.BAD_REQUEST);
		}
		
			return resp;
	}
	
	// 3.Delete Based on Id
	@DeleteMapping("/delete/{orderMethodId}")
	public ResponseEntity<String> delete(@PathVariable Integer orderMethodId){
		ResponseEntity<String> resp = null;
		try {
		service.deleteOrderMethod(orderMethodId);
		resp = new ResponseEntity<String>("Record ' "+orderMethodId+" ' deleted successfully",HttpStatus.OK);
		}catch(Exception ae) {
			resp = new ResponseEntity<String>("Record ' "+orderMethodId+" ' is Not Found",HttpStatus.BAD_REQUEST);
			ae.printStackTrace();
		}
		return resp;
	}
	
	// 4. save data in DB
	@PostMapping("/save")
	public ResponseEntity<String> saveData(@RequestBody OrderMethod orderMethod){
		
		//perform insert operation
		Integer orderMethodId = service.saveOrderMethod(orderMethod);
		ResponseEntity<String> resp = new ResponseEntity<String>("successfully OrderMethod  Id : ' "+orderMethodId +" 'saved ",HttpStatus.OK);

			return resp;
	}
	
	//5.Update data based on Pk if Exist
	@PutMapping("/modify")
	public ResponseEntity<String> updateData(@RequestBody OrderMethod orderMethod){
		ResponseEntity<String> resp = null;
		try {
			service.updateOrderMethod(orderMethod);
			resp = new ResponseEntity<String>(" OrderMethod Id :' "+orderMethod.getOrderMethodId()+" ' Updated successfully ", HttpStatus.OK);
		}catch(Exception ae) {
			resp = new ResponseEntity<String>("OrderMethod Id : ' "+orderMethod.getOrderMethodId()+" '   Not Found ",HttpStatus.BAD_REQUEST);
			ae.printStackTrace();
		}
		
		return resp;
	}
}

