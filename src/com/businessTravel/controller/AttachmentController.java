package com.businessTravel.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.businessTravel.domain.Attachment;
import com.businessTravel.service.AttachmentService;

@Controller
public class AttachmentController {

	@Autowired
	private AttachmentService attachmentService;
	
	
	  @RequestMapping(value="fileUpload")
	  public ModelAndView fileUpload(ModelAndView mv,HttpServletRequest request,@RequestParam("file") MultipartFile file)
	  throws Exception{
		   if(!file.isEmpty()){
		   String fileName=file.getOriginalFilename();
		   
		  
		   
		   String path=request.getServletContext().getRealPath("/resources/");
		   int pre=(int)System.currentTimeMillis();
		   
		  // System.out.println(path);
		//   System.out.println(fileName);
		   
		   fileName=pre+fileName;
		  
		    File filePath=new File(path,fileName);
		    if(!filePath.getParentFile().exists()){
		 	  filePath.getParentFile().mkdirs();			  
		  }
		    
		  request.setAttribute("fileName",fileName );
		  file.transferTo(new File(path+File.separator+fileName));
		  
		  
		  int index=fileName.indexOf(".");
		  System.out.println(index);
		//  String fileType=fileName.substring(index);
		  Attachment attachment=new Attachment();
		  attachment.setFileSize(String.valueOf(file.getSize()));
		  attachment.setFileAddress(path);
		  attachment.setFileName(fileName.substring(0, index));		  
		  attachment.setFileType(fileName.substring(index+1));
		  attachmentService.saveAttachment(attachment);
		  
	      }
		   
		  
		   mv.setViewName("downFile");
		   return mv;
	    }
	  
	  
	  
	  @RequestMapping(value="downLoadFile",method=RequestMethod.GET)
	  public ResponseEntity<byte[]> download(HttpServletRequest request,
				 @RequestParam("fileName") String fileName,
				 Model model)throws Exception{
			    
			String path = request.getServletContext().getRealPath(
	                "/resources/");
			File file = new File(path+File.separator+ fileName);
			
	        HttpHeaders headers = new HttpHeaders();  
	                // 转换文件格式
	        String downloadFielName = new String(fileName.getBytes("UTF-8"),"utf-8");
	        
	               // ֪ͨ通知浏览器附件
	        headers.setContentDispositionFormData("attachment", downloadFielName); 
	          
	        
	        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	     
	               // 201 HttpStatus.CREATED
	        
	        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),    
	                headers, HttpStatus.CREATED);  
		 }
	  
	  
	  
	  @RequestMapping(value="uploadMultiFile")
	  @ResponseBody  
	  public ModelAndView uploadMultiFile(ModelAndView mv,HttpServletRequest request,HttpServletResponse response)
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
					   
					          
					   
					    File filePath=new File(path,fileName);
					    if(!filePath.getParentFile().exists()){
					 	  filePath.getParentFile().mkdirs();						  
					  }
					    
					  listNames.add(fileName);
					  
					  file.transferTo(new File(path+File.separator+pre+fileName));
				  }
						  	   		  
			  }
			  
			  request.setAttribute("listNames",listNames );		  
		  }
		  return mv;
	  }
	
}
