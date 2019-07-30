package com.app.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.ShipmentType;
import com.app.service.IShipmentService;
import com.app.util.ShipmentTypeUtil;
import com.app.view.ShipmentTypeExcelView;
import com.app.view.ShipmentTypePdfView;

@Controller
@RequestMapping("/shipment")
public class ShipmentTypeController {
	@Autowired
	private IShipmentService service;
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private ShipmentTypeUtil util;
	
	//1.To Show Register page
	@RequestMapping("/reg")
	public String showReg(ModelMap map) {
		
		//Form Backing Object
		map.addAttribute("shipmentType", new ShipmentType());
		
		return "ShipmentTypeRegister";
	}

	//2.on click submit on Register form
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveShipmentType(@ModelAttribute ShipmentType shipmentType,ModelMap map) {

		// calling service layer saveShipmentType() method
		Integer id=service.saveShipmentType(shipmentType);

		//creating success message
		String message= "Shipment Type' "+id+" ' saved Successfully";

		//send data  controller to ShipmentTypeRegister UI page using ModelMap
		map.addAttribute("msg", message);
		
		//Form Backing Object
				map.addAttribute("shipmentType", new ShipmentType());
				

		return "ShipmentTypeRegister";
	}
	

	//3.Fetch All Rows from DB and send data to UI
	@RequestMapping("/data")
	public String getAllShipments(ModelMap map) {

		//call service layer getAllShipmentTypes() method
		List<ShipmentType> obs=service.getAllShipmentTypes();

		// send data Controller to ShipmentTypeData ( UI ) using ModelMap
		map.addAttribute("list", obs);
		
			return "ShipmentTypeData";
	}
	
	//4.delete row based on Id
	@RequestMapping("/delete")
	public String deleteShipmentType(@RequestParam Integer shipmentTypeId,ModelMap map) {
		
		//row delete
		
		service.deleteShipmentType(shipmentTypeId);
		//new data
		List<ShipmentType> obs=service.getAllShipmentTypes();
		
		//send data to ShipmentTypeData ( UI ) page
		map.addAttribute("msg", "Shipment Type ' "+shipmentTypeId+ "'deleted successfully");
		map.addAttribute("list", obs);
			
			return "ShipmentTypeData";
	}
	
	
	//5.show Edit page
	@RequestMapping("/edit")
	public String showEdit(@RequestParam Integer shipmentTypeId ,ModelMap map) {
		
		//call service layer getOneShipmentType() method
		ShipmentType st=service.getOneShipmentType(shipmentTypeId);
	
		//send data to ShipmentTypeEdit ( UI ) page
		map.addAttribute("shipmentType", st);
		
		return "ShipmentTypeEdit";
	}

	//6.update Operation
	@RequestMapping(value = "/update",method=RequestMethod.POST)
	public String doUpdate(@ModelAttribute ShipmentType shipmentType,ModelMap map) {
		
		//call service layer updateShipmentType 
		service.updateShipmentType(shipmentType);
		
		//call service layer getAllShipmentTypes()
		List<ShipmentType> obs=service.getAllShipmentTypes();
		
		//Updated data Send to UI (ShipmentTypeData)
		map.addAttribute("list", obs);
		map.addAttribute("msg", "Shipment ' "+shipmentType.getShipmentTypeId()+" ' updated Successfully");
		
			return "ShipmentTypeData";
	}
	
	//7.Get one row data based on Pk
	@RequestMapping("/view")
	public String ViewOne(@RequestParam Integer shipmentTypeId,ModelMap map ) {
		
		//call service layer getOneShipmentType() method
		ShipmentType s=service.getOneShipmentType(shipmentTypeId);
		
		//send to UI
		map.addAttribute("ob", s);
		
		return "ShipmentTypeViewOne";
	}
	
	//8 Excel Export
	@RequestMapping("/excel")
	public ModelAndView showExcel(@RequestParam(value="shipmentTypeId" ,required=false)Integer shipmentTypeId) {

		ModelAndView m=new ModelAndView();
		m.setView(new ShipmentTypeExcelView());
		if(shipmentTypeId != null ) {     // exactly one Row
			ShipmentType s=service.getOneShipmentType(shipmentTypeId);
			 m.addObject("list", Arrays.asList(s));
		} else {     // all rows
		List<ShipmentType> obs=service.getAllShipmentTypes();
			m.addObject("list", obs);
			
		}
		
		return m;
	}
	
	//9. pdf Export
		@RequestMapping("/pdf")
		public ModelAndView showPdf(
				@RequestParam(value = "id",required = false)Integer id
				)
		{
			ModelAndView m=new ModelAndView();
			m.setView(new ShipmentTypePdfView());

			if(id!=null) { //exactly one row
				ShipmentType s=service.getOneShipmentType(id);
				m.addObject("list", Arrays.asList(s));
			}else { //all rows
				List<ShipmentType> obs=service.getAllShipmentTypes();
				m.addObject("list", obs);
			}

			return m;
		}
		
		//10.Generate Charts
		@RequestMapping("/charts")
		public String generateCharts() {

			String path=context.getRealPath("/");
			List<Object[]> list = service.getShipmentsModeCount();
			util.generatePie(path, list);
			util.generateBar(path, list);
			return "ShipmentTypeCharts";
		}
}
