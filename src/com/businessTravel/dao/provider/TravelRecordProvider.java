package com.businessTravel.dao.provider;

import org.apache.ibatis.jdbc.SQL;

import com.businessTravel.domain.TravelRecord;

public class TravelRecordProvider {

	 public String saveOneTravelRecord(TravelRecord travelRecord){
		 return new SQL(){
			 {
				 INSERT_INTO("travel_info");
				 if(travelRecord.getEmployee()!=null)
					 VALUES("employee_id","#{employee.id}");
				 if(travelRecord.getApplyingFunding()!=null)
					 VALUES("applying_funding","#{applyingFunding}");
				 if(travelRecord.getAdditionalFunding()!=null)
					 VALUES("additional_funding","#{additionalFunding}");
				 if(travelRecord.getAdvanceFunding()!=null)
					 VALUES("advance_funding","#{advanceFunding}");
				 if(travelRecord.getAllFunding()!=null)
					 VALUES("all_funding","#{allFunding}");
				 if(travelRecord.getTravelBeginDate()!=null)
					 VALUES("travel_begin_date","#{travelBeginDate}");
				 if(travelRecord.getTravelEndDate()!=null)
					 VALUES("travel_end_date","#{travelEndDate}");
				 if(travelRecord.getDaysCount()!=null)
					 VALUES("days_count","#{daysCount}");
				 if(travelRecord.getTravelAddress()!=null)
					 VALUES("travel_address","#{travelAddress}");
				 if(travelRecord.getTravelReason()!=null)
					 VALUES("travel_reason","#{travelReason}");
				 if(travelRecord.getReviewStatus()!=null)
					 VALUES("review_status_id","#{reviewStatus.id}");	
				 if(travelRecord.getBeginPlace()!=null)
					 VALUES("begin_place","#{beginPlace}");
				 if(travelRecord.getEndPlace()!=null)
					 VALUES("end_place","#{endPlace}");
				 if(travelRecord.getReviewBeginEnd()!=null)
					 VALUES("review_begin_end","#{reviewBeginEnd}");
				 if(travelRecord.getAttachment()!=null)
					 VALUES("attachment_id","#{attachment.id}");
				 if(travelRecord.getCostDescription()!=null)
					 VALUES("cost_description","#{costDescription}");
			 }
			 
		 }.toString();
		 
	 }
	 
	 
	 public String updateTravelRecord(TravelRecord travelRecord){
		 
		 return new SQL(){
			 {
				 
				 UPDATE("travel_info");
				 if(travelRecord.getEmployee()!=null)
					 SET("employee_id=#{employee.id}");
				 if(travelRecord.getApplyingFunding()!=null)
					 SET("applying_funding=#{applyingFunding}");
				 if(travelRecord.getAdditionalFunding()!=null)
					 SET("additional_funding=#{additionalFunding}");
				 if(travelRecord.getAdvanceFunding()!=null)
					 SET("advance_funding=#{advanceFunding}");
				 if(travelRecord.getAllFunding()!=null)
					 SET("all_funding=#{allFunding}");
				 if(travelRecord.getTravelBeginDate()!=null)
					 SET("travel_begin_date=#{travelBeginDate}");
				 if(travelRecord.getTravelEndDate()!=null)
					 SET("travel_end_date=#{travelEndDate}");
				 if(travelRecord.getDaysCount()!=null)
					 SET("days_count=#{daysCount}");
				 if(travelRecord.getTravelAddress()!=null)
					 SET("travel_address=#{travelAddress}");
				 if(travelRecord.getTravelReason()!=null)
					 SET("travel_reason=#{travelReason}");
				 if(travelRecord.getReviewStatus()!=null)
					 SET("review_status_id=#{reviewStatus.id}");	
				 if(travelRecord.getBeginPlace()!=null)
					 SET("begin_place=#{beginPlace}");
				 if(travelRecord.getEndPlace()!=null)
					 SET("end_place=#{endPlace}");
				 if(travelRecord.getReviewBeginEnd()!=null)
					 SET("review_begin_end=#{reviewBeginEnd}");
				 if(travelRecord.getAttachment()!=null)
					 SET("attachment_id=#{attachment.id}");
				 if(travelRecord.getCostDescription()!=null)
					 SET("cost_description=#{costDescription}");
				 WHERE("id=#{id}");
			 }
		 }.toString();
	 }
	
}
