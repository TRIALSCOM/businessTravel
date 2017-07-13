package com.businessTravel.dao;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.mapping.FetchType;

import com.businessTravel.dao.provider.DeptProvider;
import com.businessTravel.domain.Dept;

public interface DeptDao {
   
	@Select("select * from dept_info where id=#{id}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="name",property="name"),
		@Result(column="code",property="code"),
		@Result(column="description",property="description"),
		@Result(column="companycode",property="companyInfo",one=@One(
				select="com.businessTravel.dao.CompanyDao.selectById",fetchType=FetchType.LAZY))	
	})
	Dept selectById(@Param("id")int id);
	
	
	@Select("select * from dept_info ")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="name",property="name"),
		@Result(column="code",property="code"),
		@Result(column="description",property="description"),
		@Result(column="companycode",property="companyInfo",one=@One(
				select="com.businessTravel.dao.CompanyDao.selectById",fetchType=FetchType.LAZY))	
	})
	List<Dept> selectAllDept();

	
	
	@Select("select * from dept_info where id=#{id}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="name",property="name"),
		@Result(column="code",property="code"),
		@Result(column="description",property="description"),
		@Result(column="companycode",property="companyInfo",one=@One(
				select="com.businessTravel.dao.CompanyDao.selectById",fetchType=FetchType.LAZY))	
	})
	Dept selectOneById(@Param("id")Integer id);
	
   @InsertProvider(type=DeptProvider.class,method="saveDept")
   void  saveDept(Dept dept);
	
   
   @UpdateProvider(type=DeptProvider.class,method="updateDept")
   void updateDept(Dept dept);
   
   
}
