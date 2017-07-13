package com.businessTravel.dao.provider;

import org.apache.ibatis.jdbc.SQL;

import com.businessTravel.domain.HotelBooking;

public class HotelBookingProvider {
      public String insertOne(HotelBooking hotelBooking){
    	    return new SQL(){
    	    	{
    	    		INSERT_INTO("hotel_booking_info");
    	    		if(hotelBooking.getHotel()!=null)
    	    			VALUES("hotel_id","#{hotel.id}");
    	    		if(hotelBooking.getDaysLiving()!=null)
    	    			VALUES("days_living","#{daysLiving}");
    	    		if(hotelBooking.getTotalCost()!=null)
    	    			VALUES("total_cost","#{totalCost}");
    	    		if(hotelBooking.getBookingDate()!=null)
    	    			VALUES("booking_date","#{bookingDate}");
    	    		if(hotelBooking.getBedCategory()!=null)
    	    			VALUES("bed_category","#{bedCategory}");
    	    		if(hotelBooking.getStartDate()!=null)
    	    			VALUES("start_date","#{startDate}");
    	    		if(hotelBooking.getEndDate()!=null)
    	    			VALUES("leave_date","#{endDate}");
    	    		if(hotelBooking.getTravelRecord()!=null)
    	    			VALUES("travel_revord_id","#{travelRecord.id}");
    	    		if(hotelBooking.getAttachment()!=null)
    	    			VALUES("attachment_id","#{attachment.id}");  
    	    		if(hotelBooking.getPerCost()!=null)
    	    			VALUES("per_cost","#{perCost}");
    	    	}
    	    	
    	    	
    	    }.toString();
    	  
    	  
      }
	  
	
}
