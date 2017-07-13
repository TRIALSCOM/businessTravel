package com.businessTravel.viewObject;

import com.businessTravel.domain.Station;
import com.businessTravel.domain.TicketInfo;

public class TicketBuyViewObject {

	  private String   beginPlace;
	  private String   endPlace;
	  private String   startTime;
	  private String   arriveTime;
	  private String   trainTimes;
	  private Integer  cost;
	  private TicketInfo ticketInfo;
	  private Station   beginStation;
	  private Station   endStation;
	  private String   seatCategory;
	  
	  
	public String getBeginPlace() {
		return beginPlace;
	}
	public void setBeginPlace(String beginPlace) {
		this.beginPlace = beginPlace;
	}
	public String getEndPlace() {
		return endPlace;
	}
	public void setEndPlace(String endPlace) {
		this.endPlace = endPlace;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getArriveTime() {
		return arriveTime;
	}
	public void setArriveTime(String arriveTime) {
		this.arriveTime = arriveTime;
	}
	public String getTrainTimes() {
		return trainTimes;
	}
	public void setTrainTimes(String trainTimes) {
		this.trainTimes = trainTimes;
	}
	public Integer getCost() {
		return cost;
	}
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	public TicketInfo getTicketInfo() {
		return ticketInfo;
	}
	public void setTicketInfo(TicketInfo ticketInfo) {
		this.ticketInfo = ticketInfo;
	}
	public Station getBeginStation() {
		return beginStation;
	}
	public void setBeginStation(Station beginStation) {
		this.beginStation = beginStation;
	}
	public Station getEndStation() {
		return endStation;
	}
	public void setEndStation(Station endStation) {
		this.endStation = endStation;
	}
	public String getSeatCategory() {
		return seatCategory;
	}
	public void setSeatCategory(String seatCategory) {
		this.seatCategory = seatCategory;
	}
	  
	  
}
