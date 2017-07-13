package com.businessTravel.dao.provider;

import org.apache.ibatis.jdbc.SQL;

import com.businessTravel.domain.Attachment;

public class AttachmentProvider {
       public String updateAttachment(Attachment attachment){
    	   
    	   return new SQL(){
    		   {
    			  if(attachment.getFileName()!=null)
                          SET("file_name=#{fileName}");
    			  if(attachment.getFileSize()!=null)
    				   SET("file_type=#{fileType}");
    			  if(attachment.getFileType()!=null)
                       SET("file_size=#{fileSize}");
    			  if(attachment.getFileAddress()!=null)
    				  SET("file_address=#{fileAddress}");
    			  WHERE("id=#{id}");
        		   }
    		   
    	   }.toString();
       }
       
       
       public String insertAttachment(Attachment attachment){   	   
    	   return  new SQL(){
    		   {
    			   INSERT_INTO("attachment_info");
    			  if(attachment.getFileName()!=null){
    				  VALUES("file_name","#{fileName}");
    			  }
    			  if(attachment.getFileSize()!=null)
    				  VALUES("file_size","#{fileSize}");
    			  
    			  if(attachment.getFileAddress()!=null)
    				  VALUES("file_address","#{fileAddress}");
    			  if(attachment.getFileType()!=null)
    				  VALUES("file_type","#{fileType}");
    		   }
    		       
    		   
    	   }.toString();
       }
}
