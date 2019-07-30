package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.OrderMethod;

public class OrderMethodExcelView extends AbstractXlsxView {
	
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//set file name
				response.addHeader("Content-Disposition", "attachment;filename=OrderMethod.xlsx");
				
				//read data From Model
				@SuppressWarnings("unchecked")
				List<OrderMethod> list=(List<OrderMethod>)model.get("list");
				
				//create one new sheet
				Sheet sheet=workbook.createSheet("OrederMethods");
				
				//create Header
				setHead(sheet);
				
				//create body
				setBody(sheet,list);
				
			}
			
			private void setHead(Sheet sheet) {
				
				Row row=sheet.createRow(0);
				row.createCell(0).setCellValue("orderMethodId");
				row.createCell(1).setCellValue("orderMethodMode");
				row.createCell(2).setCellValue("orderMethodCode");
				row.createCell(3).setCellValue("orderMethodExecuteType");
				row.createCell(4).setCellValue("orderMethodAccept");
				row.createCell(5).setCellValue("description");
				
			}
			
			private void setBody(Sheet sheet,List<OrderMethod> list) {
				
				int rowNum = 1;
				
				for(OrderMethod o:list) {
					
					Row row=sheet.createRow(rowNum++);
					
					row.createCell(0).setCellValue(o.getOrderMethodId());
					row.createCell(1).setCellValue(o.getOrderMethodMode());
					row.createCell(2).setCellValue(o.getOrderMethodCode());
					row.createCell(3).setCellValue(o.getOrderMethodExecuteType());
					row.createCell(4).setCellValue(o.getOrderMethodAccept().toString());
					row.createCell(5).setCellValue(o.getDescription());
				}
			}

		}

