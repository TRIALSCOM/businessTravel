package com.businessTravel.service;

import com.businessTravel.domain.Employee;
import com.businessTravel.viewObject.PdfViewObject;


public interface PDFService {
     PdfViewObject  getDetailInfo(Employee employee);
	
}
