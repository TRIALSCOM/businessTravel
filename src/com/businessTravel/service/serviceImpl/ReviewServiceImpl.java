package com.businessTravel.service.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.businessTravel.dao.ReviewStatusDao;
import com.businessTravel.dao.TravelRecordDao;
import com.businessTravel.domain.Dept;
import com.businessTravel.domain.Employee;
import com.businessTravel.domain.ReviewStatus;
import com.businessTravel.domain.RoleInfo;
import com.businessTravel.domain.TravelRecord;
import com.businessTravel.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService{
    @Autowired
    private ReviewStatusDao reviewStatusDao;
    
    @Autowired
    private TravelRecordDao travelRecordDao;

	@Override
	public ReviewStatus getReviewStatusByOrderAndDept(Integer reviewOrder, Integer deptId) {
		// TODO Auto-generated method stub
		return reviewStatusDao.selectByOrderAndDeptId(reviewOrder, deptId);
	}

	@Override
	public List<TravelRecord> getTravelRecord(Employee employee) {
		// TODO Auto-generated method stub
    List<TravelRecord> travelRecords=travelRecordDao.getAllRecordUnFinshed();
    Iterator<TravelRecord> it=travelRecords.iterator();
    if("系统管理员".equals(employee.getRoleInfo()))
    {
    	return travelRecords;
    }
    
    
    List<TravelRecord> travelRecordList=new ArrayList<>();
    while(it.hasNext())
    {
    TravelRecord travelRecord=it.next();
    if(travelRecord.getReviewStatus().getRoleInfo().getId()==employee.getRoleInfo().getId()
    		       &&(travelRecord.getReviewStatus().getDept().getId()==employee.getDept().getId())||"总经理".equals(employee.getRoleInfo().getRole())){
    		travelRecordList.add(travelRecord);  		
       }
   }
		
		return travelRecordList;
	}

	@Override
	public Integer reviewNumberCountInDept(Integer deptId) {
		// TODO Auto-generated method stub
		return reviewStatusDao.getCountInDept(deptId);
	}

	@Override
	public List<TravelRecord> getTravelRecordBeVerified(Employee employee) {
		// TODO Auto-generated method stub
		Integer deptId=employee.getDept().getId();
		RoleInfo roleInfo=employee.getRoleInfo();
	//	List<TravelRecord> travelRecords=travelRecordDao.getTravelRecordsAlreadyVerified();
		
		List<TravelRecord> travelRecords=travelRecordDao.getTravelRecordsWithReview();
		
		List<TravelRecord> travelRecordsList=new ArrayList<>();
		
		ReviewStatus reviewStatus=reviewStatusDao.getReviewStatusByDeptAndRole(roleInfo.getId(), deptId);
		

		
		for(TravelRecord travelRecord:travelRecords){
			
			
	   	    int reviewCount=reviewStatusDao.getCountInDept(travelRecord.getEmployee().getDept().getId());
	
			if(travelRecord.getEmployee().getDept().getId()==deptId||"总经理".equals(employee.getRoleInfo().getRole())){
				
				 if(reviewStatus.getReviewOrder()<reviewCount){
					 
			         if(travelRecord.getReviewStatus()!=null&&travelRecord.getReviewStatus().getReviewOrder()>reviewStatus.getReviewOrder())
			         {			     		
			        	      travelRecordsList.add(travelRecord);  		
			         }
			         
				 }else{
					
					 if(travelRecord.getReviewBeginEnd()==-1)
	     				 travelRecordsList.add(travelRecord);
				 }
			}
			
		}
		
		return travelRecordsList;
	}
    
    
}
