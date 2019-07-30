package com.app.view;

import java.util.List;
import java.util.Map;

import javax.print.Doc;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.ShipmentType;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;

public class ShipmentTypePdfView extends AbstractPdfView {
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//file name + download file
		response.addHeader("Content-Disposition", "attachment;filename=Shipments.pdf");
		
		//read data
	//	@SuppressWarnings("unchecked")
           List<ShipmentType> list=(List<ShipmentType>)model.get("list");   

		Paragraph p=new Paragraph("Welcome to Shipment Type");
		document.add(p);
		
		PdfPTable table=new PdfPTable(6);
		table.addCell("ShipmentId");
		table.addCell("ShipmentMODE");
		table.addCell("ShipmentCODE");
		table.addCell("ShipmentENABLE");
		table.addCell("ShipmentGrade");
		table.addCell("Description");
	
		for(ShipmentType s:list) {
			
			table.addCell(s.getShipmentTypeId().toString());
			table.addCell(s.getShipmentMode());
			table.addCell(s.getShipmentCode());
			table.addCell(s.getEnableShipment());
			table.addCell(s.getShipmentGrade());
			table.addCell(s.getDescription());
			
			
		}
		
		document.add(table);
	}

}
