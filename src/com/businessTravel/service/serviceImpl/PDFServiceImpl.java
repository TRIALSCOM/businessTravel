package com.businessTravel.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.businessTravel.dao.EmployeeDao;
import com.businessTravel.dao.TicketBookingDao;
import com.businessTravel.domain.Employee;
import com.businessTravel.service.PDFService;
import com.businessTravel.viewObject.PdfViewObject;

@Service
public class PDFServiceImpl  implements PDFService{

	@Autowired
	 private EmployeeDao employeeDao;
	
	@Autowired
	private TicketBookingDao  ticketBookingDao;
	
    
	
	@Override
	public PdfViewObject getDetailInfo(Employee employee) {
		// TODO Auto-generated method stub
		PdfViewObject pdfViewObject=new PdfViewObject();
		pdfViewObject.setUserName(employee.getName());
		
		
		return null;
	}



	
	
}
