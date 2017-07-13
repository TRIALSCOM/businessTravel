package com.businessTravel.util.common;


public class EmployeeUtils {
    
	 public static String createEmployeeNumber(int count){
		   String countString=String.valueOf(count+1);
		while(countString.length()<6){
			countString="0"+countString;
			
		}  
		  return countString;
		  
	  }
	
	
}
