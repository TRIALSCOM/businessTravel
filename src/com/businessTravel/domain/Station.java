package com.businessTravel.domain;

import java.io.Serializable;

public class Station implements Serializable{
	
	  	 private Integer id;
	  	 
	  	 private String stationName;  //站名
	  	 
	  	 private Integer stationFlowNumber;  //站次
	  	 
	  	 private String arriveTime;
	  	 private String leaveTime;
	  	 private String stateTime;
	  	 
	     // private Integer trainTimes;
	  	 
	  	 private TicketInfo trainTimes;
	  	 private String costFromStart;
	  	 
	
	  	 private Integer leaveDay;    //列次第几天走
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		/*public String getStationName() {
			return stationName;
		}
		public void setStationName(String stationName) {
			this.stationName = stationName;
		}*/
		public Integer getStationFlowNumber() {
			return stationFlowNumber;
		}
		public void setStationFlowNumber(Integer stationFlowNumber) {
			this.stationFlowNumber = stationFlowNumber;
		}
		public String getArriveTime() {
			return arriveTime;
		}
		public void setArriveTime(String arriveTime) {
			this.arriveTime = arriveTime;
		}
		public String getLeaveTime() {
			return leaveTime;
		}
		public void setLeaveTime(String leaveTime) {
			this.leaveTime = leaveTime;
		}
		public String getStateTime() {
			return stateTime;
		}
		public void setStateTime(String stateTime) {
			this.stateTime = stateTime;
		}
	/*	public Integer getTrainTimes() {
			return trainTimes;
		}
		public void setTrainTimes(Integer trainTimes) {
			this.trainTimes = trainTimes;
		}*/
		public String getCostFromStart() {
			return costFromStart;
		}
		public void setCostFromStart(String costFromStart) {
			this.costFromStart = costFromStart;
		}
	
	
		public TicketInfo getTrainTimes() {
			return trainTimes;
		}
		public void setTrainTimes(TicketInfo trainTimes) {
			this.trainTimes = trainTimes;
		}
		public String getStationName() {
			return stationName;
		}
		public void setStationName(String stationName) {
			this.stationName = stationName;
		}
		public Integer getLeaveDay() {
			return leaveDay;
		}
		public void setLeaveDay(Integer leaveDay) {
			this.leaveDay = leaveDay;
		}
		
	  	 
	

}
