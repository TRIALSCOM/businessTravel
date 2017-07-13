package com.businessTravel.domain;

import java.io.Serializable;
import java.util.Date;

public class TicketBooking implements Serializable {

	
	private Integer id;
	
	private Station beginStation;  //起始站
	
	private Station endStation;   //终止站
	
	private Employee employee;  //出行人
	
	private String totalCost;  //总的花费
	
//	private Integer perCost;   //单价
	
	private Date bookingDate;  //预定日期
	
	private String seatCategory;  //预定的座位信息
	
	private TravelRecord travelRecord;  //所属的出差记录
	
	private Attachment attachment;   //所对应的附件信息
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public String getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(String totalCost) {
		this.totalCost = totalCost;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public String getSeatCategory() {
		return seatCategory;
	}
	public void setSeatCategory(String seatCategory) {
		this.seatCategory = seatCategory;
	}
	public TravelRecord getTravelRecord() {
		return travelRecord;
	}
	public void setTravelRecord(TravelRecord travelRecord) {
		this.travelRecord = travelRecord;
	}
	
	public Attachment getAttachment() {
		return attachment;
	}
	
	public void setAttachment(Attachment attachment) {
		this.attachment = attachment;
	}
	
	

	@Override
	public String toString() {
		return "TicketBooking [id=" + id + ", beginStation=" + beginStation + ", endStation=" + endStation
				+ ", employee=" + employee + ", totalCost=" + totalCost + ", bookingDate=" + bookingDate
				+ ", seatCategory=" + seatCategory + ", travelRecord=" + travelRecord + ", attachment=" + attachment
				+ ", toString()=" + super.toString() + "]";
	}
	
	
	
}
