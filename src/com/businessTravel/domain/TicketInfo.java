package com.businessTravel.domain;

import java.io.Serializable;

/*
 * ���д���Ϣ
 * 
 */
public class TicketInfo implements Serializable{
    private Integer id;
    private String trainName;   //火车列次
    private String trainStartStation;  //始发站名
    private String trainEndStation;   //终点站名
    private String startTime;
    private String endTime;
    private Integer seatAmountHard;
    private Integer coachAmountHard;
    private Integer coachAmountSoft;
    private Integer standAmount;
    private Integer trainCategory;
    private Integer seatAmountFirst;
    private Integer seatAmountSecond;
    private Integer seatAmountSpecial;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	public String getTrainStartStation() {
		return trainStartStation;
	}
	public void setTrainStartStation(String trainStartStation) {
		this.trainStartStation = trainStartStation;
	}
	public String getTrainEndStation() {
		return trainEndStation;
	}
	public void setTrainEndStation(String trainEndStation) {
		this.trainEndStation = trainEndStation;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public Integer getSeatAmountHard() {
		return seatAmountHard;
	}
	public void setSeatAmountHard(Integer seatAmountHard) {
		this.seatAmountHard = seatAmountHard;
	}
	public Integer getCoachAmountHard() {
		return coachAmountHard;
	}
	public void setCoachAmountHard(Integer coachAmountHard) {
		this.coachAmountHard = coachAmountHard;
	}
	public Integer getCoachAmountSoft() {
		return coachAmountSoft;
	}
	public void setCoachAmountSoft(Integer coachAmountSoft) {
		this.coachAmountSoft = coachAmountSoft;
	}
	public Integer getStandAmount() {
		return standAmount;
	}
	public void setStandAmount(Integer standAmount) {
		this.standAmount = standAmount;
	}
	public Integer getTrainCategory() {
		return trainCategory;
	}
	public void setTrainCategory(Integer trainCategory) {
		this.trainCategory = trainCategory;
	}
	public Integer getSeatAmountFirst() {
		return seatAmountFirst;
	}
	public void setSeatAmountFirst(Integer seatAmountFirst) {
		this.seatAmountFirst = seatAmountFirst;
	}
	public Integer getSeatAmountSecond() {
		return seatAmountSecond;
	}
	public void setSeatAmountSecond(Integer seatAmountSecond) {
		this.seatAmountSecond = seatAmountSecond;
	}
	public Integer getSeatAmountSpecial() {
		return seatAmountSpecial;
	}
	public void setSeatAmountSpecial(Integer seatAmountSpecial) {
		this.seatAmountSpecial = seatAmountSpecial;
	}
    
	
	
}
