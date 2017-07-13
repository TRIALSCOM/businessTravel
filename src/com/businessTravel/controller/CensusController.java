package com.businessTravel.controller;

import java.io.IOException;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.businessTravel.domain.Employee;
import com.businessTravel.service.EmployeeService;
import com.businessTravel.service.TravelService;

@Controller
public class CensusController {
    @Autowired
    private TravelService travelService;
	@Autowired
	private EmployeeService employeeService;
    
	 @RequestMapping(value="goToStatistics" ,method=RequestMethod.GET)
	 public void goToStatistics(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		   Employee employee=(Employee)session.getAttribute("employee");
		   String dataJson=travelService.getDateJson(employee);
		 // response.setContentType("text/json");
		  response.setCharacterEncoding("UTF-8");
		  response.getWriter().println(dataJson);
	 }
	 
	 
	 @RequestMapping(value="goToStatisticsPie")
	 public void goToStatisticsPie (HttpServletRequest request,HttpServletResponse response,HttpSession session)throws IOException{
		 Employee employee=(Employee)session.getAttribute("employee");
		 employee=employeeService.getOneById(employee.getId());
		 session.removeAttribute("employee");
		 session.setAttribute("employee", employee);
		  String dataJson=travelService.getPieDataJson(employee);
			 // response.setContentType("text/json");
			  response.setCharacterEncoding("UTF-8");
			  response.getWriter().println(dataJson);
		 
		 
	 }
	 
	 
	 @RequestMapping(value="goToCostDetailByMOYON",method=RequestMethod.GET)
	 public void goToCostDetailByMOYON(HttpServletRequest request,HttpServletResponse response,HttpSession session,
			 String identy,Integer monthOrYear)throws IOException{
		 Employee employee=(Employee)session.getAttribute("employee");
		 employee=employeeService.getOneById(employee.getId());
		 session.removeAttribute("employee");
		 session.setAttribute("employee", employee);
		 String detailJson=travelService.getCostDetailJson(employee, identy,monthOrYear);
		 response.setCharacterEncoding("UTF-8");
		 response.getWriter().println(detailJson);
		 
	 }
	 
	 
}
