package com.businessTravel.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.businessTravel.domain.TicketInfo;

public interface TicketInfoDao {
      @Select("select * from ticket_info where id=#{id}")
      @Results(
    		  {
    			  @Result(id=true,column="id",property="id"),
    			  @Result(column="train_name",property="trainName"),
    			  @Result(column="train_start_station",property="trainStartStation"),
    			  @Result(column="train_end_station",property="trainEndStation"),
    			  @Result(column="start_time",property="startTime"),
    			  @Result(column="end_time",property="endTime"),
    			  @Result(column="seat_amount_hard",property="seatAmountHard"),
    			  @Result(column="coach_amount_hard",property="coachAmountHard"),
    			  @Result(column="coach_amount_soft",property="coachAmountSoft"),
    			  @Result(column="stand_amount",property="standAmount"),
    			  @Result(column="train_category",property="trainCategory"),
    			  @Result(column="seat_amount_first",property="seatAmountFirst"),
    			  @Result(column="seat_amount_second",property="seatAmountSecond"),
    			  @Result(column="seat_amount_special",property="seatAmountSpecial")    			  
    		  }
    		  
    		 )
      
      TicketInfo getOneById(@Param("id")Integer id);
	
}
