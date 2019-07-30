package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.WhUserType;
import com.app.model.WhUserType;

public class WhUserTypeExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		//set file name
				response.addHeader("Content-Disposition", "attachment;filename=WhUserType.xlsx");
				
				//read data From Model
				@SuppressWarnings("unchecked")
				List<WhUserType> list=(List<WhUserType>)model.get("list");
				
				//creat one new sheet
				Sheet sheet=workbook.createSheet("WhUserType");
				
				//create Header
				setHead(sheet);
				
				//create body
				setBody(sheet,list);
				
			}
			
			private void setHead(Sheet sheet) {
				
				Row row=sheet.createRow(0);
				row.createCell(0).setCellValue("WhUserTypeID");
				row.createCell(1).setCellValue("whUserType");
				row.createCell(2).setCellValue("whUserCode");
				row.createCell(3).setCellValue("whUserFor");
				row.createCell(4).setCellValue("whUserEmail");
				row.createCell(5).setCellValue("whuserContact");
				row.createCell(6).setCellValue("whUserIdType");
				row.createCell(7).setCellValue("whUserIdNumber");
				
			}
			
			private void setBody(Sheet sheet,List<WhUserType> list) {
				
				int rowNum = 1;
				
				for(WhUserType w:list) {
					
					Row row=sheet.createRow(rowNum++);
					
					row.createCell(0).setCellValue(w.getWhUserTypeId());
					row.createCell(1).setCellValue(w.getWhUserType());
					row.createCell(2).setCellValue(w.getWhUserCode());
					row.createCell(3).setCellValue(w.getWhUserFor());
					row.createCell(4).setCellValue(w.getWhUserEmail());
					row.createCell(5).setCellValue(w.getWhuserContact());
					row.createCell(6).setCellValue(w.getWhUserIdType());
					row.createCell(7).setCellValue(w.getWhUserIdNumber());
				}
			}

		}
