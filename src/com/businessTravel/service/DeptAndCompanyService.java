package com.businessTravel.service;

import java.util.List;

import com.businessTravel.domain.Dept;
import com.businessTravel.domain.RoleInfo;

public interface DeptAndCompanyService {

	
	public List<Dept> getAllDept();
	
	public Dept getOneDeptById(Integer id);
	
	public RoleInfo getOneRoleByName(String name);
}
