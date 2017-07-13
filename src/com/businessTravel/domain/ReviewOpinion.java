package com.businessTravel.domain;

import java.io.Serializable;

public class ReviewOpinion implements Serializable {
      private Integer id;
      private ReviewStatus reviewStatus;
      private String reviewOpinion;
      private TravelRecord travelRecord;
      private String reviewResult;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public ReviewStatus getReviewStatus() {
		return reviewStatus;
	}
	public void setReviewStatus(ReviewStatus reviewStatus) {
		this.reviewStatus = reviewStatus;
	}
	public String getReviewOpinion() {
		return reviewOpinion;
	}
	public void setReviewOpinion(String reviewOpinion) {
		this.reviewOpinion = reviewOpinion;
	}
	public TravelRecord getTravelRecord() {
		return travelRecord;
	}
	public void setTravelRecord(TravelRecord travelRecord) {
		this.travelRecord = travelRecord;
	}
	public String getReviewResult() {
		return reviewResult;
	}
	public void setReviewResult(String reviewResult) {
		this.reviewResult = reviewResult;
	}
      
}
