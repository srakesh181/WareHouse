package com.app.controller;

import java.io.IOException;


import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.app.model.Document;
import com.app.service.IDocumentService;

@Controller
@RequestMapping("/document")
public class DocumentController {
	
	@Autowired
	private IDocumentService service;
	
	@RequestMapping("/upload")	
	public void UploadDoc(@RequestParam MultipartFile file) throws IOException {
		
		String fileName = file.getOriginalFilename();
		byte[] fileData = file.getBytes();
		
		Document doc=new Document();
		doc.setFileName(fileName);
		doc.setFiledata(fileData);
		
		
		
	}
	// 1. show Document page ( full method code )
	@RequestMapping("/show")
	public String showDocsPage(ModelMap map) {
		
		/*List<Object[]> obs = service.getFileIdAndNames();
		map.addAttribute("list", obs);
			*/
			return "Document";
	}
	
	
	// 3.Download doc
	
	@RequestMapping("/download")
	public void downloadDoc(@RequestParam Integer fileId,HttpServletResponse resp) {
		
		//call service layer
		Document doc=service.getOneDocument(fileId);
		String fileName = doc.getFileName();
		byte[] filedata = doc.getFileData();
		//construct HttpServletResponse
		//Head
		
		resp.addHeader("Content-Disposition", "attachment;fileName="+fileName);
	
	
	// Body part
	
	try {
	//copy binary data
		FileCopyUtils.copy(filedata, resp.getOutputStream());
		
	}catch(Exception ae) {
		ae.printStackTrace();
	}
	}
}
