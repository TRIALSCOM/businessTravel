package com.businessTravel.service;

import java.util.List;

import com.businessTravel.domain.Employee;
import com.businessTravel.domain.ReviewStatus;
import com.businessTravel.domain.TravelRecord;

public interface ReviewService {
      ReviewStatus getReviewStatusByOrderAndDept(Integer reviewOrder,Integer deptId);
      List<TravelRecord> getTravelRecord(Employee employee);
      Integer reviewNumberCountInDept(Integer deptId);
      List<TravelRecord> getTravelRecordBeVerified(Employee employee);
}
