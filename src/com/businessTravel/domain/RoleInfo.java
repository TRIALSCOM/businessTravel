package com.businessTravel.domain;

import java.io.Serializable;

public class RoleInfo implements Serializable{
	    private  int   id ;
	    
	    private  String  role;
	    
	    private  String degree ;
	    
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		public String getDegree() {
			return degree;
		}
		public void setDegree(String degree) {
			this.degree = degree;
		}
	    
}
