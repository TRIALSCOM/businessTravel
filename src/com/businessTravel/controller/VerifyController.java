package com.businessTravel.controller;

import java.util.List;

import javax.mail.Session;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.businessTravel.dao.TravelRecordDao;
import com.businessTravel.domain.Employee;
import com.businessTravel.domain.ReviewStatus;
import com.businessTravel.domain.TravelRecord;
import com.businessTravel.service.EmployeeService;
import com.businessTravel.service.ReviewService;

@Controller
public class VerifyController {
	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private TravelRecordDao travelRecordDao;
	
	@Autowired
	private EmployeeService employeeService;
	
    @RequestMapping(value="goToPendingaudit",method=RequestMethod.GET)
    public ModelAndView goToPendingaudit(HttpSession session){
    	
    	ModelAndView mv=new ModelAndView();
    	Employee employee=(Employee)session.getAttribute("employee");
    	List<TravelRecord> travelRecords=reviewService.getTravelRecord(employee);
   // 	session.setAttribute("travelRecords", travelRecords);
    	mv.addObject("travelRecords", travelRecords);
    	mv.setViewName("Pendingaudit");
    	return mv;
    }
    
    
    @RequestMapping("rejectVerify")
    public ModelAndView rejectVerify(String rejectRecordIds,HttpSession session){
    	
    //	ModelAndView mv=new ModelAndView("Pendingaudit");
    	System.out.println(rejectRecordIds);
    	String [] rejectIds=rejectRecordIds.split(",");
    	TravelRecord travelRecord;
    	for(int i=0;i<rejectIds.length;i++){
    		travelRecord=travelRecordDao.getOneById(Integer.parseInt(rejectIds[i]));
    		travelRecord.setReviewBeginEnd(-1);
    		travelRecordDao.updateRecord(travelRecord);
    		
    	}
    	
    	return goToPendingaudit(session);
    }
    
    @RequestMapping("acceptVerify")
    public ModelAndView acceptVerify(String acceptRecordIds,HttpSession session){
    //	ModelAndView mv=new ModelAndView("Pendingaudit");
    	
    	System.out.println(acceptRecordIds);
    	
    	
    	
    	String [] acceptIds=acceptRecordIds.split(",");
    	TravelRecord travelRecord;
    	for(int i=0;i<acceptIds.length;i++){
    		if(acceptIds[i]!=null&&!"".equals(acceptIds[i])){
    		travelRecord=travelRecordDao.getOneById(Integer.parseInt(acceptIds[i]));
    		int reviewCount=reviewService.reviewNumberCountInDept(travelRecord.getEmployee().getDept().getId());
    		if(travelRecord.getReviewStatus().getReviewOrder()<reviewCount){
    			int needNumber=travelRecord.getReviewStatus().getReviewOrder()+1;
    			ReviewStatus reviewStatus=reviewService.getReviewStatusByOrderAndDept(needNumber, travelRecord.getEmployee().getDept().getId());
    			travelRecord.setReviewStatus(reviewStatus);
    			
    			
    		}else{
    			Employee ss=employeeService.getOneByName(travelRecord.getEmployee().getName());
    			if(ss.getScore()!=null)
    			  {
    			 	ss.setScore(String.valueOf(Integer.parseInt(ss.getScore())+travelRecord.getDaysCount()*5));
    			  }
    		  else{
    			ss.setScore(String.valueOf(travelRecord.getDaysCount()*5));
    			}
    			employeeService.updateEmployee(ss);
    		    travelRecord.setReviewBeginEnd(-1);
    		}
    		travelRecordDao.updateRecord(travelRecord);
    		
    	  }
    	}
    	
    	//return mv;
    	return goToPendingaudit(session);
    }
    
    
    
    
    @RequestMapping(value="goToAdults",method=RequestMethod.GET)
    public ModelAndView goToAdults(HttpSession session){
    	ModelAndView mv=new ModelAndView("audit");
    	Employee employee=(Employee)session.getAttribute("employee");
    	List<TravelRecord> travelRecords=reviewService.getTravelRecordBeVerified(employee);
    	mv.addObject("travelRecords", travelRecords);   	
    	return mv;
    	
    }
    
    @RequestMapping("deleteRecordIds")
    public ModelAndView deleteRecordIds(String deleteIds,HttpSession session){
    	String[]deleteRecordIds=deleteIds.split(",");
    	for(int i=0;i<deleteRecordIds.length;i++){
    		
    		TravelRecord travelRecord=travelRecordDao.getOneById(Integer.parseInt(deleteIds));
    		
    	}
    	
    	
    	return goToAdults(session);
    }
	
	
}
