package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Item;
import com.app.service.IItemService;

@Controller
@RequestMapping("/item")
public class ItemController {

	//HAS-A Relation with IItemService
	@Autowired
	private IItemService service;

	//1.show Register page
	@RequestMapping("/reg")
	public String showReg(@ModelAttribute Item item,ModelMap map) {
		
		// Form Backing Object
		map.addAttribute("item", new Item());
		return "ItemRegister";
	}
	
	//on click submit on registration form
	@RequestMapping(value = "/save", method=RequestMethod.POST)
	public String saveItem(@ModelAttribute Item item , ModelMap map) {
		
		//Form Backing object
		map.addAttribute("item", new Item());
		
		// call service layer saveItem() method
		Integer itemId=service.saveItem(item);
		
		//send to UI
		map.addAttribute("msg", "Item ' "+itemId+" ' saved successfully");
		
			return "ItemRegister";
	}
	
	//3.Fetch All Records from DB and send to UI 
	 @RequestMapping("/data")
	public String getAllItems(ModelMap map) {
		
		 //call service layer getAllItems() method
		 List<Item> obs=service.getAllItems();
		 
		 //send to UI
		 map.addAttribute("list", obs);
		 
		 	return "ItemData";
	}
	 
	 //4.delete Row Based on itemId
	 @RequestMapping("/delete")
	 public String deleteItem(@RequestParam Integer itemId,ModelMap map) {
		 
		 //call service layer deleteItem()
		 service.deleteItem(itemId);
		 
		 //new Data
		 List<Item> obs=service.getAllItems();
		 
		 //send data UI
		 map.addAttribute("list", obs);
		 map.addAttribute("msg", "Item ' "+itemId+" ' deleted successfully");
		 	
		 	return "ItemData";
	 }
	 
	 //5.show Edit page
	 @RequestMapping("/edit")
	 public String showEdit(@RequestParam Integer itemId,ModelMap map) {
		 
		 //call service layer getOneItem()
		 Item itm=service.getOneItem(itemId);
		 
		 //send to UI
		 map.addAttribute("item", itm);
		 
		 	return "ItemEdit";
	 }
	 
	 //6.update operation
	 @RequestMapping("/update")
	 public String updateItem(@ModelAttribute Item item,ModelMap map) {
		 
		 //call service layer updateItem()
		 service.updateItem(item);
		 
		 //getAllItems
		 List<Item> obs=service.getAllItems();
		 
		 //updated data Send to UI
		 map.addAttribute("list", obs);
		 map.addAttribute("msg", "Item ' "+item.getItemId()+" ' updated successfully");
		 
		 return "ItemData";
	 }
	 
	 //7.get one Row based on PK
	 @RequestMapping("/view")
	 public String viewOne(@RequestParam Integer itemId,ModelMap map) {
		 
		 //call service layer getOneItem()
		 Item itm=service.getOneItem(itemId);
		 
		 //data Send to UI 
		 map.addAttribute("ob", itm);
		 
		 	return "ItemViewOne";
	 }
	 
}
