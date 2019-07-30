package com.app.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Uom;
import com.app.service.IUomService;

public class UomValidator implements Validator {

	@Autowired
	private IUomService service;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Uom.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		//target is form(Model class ) object
		System.out.println("FROM VALIDATOR");
		Uom uom=(Uom)target;
		if(service.isUomModelExist(uom.getUomModel())){
		errors.rejectValue("uomModel", null,uom.getUomModel()+" already exist");	
		}
		
	}

}
