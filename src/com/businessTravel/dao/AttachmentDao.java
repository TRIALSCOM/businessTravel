package com.businessTravel.dao;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import com.businessTravel.dao.provider.AttachmentProvider;
import com.businessTravel.domain.Attachment;

public interface AttachmentDao {
     @Select("select * from attachment_info where id=#{id}")
     @Results(
    		 {
    			 @Result(id=true,column="id",property="id"),
    			 @Result(column="file_name",property="fileName"),
    			 @Result(column="file_type",property="fileType"),
    			 @Result(column="file_size",property="fileSize"),
    			 @Result(column="file_address",property="fileAddress")   			   			
    		 }    		 
    	 )
     
     Attachment getOneById(@Param("id") Integer id);
     
     
     @UpdateProvider(type=AttachmentProvider.class,method="updateAttachment")
     void updateAttachment(Attachment attachment);
    
     @InsertProvider(type=AttachmentProvider.class,method="insertAttachment")
     void insertAttachment(Attachment attachment);
   
     
     @Select("select * from attachment_info where file_name=#{fileName}")
     @Results(
    		 {
    			 @Result(id=true,column="id",property="id"),
    			 @Result(column="file_name",property="fileName"),
    			 @Result(column="file_type",property="fileType"),
    			 @Result(column="file_size",property="fileSize"),
    			 @Result(column="file_address",property="fileAddress")   			   			
    		 }    		 
    	 )
     Attachment getOneByName(@Param("fileName")String fileName);
}
