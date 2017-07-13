package com.businessTravel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import com.businessTravel.dao.provider.HotelBookingProvider;
import com.businessTravel.domain.HotelBooking;

public interface HotelBookingDao {
    
	 @Select("select * from hotel_booking_info where id=#{id}" )
	 @Results(
			 {
			   @Result(id=true,column="id",property="id"),				
			   @Result(column="days_living",property="daysLiving"),
			   @Result(column="total_cost",property="totalCost"),
			   @Result(column="booking_date",property="bookingDate"),
			   @Result(column="bed_category",property="bedCategory"),
			   @Result(column="start_date",property="startDate"),
			   @Result(column="leave_date",property="endDate"),
			   @Result(column="per_cost",property="perCost"),
			   @Result(column="hotel_id",property="hotel",
				 one=@One(select="com.businessTravel.dao.HotelDao.selectOneById",fetchType=FetchType.EAGER)),
				
			   @Result(column="travel_revord_id",property="travelRecord",one=@One(
					   select="com.businessTravel.dao.TravelRecordDao.getOneById",fetchType=FetchType.EAGER)),
			   @Result(column="attachment_id",property="attachment",one=@One(
					   select="com.businessTravel.dao.AttachmentDao.getOneById",fetchType=FetchType.EAGER))			   			   
			    }
			 )
	 HotelBooking getOneById(@Param("id") Integer id);
	 
	 
	 @Select("select * from hotel_booking_info where travel_revord_id=#{travelRecordId} order by booking_date asc ")
	 @Results(
			 {
			   @Result(id=true,column="id",property="id"),				
			   @Result(column="days_living",property="daysLiving"),
			   @Result(column="total_cost",property="totalCost"),
			   @Result(column="booking_date",property="bookingDate"),
			   @Result(column="bed_category",property="bedCategory"),
			   @Result(column="start_date",property="startDate"),
			   @Result(column="leave_date",property="endDate"),
			   @Result(column="per_cost",property="perCost"),
			   @Result(column="hotel_id",property="hotel",
				 one=@One(select="com.businessTravel.dao.HotelDao.selectOneById",fetchType=FetchType.EAGER)),
				
			   @Result(column="travel_revord_id",property="travelRecord",one=@One(
					   select="com.businessTravel.dao.TravelRecordDao.getOneById",fetchType=FetchType.EAGER)),
			   @Result(column="attachment_id",property="attachment",one=@One(
					   select="com.businessTravel.dao.AttachmentDao.getOneById",fetchType=FetchType.EAGER))			   			   
			    }
			 )
	 List<HotelBooking> getAllByRecordId(@Param("travelRecordId")Integer travelRecordId);
	 
	 
	 @InsertProvider(type=HotelBookingProvider.class,method="insertOne")
	 void insertOne(HotelBooking hotelBooking);
}
