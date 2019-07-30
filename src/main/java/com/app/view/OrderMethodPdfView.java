package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.OrderMethod;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class OrderMethodPdfView extends AbstractPdfView {
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//file name + download file
				response.addHeader("Content-Disposition", "attachment;filename=OrderMethod.pdf");
				
				//read data
			//	@SuppressWarnings("unchecked")
		           List<OrderMethod> list=(List<OrderMethod>)model.get("list");   

				Paragraph p=new Paragraph("Welcome to OrderMethod ");
				document.add(p);
				
				PdfPTable table=new PdfPTable(6);
				table.addCell("orderMethodId");
				table.addCell("orderMethodMode");
				table.addCell("orderMethodCode");
				table.addCell("orderMethodExecuteType");
				table.addCell("orderMethodAccept");
				table.addCell("description");
			
				for(OrderMethod o:list) {
					
					table.addCell(o.getOrderMethodId().toString());
					table.addCell(o.getOrderMethodMode());
					table.addCell(o.getOrderMethodCode());
					table.addCell(o.getOrderMethodExecuteType());
					table.addCell(o.getOrderMethodAccept().toString());
					table.addCell(o.getDescription());
					
					
				}
				
				document.add(table);
			}

		}
