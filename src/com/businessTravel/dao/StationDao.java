package com.businessTravel.dao;

import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import com.businessTravel.domain.Station;

public interface StationDao {
     @Select("select * from station_info where id=#{id}")
     @Results(
    		 {
    		 @Result(id=true,column="id",property="id"),
    		 @Result(column="station_name",property="stationName"),
    		 @Result(column="station_flow_number",property="stationFlowNumber"),
    		 @Result(column="arrived_time",property="arriveTime"),
    		 @Result(column="leave_time",property="leaveTime"),
    		 @Result(column="state_time",property="stateTime"),
    	  // @Result(column="trainTimes",property="trainTimes"),
    		 @Result(column="cost_from_start",property="costFromStart"),    		
    		 @Result(column="leave_day",property="leaveDay"),
    		 @Result(column="train_times",property="trainTimes",one=@One(
					  select="com.businessTravel.dao.TicketInfoDao.getOneById",fetchType=FetchType.EAGER)),
    		 }
    		 )
     Station selectOneById(@Param("id")Integer id);
     
     
     
     @Select("select * from station_info where station_name like '%${stationName}%'  ")
     @Results(
    		 {
    		 @Result(id=true,column="id",property="id"),
    		 @Result(column="station_name",property="stationName"),
    		 @Result(column="station_flow_number",property="stationFlowNumber"),
    		 @Result(column="arrived_time",property="arriveTime"),
    		 @Result(column="leave_time",property="leaveTime"),
    		 @Result(column="state_time",property="stateTime"),
    	  // @Result(column="trainTimes",property="trainTimes"),
    		 @Result(column="cost_from_start",property="costFromStart"),    		
    		 @Result(column="leave_day",property="leaveDay"),
    		 @Result(column="train_times",property="trainTimes",one=@One(
					  select="com.businessTravel.dao.TicketInfoDao.getOneById",fetchType=FetchType.EAGER))
    		 }
    		 )
     List<Station> selectAllByStationName(@Param("stationName")String stationName);
     
    //第一个版本，未考虑第几天到的因素 
     @Select("select * from station_info where train_times=#{trainId} and arrived_time > #{leaveTime} "
     		+ "and station_name like '%${stationName}%' ")
     @Results(
    		 {
    		 @Result(id=true,column="id",property="id"),
    		 @Result(column="station_name",property="stationName"),
    		 @Result(column="station_flow_number",property="stationFlowNumber"),
    		 @Result(column="arrived_time",property="arriveTime"),
    		 @Result(column="leave_time",property="leaveTime"),
    		 @Result(column="state_time",property="stateTime"),
    	  // @Result(column="trainTimes",property="trainTimes"),
    		 @Result(column="cost_from_start",property="costFromStart"),    		
    		 @Result(column="leave_day",property="leaveDay"),
    		 @Result(column="train_times",property="trainTimes",one=@One(
					  select="com.businessTravel.dao.TicketInfoDao.getOneById",fetchType=FetchType.EAGER))
    		 }
    		 )
     List<Station> selectEndStationByStartStation(@Param("trainId")Integer trainId,@Param("leaveTime")String leaveTime,
    		    @Param("stationName")String stationName);
     
     
     //考虑了第几天到的版本
     @Select("select * from station_info where train_times=#{trainId} and ( (arrived_time > #{leaveTime} and leave_day=#{leaveDay} ) "
      		 + "or (leave_day>#{leaveDay}))"
    		 +" and station_name like '%${stationName}%' ")
     @Results(
    		 {
    		 @Result(id=true,column="id",property="id"),
    		 @Result(column="station_name",property="stationName"),
    		 @Result(column="station_flow_number",property="stationFlowNumber"),
    		 @Result(column="arrived_time",property="arriveTime"),
    		 @Result(column="leave_time",property="leaveTime"),
    		 @Result(column="state_time",property="stateTime"),
    	  // @Result(column="trainTimes",property="trainTimes"),
    		 @Result(column="cost_from_start",property="costFromStart"),    		
    		 @Result(column="leave_day",property="leaveDay"),
    		 @Result(column="train_times",property="trainTimes",one=@One(
					  select="com.businessTravel.dao.TicketInfoDao.getOneById",fetchType=FetchType.EAGER))
    		 }
    		 )
     List<Station> selectEndStationByStationAndLeaveDay(@Param("trainId")Integer trainId,@Param("leaveTime")String leaveTime,
    		    @Param("stationName")String stationName,@Param("leaveDay")Integer leaveDay);
     
     
     
     //不考虑时间，将时间放在java代码中处理
     @Select("select * from station_info where train_times=#{trainId}  "
      		+ "and station_name like '%${stationName}%' ")
      @Results(
     		 {
     		 @Result(id=true,column="id",property="id"),
     		 @Result(column="station_name",property="stationName"),
     		 @Result(column="station_flow_number",property="stationFlowNumber"),
     		 @Result(column="arrived_time",property="arriveTime"),
     		 @Result(column="leave_time",property="leaveTime"),
     		 @Result(column="state_time",property="stateTime"),
     	  // @Result(column="trainTimes",property="trainTimes"),
     		 @Result(column="cost_from_start",property="costFromStart"),    		
     		 @Result(column="leave_day",property="leaveDay"),
     		 @Result(column="train_times",property="trainTimes",one=@One(
 					  select="com.businessTravel.dao.TicketInfoDao.getOneById",fetchType=FetchType.EAGER))
     		 }
     		 )
      List<Station> selectEndStationWithoutTime(@Param("trainId")Integer trainId,
     		    @Param("stationName")String stationName);
     
}
