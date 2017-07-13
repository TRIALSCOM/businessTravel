package com.businessTravel.viewObject;

import java.util.Date;

import com.businessTravel.domain.Hotel;

public class HotelBuyViewObject {
    private String hotelName;
    private Integer grade;
    private Integer perCost;
    private Integer totalCost;
    private Hotel   hotel;
    private Integer dyasLiving;
    private String bedCategory;
    
    private Date beginDate;
    private Date endDate;
    
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
	public Integer getPerCost() {
		return perCost;
	}
	public void setPerCost(Integer perCost) {
		this.perCost = perCost;
	}
	public Integer getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(Integer totalCost) {
		this.totalCost = totalCost;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public Integer getDyasLiving() {
		return dyasLiving;
	}
	public void setDyasLiving(Integer dyasLiving) {
		this.dyasLiving = dyasLiving;
	}
	public String getBedCategory() {
		return bedCategory;
	}
	public void setBedCategory(String bedCategory) {
		this.bedCategory = bedCategory;
	}
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
    
    
}
