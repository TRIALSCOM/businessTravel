package com.businessTravel.service;

import java.util.List;

import com.businessTravel.domain.Employee;
import com.businessTravel.domain.TravelRecord;
import com.businessTravel.viewObject.PdfViewObject;

public interface TravelService {
    List<TravelRecord> getOneByEmployeeId(Integer employeeId);
    
    PdfViewObject getOnePdfViewObject(Employee employee);
    
    PdfViewObject  getDetailInfoByRecordId(Integer id);
    
    
    String getDateJson(Employee employee);
    
    String getPieDataJson(Employee employee);
    
    String getCostDetailJson(Employee employee,String identy,Integer monthOrYear);
}
