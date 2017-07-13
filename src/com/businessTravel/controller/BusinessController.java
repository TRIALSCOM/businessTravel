package com.businessTravel.controller;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.businessTravel.dao.TravelRecordDao;
import com.businessTravel.domain.Attachment;
import com.businessTravel.domain.Employee;
import com.businessTravel.domain.HotelBooking;
import com.businessTravel.domain.ReviewStatus;
import com.businessTravel.domain.Station;
import com.businessTravel.domain.TicketBooking;
import com.businessTravel.domain.TravelRecord;
import com.businessTravel.service.AttachmentService;
import com.businessTravel.service.BusinessService;
import com.businessTravel.service.ReviewService;
import com.businessTravel.viewObject.HotelBuyViewObject;
import com.businessTravel.viewObject.TicketBuyViewObject;
import static com.businessTravel.util.BusinessConstant.*;


@Controller
public class BusinessController {
   
	  @Autowired
	  private BusinessService businessService;
	  
	  @Autowired
	  private AttachmentService attachmentService;
	  
	  @Autowired
	  private ReviewService reviewService;
	  
	  @RequestMapping("goBusinessPlan")
	   public ModelAndView goBusinessPlan(ModelAndView mv,HttpSession session,@ModelAttribute("travelRecord")TravelRecord travelRecord){
		
		     // TravelRecord travelRecord=new TravelRecord();
		     // travelRecord
	    	// travelRecord.setBeginPlace((String)request.getAttribute("beginPlace"));
		 // travelRecord.setReviewStatus(null);
		  		  		  
		  Employee employee=(Employee)session.getAttribute("employee");
		  
		  String msg="";
		  if(businessService.getUnApplyOneByEmployeeId(employee.getId())!=null){
			  msg="您正在出差过程中，不能再次申请出差";
			  mv.addObject("msg", msg);
			  mv.setViewName("business");
			  return mv;
		  }
		  
		  travelRecord.setEmployee(employee);
		  travelRecord.setReviewBeginEnd(0);
		  
		 //日期的处理
		  Calendar calendar=new GregorianCalendar();
		  calendar.setTime(travelRecord.getTravelBeginDate());
		  calendar.add(Calendar.DATE, travelRecord.getDaysCount());
		  travelRecord.setTravelEndDate(calendar.getTime());
		  
	      businessService.saveTravelRecord(travelRecord);
	      travelRecord=businessService.getUnApplyOneByEmployeeId(employee.getId());
	      SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	      try{
	      travelRecord.setTravelBeginDate(sdf.parse(sdf.format(travelRecord.getTravelBeginDate())));
	      }catch(ParseException e){
	    	  e.printStackTrace();
	      }
	      session.setAttribute("travelRecord",travelRecord);
	     
	      System.out.println(session.getAttribute("travelRecord").toString());
		  mv.setViewName("planConfirm");
		  
		  System.out.println(travelRecord.getTravelEndDate().toString());
		  
		  travelRecord=businessService.getUnApplyOneByEmployeeId(employee.getId());
		 return mv;
		 
	 }
	  
	  
	  @RequestMapping("searchTicketByCondition")
	  public ModelAndView searchTicketByCondition(ModelAndView mv,String addTktBeginPlace,
			  String addTktEndPlace,String addTktStartTime,String ticketType,HttpSession session){
		      List<TicketBuyViewObject>  ticketBuyViewObjects=businessService.searchStationByCondition( addTktBeginPlace,
					   addTktEndPlace, addTktStartTime, ticketType);
		   
		   //   TicketBuyViewObject ticketBuyViewObject=  new TicketBuyViewObject();
		 //     ticketBuyViewObject.setTrainTimes("111");
		    
		  //    ticketBuyViewObjects.add(ticketBuyViewObject); 
		      mv.addObject("ticketBuyViewObjects", ticketBuyViewObjects);
		  		      
		      session.setAttribute("ticketBuyViewObjects", ticketBuyViewObjects);
		     
		      mv.addObject("addTktBeginPlace", addTktBeginPlace);
		      mv.addObject("addTktEndPlace", addTktEndPlace);
		      mv.addObject("addTktStartTime", addTktStartTime);
		      mv.addObject("ticketType",ticketType);
		      
		      mv.setViewName("addTicket");
		     return mv;
		  
	  }
	  

	  
	  
	  
	  
	  
	  @RequestMapping(value="buyTicketSelected",method=RequestMethod.GET)
	  public ModelAndView buyTicketSelected(HttpSession session,Integer index){
		  ModelAndView mv=new ModelAndView();
		  
	    List<TicketBuyViewObject>ticketBuyViewObjects=(List<TicketBuyViewObject>)session.getAttribute("ticketBuyViewObjects");
	  	  
		TicketBuyViewObject ticketBuyViewObject=ticketBuyViewObjects.get(index);  
		TicketBooking ticketBooking=new TicketBooking();
		ticketBooking.setBeginStation(ticketBuyViewObject.getBeginStation());
		ticketBooking.setEndStation(ticketBuyViewObject.getEndStation());
		
		Employee employee=(Employee)session.getAttribute("employee");
		
		ticketBooking.setEmployee(employee);
		ticketBooking.setTotalCost(ticketBuyViewObject.getCost().toString());
		ticketBooking.setBookingDate(new Date());
		ticketBooking.setSeatCategory(ticketBuyViewObject.getSeatCategory());
		
		//TravelRecord travelRecord=businessService.getUnApplyOneByEmployeeId(employee.getId());
		TravelRecord travelRecord=(TravelRecord)session.getAttribute("travelRecord");
		ticketBooking.setTravelRecord(travelRecord);
		businessService.saveTicketBooing(ticketBooking);
		
		if(ticketBooking.getTotalCost()!=null)
		{
			if(travelRecord.getApplyingFunding()!=null)
				travelRecord.setApplyingFunding(String.valueOf(Integer.parseInt(travelRecord.getApplyingFunding())+Integer.parseInt(ticketBooking.getTotalCost())));
			else
				travelRecord.setApplyingFunding(ticketBooking.getTotalCost());
		}
	//	travelRecord.setApplyingFunding(String.valueOf(Integer.parseInt(travelRecord.getApplyingFunding())+Integer.parseInt(ticketBooking.getTotalCost())));
		businessService.updateTravelRecord(travelRecord);
		  
		travelRecord=businessService.getOneTravelRecordById(travelRecord.getId());
		session.setAttribute("travelRecord", travelRecord);
		
		
		List<TicketBooking> ticketBookings=(List<TicketBooking>)session.getAttribute("ticketBookings");
		if(ticketBookings==null){
			ticketBookings=new ArrayList<>();
		}
		ticketBookings.add(ticketBooking);
		session.setAttribute("ticketBookings", ticketBookings);
		mv.getModelMap().addAttribute("getValue", 1);
		mv.setViewName("addTicket");
		return mv;
		  
	  }
	  
	  
	  
	  
	  
	  @RequestMapping("searchHotelByCondition")
	  public ModelAndView searchHotelByCondition(HttpSession session,ModelAndView mv,String addHtCity,String addHtStartTime,String addHtEndTime,
			 String roomType)throws ParseException{
		  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		  Date dateBegin=sdf.parse(addHtStartTime);
		  Date dateEnd=sdf.parse(addHtEndTime);
		  if(dateBegin.getTime()>dateEnd.getTime())
		  {
			  mv.setViewName("addHotel");
			  String msg="离店日期不能早于入住日期";
			  mv.addObject("msg", msg);
			  return mv;
		  }
		  
		  
		 /* if(Integer.parseInt(addHtStartTime)>Integer.parseInt(addHtEndTime)){
			  mv.setViewName("addHotel");
			  String msg="离店日期不能早于入住日期";
			  mv.addObject("msg", msg);
			  return mv;
		  }*/
		//  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		  List<HotelBuyViewObject> hotelBuyViewObjects=businessService.searchHotelByCondition(addHtCity, sdf.parse(addHtStartTime), sdf.parse(addHtEndTime), roomType);
		  session.setAttribute("hotelBuyViewObjects", hotelBuyViewObjects);
		  mv.addObject("hotelBuyViewObjects", hotelBuyViewObjects);
		  mv.addObject("addHtCity", addHtCity);
		  mv.addObject("addHtStartTime", addHtStartTime);
		  mv.addObject("addHtEndTime", addHtEndTime);
		  mv.addObject("roomType", roomType);
		  mv.setViewName("addHotel");
		  return mv;
	  }
	  
	  
	  @RequestMapping(value="bookingHotelSelected",method=RequestMethod.GET)
	  public ModelAndView bookingHotelSelected(HttpSession session,Integer index){
		  Employee employee=(Employee)session.getAttribute("employee");
		  ModelAndView mv=new ModelAndView();
		  List<HotelBuyViewObject> hotelBuyViewObjects=(List<HotelBuyViewObject>)session.getAttribute("hotelBuyViewObjects");
		  HotelBuyViewObject hotelBuyViewObject=hotelBuyViewObjects.get(index);
		  HotelBooking hotelBooking=new HotelBooking();
		  hotelBooking.setHotel(hotelBuyViewObject.getHotel());
		  hotelBooking.setBedCategory(hotelBuyViewObject.getBedCategory());
		  hotelBooking.setBookingDate(new Date());
		  hotelBooking.setDaysLiving(hotelBuyViewObject.getDyasLiving());
		  hotelBooking.setStartDate(hotelBuyViewObject.getBeginDate());
		  hotelBooking.setEndDate(hotelBuyViewObject.getEndDate());
		  hotelBooking.setTotalCost(String.valueOf(hotelBuyViewObject.getTotalCost()));	
		  hotelBooking.setPerCost(hotelBuyViewObject.getPerCost());
		//  TravelRecord travelRecord=businessService.getUnApplyOneByEmployeeId(employee.getId());
		  TravelRecord travelRecord=(TravelRecord)session.getAttribute("travelRecord");
		  hotelBooking.setTravelRecord(travelRecord); 
		  businessService.saveHotelBooking(hotelBooking);
		  
		  if(hotelBooking.getTotalCost()!=null){
			  if(travelRecord.getApplyingFunding()!=null){
		      	  travelRecord.setApplyingFunding(String.valueOf(Integer.parseInt(travelRecord.getApplyingFunding())+Integer.parseInt(hotelBooking.getTotalCost())));
			  }else{
				  travelRecord.setApplyingFunding(hotelBooking.getTotalCost());
			  }
			  
		  }
		  
		 // if(travelRecord.getApplyingFunding()!=null)
	      	//  travelRecord.setApplyingFunding(String.valueOf(Integer.parseInt(travelRecord.getApplyingFunding())+Integer.parseInt(hotelBooking.getTotalCost())));
		 
		  
		  businessService.updateTravelRecord(travelRecord);
		  travelRecord=businessService.getOneTravelRecordById(travelRecord.getId());
		  session.setAttribute("travelRecord", travelRecord);
		  
		  List<HotelBooking> hotelBookings=(List<HotelBooking>)session.getAttribute("hotelBookings");
		  if(hotelBookings==null){
			  hotelBookings=new ArrayList<>();
		  }
		  hotelBookings.add(hotelBooking);
		  session.setAttribute("hotelBookings", hotelBookings);
		  mv.getModelMap().addAttribute("getValue", 1);
		  mv.setViewName("addHotel");
		  return mv;
		  
	  }
	  
	  
	  @RequestMapping(value="confirmSelect",method=RequestMethod.GET)
	  public ModelAndView confirSelect(ModelAndView mv,HttpSession session){
		  session.removeAttribute("hotelBuyViewObjects");
		  session.removeAttribute("ticketBuyViewObjects");  
		  mv.setViewName("planConfirm");
		  return mv;
	  }
	  
	  
	  @RequestMapping(value="goToTravelRecord",method=RequestMethod.GET)
	  public ModelAndView  goToTravelRecord(HttpSession session){
		  ModelAndView mv=new ModelAndView();
		  Employee employee=(Employee)session.getAttribute("employee");
	      List<TravelRecord> travelRecords=businessService.getAllTravelRecordByEmployeeId(employee.getId());
		  mv.addObject("travelRecords", travelRecords);
		  mv.setViewName("print");
		return mv;  
	  }
	  
	 
	 //提交预申请金额 
	  @RequestMapping(value="confirmTravelRecord",method=RequestMethod.POST)
	  public ModelAndView confirmTravelRecord(String prePay,HttpSession session){
		//  ModelAndView mv=new ModelAndView();
		  TravelRecord travelRecord=(TravelRecord)session.getAttribute("travelRecord");
		  travelRecord.setAdvanceFunding(prePay);
		  businessService.updateTravelRecord(travelRecord);
		  travelRecord=businessService.getOneTravelRecordById(travelRecord.getId());
		  session.setAttribute("travelRecord", travelRecord);
		//  mv.setViewName("planConfirm");
		 // return mv;
		  return goToTravelRecord(session);
	  }
	  
	  
	  //出差记录页面，填写最终申请金额
	  @RequestMapping("fillInAllFunding")
	  public  ModelAndView fillInAllFunding(HttpServletRequest request,HttpSession session,String allFunding,@RequestParam("file") MultipartFile  file,String costDescription,Integer travelRecordId)throws
	     Exception
	  {
		  TravelRecord travelRecord=businessService.getOneTravelRecordById(travelRecordId);
		  
		//  ModelAndView mv=new ModelAndView();
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
			  
			  attachment=attachmentService.getOneByName(attachment.getFileName());
			  
			 
			  travelRecord.setAttachment(attachment);
		
			  
			  // TravelRecord travelRecord=(TravelRecord)session.getAttribute("travelRecord");
			 //  travelRecord.setAttachment(attachment);			  
			 //  businessService.updateTravelRecord(travelRecord);			  
		     //  travelRecord=businessService.getOneTravelRecordById(travelRecord.getId());			  
			 //  session.setAttribute("travelRecord", travelRecord);
		  
		  }
		  travelRecord.setAllFunding(allFunding);
		  travelRecord.setCostDescription(costDescription);
		  travelRecord.setReviewBeginEnd(UNFINSH);
		  ReviewStatus reviewStatus=reviewService.getReviewStatusByOrderAndDept(1, travelRecord.getEmployee().getDept().getId());
		  travelRecord.setReviewStatus(reviewStatus);		  
		  businessService.updateTravelRecord(travelRecord);
		  session.removeAttribute("ticketBookings");
		  session.removeAttribute("hotelBookings");
		  return goToTravelRecord(session);
	  }
	  
	 
	
}
