package com.businessTravel.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.businessTravel.domain.RoleInfo;

public interface RoleDao {

	@Select("select * from role_info where id=#{id}")
	RoleInfo selectById(@Param("id")int id);
	
	@Select("select * from role_info where role=#{role}")
	RoleInfo rgetRoleInfoByName(@Param("role")String role);
}
