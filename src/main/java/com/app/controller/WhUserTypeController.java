package com.app.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.ShipmentType;
import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;
import com.app.util.ShipmentTypeUtil;
import com.app.view.WhUserTypeExcelView;
import com.app.view.WhUserTypePdfView;

@Controller
@RequestMapping("/whuser")
public class WhUserTypeController {
	
	//HAS-A Relation with IWhUserTypeService
	@Autowired
	private IWhUserTypeService service;
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private ShipmentTypeUtil util;
	
	//1.Show Register page
	@RequestMapping("/reg")
	public String showReg(ModelMap map) {
		
		//Form Backing Object
		
		map.addAttribute("whUserType", new WhUserType());
		
		return "WhUserTypeRegister";
	}
	
	//2.onclick submit button on Register form
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveWhUserType(@ModelAttribute WhUserType whUserType,ModelMap map) {
		
		// calling save method
		Integer whUserTypeId=service.saveWhUserType(whUserType);
		System.out.println(whUserTypeId);
		
		//creating Success messages and send to UI
		String message="WhUserType ' "+whUserTypeId+" ' saved Successfully";
		map.addAttribute("msg",message);
		
		//Form Backing Object
		map.addAttribute("whUserType", new WhUserType());
				
			
			return "WhUserTypeRegister";
	}
	
	//3.Fetch all rows from DB and Send to UI
	@RequestMapping("/data")
	public String getAllWhUserTypes(ModelMap map ) {
		
		//call service layer getAllWhUserTypes() method
		List<WhUserType> obs=service.getAllWhUserTypes();
		
		//send data to WhUserTypeData (UI) page
		map.addAttribute("list", obs);
			
			return "WhUserTypeData";
	}
	
	//4.delete row based on Id
		@RequestMapping("/delete")
		public String deleteWhUserType(@RequestParam Integer whUserTypeId,ModelMap map) {
			
			//row delete
			service.deleteWhUserType(whUserTypeId);
			
			//new data
			List<WhUserType> obs=service.getAllWhUserTypes();
			
			//send data to ShipmentTypeData ( UI ) page
			map.addAttribute("msg", "WhUser Type ' "+whUserTypeId+ "'deleted successfully");
			map.addAttribute("list", obs);
				
				return "WhUserTypeData";
		}
		
		
	//5.show Edit page
		@RequestMapping("/edit")
		public String showEdit(@RequestParam Integer whUserTypeId, ModelMap map ) {
			
			//call Service layer getOneWhUserType()
			WhUserType wh=service.getOneWhUserType(whUserTypeId);
			
			//send Data to UI( WhUserTypeEdit )
			map.addAttribute("whUserType", wh);
			
				return "WhUserTypeEdit";
		}
		
	//6.update Operation
		@RequestMapping("/update")
		public String doUpdate(@ModelAttribute WhUserType whUserType,ModelMap map) {
			
			//call service layer update methode
			service.updateWhUserType(whUserType);
			
			//call service layer all rows
			List<WhUserType> obs=service.getAllWhUserTypes();
			
			//send data to UI ( WhUserTypeData )
			map.addAttribute("list", obs);
			map.addAttribute("msg", "WhUserType ' "+whUserType.getWhUserTypeId()+" ' update Successfully");
			
				return "WhUserTypeData";
		}
		
		
		//7.get one Row data based on PK
		@RequestMapping("/view")
		public String viewOne(@RequestParam Integer whUserTypeId,ModelMap map) {
			
			//call service method getOnWhUserType() method
			WhUserType wh=service.getOneWhUserType(whUserTypeId);
			
			// data send to UI
			map.addAttribute("ob", wh);
			
			return "WhUserTypeViewOne";
		}
		
		//8. Excel Export
		@RequestMapping("/excel")
		public ModelAndView showExcel(@RequestParam(value="whUserTypeId",required=false)Integer whUserTypeId) {
			ModelAndView m=new ModelAndView();
			m.setView(new WhUserTypeExcelView());
			
			if(whUserTypeId != null) { //exactly one row
				WhUserType w = service.getOneWhUserType(whUserTypeId);
				m.addObject("list", Arrays.asList(w));
			}
			else {  // all rows
				
			List<WhUserType> obs = service.getAllWhUserTypes();
				m.addObject("list", obs);
				
			}
			
			return m;
		}
		//9. pdf Export
		@RequestMapping("/pdf")
		public ModelAndView showPdf(
				@RequestParam(value = "whUserTypeId",required = false)Integer whUserTypeId
				)
		{
			ModelAndView m=new ModelAndView();
			m.setView(new WhUserTypePdfView());

			if(whUserTypeId != null) { //exactly one row
				WhUserType w=service.getOneWhUserType(whUserTypeId);
				m.addObject("list", Arrays.asList(w));
			}else { //all rows
				List<WhUserType> obs=service.getAllWhUserTypes();
				m.addObject("list", obs);
			}

			return m;
		}
		
		//10.Generate Charts
				@RequestMapping("/charts")
				public String generateCharts() {

					String path=context.getRealPath("/");
					List<Object[]> list = service.getWhUserTypesCount();
					util.generatePie(path, list);
					util.generateBar(path, list);
					return "WhUserTypeCharts";
				}

}
