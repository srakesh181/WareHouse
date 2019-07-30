package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.Uom;

public class UomExcelView extends AbstractXlsxView {
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		//set File name
		response.addHeader("Content-Disposition", "attachment;filename=Uom.xlsx");
		
		//read data from model
		@SuppressWarnings("unchecked")
		List<Uom> list =(List<Uom>) model.get("list");
		
		//create one new Sheet
		Sheet sheet = workbook.createSheet();
		
		//create one Header
		setHead(sheet);
		
		//create body
		setBody(sheet,list);
	}
	
	private void setHead(Sheet sheet) {
		
		Row row = sheet.createRow(0);
		
		row.createCell(0).setCellValue("UomId");
		row.createCell(1).setCellValue("UomType");
		row.createCell(2).setCellValue("UomModel");
		row.createCell(3).setCellValue("Desciption");
	}
	
	private void setBody(Sheet sheet,List<Uom> list) {
		
		int rowNum=1;
		
		for(Uom u : list) {
			
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(u.getUomId());
			row.createCell(1).setCellValue(u.getUomType());
			row.createCell(2).setCellValue(u.getUomModel());
			row.createCell(3).setCellValue(u.getUomDescription());
		}
	}

}
