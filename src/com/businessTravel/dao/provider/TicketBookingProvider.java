package com.businessTravel.dao.provider;

import org.apache.ibatis.jdbc.SQL;

import com.businessTravel.domain.TicketBooking;

public class TicketBookingProvider {

	public String insertOne(TicketBooking ticketBooking){
		return new SQL(){
			{
				INSERT_INTO("ticket_booking_info");
				if(ticketBooking.getBeginStation()!=null)
					VALUES("begin_station_id","#{beginStation.id}");
				if(ticketBooking.getEndStation()!=null)
					VALUES("end_station_id","#{endStation.id}");
				if(ticketBooking.getEmployee()!=null)
					VALUES("employee_id","#{employee.id}");
				if(ticketBooking.getTotalCost()!=null)
					VALUES("total_cost","#{totalCost}");
				if(ticketBooking.getBookingDate()!=null)
					VALUES("booking_date","#{bookingDate}");
				if(ticketBooking.getSeatCategory()!=null)
					VALUES("seat_category","#{seatCategory}");
				if(ticketBooking.getTravelRecord()!=null)
					VALUES("travel_revord_id","#{travelRecord.id}");
				if(ticketBooking.getAttachment()!=null)
					VALUES("attachment_id","#{attachment}");				
			}
			
		}.toString();
		
	}
	
}
