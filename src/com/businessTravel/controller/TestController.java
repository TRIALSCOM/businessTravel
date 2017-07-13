package com.businessTravel.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.businessTravel.dao.EmployeeDao;
import com.businessTravel.domain.Attachment;
import com.businessTravel.domain.Employee;
import com.businessTravel.service.AttachmentService;
import com.businessTravel.viewObject.Test;
import com.sun.org.apache.bcel.internal.generic.NEW;

@Controller
public class TestController {
    @Autowired
    private AttachmentService attachmentService;
	
    @Autowired
    private EmployeeDao employeeDao;
    
	@RequestMapping("/beanToPdfRich")
	public ModelAndView beanToPdfSimple() {
		ModelAndView m = new ModelAndView("richStudPdfView");
		Employee employee=new Employee();
		employee.setName("Braxton Miller");
		m.getModelMap().addAttribute("employee", employee);
		return m;
	}
	
	
	
	@RequestMapping(value="/testPrint",method=RequestMethod.GET)
	@ResponseBody
	public void testPrint(HttpServletRequest request,HttpServletResponse response)throws Exception{
		
		Test test=new Test();
		test.setName("tj");
		test.setLeavePlace("tj");
		test.setDesc("tj");
		test.setTime(new Date());
		response.getWriter().println(test);
	//	return test;
	}
	
	
	 @RequestMapping("/tempimg")
	// @ResponseBody  
	  public void uploadMultiFile(HttpServletRequest request,HttpServletResponse response,HttpSession session)
	  throws IllegalStateException,IOException{
		  CommonsMultipartResolver multiResolver=new CommonsMultipartResolver(request.getSession().getServletContext());
		
		  
		  if(multiResolver.isMultipart(request)){
			  MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
			  Iterator<String> iterator=multiRequest.getFileNames();
			 ArrayList<String> listNames=new ArrayList<>();
			  while(iterator.hasNext()){
				   int pre=(int)System.currentTimeMillis();
				  
				  MultipartFile file=multiRequest.getFile(iterator.next());
				  if(file!=null){
					  
					   String fileName=file.getOriginalFilename();
					   String path=request.getServletContext().getRealPath("/resources/");					   
					   System.out.println(path);
					   
					   fileName=pre+fileName;
					   
					    File filePath=new File(path,fileName);
					    if(!filePath.getParentFile().exists()){
					 	  filePath.getParentFile().mkdirs();						  
					  }
					    
					  listNames.add(fileName);
					  
					  file.transferTo(new File(path+File.separator+fileName));
					  
					  response.setContentType("text/html");

					  response.getWriter().println("resources/"+fileName);
					  
					  Employee  employee=(Employee)session.getAttribute("employee");
					  int index=fileName.indexOf(".");
					  System.out.println(index);
					 //String fileType=fileName.substring(index);
					  Attachment attachment=new Attachment();
					  attachment.setFileSize(String.valueOf(file.getSize()));
					  attachment.setFileAddress(path);
					  attachment.setFileName(fileName.substring(0, index));		  
					  attachment.setFileType(fileName.substring(index+1));
					  attachmentService.saveAttachment(attachment);
			   		  
					  Attachment attachementUpdate= attachmentService.getOneByName(fileName.substring(0, index));
					  employee.setAttachment(attachementUpdate);
					  employeeDao.updateEmployee(employee);
				  }
						  	   		  
			  }
			  
			  request.setAttribute("listNames",listNames );		  
		  }
		
	  }
	 
	 
	 

	
}
