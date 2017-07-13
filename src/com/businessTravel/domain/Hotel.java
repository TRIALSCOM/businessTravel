package com.businessTravel.domain;

import java.io.Serializable;

/*
 * 酒店信息
 * 
 */
public class Hotel  implements Serializable{

	private Integer id;
	private String name;
	private Integer grade;
	
	private Integer amountKingSize;//大床房数量
	private Integer amountMediumSize;//中型房数量
	private Integer amountSmallSize;//小型房数量
	private String cost;
	private String provinceName;
	private String cityName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public Integer getAmountKingSize() {
		return amountKingSize;
	}
	public void setAmountKingSize(Integer amountKingSize) {
		this.amountKingSize = amountKingSize;
	}
	public Integer getAmountMediumSize() {
		return amountMediumSize;
	}
	public void setAmountMediumSize(Integer amountMediumSize) {
		this.amountMediumSize = amountMediumSize;
	}
	public Integer getAmountSmallSize() {
		return amountSmallSize;
	}
	public void setAmountSmallSize(Integer amountSmallSize) {
		this.amountSmallSize = amountSmallSize;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	
}
