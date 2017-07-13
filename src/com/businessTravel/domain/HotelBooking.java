package com.businessTravel.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/*
 * 房间预订信息
 */

public class HotelBooking  implements Serializable{
      private Integer id;
      private Hotel hotel;
      private Integer daysLiving;
      private String totalCost;
      private Date bookingDate;
      private String bedCategory;
      private TravelRecord travelRecord;
      private Attachment attachment;
      private Integer perCost;
      
      @DateTimeFormat(pattern="yyyy-MM-dd")
      private Date startDate;
      
      @DateTimeFormat(pattern="yyyy-MM-dd")
      private Date endDate;
      
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public Integer getDaysLiving() {
		return daysLiving;
	}
	public void setDaysLiving(Integer daysLiving) {
		this.daysLiving = daysLiving;
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
	public String getBedCategory() {
		return bedCategory;
	}
	public void setBedCategory(String bedCategory) {
		this.bedCategory = bedCategory;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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
	
	
	
	public Integer getPerCost() {
		return perCost;
	}
	public void setPerCost(Integer perCost) {
		this.perCost = perCost;
	}
	@Override
	public String toString() {
		return "HotelBooking [id=" + id + ", hotel=" + hotel + ", daysLiving=" + daysLiving + ", totalCost=" + totalCost
				+ ", bookingDate=" + bookingDate + ", bedCategory=" + bedCategory + ", travelRecord=" + travelRecord
				+ ", attachment=" + attachment + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	
    
}
