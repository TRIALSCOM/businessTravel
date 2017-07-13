package com.businessTravel.dao.provider;

import org.apache.ibatis.jdbc.SQL;

import com.businessTravel.domain.Employee;

public class EmployeeProvider {

	  public String updateEmployee(Employee employee){
		  
		  return new SQL(){
				  {
					  UPDATE("employee_info");
					  if(employee.getName()!=null)
						  SET("name=#{name}");
					  if(employee.getId()!=null)
						  SET("id=#{id}");
					  if(employee.getSex()!=null)
						  SET("sex=#{sex}");
					  if(employee.getEmployeeNumber()!=null)
						  SET("employee_number=#{employeeNumber}");
					  if(employee.getDept()!=null)
						  SET("department_id=#{dept.id}");
					  if(employee.getRoleInfo()!=null)
						  SET("role_id=#{roleInfo.id}");
					  if(employee.getAttachment()!=null)
						  SET("attachment_id=#{attachment.id}");
					  if(employee.getTel()!=null)
						  SET("tel=#{tel}");
					  if(employee.getPhone()!=null)
						  SET("phone=#{phone}");
					  if(employee.getQqNum()!=null)
						  SET("qq_num=#{qqNum}");
					  if(employee.getEmail()!=null)
						  SET("email=#{email}");
					  if(employee.getParty()!=null)
						  SET("party=#{party}");
					  if(employee.getBirthday()!=null)
						  SET("birthday=#{birthday}");
					  if(employee.getEducation()!=null)
						  SET("education=#{education}");
					  if(employee.getWorkLife()!=null)
						  SET("work_life=#{workLife}");
					  if(employee.getAddress()!=null)
						  SET("address=#{address}");
					  if(employee.getScore()!=null)
						  SET("score=#{score}");
					  if(employee.getPassword()!=null)
						  SET("password=#{password}");
					  if(employee.getBankCard()!=null)
						  SET("bank_card=#{bankCard}");
					  if(employee.getValidateCode()!=null)
						  SET("validate_code=#{validateCode}");
					  if(employee.getRegisterDate()!=null)
						  SET("register_date=#{registerDate}");
					  if(employee.getActiveStatus()!=null)
						  SET("active_status=#{activeStatus}");
					  if(employee.getRealName()!=null)
						  SET("real_name=#{realName}");
					  WHERE("id=#{id}");
				  }
				  
		  } .toString();
	  }
	  
	
	  
	  public String insertIntoEmployee(Employee employee){
		  
		  return new SQL(){
			  {
			 INSERT_INTO("employee_info");
			 if(employee.getName()!=null)
				 VALUES("name","#{name}");
			  if(employee.getId()!=null)
				  VALUES("id", "#{id}");
			  if(employee.getSex()!=null)
				  VALUES("sex","#{sex}");
			  if(employee.getEmployeeNumber()!=null)
				  VALUES("employee_number","#{employeeNumber}");
			  if(employee.getDept()!=null)
				  VALUES("department_id","#{dept.id}");
			  if(employee.getRoleInfo()!=null)
				  VALUES("role_id","#{roleInfo.id}");
			  if(employee.getAttachment()!=null)
				  VALUES("attachment_id","#{attachment.id}");
			  if(employee.getTel()!=null)
				  VALUES("tel","#{tel}");
			  if(employee.getPhone()!=null)
				  VALUES("phone","#{phone}");
			  if(employee.getQqNum()!=null)
				  VALUES("qq_num","#{qqNum}");
			  if(employee.getEmail()!=null)
				  VALUES("email","#{email}");
			  if(employee.getParty()!=null)
				  VALUES("party","#{party}");
			  if(employee.getBirthday()!=null)
				  VALUES("birthday","#{birthday}");
			  if(employee.getEducation()!=null)
				  VALUES("education","#{education}");
			  if(employee.getWorkLife()!=null)
				  VALUES("work_life","#{workLife}");
			  if(employee.getAddress()!=null)
				  VALUES("address","#{address}");
			  if(employee.getScore()!=null)
				  VALUES("score","#{score}");
			  if(employee.getPassword()!=null)
				  VALUES("password","#{password}");
			  if(employee.getBankCard()!=null)
				  VALUES("bank_card","#{bankCard}");
			  if(employee.getValidateCode()!=null)
				  VALUES("validate_code","#{validateCode}");
			  if(employee.getRegisterDate()!=null)
				  VALUES("register_date","#{registerDate}");
			  if(employee.getActiveStatus()!=null)
				  VALUES("active_status","#{activeStatus}");
			  if(employee.getRealName()!=null)
				  VALUES("real_name","#{realName}");
		  } 
			  
		  }.toString();
		  
		  
	  }
	
}
