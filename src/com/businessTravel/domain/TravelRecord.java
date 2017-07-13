package com.businessTravel.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/*
 *出行记录
 * 
 */
public class TravelRecord implements Serializable {

	private Integer id;
	private Employee employee;
	private String applyingFunding; //本来申请
	private String  additionalFunding; //追加经费
	private String advanceFunding;  //已申请经费
	private String allFunding;    //总经费
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date travelBeginDate;
	
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date travelEndDate;
	
	private Integer daysCount;
	private String travelAddress;
	private String travelReason;
	
//	private CostDetail costDetail;

	private ReviewStatus reviewStatus;
	
	
	private  String beginPlace;
	
	private String endPlace;
	
	private Integer reviewBeginEnd;
	
	
	private Attachment  attachment;
	
	private String costDescription;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public String getApplyingFunding() {
		return applyingFunding;
	}
	public void setApplyingFunding(String applyingFunding) {
		this.applyingFunding = applyingFunding;
	}
	public String getAdditionalFunding() {
		return additionalFunding;
	}
	public void setAdditionalFunding(String additionalFunding) {
		this.additionalFunding = additionalFunding;
	}
	public String getAdvanceFunding() {
		return advanceFunding;
	}
	public void setAdvanceFunding(String advanceFunding) {
		this.advanceFunding = advanceFunding;
	}
	public String getAllFunding() {
		return allFunding;
	}
	public void setAllFunding(String allFunding) {
		this.allFunding = allFunding;
	}
	public Date getTravelBeginDate() {
		return travelBeginDate;
	}
	public void setTravelBeginDate(Date travelBeginDate) {
		this.travelBeginDate = travelBeginDate;
	}
	public Date getTravelEndDate() {
		return travelEndDate;
	}
	public void setTravelEndDate(Date travelEndDate) {
		this.travelEndDate = travelEndDate;
	}
	public Integer getDaysCount() {
		return daysCount;
	}
	public void setDaysCount(Integer daysCount) {
		this.daysCount = daysCount;
	}
	public String getTravelAddress() {
		return travelAddress;
	}
	public void setTravelAddress(String travelAddress) {
		this.travelAddress = travelAddress;
	}
	public String getTravelReason() {
		return travelReason;
	}
	public void setTravelReason(String travelReason) {
		this.travelReason = travelReason;
	}
/*	public CostDetail getCostDetail() {
		return costDetail;
	}
	public void setCostDetail(CostDetail costDetail) {
		this.costDetail = costDetail;
	}*/
	public ReviewStatus getReviewStatus() {
		return reviewStatus;
	}
	public void setReviewStatus(ReviewStatus reviewStatus) {
		this.reviewStatus = reviewStatus;
	}
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
	public Integer getReviewBeginEnd() {
		return reviewBeginEnd;
	}
	public void setReviewBeginEnd(Integer reviewBeginEnd) {
		this.reviewBeginEnd = reviewBeginEnd;
	}
	
	
	public Attachment getAttachment() {
		return attachment;
	}
	public void setAttachment(Attachment attachment) {
		this.attachment = attachment;
	}
	
	
	public String getCostDescription() {
		
	     return costDescription;
	     
	}
	public void setCostDescription(String costDescription) {
		this.costDescription = costDescription;
	}
	@Override
	public String toString() {
		return "TravelRecord [id=" + id + ", employee=" + employee + ", applyingFunding=" + applyingFunding
				+ ", additionalFunding=" + additionalFunding + ", advanceFunding=" + advanceFunding + ", allFunding="
				+ allFunding + ", travelBeginDate=" + travelBeginDate + ", travelEndDate=" + travelEndDate
				+ ", daysCount=" + daysCount + ", travelAddress=" + travelAddress + ", travelReason=" + travelReason
				+ ", reviewStatus=" + reviewStatus + ", beginPlace=" + beginPlace + ", endPlace=" + endPlace
				+ ", reviewBeginEnd=" + reviewBeginEnd + "]";
	}
	
	
}
