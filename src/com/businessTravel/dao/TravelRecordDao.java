package com.businessTravel.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.mapping.FetchType;

import com.businessTravel.dao.provider.TravelRecordProvider;
import com.businessTravel.domain.TravelRecord;

public interface TravelRecordDao {

	//得到个人的所有出差记录
	  @Select("select * from travel_info where employee_id =#{employeeId}")
	  @Results(
			  {
				  @Result(id=true,column="id",property="id"),
				  @Result(column="employee_id",property="employee",one=@One(
						  select="com.businessTravel.dao.EmployeeDao.getOneById",fetchType=FetchType.EAGER)),
				  @Result(column="applying_funding",property="applyingFunding"),
				  @Result(column="additional_funding",property="additionalFunding"),
				  @Result(column="cost_description",property="costDescription"),
				  @Result(column="advance_funding",property="advanceFunding"),
				  @Result(column="all_funding",property="allFunding"),
				  @Result(column="travel_begin_date",property="travelBeginDate"),
				  @Result(column="travel_end_date",property="travelEndDate"),
				  @Result(column="days_count",property="daysCount"),
				  @Result(column="travel_address",property="travelAddress"),
				  @Result(column="travel_reason",property="travelReason"),
				  
		//待修复
			  //   @Result(column="consumption_id",property="costDetail",one=@One(
			 //    		select="com.businessTravel.dao.CostDetailDao.selectOneById",fetchType=FetchType.EAGER)),
			    
				@Result(column="review_status_id",property="reviewStatus",one=@One(
						select="com.businessTravel.dao.ReviewStatusDao.selectById",fetchType=FetchType.EAGER)) ,
				
				@Result(column="begin_place",property="beginPlace"),
				@Result(column="end_place",property="endPlace"),
				@Result(column="review_begin_end",property="reviewBeginEnd"),
				@Result(column="attachment_id",property="attachment" ,one=@One(
						select="com.businessTravel.dao.AttachmentDao.getOneById",fetchType=FetchType.EAGER))
				  
			   }			  
			  )  
	  List<TravelRecord> getAllByEmployeeId(@Param("employeeId")Integer employeeId);
	 
	  
	  
	  
	  
     
	  
	  
	  //得到个人的所有已经经过评审的出差记录
	  @Select("select * from travel_info where employee_id =#{employeeId} and review_begin_end=-1 ")
	  @Results(
			  {
				  @Result(id=true,column="id",property="id"),
				  @Result(column="employee_id",property="employee",one=@One(
						  select="com.businessTravel.dao.EmployeeDao.getOneById",fetchType=FetchType.EAGER)),
				  @Result(column="applying_funding",property="applyingFunding"),
				  @Result(column="additional_funding",property="additionalFunding"),
				  @Result(column="cost_description",property="costDescription"),
				  @Result(column="advance_funding",property="advanceFunding"),
				  @Result(column="all_funding",property="allFunding"),
				  @Result(column="travel_begin_date",property="travelBeginDate"),
				  @Result(column="travel_end_date",property="travelEndDate"),
				  @Result(column="days_count",property="daysCount"),
				  @Result(column="travel_address",property="travelAddress"),
				  @Result(column="travel_reason",property="travelReason"),
				  
		//待修复
			  //   @Result(column="consumption_id",property="costDetail",one=@One(
			 //    		select="com.businessTravel.dao.CostDetailDao.selectOneById",fetchType=FetchType.EAGER)),
			    
				@Result(column="review_status_id",property="reviewStatus",one=@One(
						select="com.businessTravel.dao.ReviewStatusDao.selectById",fetchType=FetchType.EAGER)) ,
				
				@Result(column="begin_place",property="beginPlace"),
				@Result(column="end_place",property="endPlace"),
				@Result(column="review_begin_end",property="reviewBeginEnd"),
				@Result(column="attachment_id",property="attachment" ,one=@One(
						select="com.businessTravel.dao.AttachmentDao.getOneById",fetchType=FetchType.EAGER))
				  
			   }			  
			  )  
	  List<TravelRecord> getAllVerifiedByEmployeeId(@Param("employeeId")Integer employeeId);
	  
	  @Select("select * from travel_info where id=#{id}")
	  @Results(
			  {
				  @Result(id=true,column="id",property="id"),
				  @Result(column="employee_id",property="employee",one=@One(
						  select="com.businessTravel.dao.EmployeeDao.getOneById",fetchType=FetchType.EAGER)),
				  @Result(column="applying_funding",property="applyingFunding"),
				  @Result(column="additional_funding",property="additionalFunding"),
				  @Result(column="advance_funding",property="advanceFunding"),
				  @Result(column="all_funding",property="allFunding"),
				  @Result(column="cost_description",property="costDescription"),
				  @Result(column="travel_begin_date",property="travelBeginDate"),
				  @Result(column="travel_end_date",property="travelEndDate"),
				  @Result(column="days_count",property="daysCount"),
				  @Result(column="travel_address",property="travelAddress"),
				  @Result(column="travel_reason",property="travelReason"),
				  
		//待修复
			  //   @Result(column="consumption_id",property="costDetail",one=@One(
			 //    		select="com.businessTravel.dao.CostDetailDao.selectOneById",fetchType=FetchType.EAGER)),
			    
				@Result(column="review_status_id",property="reviewStatus",one=@One(
						select="com.businessTravel.dao.ReviewStatusDao.selectById",fetchType=FetchType.EAGER)),
				
				@Result(column="begin_place",property="beginPlace"),
				@Result(column="end_place",property="endPlace"),
				@Result(column="review_begin_end",property="reviewBeginEnd"),
				@Result(column="attachment_id",property="attachment" ,one=@One(
						select="com.businessTravel.dao.AttachmentDao.getOneById",fetchType=FetchType.EAGER))
			   }			  
			  )  
	  TravelRecord getOneById(@Param("id")Integer id);
	  
	  @InsertProvider(type=TravelRecordProvider.class,method="saveOneTravelRecord")
	  void saveOneRecord(TravelRecord travelRecord);

	  
	   
	  @UpdateProvider(type=TravelRecordProvider.class,method="updateTravelRecord")
	  void updateRecord(TravelRecord travelRecord);
	  
	  //得到该用户的所有未申请审核的记录
	  @Select("select * from travel_info where employee_id =#{employeeId} and review_begin_end=0 ")
	  @Results(
			  {
				  @Result(id=true,column="id",property="id"),
				  @Result(column="employee_id",property="employee",one=@One(
						  select="com.businessTravel.dao.EmployeeDao.getOneById",fetchType=FetchType.EAGER)),
				  @Result(column="applying_funding",property="applyingFunding"),
				  @Result(column="additional_funding",property="additionalFunding"),
				  @Result(column="advance_funding",property="advanceFunding"),
				  @Result(column="all_funding",property="allFunding"),
				  @Result(column="travel_begin_date",property="travelBeginDate"),
				  @Result(column="cost_description",property="costDescription"),
				  @Result(column="travel_end_date",property="travelEndDate"),
				  @Result(column="days_count",property="daysCount"),
				  @Result(column="travel_address",property="travelAddress"),
				  @Result(column="travel_reason",property="travelReason"),
				  
		//待修复
			  //   @Result(column="consumption_id",property="costDetail",one=@One(
			 //    		select="com.businessTravel.dao.CostDetailDao.selectOneById",fetchType=FetchType.EAGER)),
			    
				@Result(column="review_status_id",property="reviewStatus",one=@One(
						select="com.businessTravel.dao.ReviewStatusDao.selectById",fetchType=FetchType.EAGER)),
				
				@Result(column="begin_place",property="beginPlace"),
				@Result(column="end_place",property="endPlace"),
				@Result(column="review_begin_end",property="reviewBeginEnd"),
				@Result(column="attachment_id",property="attachment" ,one=@One(
						select="com.businessTravel.dao.AttachmentDao.getOneById",fetchType=FetchType.EAGER))
			   }			  
			  )  
	  TravelRecord getOneUnApplyByEmployeeId(@Param("employeeId") Integer employeeId);
	  
	  
	  
	  //得到该用户的所有正在审核的项目
	  @Select("select * from travel_info where employee_id =#{employeeId} and review_begin_end='1' ")
	  @Results(
			  {
				  @Result(id=true,column="id",property="id"),
				  @Result(column="employee_id",property="employee",one=@One(
						  select="com.businessTravel.dao.EmployeeDao.getOneById",fetchType=FetchType.EAGER)),
				  @Result(column="applying_funding",property="applyingFunding"),
				  @Result(column="additional_funding",property="additionalFunding"),
				  @Result(column="advance_funding",property="advanceFunding"),
				  @Result(column="all_funding",property="allFunding"),
				  @Result(column="travel_begin_date",property="travelBeginDate"),
				  @Result(column="travel_end_date",property="travelEndDate"),
				  @Result(column="cost_description",property="costDescription"),
				  @Result(column="days_count",property="daysCount"),
				  @Result(column="travel_address",property="travelAddress"),
				  @Result(column="travel_reason",property="travelReason"),
				  
		//待修复
			  //   @Result(column="consumption_id",property="costDetail",one=@One(
			 //    		select="com.businessTravel.dao.CostDetailDao.selectOneById",fetchType=FetchType.EAGER)),
			    
				@Result(column="review_status_id",property="reviewStatus",one=@One(
						select="com.businessTravel.dao.ReviewStatusDao.selectById",fetchType=FetchType.EAGER)),
				
				@Result(column="begin_place",property="beginPlace"),
				@Result(column="end_place",property="endPlace"),
				@Result(column="review_begin_end",property="reviewBeginEnd"),
				@Result(column="attachment_id",property="attachment" ,one=@One(
						select="com.businessTravel.dao.AttachmentDao.getOneById",fetchType=FetchType.EAGER))
			   }			  
			  )  
	   
	  TravelRecord getOneUnFinshByEmployeeId(@Param("employeeId")Integer employeeId);	
	  
	  
	  
	  
	  //得到所有处于审核状态中的记录
	  @Select("select * from travel_info where review_begin_end='1' ")
	
	  @Results(
			  {
				  @Result(id=true,column="id",property="id"),
				  @Result(column="employee_id",property="employee",one=@One(
						  select="com.businessTravel.dao.EmployeeDao.getOneById",fetchType=FetchType.EAGER)),
				  @Result(column="applying_funding",property="applyingFunding"),
				  @Result(column="additional_funding",property="additionalFunding"),
				  @Result(column="advance_funding",property="advanceFunding"),
				  @Result(column="all_funding",property="allFunding"),
				  @Result(column="travel_begin_date",property="travelBeginDate"),
				  @Result(column="travel_end_date",property="travelEndDate"),
				  @Result(column="cost_description",property="costDescription"),
				  @Result(column="days_count",property="daysCount"),
				  @Result(column="travel_address",property="travelAddress"),
				  @Result(column="travel_reason",property="travelReason"),
				  
		//待修复
			  //   @Result(column="consumption_id",property="costDetail",one=@One(
			 //    		select="com.businessTravel.dao.CostDetailDao.selectOneById",fetchType=FetchType.EAGER)),
			    
				@Result(column="review_status_id",property="reviewStatus",one=@One(
						select="com.businessTravel.dao.ReviewStatusDao.selectById",fetchType=FetchType.EAGER)),
				
				@Result(column="begin_place",property="beginPlace"),
				@Result(column="end_place",property="endPlace"),
				@Result(column="review_begin_end",property="reviewBeginEnd"),
				@Result(column="attachment_id",property="attachment" ,one=@One(
						select="com.businessTravel.dao.AttachmentDao.getOneById",fetchType=FetchType.EAGER))
			   }			  
			  )  
	  List<TravelRecord> getAllRecordUnFinshed();
	  
	  
	  
	  
	  
	  @Select("select * from travel_info where employee_id =#{employeeId} and review_begin_end='-1' ")
	  @Results(
			  {
				  @Result(id=true,column="id",property="id"),
				  @Result(column="employee_id",property="employee",one=@One(
						  select="com.businessTravel.dao.EmployeeDao.getOneById",fetchType=FetchType.EAGER)),
				  @Result(column="applying_funding",property="applyingFunding"),
				  @Result(column="additional_funding",property="additionalFunding"),
				  @Result(column="advance_funding",property="advanceFunding"),
				  @Result(column="all_funding",property="allFunding"),
				  @Result(column="travel_begin_date",property="travelBeginDate"),
				  @Result(column="travel_end_date",property="travelEndDate"),
				  @Result(column="cost_description",property="costDescription"),
				  @Result(column="days_count",property="daysCount"),
				  @Result(column="travel_address",property="travelAddress"),
				  @Result(column="travel_reason",property="travelReason"),
				  
		//待修复
			  //   @Result(column="consumption_id",property="costDetail",one=@One(
			 //    		select="com.businessTravel.dao.CostDetailDao.selectOneById",fetchType=FetchType.EAGER)),
			    
				@Result(column="review_status_id",property="reviewStatus",one=@One(
						select="com.businessTravel.dao.ReviewStatusDao.selectById",fetchType=FetchType.EAGER)),
				
				@Result(column="begin_place",property="beginPlace"),
				@Result(column="end_place",property="endPlace"),
				@Result(column="review_begin_end",property="reviewBeginEnd"),
				@Result(column="attachment_id",property="attachment" ,one=@One(
						select="com.businessTravel.dao.AttachmentDao.getOneById",fetchType=FetchType.EAGER))
			   }			  
			  )
	 List<TravelRecord> selectAllFinished(@Param("employeeId")Integer employeeId);
	  
	  
	//查询所有审核完毕的记录
	  @Select("select * from travel_info where review_begin_end='-1' ")
	  
	  @Results(
			  {
				  @Result(id=true,column="id",property="id"),
				  @Result(column="employee_id",property="employee",one=@One(
						  select="com.businessTravel.dao.EmployeeDao.getOneById",fetchType=FetchType.EAGER)),
				  @Result(column="applying_funding",property="applyingFunding"),
				  @Result(column="additional_funding",property="additionalFunding"),
				  @Result(column="advance_funding",property="advanceFunding"),
				  @Result(column="all_funding",property="allFunding"),
				  @Result(column="travel_begin_date",property="travelBeginDate"),
				  @Result(column="travel_end_date",property="travelEndDate"),
				  @Result(column="cost_description",property="costDescription"),
				  @Result(column="days_count",property="daysCount"),
				  @Result(column="travel_address",property="travelAddress"),
				  @Result(column="travel_reason",property="travelReason"),
				  
		//待修复
			  //   @Result(column="consumption_id",property="costDetail",one=@One(
			 //    		select="com.businessTravel.dao.CostDetailDao.selectOneById",fetchType=FetchType.EAGER)),
			    
				@Result(column="review_status_id",property="reviewStatus",one=@One(
						select="com.businessTravel.dao.ReviewStatusDao.selectById",fetchType=FetchType.EAGER)),
				
				@Result(column="begin_place",property="beginPlace"),
				@Result(column="end_place",property="endPlace"),
				@Result(column="review_begin_end",property="reviewBeginEnd"),
				@Result(column="attachment_id",property="attachment" ,one=@One(
						select="com.businessTravel.dao.AttachmentDao.getOneById",fetchType=FetchType.EAGER))
			   }			  
			  )
	  List<TravelRecord> getTravelRecordsAlreadyVerified();
	  
	  
	  
	  //查询所有已经进入评审或者评审完成的记录
  @Select("select * from travel_info where review_begin_end !='0' ")
	  
	  @Results(
			  {
				  @Result(id=true,column="id",property="id"),
				  @Result(column="employee_id",property="employee",one=@One(
						  select="com.businessTravel.dao.EmployeeDao.getOneById",fetchType=FetchType.EAGER)),
				  @Result(column="applying_funding",property="applyingFunding"),
				  @Result(column="additional_funding",property="additionalFunding"),
				  @Result(column="advance_funding",property="advanceFunding"),
				  @Result(column="all_funding",property="allFunding"),
				  @Result(column="travel_begin_date",property="travelBeginDate"),
				  @Result(column="travel_end_date",property="travelEndDate"),
				  @Result(column="cost_description",property="costDescription"),
				  @Result(column="days_count",property="daysCount"),
				  @Result(column="travel_address",property="travelAddress"),
				  @Result(column="travel_reason",property="travelReason"),
				  
		//待修复
			  //   @Result(column="consumption_id",property="costDetail",one=@One(
			 //    		select="com.businessTravel.dao.CostDetailDao.selectOneById",fetchType=FetchType.EAGER)),
			    
				@Result(column="review_status_id",property="reviewStatus",one=@One(
						select="com.businessTravel.dao.ReviewStatusDao.selectById",fetchType=FetchType.EAGER)),
				
				@Result(column="begin_place",property="beginPlace"),
				@Result(column="end_place",property="endPlace"),
				@Result(column="review_begin_end",property="reviewBeginEnd"),
				@Result(column="attachment_id",property="attachment" ,one=@One(
						select="com.businessTravel.dao.AttachmentDao.getOneById",fetchType=FetchType.EAGER))
			   }			  
			  )
	  List<TravelRecord> getTravelRecordsWithReview();
	  
	  
	  
	   @Select("select DISTINCT employee_id from travel_info where review_begin_end=-1 ")
	   List<Integer> getEmployeeIdHaveTravel();
		  
	   
	   @Select("select DISTINCT end_place from  travel_info where employee_id=#{employeeId} ")
	   List<String> getEmployeeTravelPlace(@Param("employeeId")Integer employeeId);
	   
	   @Select("select count(*) from travel_info where employee_id=#{employeeId} ")
	   Integer  getRecordCountOfOneEmployee(@Param("employeeId")Integer employeeId);
	   
}
