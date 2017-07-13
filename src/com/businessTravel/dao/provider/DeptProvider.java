package com.businessTravel.dao.provider;

import org.apache.ibatis.jdbc.SQL;

import com.businessTravel.domain.Dept;

public class DeptProvider {

	
	
	  public String saveDept(Dept dept){
		  
		  return new SQL(){
			  {
				  INSERT_INTO("dept_info");
				  if(dept.getName()!=null)
					  VALUES("name","#{name}");
				  if(dept.getCode()!=null)
					  VALUES("code","#{code}");
				  if(dept.getCompanyInfo()!=null)
					  VALUES("companycode","#{companyInfo.id}");
				  if(dept.getDescription()!=null)
					  VALUES("description","#{description}");
			  }
		  }.toString();
		  
	  }
	  
	  
	  
	  public String updateDept(Dept dept){
		  
		  return new SQL(){
			  {
				  UPDATE("dept_info");
				  if(dept.getName()!=null)
					  SET("name=#{name}");
				  if(dept.getCode()!=null)
					  SET("code=#{code}");
				  if(dept.getCompanyInfo()!=null)
					  SET("companycode=#{companyInfo.id}");
				  if(dept.getDescription()!=null)
					  SET("description=#{description}");
				  WHERE("id=#{id}");
			  }
		  }.toString();
	  }
}
