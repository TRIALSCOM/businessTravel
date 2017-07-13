package com.businessTravel.service;

import java.util.Date;
import java.util.List;

import com.businessTravel.domain.Hotel;
import com.businessTravel.domain.HotelBooking;
import com.businessTravel.domain.ReviewStatus;
import com.businessTravel.domain.Station;
import com.businessTravel.domain.TicketBooking;
import com.businessTravel.domain.TravelRecord;
import com.businessTravel.viewObject.HotelBuyViewObject;
import com.businessTravel.viewObject.TicketBuyViewObject;

public interface BusinessService {

	  void  saveTravelRecord(TravelRecord travelRecord);   //保存出差记录
	  
	  void updateTravelRecord(TravelRecord travelRecord);
	  
	  TravelRecord getUnApplyOneByEmployeeId(Integer employeeId);  //得到未申请的记录
	  
	  TravelRecord getOneTravelRecordById(Integer id);
	  
	  //按照条件查找可订购车站信息
	  List<TicketBuyViewObject> searchStationByCondition(String addTktBeginPlace,
			  String addTktEndPlace,String addTktStartTime,String ticketType); 
	  
	  //保存车票购买信息
	  void saveTicketBooing(TicketBooking ticketBooking);
	  
	  
	  //按照条件查找可订购酒店信息
	  List<HotelBuyViewObject> searchHotelByCondition(String cityName,Date startDate,Date endDate,String bedCategory);
	  
	  //保存酒店预订信息
	  void saveHotelBooking(HotelBooking hotelBooking);
	  
	  List<TravelRecord> getAllTravelRecordByEmployeeId(Integer employeeId);
}
