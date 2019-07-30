package com.app.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.OrderMethod;
import com.app.model.ShipmentType;
import com.app.service.IOrderMethodService;
import com.app.util.ShipmentTypeUtil;

@Controller
@RequestMapping("/order")
public class OrderMethodController {

	//HAS-A Relation with Service layer
	@Autowired
	private IOrderMethodService service;
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private ShipmentTypeUtil util;
	
	
	//1.show Register page
	@RequestMapping("/reg")
	public String showReg(@ModelAttribute OrderMethod orderMethod,ModelMap map) {
		
				//Form Backing Object
		map.addAttribute("orderMethod", new OrderMethod());
		
		return "OrderMethodRegister";
	}
	
	//2.on click  save Form
	@RequestMapping("/save")
	public String saveOrederMethod(@ModelAttribute OrderMethod orderMethod,ModelMap map) {
		
		//call service layer save method
		Integer orderMethodId=service.saveOrderMethod(orderMethod);
		
		//creataing Success message and send to UI( OrderMethodRegister )
		map.addAttribute("msg", "Order Method ' "+orderMethodId+" ' Registerd Successfully");
		
			return "OrderMethodRegister";
	}
	
	//3.Fetch All rows from DB and send to UI
	@RequestMapping("/data")
	public String getAllOrederMethods(ModelMap map) {
		
		//calling service layer getAllShipments() method
		List<OrderMethod> obs=service.getAllOrderMethods();
		
		//send to UI( OrderMethodData )
		map.addAttribute("list", obs);
			
			return "OrderMethodData";
	}
	
	//delete row based on Id
	@RequestMapping("/delete")
	String deleteOrderMethod(@RequestParam Integer orderMethodId,ModelMap map ) {
		
		//Row delete
		service.deleteOrderMethod(orderMethodId);
		
		//new data
		List<OrderMethod> obs=service.getAllOrderMethods();
		
		//send data to UI (OrderMethodData )
		map.addAttribute("list", obs);
		map.addAttribute("msg", "Order Method ' "+orderMethodId+" 'deleted successfully");
		
		return "OrderMethodData";
	}
	
	//5.show Edit page
		@RequestMapping("/edit")
		public String showEdit(@RequestParam Integer orderMethodId ,ModelMap map) {
			
			//call service layer getOneOrderMethod() method
			OrderMethod om=service.getOneOrderMethod(orderMethodId);
		
			//send data to OrderMethodEdit ( UI ) page
			map.addAttribute("orderMethod", om);
			
			return "OrderMethodEdit";
		}

		//6.update Operation
		@RequestMapping(value = "/update",method=RequestMethod.POST)
		public String doUpdate(@ModelAttribute OrderMethod orderMethod,ModelMap map) {
			
			//call service layer updateShipmentType 
			service.updateOrderMethod(orderMethod);
			
			//call service layer getAllShipmentTypes()
			List<OrderMethod> obs=service.getAllOrderMethods();
			
			//Updated data Send to UI (ShipmentTypeData)
			map.addAttribute("list", obs);
			map.addAttribute("msg", "Order Method ' "+orderMethod.getOrderMethodId()+" ' updated Successfully");
			
				return "OrderMethodData";
		}
		
		//7.get One Row data based on PK
		@RequestMapping("/view")
		public String viewOne(@RequestParam Integer orderMethodId,ModelMap map) {
			
			//call service layer getOneOrderMethod()
			OrderMethod or=service.getOneOrderMethod(orderMethodId);
			
			//send to UI
			map.addAttribute("ob", or);
			
				return "OrderMethodViewOne";
		}

		//10.Generate Charts
		@RequestMapping("/charts")
		public String generateCharts() {

			String path=context.getRealPath("/");
			List<Object[]> list = service.getOrderMethodExecuteTypeCount();
			util.generatePie(path, list);
			util.generateBar(path, list);
			return "OrderMethodCharts";
		}

	
}
