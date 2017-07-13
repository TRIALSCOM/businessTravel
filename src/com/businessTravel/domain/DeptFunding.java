package com.businessTravel.domain;

import java.io.Serializable;

/*
 * 部门经费
 */
public class DeptFunding implements Serializable {
   
	  private Integer id;
	  private Dept dept;
	  private String budget;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public String getBudget() {
		return budget;
	}
	public void setBudget(String budget) {
		this.budget = budget;
	}
	  
}
