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

import com.app.model.Item;
import com.app.service.IItemService;
import com.app.service.IShipmentService;

@RestController
@RequestMapping("/rest/item")
public class ItemRestController {

	@Autowired
	private IItemService service;
	
	// 1. To Show all Records in DB
	@GetMapping("/all")
	public ResponseEntity<?> getAll(){
		ResponseEntity<?> resp = null;
		
		// call service layer
		List<Item> obs = service.getAllItems();
		
		if( obs != null && !obs.isEmpty()) {
		// if data exist in DB
			resp = new ResponseEntity<List<Item>>(obs,HttpStatus.OK);
		}
		else {
			//no data found then
			resp = new ResponseEntity<String>("No Records found in App"	, HttpStatus.OK);
		}
		return resp;
	}
	
	// 2. To Fetch one Row data
	@GetMapping("/one/{itemId}")
	public ResponseEntity<?> getOne(@PathVariable Integer itemId){
		ResponseEntity<?> resp = null;
		
		//call service layer
		Item itm = service.getOneItem(itemId);
		
		if(itm != null ) {  // if Row Exist
			resp = new ResponseEntity<Item>(itm,HttpStatus.OK);
		}
		else {   // Row not Exist
			resp = new ResponseEntity<String>("Your ' "+itemId+" ' is not exist",HttpStatus.BAD_REQUEST);
		}
		
			return resp;
	}
	
	// 3.Delete Based on Id
	@DeleteMapping("/delete/{itemId}")
	public ResponseEntity<String> delete(@PathVariable Integer itemId){
		ResponseEntity<String> resp = null;
		try {
		service.deleteItem(itemId);
		resp = new ResponseEntity<String>("Record ' "+itemId+" ' deleted successfully",HttpStatus.OK);
		}catch(Exception ae) {
			resp = new ResponseEntity<String>("Record ' "+itemId+" ' is Not Found",HttpStatus.BAD_REQUEST);
			ae.printStackTrace();
		}
		return resp;
	}
	
	// 4. save data in DB
	@PostMapping("/save")
	public ResponseEntity<String> saveData(@RequestBody Item item){
		
		//perform insert operation
		Integer itemId = service.saveItem(item);
		ResponseEntity<String> resp = new ResponseEntity<String>("successfully Item  Id : ' "+itemId +" 'saved ",HttpStatus.OK);

			return resp;
	}
	
	//5.Update data based on Pk if Exist
	@PutMapping("/modify")
	public ResponseEntity<String> updateData(@RequestBody Item item){
		ResponseEntity<String> resp = null;
		try {
			service.updateItem(item);
			resp = new ResponseEntity<String>(" Item Id :' "+item.getItemId()+" ' Updated successfully ", HttpStatus.OK);
		}catch(Exception ae) {
			resp = new ResponseEntity<String>("Item Id : ' "+item.getItemId()+" '   Not Found ",HttpStatus.BAD_REQUEST);
			ae.printStackTrace();
		}
		
		return resp;
	}
}

