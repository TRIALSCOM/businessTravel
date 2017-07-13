package com.businessTravel.dao;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import com.businessTravel.dao.provider.TicketBookingProvider;
import com.businessTravel.domain.TicketBooking;

public interface TicketBookingDao {
    
	  @Select("select * from ticket_booking_info where id=#{id}")
	  @Results(
			  {
			@Result(id=true,column="id",property="id"),
			@Result(column="begin_station_id",property="beginStation",
		       one=@One(select="com.businessTravel.dao.StationDao.selectOneById",fetchType=FetchType.EAGER)),
			@Result(column="end_station_id",property="endStation",
			   one=@One(select="com.businessTravel.dao.StationDao.selectOneById",fetchType=FetchType.EAGER)),
			@Result(column="employee_id",property="employee",
			   one=@One(select="com.businessTravel.dao.EmployeeDao.getOneById",fetchType=FetchType.EAGER)),
			@Result(column="total_cost",property="totalCost"),
			@Result(column="booking_date",property="bookingDate"),	
			@Result(column="seat_category",property="seatCategory"),
			@Result(column="travel_revord_id",property="travelRecord",one=@One(
					   select="com.businessTravel.dao.TravelRecordDao.getOneById",fetchType=FetchType.EAGER)),
			@Result(column="attachment_id",property="attachment",one=@One(
					   select="com.businessTravel.dao.AttachmentDao.getOneById",fetchType=FetchType.EAGER))
			  }			  
			  )
	  
	  TicketBooking getOneById(@Param("id")Integer id);
	  
	  
	@Select("select * from  ticket_booking_info where travel_revord_id=#{travelRecordId} order by booking_date asc")  
	 @Results(
			  {
			@Result(id=true,column="id",property="id"),
			@Result(column="begin_station_id",property="beginStation",
		       one=@One(select="com.businessTravel.dao.StationDao.selectOneById",fetchType=FetchType.EAGER)),
			@Result(column="end_station_id",property="endStation",
			   one=@One(select="com.businessTravel.dao.StationDao.selectOneById",fetchType=FetchType.EAGER)),
			@Result(column="employee_id",property="employee",
			   one=@One(select="com.businessTravel.dao.EmployeeDao.getOneById",fetchType=FetchType.EAGER)),
			@Result(column="total_cost",property="totalCost"),
			@Result(column="booking_date",property="bookingDate"),	
			@Result(column="seat_category",property="seatCategory"),
			@Result(column="travel_revord_id",property="travelRecord",one=@One(
					   select="com.businessTravel.dao.TravelRecordDao.getOneById",fetchType=FetchType.EAGER)),
			@Result(column="attachment_id",property="attachment",one=@One(
					   select="com.businessTravel.dao.AttachmentDao.getOneById",fetchType=FetchType.EAGER))
			  }			  
			  )
	List<TicketBooking> getAllByTravelRecordId(@Param("travelRecordId")Integer travelRecordId);

	@InsertProvider(type=TicketBookingProvider.class,method="insertOne")
	void insertOne(TicketBooking ticketBooking);
	
}
