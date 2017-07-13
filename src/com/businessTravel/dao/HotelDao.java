package com.businessTravel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.businessTravel.domain.Hotel;

public interface HotelDao {
     @Select("select * from hotel_info where id=#{id}")
     @Results(
    		 {
    			 @Result(id=true,column="id",property="id"),
    			 @Result(column="name",property="name"),
    			 @Result(column="grade",property="grade"),
    			 @Result(column="amount_king_size",property="amountKingSize"),
    			 @Result(column="amount_medium_size",property="amountMediumSize"),
    			 @Result(column="amount_small_size",property="amountSmallSize"),
    			 @Result(column="cost",property="cost"),
    			 @Result(column="province_name",property="provinceName"),
    			 @Result(column="city_name",property="cityName")	 
    		  }
    	 )
     Hotel selectOneById(@Param("id")Integer id);
     
     
     @Select("select * from hotel_info where city_name like '%${cityName}%' ")
     @Results(
    		 {
    			 @Result(id=true,column="id",property="id"),
    			 @Result(column="name",property="name"),
    			 @Result(column="grade",property="grade"),
    			 @Result(column="amount_king_size",property="amountKingSize"),
    			 @Result(column="amount_medium_size",property="amountMediumSize"),
    			 @Result(column="amount_small_size",property="amountSmallSize"),
    			 @Result(column="cost",property="cost"),
    			 @Result(column="province_name",property="provinceName"),
    			 @Result(column="city_name",property="cityName")	 
    		  }
    	 )
     List<Hotel> selectAllInCity(@Param("cityName")String cityName);
     
}
