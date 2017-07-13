package com.businessTravel.service.serviceImpl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.businessTravel.dao.HotelBookingDao;
import com.businessTravel.dao.HotelDao;
import com.businessTravel.dao.StationDao;
import com.businessTravel.dao.TicketBookingDao;
import com.businessTravel.dao.TravelRecordDao;
import com.businessTravel.domain.Hotel;
import com.businessTravel.domain.HotelBooking;
import com.businessTravel.domain.Station;
import com.businessTravel.domain.TicketBooking;
import com.businessTravel.domain.TravelRecord;
import com.businessTravel.service.BusinessService;
import com.businessTravel.util.common.BusinessUtils;
import com.businessTravel.viewObject.HotelBuyViewObject;
import com.businessTravel.viewObject.TicketBuyViewObject;
import static com.businessTravel.util.BusinessConstant.*;

@Service
public class BusinessServiceImpl implements BusinessService {
     @Autowired
     private TravelRecordDao travelRecordDao;
	 
     @Autowired
     private StationDao stationDao;
     
     @Autowired
     
     private TicketBookingDao ticketBookingDao;
     
     @Autowired
     private HotelDao hotelDao;
     
     @Autowired
     private HotelBookingDao hotelBookingDao;
     
	 @Override
	 public void saveTravelRecord(TravelRecord travelRecord) {
		// TODO Auto-generated method stub
		travelRecordDao.saveOneRecord(travelRecord);
	}

	@Override
	public TravelRecord getUnApplyOneByEmployeeId(Integer employeeId) {
		// TODO Auto-generated method stub
		return travelRecordDao.getOneUnApplyByEmployeeId(employeeId);
	}

	@Override
	public List<TicketBuyViewObject> searchStationByCondition(String addTktBeginPlace,
			  String addTktEndPlace,String addTktStartTime,String ticketType) {
		// TODO Auto-generated method stub
		List<TicketBuyViewObject> ticketBuyViewObjects=new ArrayList<>();
		
		List<Station>startStations=stationDao.selectAllByStationName(addTktBeginPlace);
		for(Station station:startStations){
			
	     if(station.getTrainTimes().getTrainCategory()==K_TRAIN_CATEGORY&&K_TRIANS.contains(ticketType))
	     {	/*
			List<Station> endStations=stationDao.selectEndStationByStartStation(
					station.getTrainTimes().getId(), station.getLeaveTime(),addTktEndPlace);*/
	    	
	    	 //将对时间的甄选放在java代码中
	    	/* List<Station> endStations=stationDao.selectEndStationWithoutTime(
						station.getTrainTimes().getId(),addTktEndPlace);
			//
			Iterator<Station> it=endStations.iterator();
			while(it.hasNext()){
				Station tempStation=it.next();
				if(tempStation.getLeaveDay()<station.getLeaveDay()){
					it.remove();
				}
				if(tempStation.getLeaveDay()==station.getLeaveDay()){
					if(tempStation.getLeaveDay()<station.getLeaveDay()){
						it.remove();
					}
				}		
			}*/
	    	 
	    	 List<Station> endStations=stationDao.selectEndStationByStationAndLeaveDay(
						station.getTrainTimes().getId(), station.getLeaveTime(),addTktEndPlace,station.getLeaveDay());
			
			
			 for(Station end:endStations){
				 TicketBuyViewObject ticketBuyViewObject=new TicketBuyViewObject();
				 ticketBuyViewObject.setBeginStation(station);
				 ticketBuyViewObject.setEndStation(end);
				 ticketBuyViewObject.setTicketInfo(end.getTrainTimes());
				 ticketBuyViewObject.setTrainTimes(end.getTrainTimes().getTrainName());
				 ticketBuyViewObject.setBeginPlace(station.getStationName());
				 ticketBuyViewObject.setEndPlace(end.getStationName());
				 ticketBuyViewObject.setStartTime(station.getLeaveTime());
				 ticketBuyViewObject.setArriveTime(end.getArriveTime());
			     //ticketBuyViewObject.setCost(cost);
				 if(SEAT_STAND.equals(ticketType)){
					  if(end.getTrainTimes().getStandAmount()>0){
						  ticketBuyViewObject.setCost(
								Integer.parseInt(end.getCostFromStart())-Integer.parseInt(station.getCostFromStart()));
						 
						  ticketBuyViewObject.setSeatCategory(SEAT_STAND);
						  ticketBuyViewObjects.add(ticketBuyViewObject);
					       }
					  }
				  if(SEAT_HARD.equals(ticketType)){
					   if(end.getTrainTimes().getSeatAmountHard()>0){  
						  ticketBuyViewObject.setCost(
									Integer.parseInt(end.getCostFromStart())-Integer.parseInt(station.getCostFromStart()));
						
						  ticketBuyViewObject.setSeatCategory(SEAT_HARD);
						  ticketBuyViewObjects.add(ticketBuyViewObject);
					  }
					 
				 }
				  if(COACH_HARD.equals(ticketType)){
					 if(end.getTrainTimes().getCoachAmountHard()>0){
						 ticketBuyViewObject.setCost(
									2*(Integer.parseInt(end.getCostFromStart())-Integer.parseInt(station.getCostFromStart())));
					     ticketBuyViewObject.setSeatCategory(COACH_HARD);
						 ticketBuyViewObjects.add(ticketBuyViewObject);
					 }
					 
				 }
				if(COACH_SOFT.equals(ticketType)){
					if(end.getTrainTimes().getCoachAmountSoft()>0){
						
						 ticketBuyViewObject.setCost(
									3*(Integer.parseInt(end.getCostFromStart())-Integer.parseInt(station.getCostFromStart())));
							  
						  ticketBuyViewObject.setSeatCategory(COACH_SOFT);
						  ticketBuyViewObjects.add(ticketBuyViewObject);
					}										
				}
				 					  				 				 	
			 }
			
	     }
	     if(station.getTrainTimes().getTrainCategory()!=K_TRAIN_CATEGORY&&O_TRAINS.contains(ticketType)){
	    	 
	    	 List<Station> endStations=stationDao.selectEndStationByStartStation(
						station.getTrainTimes().getId(), station.getLeaveTime(),addTktEndPlace);
				 for(Station end:endStations){
					 TicketBuyViewObject ticketBuyViewObject=new TicketBuyViewObject();
					 ticketBuyViewObject.setBeginStation(station);
					 ticketBuyViewObject.setEndStation(end);
					 ticketBuyViewObject.setTicketInfo(end.getTrainTimes());
					 ticketBuyViewObject.setTrainTimes(end.getTrainTimes().getTrainName());
					 ticketBuyViewObject.setBeginPlace(station.getStationName());
					 ticketBuyViewObject.setEndPlace(end.getStationName());
					 ticketBuyViewObject.setStartTime(station.getLeaveTime());
					 ticketBuyViewObject.setArriveTime(end.getArriveTime());
				     //ticketBuyViewObject.setCost(cost);
					 if(SEAT_FIRST.equals(ticketType)){
						 if(end.getTrainTimes().getSeatAmountFirst()>0){
							  
							 ticketBuyViewObject.setCost(
										2*(Integer.parseInt(end.getCostFromStart())-Integer.parseInt(station.getCostFromStart())));
								
							  ticketBuyViewObject.setSeatCategory(SEAT_FIRST);
							  ticketBuyViewObjects.add(ticketBuyViewObject);
						 }
						
					 }
					 
					if(SEAT_SECOND.equals(ticketType)){
						if(end.getTrainTimes().getSeatAmountSecond()>0){
							
							  
							 ticketBuyViewObject.setCost(
										(Integer.parseInt(end.getCostFromStart())-Integer.parseInt(station.getCostFromStart())));
							 ticketBuyViewObject.setSeatCategory(SEAT_SECOND); 
							 ticketBuyViewObjects.add(ticketBuyViewObject);
						}
						
					}
					if(SEAT_SPECIAL.equals(ticketType)){
						if(end.getTrainTimes().getSeatAmountSpecial()!=null){
							ticketBuyViewObject.setCost(
									3*(Integer.parseInt(end.getCostFromStart())-Integer.parseInt(station.getCostFromStart())));
							ticketBuyViewObject.setSeatCategory(SEAT_SPECIAL);
							ticketBuyViewObjects.add(ticketBuyViewObject);
							
						}						
					 }
					 
				   }
	       }	
	}
			
		return ticketBuyViewObjects;
	}

	@Override
	public void saveTicketBooing(TicketBooking ticketBooking) {
		// TODO Auto-generated method stub
		ticketBookingDao.insertOne(ticketBooking);
	}

	@Override
	public List<HotelBuyViewObject> searchHotelByCondition(String cityName, Date startDate, Date endDate, String bedCategory) {
		// TODO Auto-generated method stub
		int dayBetweens=1;
		try{		
		    dayBetweens=BusinessUtils.daysBetween(startDate, endDate);
	      }catch(ParseException e){
		  e.printStackTrace();
	   }
	  
		List<Hotel> hotelList=hotelDao.selectAllInCity(cityName);
	    List<HotelBuyViewObject> hotelBuyViewObjects=new ArrayList<>();
	    for(Hotel hotel:hotelList){
	    	HotelBuyViewObject hotelBuyViewObject=new HotelBuyViewObject();
	    	hotelBuyViewObject.setHotelName(hotel.getName());
	    	hotelBuyViewObject.setGrade(hotel.getGrade());
	    	hotelBuyViewObject.setHotel(hotel);
	    	hotelBuyViewObject.setDyasLiving(dayBetweens);
	    	hotelBuyViewObject.setBedCategory(bedCategory);
	    	hotelBuyViewObject.setBeginDate(startDate);
	    	hotelBuyViewObject.setEndDate(endDate);
	       if(KING_BED.equals(bedCategory)&&hotel.getAmountKingSize()>0){
	    	    hotelBuyViewObject.setPerCost((int)Math.floor(Double.valueOf(hotel.getCost())*1.25*1.25));
	    	    hotelBuyViewObject.setTotalCost(hotelBuyViewObject.getPerCost()*dayBetweens);
	    	    hotelBuyViewObjects.add(hotelBuyViewObject);
	       }else if(MEDIUM_BED.equals(bedCategory)&&hotel.getAmountMediumSize()>0){
	    	   hotelBuyViewObject.setPerCost((int)Math.floor(Double.valueOf(hotel.getCost())*1.25));
	    	    hotelBuyViewObject.setTotalCost(hotelBuyViewObject.getPerCost()*dayBetweens);
	    	    hotelBuyViewObjects.add(hotelBuyViewObject);
	       }else {
	    	   if(hotel.getAmountSmallSize()>0)
	    	       {
	    		    hotelBuyViewObject.setPerCost(Integer.valueOf(hotel.getCost()));
	    	         hotelBuyViewObject.setTotalCost(hotelBuyViewObject.getPerCost()*dayBetweens);
	    	         hotelBuyViewObjects.add(hotelBuyViewObject);
	    	       }
		     }    	
	    }
		  return hotelBuyViewObjects;
	}

	@Override
	public void saveHotelBooking(HotelBooking hotelBooking) {
		// TODO Auto-generated method stub
		
		hotelBookingDao.insertOne(hotelBooking);
	}

	@Override
	public List<TravelRecord> getAllTravelRecordByEmployeeId(Integer employeeId) {
		// TODO Auto-generated method stub
		return travelRecordDao.getAllByEmployeeId(employeeId);
	}

	@Override
	public void updateTravelRecord(TravelRecord travelRecord) {
		// TODO Auto-generated method stub
		travelRecordDao.updateRecord(travelRecord);
	}

	@Override
	public TravelRecord getOneTravelRecordById(Integer id) {
		// TODO Auto-generated method stub
		return travelRecordDao.getOneById(id);
	}
	
	

	

}
