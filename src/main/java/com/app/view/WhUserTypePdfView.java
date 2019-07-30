package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.WhUserType;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class WhUserTypePdfView extends AbstractPdfView {
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		//file name+download file
		response.addHeader("Content-Disposition", "attachment;filename=WhUserType.pdf");
		
		//read data 
		List<WhUserType> list=(List<WhUserType>) model.get("list");
		
		Paragraph p=new Paragraph("Welcome to WhUserType");
		document.add(p);
		
		PdfPTable table=new PdfPTable(8);
		table.addCell("whUserTypeId");
		table.addCell("whUserType");
		table.addCell("whUserCode");
		table.addCell("whUserFor");
		table.addCell("whUserEmail");
		table.addCell("whuserContact");
		table.addCell("whUserIdType");
		table.addCell("whUserIdNumber");
		
		for(WhUserType w:list) {
			
			table.addCell(w.getWhUserTypeId().toString());
			table.addCell(w.getWhUserIdType());
			table.addCell(w.getWhUserCode());
			table.addCell(w.getWhUserFor());
			table.addCell(w.getWhUserEmail());
			table.addCell(w.getWhuserContact());
			table.addCell(w.getWhUserIdType());
			table.addCell(w.getWhUserIdNumber());
		}
		
		document.add(table);
	}
}
