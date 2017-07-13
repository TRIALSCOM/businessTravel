package com.businessTravel.util.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class BusinessUtils {

	  public static int daysBetween(Date beginDate,Date endDate) throws ParseException{
		  SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		  endDate=simpleDateFormat.parse(simpleDateFormat.format(endDate));
		  Calendar calendar=Calendar.getInstance();
		  calendar.setTime(endDate);
		  long timeEnd=calendar.getTimeInMillis();
		  beginDate=simpleDateFormat.parse(simpleDateFormat.format(beginDate));
		  calendar.setTime(beginDate);
		  long timeBegin=calendar.getTimeInMillis();
		  long dayBetween=(timeEnd-timeBegin)/(1000*3600*24);
		  return Integer.parseInt(String.valueOf(dayBetween));
		  
	  }
}
