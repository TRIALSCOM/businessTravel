package com.businessTravel.dao;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import com.businessTravel.domain.CostDetail;

public interface CostDetailDao {

	
	@Select("select * from cost_detail_info where id=#{id}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="hotel_booking_id",property="bookingHotel",one=@One(
				select="com.businessTravel.dao.HotelBookingDao.getOneById",fetchType=FetchType.EAGER)),
	    @Result(column="ticket_booking_id",property="bookingTicket",one=@One(
	    		select="com.businessTravel.dao.TicketBookingDao.getOneById",fetchType=FetchType.EAGER)),
	    @Result(column="attachment_id",property="attachment",one=@One(
	    		select="com.businessTravel.dao.AttachmentDao.getOneById",fetchType=FetchType.EAGER)),
	    @Result(column="total_cost",property="totalCost"),
	//  @Result(column="")
		
	})
	CostDetail selectOneById(@Param("id")Integer id);
	
}
