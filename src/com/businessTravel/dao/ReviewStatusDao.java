package com.businessTravel.dao;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import com.businessTravel.domain.ReviewStatus;

public interface ReviewStatusDao {
    @Select("select * from review_status where id=#{id}")
    @Results(
    		{
    		@Result(id=true,column="id",property="id"),
    		@Result(column="review_role_id",property="roleInfo",one=@One(
    				select="com.businessTravel.dao.RoleDao.selectById",fetchType=FetchType.EAGER)),    		
    		@Result(column="review_order",property="reviewOrder"),
    		@Result(column="department_id",property="dept",one=@One(
    				select="com.businessTravel.dao.DeptDao.selectById",fetchType=FetchType.EAGER))
    		}
    		)
    ReviewStatus  selectById(@Param("id")Integer id);
    
    
    @Select("select * from review_status where review_order=#{reviewOrder} and department_id=#{deptId}")
    @Results(
    		{
    		@Result(id=true,column="id",property="id"),
    		@Result(column="review_role_id",property="roleInfo",one=@One(
    				select="com.businessTravel.dao.RoleDao.selectById",fetchType=FetchType.EAGER)),    		
    		@Result(column="review_order",property="reviewOrder"),
    		@Result(column="department_id",property="dept",one=@One(
    				select="com.businessTravel.dao.DeptDao.selectById",fetchType=FetchType.EAGER)) 
    		}
    		)
    ReviewStatus selectByOrderAndDeptId(@Param("reviewOrder")Integer reviewOrder,@Param("deptId")Integer deptId); 
    
    
    
    @Select("select count(*) from review_status where department_id=#{deptId}")
      Integer getCountInDept(@Param("deptId")Integer deptId);
    
    
    @Select("select * from review_status where review_role_id=#{roleId} and department_id=#{deptId}")
    @Results(
    		{
    		@Result(id=true,column="id",property="id"),
    		@Result(column="review_role_id",property="roleInfo",one=@One(
    				select="com.businessTravel.dao.RoleDao.selectById",fetchType=FetchType.EAGER)),    		
    		@Result(column="review_order",property="reviewOrder"),
    		@Result(column="department_id",property="dept",one=@One(
    				select="com.businessTravel.dao.DeptDao.selectById",fetchType=FetchType.EAGER)) 
    		}
    		)
    ReviewStatus getReviewStatusByDeptAndRole(@Param("roleId")Integer roleId,@Param("deptId")Integer deptId);
}
