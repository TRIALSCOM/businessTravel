package com.businessTravel.service.serviceImpl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.businessTravel.dao.DeptDao;
import com.businessTravel.dao.EmployeeDao;
import com.businessTravel.dao.HotelBookingDao;
import com.businessTravel.dao.TicketBookingDao;
import com.businessTravel.dao.TravelRecordDao;
import com.businessTravel.domain.Dept;
import com.businessTravel.domain.Employee;
import com.businessTravel.domain.HotelBooking;
import com.businessTravel.domain.TicketBooking;
import com.businessTravel.domain.TravelRecord;
import com.businessTravel.service.TravelService;
import com.businessTravel.viewObject.PdfViewObject;

@Service
public class TravelServiceImpl implements TravelService{
      @Autowired
      private EmployeeDao employeeDao;
      @Autowired
      private TravelRecordDao travelRecordDao;
      
      @Autowired 
      private  TicketBookingDao ticketBookingDao;
      
      @Autowired
      private HotelBookingDao hotelBookingDao;
      
      @Autowired
      private DeptDao deptDao;
      
	@Override
	public List<TravelRecord> getOneByEmployeeId(Integer employeeId) {
		// TODO Auto-generated method stub
		return travelRecordDao.getAllByEmployeeId(employeeId);
	}
	
	
	@Override
	public PdfViewObject getOnePdfViewObject(Employee employee) {
		// TODO Auto-generated method stub
		PdfViewObject pdfViewObject=new PdfViewObject();
		pdfViewObject.setUserName(employee.getName());
		
		TravelRecord travelRecord=travelRecordDao.getOneUnFinshByEmployeeId(employee.getId());
		pdfViewObject.setDaysCount(travelRecord.getDaysCount());
		
		List<TicketBooking> ticketBookingList=ticketBookingDao.getAllByTravelRecordId(travelRecord.getId());
		
		/*for(TicketBooking ticketBooking:ticketBookingList){
			  int cost=Integer.parseInt(ticketBooking.getEndStation().getCostFromStart())
					                -Integer.parseInt(ticketBooking.getBeginStation().getCostFromStart());
			  ticketBooking.setTotalCost(String.valueOf(cost));
			
		}
		*/
		int totalTicketCost=0; 
		for(TicketBooking ticketBooking:ticketBookingList){
			totalTicketCost+=Integer.parseInt(ticketBooking.getTotalCost());
		}
		pdfViewObject.setTicketCost(String.valueOf(totalTicketCost));
		
	
		
		
		pdfViewObject.setTicketBookingList(ticketBookingList);
		
		
		List<HotelBooking> hotelBookingList=hotelBookingDao.getAllByRecordId(travelRecord.getId()); 
		
		int totalHotelCost=0;
		for(HotelBooking hotelBooking:hotelBookingList){
			totalHotelCost+=Integer.parseInt(hotelBooking.getTotalCost());
		}
		
		pdfViewObject.setHotelCost(String.valueOf(totalHotelCost));
		pdfViewObject.setHotelBookingList(hotelBookingList);
		
		
		pdfViewObject.setAllCost(String.valueOf(totalHotelCost+totalTicketCost));
				
		return pdfViewObject;
	}
      

	@Override
	public PdfViewObject getDetailInfoByRecordId(Integer id) {
		// TODO Auto-generated method stub
		PdfViewObject pdfViewObject=new PdfViewObject();
	//	pdfViewObject.setUserName(employee.getName());
		
	    TravelRecord travelRecord=travelRecordDao.getOneById(id);	
	    pdfViewObject.setTravelBeginDate(travelRecord.getTravelBeginDate());
		pdfViewObject.setDaysCount(travelRecord.getDaysCount());
		pdfViewObject.setUserName(travelRecord.getEmployee().getName());
		
		List<TicketBooking> ticketBookingList=ticketBookingDao.getAllByTravelRecordId(travelRecord.getId());
		
		/*for(TicketBooking ticketBooking:ticketBookingList){
			  int cost=Integer.parseInt(ticketBooking.getEndStation().getCostFromStart())
					                -Integer.parseInt(ticketBooking.getBeginStation().getCostFromStart());
			  ticketBooking.setTotalCost(String.valueOf(cost));
			
		}
		*/
		int totalTicketCost=0; 
		for(TicketBooking ticketBooking:ticketBookingList){
			totalTicketCost+=Integer.parseInt(ticketBooking.getTotalCost());
		}
		pdfViewObject.setTicketCost(String.valueOf(totalTicketCost));
		
		
		pdfViewObject.setTicketBookingList(ticketBookingList);
		
		
		List<HotelBooking> hotelBookingList=hotelBookingDao.getAllByRecordId(travelRecord.getId()); 
		
		int totalHotelCost=0;
		for(HotelBooking hotelBooking:hotelBookingList){
			totalHotelCost+=Integer.parseInt(hotelBooking.getTotalCost());
		}
		
		pdfViewObject.setHotelCost(String.valueOf(totalHotelCost));
		pdfViewObject.setHotelBookingList(hotelBookingList);
		
		pdfViewObject.setAllCost(String.valueOf(totalHotelCost+totalTicketCost));
				
		return pdfViewObject;
	}


	@Override
	public String getDateJson(Employee employee) {
		// TODO Auto-generated method stub
	//	String dataJson="";
	   if(employee==null)
		   return null;
	   
	   String dataJson="{";
	   List<TravelRecord> travelRecords;
	   String categories="\"categories\":[";
	   String cishu="\"cishu\":[";
	   String jifen="\"jifen\":[";
	   
	  List<Integer> employeeIds;
	   int count;
	//   if(employee.getRoleInfo()!=null){
		if(employee.getRoleInfo()!=null&&("总经理".equals(employee.getRoleInfo().getRole())||"系统管理员".equals(employee.getRoleInfo().getRole()))){
			
			employeeIds=travelRecordDao.getEmployeeIdHaveTravel();
			int numberCount=0;
			for(Integer employeeId:employeeIds){
			
				 Employee user=employeeDao.getOneActiveEmployeeById(employeeId);
				 count=travelRecordDao.getRecordCountOfOneEmployee(employeeId);
				 if(numberCount==employeeIds.size()-1)
				 {
					 categories+="\""+user.getName()+"\"";
					 cishu+=""+count+"";
					 if(user.getScore()!=null)
					  jifen+=""+user.getScore()+"";
					 else 
					   jifen+="0";
					
				 }
				 else
				 {
					 categories+="\""+user.getName()+"\",";
					 cishu+=""+count+",";
					 if(user.getScore()!=null)
					    jifen+=""+user.getScore()+",";
					 else
						 jifen+="0,";
				 }
				
				numberCount++;
				
			   }	
			}
		
			/*travelRecords=travelRecordDao.getTravelRecordsAlreadyVerified();
			
			for(TravelRecord travelRecord:travelRecords)
			{
				//dataJson+="'categories':['"+;
				categories+="'"+travelRecord.getEmployee().getName()+"'";
				cishu+="";
			}*/
			
	//	}
	else if(employee.getRoleInfo()!=null&&"部门经理".equals(employee.getRoleInfo().getRole())){
			
			
			
			/*travelRecords=travelRecordDao.getTravelRecordsAlreadyVerified();
			Iterator<TravelRecord> it=travelRecords.iterator();
			while(it.hasNext()){
				if(it.next().getEmployee().getDept().getId()!=employee.getId()){
					it.remove();
				}
				
			}*/
			
			employeeIds=travelRecordDao.getEmployeeIdHaveTravel();
			int numberCount=0;
			for(Integer employeeId:employeeIds){
				  Employee user=employeeDao.getOneActiveEmployeeById(employeeId);
			  //  if(employeeId==employee.getId().intValue())
				  if(user.getDept().getId()==employee.getDept().getId())
			    { 
			     //  Employee user=employeeDao.getOneActiveEmployeeById(employeeId);
				   count=travelRecordDao.getRecordCountOfOneEmployee(employeeId);
				   if(numberCount==employeeIds.size()-1)
				 {
					 categories+="\""+user.getName()+"\"";
					 cishu+=""+count+"";
					 jifen+=""+user.getScore()+"";
				 }
				 else
				 {
					 categories+="\""+user.getName()+"\",";
					 cishu+=""+count+",";
					 jifen+=""+user.getScore()+",";
				 }
				
				
				 
			    }
				numberCount++;
	    }
		}else {
		
			//travelRecords=travelRecordDao.getAllVerifiedByEmployeeId(employee.getId());
			 
			     count=travelRecordDao.getRecordCountOfOneEmployee(employee.getId());			 
				 categories+="\""+employee.getName()+"\"";
				 cishu+=""+count+"";
				 if(employee.getScore()!=null)
				     jifen+=""+employee.getScore()+"";
				 else
					 jifen+="0";
			
						
		}
	  // }
	
		categories+="],";
		cishu+="],";
		jifen+="]";
		dataJson+=categories+cishu+jifen;		
		dataJson+="}";
		return dataJson;
	}


	@Override
	public String getPieDataJson(Employee employee) {
		// TODO Auto-generated method stub
		List<TravelRecord>travelRecords=travelRecordDao.getAllVerifiedByEmployeeId(employee.getId());
		List<String>endPlaces=travelRecordDao.getEmployeeTravelPlace(employee.getId());
		int [] counts=new int[endPlaces.size()];
		for(int i=0;i<counts.length;i++){
			counts[i]=0;
		}
		
		
		Map<String,Integer> endPlaceAndCount=new HashMap<>();
		
		for(TravelRecord travelRecord:travelRecords){
			
			int index=endPlaces.indexOf(travelRecord.getEndPlace());
			
			if(index!=-1){
				 counts[index]++;				
			}
				
			
		}
		
		
		String pieDataJson="{ \"value\" :[ ";
		//String valueDataJson=
		for(int i=0;i<counts.length;i++){
			if(i==counts.length-1){
				pieDataJson+=counts[i]+"],";
			}else
			{
			pieDataJson+=counts[i]+",";
			}
			
		}
		pieDataJson+="\"name\":[";
		int n=0;
		for(String city:endPlaces){
			if(n==endPlaces.size()-1)
			   pieDataJson+="\""+city+"\" ]";
			else{
			pieDataJson+="\""+city+"\",";
			}
			n++;
			 
		}
		
		pieDataJson+="}";
		
		  return pieDataJson;
	}


	
	@Override
	public String getCostDetailJson(Employee employee, String identy,Integer monthOrYear) {
		// TODO Auto-generated method stub
		if(employee==null)
			return null;
	 String dataJson="{";
     List<TravelRecord> travelRecords;
     String categories="\"categories\":[";
     String cost="\"cost\":[";
     List<Integer> employeeIds;
     List<Integer> deptIds=new ArrayList<>();
     Map<Integer,Integer>deptCost=new HashMap<>();
     Map<Integer,Integer>employeeCost=new HashMap<>();
		  if(employee.getRoleInfo()!=null){
			  
			     if("总经理".equals(employee.getRoleInfo().getRole())){
			    	 
			    	 travelRecords=travelRecordDao.getTravelRecordsAlreadyVerified(); 
			    	  if("月份".equals(identy)){
			    		    Iterator<TravelRecord> it=travelRecords.iterator();
			    		    while(it.hasNext()){
			    		    	 TravelRecord temp=it.next();
			    		    	  Date date=temp.getTravelBeginDate();
			    		    	  Calendar calendar=Calendar.getInstance();
			    		    	  calendar.setTime(date);
			    		    	  System.out.println(calendar.get(Calendar.MONTH));
			    		    	  if((calendar.get(Calendar.MONTH)+1)!=monthOrYear)
			    		    	  {		    		    		  
			    		    		     it.remove();			    		    		  
			    		    	  }else{
			    		    		   if(!deptCost.containsKey(temp.getEmployee().getDept().getId())){			    		    			      
			    		    	           
			    		    			  // deptIds.add(temp.getEmployee().getDept().getId()); 
			    		    	           
			    		    	         /*  if(deptCost.get(temp.getEmployee().getDept().getId())!=null)
			    		    	           {
			    		    	        	   deptCost.put(temp.getEmployee().getDept().getId(),
			    		    	        			   deptCost.get(temp.getEmployee().getDept().getId())
			    		    	        			   +temp.getAllFunding()==null?0:Integer.parseInt(temp.getAllFunding())
			    		    	        					   +temp.getAdvanceFunding()==null?0:Integer.parseInt(temp.getAdvanceFunding()));			    		    	        	   
			    		    	           }else{*/
			    		    	        	    
			    		    	         deptCost.put(temp.getEmployee().getDept().getId(), temp.getAllFunding()==null||"".equals(temp.getAllFunding())?0:Integer.parseInt(temp.getAllFunding())
			    		    	        					   +temp.getAdvanceFunding()==null||"".equals(temp.getAdvanceFunding())?0:Integer.parseInt(temp.getAdvanceFunding()));
			    		    	        	   	    	        	   
			    		    	          // }
			    		    		}else{
			    		    			
			    		    			if(deptCost.get(temp.getEmployee().getDept().getId())!=null)
			    		    	           {
			    		    				
			    		    				int cost1=0;
			    		    				int cost2=0;
			    		    				if(temp.getAllFunding()!=null&&!"".equals(temp.getAllFunding())){
			    		    					cost1=Integer.parseInt(temp.getAllFunding());
			    		    				}
			    		    				if(temp.getAdvanceFunding()!=null&&!"".equals(temp.getAdvanceFunding())){
			    		    					cost2=Integer.parseInt(temp.getAdvanceFunding());
			    		    				}
			    		    				int cost3=  deptCost.get(temp.getEmployee().getDept().getId());
			    		    				
			    		    				deptCost.put(temp.getEmployee().getDept().getId(),cost1+cost2+cost3);
			    		    				
			    		    	        	 /*  deptCost.put(temp.getEmployee().getDept().getId(),
			    		    	        			   deptCost.get(temp.getEmployee().getDept().getId())
			    		    	        			   +(temp.getAllFunding()==null||"".equals(temp.getAllFunding())?0:Integer.parseInt(temp.getAllFunding()))
			    		    	        					   +(temp.getAdvanceFunding()==null||"".equals(temp.getAdvanceFunding())?0:Integer.parseInt(temp.getAdvanceFunding())));			    		   */ 	        	   
			    		    	           }
			    		    			
			    		    		}
			    		    		  
			    		    	}			    	 	  
			    		   }
			          		  
			    		    
			    		    
			       }else if("年份".equals(identy)){
			    		 
			    		  
			    		
			    	   Iterator<TravelRecord> it=travelRecords.iterator();
		    		    while(it.hasNext()){
		    		    	  TravelRecord temp=it.next();
		    		    	  Date date=temp.getTravelBeginDate();
		    		    	  Calendar calendar=Calendar.getInstance();
		    		    	  calendar.setTime(date);
		    		    	  if(calendar.get(Calendar.YEAR)!=monthOrYear)
		    		    	  {		    		    		  
		    		    		     it.remove();			    		    		  
		    		    	  }else{
		    		    		  if(!deptCost.containsKey(temp.getEmployee().getDept().getId())){
		    		    			//  deptIds.add(temp.getEmployee().getDept().getId()); 
		    		    	           
			    		    	         /*if(deptCost.get(temp.getEmployee().getDept().getId())!=null)
			    		    	           {
			    		    	        	   deptCost.put(temp.getEmployee().getDept().getId(),
			    		    	        			   deptCost.get(temp.getEmployee().getDept().getId())
			    		    	        			   +temp.getAllFunding()==null?0:Integer.parseInt(temp.getAllFunding())
			    		    	        					   +temp.getAdvanceFunding()==null?0:Integer.parseInt(temp.getAdvanceFunding()));			    		    	        	   
			    		    	           }else{*/
			    		    	        	    
			    		    	         deptCost.put(temp.getEmployee().getDept().getId(), temp.getAllFunding()==null||"".equals(temp.getAllFunding())?0:Integer.parseInt(temp.getAllFunding())
			    		    	        					   +temp.getAdvanceFunding()==null||"".equals(temp.getAdvanceFunding())?0:Integer.parseInt(temp.getAdvanceFunding()));
		    		    			 
			    		    	         
		    		    		  }else{
		    		    			  
		    		    			  if(deptCost.get(temp.getEmployee().getDept().getId())!=null)
		    		    	           {
		    		    				    int cost1=0;
			    		    				int cost2=0;
			    		    				if(temp.getAllFunding()!=null&&!"".equals(temp.getAllFunding())){
			    		    					cost1=Integer.parseInt(temp.getAllFunding());
			    		    				}
			    		    				if(temp.getAdvanceFunding()!=null&&!"".equals(temp.getAdvanceFunding())){
			    		    					cost2=Integer.parseInt(temp.getAdvanceFunding());
			    		    				}
			    		    				int cost3=  deptCost.get(temp.getEmployee().getDept().getId());
			    		    				
			    		    				deptCost.put(temp.getEmployee().getDept().getId(),cost1+cost2+cost3);	  
		    		    	        	 /*  deptCost.put(temp.getEmployee().getDept().getId(),
		    		    	        			   deptCost.get(temp.getEmployee().getDept().getId())
		    		    	        			   +temp.getAllFunding()==null||"".equals(temp.getAllFunding())?0:Integer.parseInt(temp.getAllFunding())
		    		    	        					   +temp.getAdvanceFunding()==null||"".equals(temp.getAdvanceFunding())?0:Integer.parseInt(temp.getAdvanceFunding()));			    		    	        	   */
		    		    	           }
		    		    		  }
		    		    		    		    		  
		    		    	  }
		    		    }
			    
			     }else{
			    	   
			    	       for(TravelRecord temp:travelRecords){
			    	    	   
			    	    	   
			    	    	   if(!deptCost.containsKey(temp.getEmployee().getDept().getId())){
			    	    		   
		    		    			   //deptIds.add(temp.getEmployee().getDept().getId()); 
		    		    	           
			    		    	         /*if(deptCost.get(temp.getEmployee().getDept().getId())!=null)
			    		    	           {
			    		    	        	   deptCost.put(temp.getEmployee().getDept().getId(),
			    		    	        			   deptCost.get(temp.getEmployee().getDept().getId())
			    		    	        			   +temp.getAllFunding()==null?0:Integer.parseInt(temp.getAllFunding())
			    		    	        					   +temp.getAdvanceFunding()==null?0:Integer.parseInt(temp.getAdvanceFunding()));			    		    	        	   
			    		    	           }else{*/
			    		    	        	    
			    		    	         deptCost.put(temp.getEmployee().getDept().getId(), temp.getAllFunding()==null||"".equals(temp.getAllFunding())?0:Integer.parseInt(temp.getAllFunding())
			    		    	        					   +temp.getAdvanceFunding()==null||"".equals(temp.getAdvanceFunding())?0:Integer.parseInt(temp.getAdvanceFunding()));
		    		    			 
			    		    	         
		    		    		  }else{
		    		    			  
		    		    			  if(deptCost.get(temp.getEmployee().getDept().getId())!=null)
		    		    	           {
		    		    				  
		    		    				  int cost1=0;
			    		    				int cost2=0;
			    		    				if(temp.getAllFunding()!=null&&!"".equals(temp.getAllFunding())){
			    		    					cost1=Integer.parseInt(temp.getAllFunding());
			    		    				}
			    		    				if(temp.getAdvanceFunding()!=null&&!"".equals(temp.getAdvanceFunding())){
			    		    					cost2=Integer.parseInt(temp.getAdvanceFunding());
			    		    				}
			    		    				int cost3=  deptCost.get(temp.getEmployee().getDept().getId());
			    		    				
			    		    				deptCost.put(temp.getEmployee().getDept().getId(),cost1+cost2+cost3);
		    		    	        	   /*deptCost.put(temp.getEmployee().getDept().getId(),
		    		    	        			   deptCost.get(temp.getEmployee().getDept().getId())
		    		    	        			   +temp.getAllFunding()==null||"".equals(temp.getAllFunding())?0:Integer.parseInt(temp.getAllFunding())
		    		    	        					   +temp.getAdvanceFunding()==null||"".equals(temp.getAdvanceFunding())?0:Integer.parseInt(temp.getAdvanceFunding()));			    */		    	        	   
		    		    	           }
		    		    		  }
		    		    		    		    		  
		    		    	   }
			    	    	   			    		   
			    	       }
			    	  
			      Set<Map.Entry<Integer, Integer>>entries=deptCost.entrySet();
			      Iterator<Map.Entry<Integer, Integer>> itDeptCost=entries.iterator();
			      int count=0;
			      while(itDeptCost.hasNext()){
			    	  Map.Entry<Integer, Integer>entry=itDeptCost.next();
			    	  if(count<entries.size()-1){
			    	  categories+="\""+deptDao.selectById(entry.getKey()).getName()+"\",";
			    	  cost+="\""+entry.getValue()+"\",";
			    	  }else{
			    		  categories+="\""+deptDao.selectById(entry.getKey()).getName()+"\"";
				    	  cost+="\""+entry.getValue()+"\"";			    		  
			    	  }
			    	  count++;
			      }
			    	  				   
			    }
			      if("部门经理".equals(employee.getRoleInfo().getRole())){
			    	  
			    	  travelRecords=travelRecordDao.getTravelRecordsAlreadyVerified();
			    	  Iterator<TravelRecord>it=travelRecords.iterator();
			    	  while(it.hasNext()){
			    		  TravelRecord temp=it.next();
			    		  if(!(temp.getEmployee().getDept()!=null&&temp.getEmployee().getDept().getId()==employee.getDept().getId())) 
			    		  {
			    			   it.remove();
			    		  }
			    	  }	
			    	  
			    	  
                     if("月份".equals(identy)){
			    		   Iterator<TravelRecord> itM=travelRecords.iterator();
			    		   while(itM.hasNext()){
			    			   TravelRecord temp=itM.next();
			    		    	  Date date=temp.getTravelBeginDate();
			    		    	  Calendar calendar=Calendar.getInstance();
			    		    	  calendar.setTime(date);
			    		    	  if((calendar.get(Calendar.MONTH)+1)!=monthOrYear)
			    		    	  {		    		    		  
			    		    		      itM.remove();	
			    		    		     
			    		    	  }else{
			    		    		  if(!employeeCost.containsKey(temp.getEmployee().getId())){
			    		    			  employeeCost.put(temp.getEmployee().getId(),temp.getAllFunding()==null||"".equals(temp.getAllFunding())?0:Integer.parseInt(temp.getAllFunding())
   		    	        					   +temp.getAdvanceFunding()==null||"".equals(temp.getAdvanceFunding())?0:Integer.parseInt(temp.getAdvanceFunding()) );
			    		    			  
			    		    		  }else{
			    		    			  
			    		    			    int cost1=0;
			    		    				int cost2=0;
			    		    				if(temp.getAllFunding()!=null&&!"".equals(temp.getAllFunding())){
			    		    					cost1=Integer.parseInt(temp.getAllFunding());
			    		    				}
			    		    				if(temp.getAdvanceFunding()!=null&&!"".equals(temp.getAdvanceFunding())){
			    		    					cost2=Integer.parseInt(temp.getAdvanceFunding());
			    		    				}
			    		    				int cost3=  employeeCost.get(temp.getEmployee().getId());
			    		    				
			    		    				employeeCost.put(temp.getEmployee().getId(),cost1+cost2+cost3);
			    		    			  /*employeeCost.put(temp.getEmployee().getId(), employeeCost.get(temp.getEmployee().getId())+temp.getAllFunding()==null||"".equals(temp.getAllFunding())?0:Integer.parseInt(temp.getAllFunding())
	   		    	        					   +temp.getAdvanceFunding()==null||"".equals(temp.getAdvanceFunding())?0:Integer.parseInt(temp.getAdvanceFunding()) );*/
			    		    			  
			    		    		  }
			   		  
			    		    	 }
			    			   
			    		   }
                    	 			 			    		  
			    	  }else if("年份".equals(identy)){
			    		
			    		  Iterator<TravelRecord> itM=travelRecords.iterator();
			    		   while(itM.hasNext()){
			    			      TravelRecord temp=itM.next();
			    		    	  Date date=temp.getTravelBeginDate();
			    		    	  Calendar calendar=Calendar.getInstance();
			    		    	  calendar.setTime(date);
			    		    	  if(calendar.get(Calendar.YEAR)!=monthOrYear)
			    		    	  {		    		    		  
			    		    		      itM.remove();	
			    		    		     
			    		    	  }else{
			    		    		  if(!employeeCost.containsKey(temp.getEmployee().getId())){
			    		    			  employeeCost.put(temp.getEmployee().getId(),temp.getAllFunding()==null||"".equals(temp.getAllFunding())?0:Integer.parseInt(temp.getAllFunding())
	   		    	        					   +temp.getAdvanceFunding()==null||"".equals(temp.getAdvanceFunding())?0:Integer.parseInt(temp.getAdvanceFunding()) );
			    		    			  
			    		    		  }else{
			    		    			  
			    		    			  int cost1=0;
			    		    				int cost2=0;
			    		    				if(temp.getAllFunding()!=null&&!"".equals(temp.getAllFunding())){
			    		    					cost1=Integer.parseInt(temp.getAllFunding());
			    		    				}
			    		    				if(temp.getAdvanceFunding()!=null&&!"".equals(temp.getAdvanceFunding())){
			    		    					cost2=Integer.parseInt(temp.getAdvanceFunding());
			    		    				}
			    		    				int cost3=  employeeCost.get(temp.getEmployee().getId());
			    		    				
			    		    				employeeCost.put(temp.getEmployee().getId(),cost1+cost2+cost3);
			    		    			  
			    		    			/*  employeeCost.put(temp.getEmployee().getId(), employeeCost.get(temp.getEmployee().getId())+temp.getAllFunding()==null||"".equals(temp.getAllFunding())?0:Integer.parseInt(temp.getAllFunding())
	   		    	        					   +temp.getAdvanceFunding()==null||"".equals(temp.getAdvanceFunding())?0:Integer.parseInt(temp.getAdvanceFunding()) );*/
			    		    			  
			    		    		  }
			   		  
			    		    	 }
			    			   
			    		   }
			    		  
			    		  
			    		  
			    	  }else{
			    		  
			    		 for(TravelRecord temp:travelRecords){
			    			 
			    			 
			    			 if(!employeeCost.containsKey(temp.getEmployee().getId())){
	    		    			  employeeCost.put(temp.getEmployee().getId(),temp.getAllFunding()==null||"".equals(temp.getAllFunding())?0:Integer.parseInt(temp.getAllFunding())
		    	        					   +temp.getAdvanceFunding()==null||"".equals(temp.getAdvanceFunding())?0:Integer.parseInt(temp.getAdvanceFunding()) );
	    		    			  
	    		    		  }else{
	    		    			  
	    		    			/*  employeeCost.put(temp.getEmployee().getId(), employeeCost.get(temp.getEmployee().getId())+temp.getAllFunding()==null||"".equals(temp.getAllFunding())?0:Integer.parseInt(temp.getAllFunding())
		    	        					   +temp.getAdvanceFunding()==null||"".equals(temp.getAdvanceFunding())?0:Integer.parseInt(temp.getAdvanceFunding()) );*/
	    		    			  
	    		    			     int cost1=0;
	    		    				int cost2=0;
	    		    				if(temp.getAllFunding()!=null&&!"".equals(temp.getAllFunding())){
	    		    					cost1=Integer.parseInt(temp.getAllFunding());
	    		    				}
	    		    				if(temp.getAdvanceFunding()!=null&&!"".equals(temp.getAdvanceFunding())){
	    		    					cost2=Integer.parseInt(temp.getAdvanceFunding());
	    		    				}
	    		    				int cost3=  employeeCost.get(temp.getEmployee().getId());
	    		    				
	    		    				employeeCost.put(temp.getEmployee().getId(),cost1+cost2+cost3);  
	    		    			  
	    		    		  }
			    		 }
			    		  
			    		  
			    	  }		  
		  	  
			 	
			  
			    
			      Set<Map.Entry<Integer, Integer>>entries=employeeCost.entrySet();
			      Iterator<Map.Entry<Integer, Integer>> itEmployCost=entries.iterator();
			      int count=0;
			      while(itEmployCost.hasNext()){
			    	  Map.Entry<Integer, Integer>entry=itEmployCost.next();
			    	  if(count<entries.size()-1){
			    	  categories+="\""+employeeDao.getOneById(entry.getKey()).getName()+"\",";
			    	  cost+="\""+entry.getValue()+"\",";
			    	  }else{
			    		  categories+="\""+employeeDao.getOneById(entry.getKey()).getName()+"\"";
				    	  cost+="\""+entry.getValue()+"\"";			    		  
			    	  }
			    	  count++;
			         } 
			    }
		  } 
		  
		 categories+="],";
		 cost+="]";
		 dataJson=dataJson+categories+cost;
		 dataJson+="}";
		return dataJson;
	} 

	
	
}
