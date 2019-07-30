package com.app.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.Uom;
import com.app.service.IUomService;
import com.app.util.ShipmentTypeUtil;
import com.app.view.UomExcelView;
import com.app.view.UomPdfView;

@Controller
@RequestMapping("/uom")
public class UomController {

	//HAS-A Relation with IUomService
	@Autowired
	private IUomService service;
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private ShipmentTypeUtil util;
	
	@Autowired
	private Validator validator;
	
	
	//1.show Uom Register Page
	@RequestMapping("/reg")
	public String showReg(ModelMap map) {
		
		//Form Backing Object
		map.addAttribute("uom", new Uom());
		
		return "UomRegister";
	}
	
	//2.onClick submit on Register Form
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public String saveUom(@ModelAttribute Uom uom,ModelMap map,Errors errors) {
		
		//call validator
		validator.validate(uom, errors);
		
		//check for errors exist
		if(!errors.hasErrors()) { // no errors

			//calling Service layer saveUom() method
			Integer id=service.saveUom(uom);
			
			//creating success message
			String message="Uom '"+id+"' saved Successfully";
			
			//send data controller to UomRegister UI page using ModelMap
			map.addAttribute("msg", message);
			
			//Form Backing Object
				map.addAttribute("uom", new Uom());
		}
		else {  // errors exist
			map.addAttribute("msg", "please check all errors");
		}
		
			return "UomRegister";
	}
	
	//3.Fetch all Rows From DB and Send to UI
		@RequestMapping("/data")
		public String getAllUoms(ModelMap map) {
			
		// call Service layer getAllUoms() method
			List<Uom> obs=service.getAllUoms();
			
		//send data controller to UomData ( UI ) using ModelMap  
			map.addAttribute("list", obs);
			
			return "UomData";
		}
		
	//4.delete row based on Id
		@RequestMapping("/delete")
		public String uomDelete(@RequestParam Integer uomId,ModelMap map) {
			
			//delete one row 
			service.deleteUom(uomId);
			
			//new data
			List<Uom> obs=service.getAllUoms();
			
			//send data to UomData ( UI )
			map.addAttribute("msg", "Uom Type ' "+uomId+"'deleted successfully ");
			map.addAttribute("list", obs);
			
				return "UomData";
		}
		
		//5.show Edit page
		@RequestMapping("/edit")
		public String showEdit(@RequestParam Integer uomId ,ModelMap map) {
			
			//call service layer getOneUom() method 
			Uom u=service.getOneUom(uomId);
		
			//send data to UomEdit ( UI ) page
			map.addAttribute("uom", u);
			
			return "UomEdit";
		}

		//6.update Operation
		@RequestMapping(value = "/update",method=RequestMethod.POST)
		public String doUpdate(@ModelAttribute Uom uom,ModelMap map) {
			
			//call service layer updateShipmentType 
			service.updateUom(uom);
			
			//call service layer getAllShipmentTypes()
			List<Uom> obs=service.getAllUoms();
			
			//Updated data Send to UI (ShipmentTypeData)
			map.addAttribute("list", obs);
			map.addAttribute("msg", "uom ' "+uom.getUomId()+" ' updated Successfully");

			
				return "UomData";
		}
		
		//7.Get one row data based on Id
		@RequestMapping("/view")
		public String viewOne(@RequestParam Integer uomId,ModelMap map ) {
			
			//call service layer getOneUom() method
			Uom u=service.getOneUom(uomId);
			
			//send to UI
			map.addAttribute("ob", u);
			
			return "UomViewOne";
		}
		
		//8.Excel Export
		@RequestMapping("/excel")
		public ModelAndView showExcel(@RequestParam(value="uomId",required=false)Integer uomId) {
			
			ModelAndView m=new ModelAndView();
			m.setView(new UomExcelView());
			
			if( uomId != null) {    //exactly one Row
				Uom u = service.getOneUom(uomId);
				m.addObject("list", Arrays.asList(u));
			}
			else {  //all rows
				List<Uom> obs = service.getAllUoms();
				m.addObject("list", obs);
			}
			return m;
		}
		
		//9.Pdf export
		@RequestMapping("/pdf")
		public ModelAndView showPdf(@RequestParam(value="uomId",required=false)Integer uomId) {
			
			ModelAndView m=new ModelAndView();
			m.setView(new UomPdfView());
			
			if( uomId != null) { // exactly one Row
				Uom u=service.getOneUom(uomId);
			}
			else { // all rows
			List<Uom> obs = service.getAllUoms();
				m.addObject("list", obs);
			}
			return m;
		}

		//10.Generate Charts
				@RequestMapping("/charts")
				public String generateCharts() {

					String path=context.getRealPath("/");
					List<Object[]> list = service.getUomTypesCount();
					util.generatePie(path, list);
					util.generateBar(path, list);
					return "UomCharts";
				}
}
