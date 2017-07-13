package com.businessTravel.domain;

import java.io.Serializable;

public class CostDetail implements Serializable {
      
	 private Integer id;
	 private HotelBooking bookingHotel;
	 private TicketBooking bookingTicket;
	 private String totalCost;
	 private Attachment attachment;
	 private TravelRecord travelRecord;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public HotelBooking getBookingHotel() {
		return bookingHotel;
	}
	public void setBookingHotel(HotelBooking bookingHotel) {
		this.bookingHotel = bookingHotel;
	}
	public TicketBooking getBookingTicket() {
		return bookingTicket;
	}
	public void setBookingTicket(TicketBooking bookingTicket) {
		this.bookingTicket = bookingTicket;
	}
	public String getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(String totalCost) {
		this.totalCost = totalCost;
	}
	public Attachment getAttachment() {
		return attachment;
	}
	public void setAttachment(Attachment attachment) {
		this.attachment = attachment;
	}
	
	public TravelRecord getTravelRecord() {  
		return travelRecord; 
		}
	
	public void setTravelRecord(TravelRecord travelRecord) {	
		this.travelRecord = travelRecord;
	}
	@Override
	public String toString() {
		return "CostDetail [attachment=" + attachment + ", bookingHotel=" + bookingHotel + ", bookingTicket="
				+ bookingTicket + ", id=" + id + ", totalCost=" + totalCost + ", travelRecord=" + travelRecord + "]";
	}
	 
	 
	 
	 
}
