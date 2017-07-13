package com.businessTravel.domain;

import java.io.Serializable;

public class ReviewStatus implements Serializable{
    private Integer id;
    private RoleInfo roleInfo;  //角色
    private Integer reviewOrder; //评审顺序
    private  Dept  dept;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public RoleInfo getRoleInfo() {
		return roleInfo;
	}
	public void setRoleInfo(RoleInfo roleInfo) {
		this.roleInfo = roleInfo;
	}
	
	public Integer getReviewOrder() {
		return reviewOrder;
	}
	public void setReviewOrder(Integer reviewOrder) {
		this.reviewOrder = reviewOrder;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
    
    
    
}
