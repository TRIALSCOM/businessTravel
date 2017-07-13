package com.businessTravel.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.businessTravel.domain.Employee;
import com.businessTravel.service.TravelService;
import com.businessTravel.viewObject.PdfViewObject;

@Controller
public class PDFController {
      
      
      @Autowired
      private TravelService travelService;
	
	
	  @RequestMapping(value="/exportTravelDetailPdf")
	  public ModelAndView exportTravelDetailPdf(HttpSession session){
		  ModelAndView mv=new ModelAndView("travelDetailPdfView");
		  Employee employee=(Employee)session.getAttribute("employee");
		  
		  PdfViewObject pdfViewObject=travelService.getOnePdfViewObject(employee);
		   
		//  mv.addObject("pdfViewObject",pdfViewObject);
		  mv.getModelMap().addAttribute("pdfViewObject",pdfViewObject);
		  return mv;
	  }
	  
	  
	  @RequestMapping(value="/printOneRecord",method=RequestMethod.GET)
	  public ModelAndView printOneRecord(Integer travelRecordId){
		  ModelAndView mv=new ModelAndView("travelDetailPdfView");
		  
		  PdfViewObject pdfViewObject=travelService.getDetailInfoByRecordId(travelRecordId);
		   
		  mv.getModelMap().addAttribute("pdfViewObject",pdfViewObject);
		  
		  return mv;
		  
	  }
	  
}
