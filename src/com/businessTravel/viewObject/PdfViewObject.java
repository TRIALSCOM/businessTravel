package com.businessTravel.viewObject;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.businessTravel.domain.HotelBooking;
import com.businessTravel.domain.TicketBooking;

public class PdfViewObject {
	
     private   String  userName;   //订票人
     private Date travelBeginDate;//订票时间
     private   Integer daysCount;  //出行天数
        
     private   String  ticketCost;  //车票花费
     private   String  hotelCost;   //酒店花费	
     
     private   String  allCost;  //总花费
     
      
     private String trainTimes;    //火车列次
     private String startCity;     //始发站
     private String endCity;       //终止站
     private String seatCategory;  //座位类别
     
     private List<TicketBooking> ticketBookingList;  //每个车票的信息
     private Map<String,String> costOnTrainName;   //各个车票花费
     	
	  
     private String hotelName;  //酒店名
     private Integer grade;     //星级
     private String hotelCategory;  //酒店类别
     private Date   startHotelDate;   //入住日期
     private Date   endHotelDate;     //退房日期
     private List<HotelBooking> hotelBookingList;//每个酒店的预定信息
     private Map<String,String> costOnHotelName;  //各个房间花费
     
     private Date bookingDate;
     
     private Date ticketBookingDate;
     private Date hotelBookingDate;
     
     
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getDaysCount() {
		return daysCount;
	}
	public void setDaysCount(Integer daysCount) {
		this.daysCount = daysCount;
	}
	public String getTicketCost() {
		return ticketCost;
	}
	public void setTicketCost(String ticketCost) {
		this.ticketCost = ticketCost;
	}
	public String getHotelCost() {
		return hotelCost;
	}
	public void setHotelCost(String hotelCost) {
		this.hotelCost = hotelCost;
	}
	public String getAllCost() {
		return allCost;
	}
	public void setAllCost(String allCost) {
		this.allCost = allCost;
	}
	
	public String getStartCity() {
		return startCity;
	}
	public void setStartCity(String startCity) {
		this.startCity = startCity;
	}
	public String getEndCity() {
		return endCity;
	}
	public void setEndCity(String endCity) {
		this.endCity = endCity;
	}
	public String getSeatCategory() {
		return seatCategory;
	}
	public void setSeatCategory(String seatCategory) {
		this.seatCategory = seatCategory;
	}
	public Map<String, String> getCostOnTrainName() {
		return costOnTrainName;
	}
	public void setCostOnTrainName(Map<String, String> costOnTrainName) {
		this.costOnTrainName = costOnTrainName;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public String getHotelCategory() {
		return hotelCategory;
	}
	public void setHotelCategory(String hotelCategory) {
		this.hotelCategory = hotelCategory;
	}
	public Date getStartHotelDate() {
		return startHotelDate;
	}
	public void setStartHotelDate(Date startHotelDate) {
		this.startHotelDate = startHotelDate;
	}
	public Date getEndHotelDate() {
		return endHotelDate;
	}
	public void setEndHotelDate(Date endHotelDate) {
		this.endHotelDate = endHotelDate;
	}
	public Map<String, String> getCostOnHotelName() {
		return costOnHotelName;
	}
	public void setCostOnHotelName(Map<String, String> costOnHotelName) {
		this.costOnHotelName = costOnHotelName;
	}
	public String getTrainTimes() {
		return trainTimes;
	}
	public void setTrainTimes(String trainTimes) {
		this.trainTimes = trainTimes;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public List<TicketBooking> getTicketBookingList() {
		return ticketBookingList;
	}
	public void setTicketBookingList(List<TicketBooking> ticketBookingList) {
		this.ticketBookingList = ticketBookingList;
	}
	public Date getTicketBookingDate() {
		return ticketBookingDate;
	}
	public void setTicketBookingDate(Date ticketBookingDate) {
		this.ticketBookingDate = ticketBookingDate;
	}
	public Date getHotelBookingDate() {
		return hotelBookingDate;
	}
	public void setHotelBookingDate(Date hotelBookingDate) {
		this.hotelBookingDate = hotelBookingDate;
	}
	public List<HotelBooking> getHotelBookingList() {
		return hotelBookingList;
	}
	public void setHotelBookingList(List<HotelBooking> hotelBookingList) {
		this.hotelBookingList = hotelBookingList;
	}
	public Date getTravelBeginDate() {
		return travelBeginDate;
	}
	public void setTravelBeginDate(Date travelBeginDate) {
		this.travelBeginDate = travelBeginDate;
	}
     
     
     
     
	
}
