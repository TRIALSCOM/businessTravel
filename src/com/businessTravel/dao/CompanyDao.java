package com.businessTravel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.businessTravel.domain.CompanyInfo;

public interface CompanyDao {
     @Select("select * from company_info")
      List<CompanyInfo> selectAll();
     
     @Select("select * from company_info where id=#{id}")
     CompanyInfo selectById(@Param("id")Integer id);
}