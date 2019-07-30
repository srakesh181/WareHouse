package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.config.YamlProcessor.ResolutionMethod;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Uom;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;

public class UomPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		//file name + download file
		response.addHeader("Content-Disposition", "attachment;filename=Uoms.pdf");
		
		//read data 
		List<Uom> list=(List<Uom>) model.get("list");
		
		Paragraph p=new Paragraph("Welcome to Uom ");
		document.add(p);

		PdfPTable table=new PdfPTable(4);
		table.addCell("UomId");
		table.addCell("UomType");
		table.addCell("UomModel");
		table.addCell("Descrption");
		
		for(Uom u:list) {
			
			table.addCell(u.getUomId().toString());
			table.addCell(u.getUomType());
			table.addCell(u.getUomModel());
			table.addCell(u.getUomDescription());
			
		}
		
		document.add(table);
			
	}
}
