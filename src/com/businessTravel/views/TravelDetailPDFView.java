package com.businessTravel.views;

import java.text.SimpleDateFormat;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.businessTravel.domain.HotelBooking;
import com.businessTravel.domain.TicketBooking;
import com.businessTravel.viewObject.PdfViewObject;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfAction;
import com.lowagie.text.pdf.PdfDestination;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;

public class TravelDetailPDFView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
	   	 document.open();
		
		PdfViewObject pdfViewObject=(PdfViewObject)model.get("pdfViewObject");
		BaseFont bfChinese=BaseFont.createFont("STSong-Light","UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);
		Font titleFont=new Font(bfChinese,12,Font.BOLD);
		Font contentFont=new Font(bfChinese,12); 
		 
		String[]titlesAllInfo=new String[]{"出行人","出行时间","出行天数","车票费用","酒店费用","总计"};
		String[]titlestTicketInfo=new String[]{"车次","出发地","目的地","座位类型","费用"};
		String[]titlesHotelInfo=new String[]{"酒店名","星级","订房类型","入住时间","退房时间","费用"};
		
		
	    Font titleFont2=new Font(bfChinese,36,Font.BOLD);
	    Paragraph title=new Paragraph("出差信息总览",titleFont2);
	   	 
		document.add(title);
		
	//信息纵览部分	
		document.add(new Paragraph("信息总览",titleFont));	
		PdfPTable tableAllInfo=new PdfPTable(6);
	
		/**
		 * 标题
		 */
		    PdfPCell titleCell=null; 
		    for(int i=0;i<titlesAllInfo.length;i++){	
	         titleCell=new PdfPCell(new Paragraph(titlesAllInfo[i],titleFont));
		     titleCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		     titleCell.setVerticalAlignment(Element.ALIGN_CENTER);
		     titleCell.setFixedHeight(20.0f);
		     tableAllInfo.addCell(titleCell);
		    }
		  
		  
		    /**
		     * 内容
		     */
		    PdfPCell contentCell=null;
		    
		
		    
		    contentCell=new PdfPCell(new Paragraph(pdfViewObject.getUserName(), contentFont));  
			contentCell.setBorderWidthBottom(0.01f);
			contentCell.setBorderWidthTop(0.0f);
		    contentCell.setFixedHeight(20.0f);
		    tableAllInfo.addCell(contentCell);
		    
		    
		    contentCell=new PdfPCell(new Paragraph(new SimpleDateFormat("yyyy-MM-dd").format(pdfViewObject.getTravelBeginDate()), contentFont));
		    contentCell.setBorderWidthBottom(0.01f);
			contentCell.setBorderWidthTop(0.0f);
		    contentCell.setFixedHeight(20.0f);
		    tableAllInfo.addCell(contentCell);
		    
		    contentCell=new PdfPCell(new Paragraph(pdfViewObject.getDaysCount().toString(), contentFont));
		    contentCell.setBorderWidthBottom(0.01f);
			contentCell.setBorderWidthTop(0.0f);
		    contentCell.setFixedHeight(20.0f);
		    tableAllInfo.addCell(contentCell);
		   
		    
		    contentCell=new PdfPCell(new Paragraph(pdfViewObject.getTicketCost(), contentFont));
		    contentCell.setBorderWidthBottom(0.01f);
			contentCell.setBorderWidthTop(0.0f);
		    contentCell.setFixedHeight(20.0f);
		    tableAllInfo.addCell(contentCell);
		    
		    
		    
		    contentCell=new PdfPCell(new Paragraph(pdfViewObject.getHotelCost(), contentFont));
		    contentCell.setBorderWidthBottom(0.01f);
			contentCell.setBorderWidthTop(0.0f);
		    contentCell.setFixedHeight(20.0f);
		    tableAllInfo.addCell(contentCell);
		    
		    
		    
		    contentCell=new PdfPCell(new Paragraph(pdfViewObject.getAllCost(), contentFont));
		    contentCell.setBorderWidthBottom(0.01f);
			contentCell.setBorderWidthTop(0.0f);
		    contentCell.setFixedHeight(20.0f);
		    tableAllInfo.addCell(contentCell);
		    
	      //加入document
		    document.add(tableAllInfo);
		    
		    
     //车票信息
		    document.add(new Paragraph("车票信息",titleFont));	
			PdfPTable tableTicketInfo=new PdfPTable(5); 
			
			/**
			 * 标题
			 */
			     titleCell=null; 
			     for(int i=0;i<titlestTicketInfo.length;i++){	
		         titleCell=new PdfPCell(new Paragraph(titlestTicketInfo[i],titleFont));
		         
			     titleCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			     titleCell.setVerticalAlignment(Element.ALIGN_CENTER);
			     titleCell.setFixedHeight(20.0f);
			     tableTicketInfo.addCell(titleCell);
			     
			    }
		    
		  /**
		    * 内容
			*/
				     contentCell=null;
				    
			  for(TicketBooking ticketBooking:pdfViewObject.getTicketBookingList())
			  {  
				    contentCell=new PdfPCell(new Paragraph(ticketBooking.getBeginStation().getTrainTimes().getTrainName(), contentFont));  
					contentCell.setBorderWidthBottom(0.01f);
					contentCell.setBorderWidthTop(0.0f);
				    contentCell.setFixedHeight(20.0f);
				    tableTicketInfo.addCell(contentCell);
				    
				    
				    contentCell=new PdfPCell(new Paragraph(ticketBooking.getBeginStation().getStationName(), contentFont));
				    contentCell.setBorderWidthBottom(0.01f);
					contentCell.setBorderWidthTop(0.0f);
				    contentCell.setFixedHeight(20.0f);
				    tableTicketInfo.addCell(contentCell);
				   
				    
				    contentCell=new PdfPCell(new Paragraph(ticketBooking.getEndStation().getStationName(), contentFont));
				    contentCell.setBorderWidthBottom(0.01f);
					contentCell.setBorderWidthTop(0.0f);
				    contentCell.setFixedHeight(20.0f);
				    tableTicketInfo.addCell(contentCell);
				    
				    
				    
				    contentCell=new PdfPCell(new Paragraph(ticketBooking.getSeatCategory(), contentFont));
				    contentCell.setBorderWidthBottom(0.01f);
					contentCell.setBorderWidthTop(0.0f);
				    contentCell.setFixedHeight(20.0f);
				    tableTicketInfo.addCell(contentCell);
				    
				    
				    
				    contentCell=new PdfPCell(new Paragraph(ticketBooking.getTotalCost(), contentFont));
				    contentCell.setBorderWidthBottom(0.01f);
					contentCell.setBorderWidthTop(0.0f);
				    contentCell.setFixedHeight(20.0f);
				    tableTicketInfo.addCell(contentCell);
			  }    
				    
				    
			      //加入document
				    document.add(tableTicketInfo);
		    
		    
		    
		    
     //酒店信息
				    document.add(new Paragraph("酒店信息",titleFont));	
					PdfPTable tableHotelInfo=new PdfPTable(5); 
					
					/**
					 * 标题
					 */
					     titleCell=null; 
					     for(int i=0;i<titlesHotelInfo.length;i++){	
				         titleCell=new PdfPCell(new Paragraph(titlesHotelInfo[i],titleFont));
				         
					     titleCell.setHorizontalAlignment(Element.ALIGN_CENTER);
					     titleCell.setVerticalAlignment(Element.ALIGN_CENTER);
					     titleCell.setFixedHeight(20.0f);
					     tableHotelInfo.addCell(titleCell);
					     
					    }
					     
					     
						  /**
						    * 内容
							*/
								     contentCell=null;
								    
							  for(HotelBooking hotelBooking:pdfViewObject.getHotelBookingList())
							  {  
								    contentCell=new PdfPCell(new Paragraph(hotelBooking.getHotel().getName(), contentFont));  
									contentCell.setBorderWidthBottom(0.01f);
									contentCell.setBorderWidthTop(0.0f);
								    contentCell.setFixedHeight(20.0f);
								    tableHotelInfo.addCell(contentCell);
								    
								    
								    contentCell=new PdfPCell(new Paragraph(hotelBooking.getHotel().getGrade().toString(), contentFont));
								    contentCell.setBorderWidthBottom(0.01f);
									contentCell.setBorderWidthTop(0.0f);
								    contentCell.setFixedHeight(20.0f);
								    tableHotelInfo.addCell(contentCell);
								   
								    
								    contentCell=new PdfPCell(new Paragraph(hotelBooking.getBedCategory(), contentFont));
								    contentCell.setBorderWidthBottom(0.01f);
									contentCell.setBorderWidthTop(0.0f);
								    contentCell.setFixedHeight(20.0f);
								    tableHotelInfo.addCell(contentCell);
								    
								    
								    
								    contentCell=new PdfPCell(new Paragraph(hotelBooking.getStartDate().toString(), contentFont));
								    contentCell.setBorderWidthBottom(0.01f);
									contentCell.setBorderWidthTop(0.0f);
								    contentCell.setFixedHeight(20.0f);
								    tableHotelInfo.addCell(contentCell);
								    
								    
								    
								    contentCell=new PdfPCell(new Paragraph(hotelBooking.getEndDate().toString(), contentFont));
								    contentCell.setBorderWidthBottom(0.01f);
									contentCell.setBorderWidthTop(0.0f);
								    contentCell.setFixedHeight(20.0f);
								    tableHotelInfo.addCell(contentCell);
								    
								    
								    contentCell=new PdfPCell(new Paragraph(hotelBooking.getTotalCost(), contentFont));
								    contentCell.setBorderWidthBottom(0.01f);
									contentCell.setBorderWidthTop(0.0f);
								    contentCell.setFixedHeight(20.0f);
								    tableHotelInfo.addCell(contentCell);
								    
							  }    
								    
								    
							 //加入document
							 document.add(tableHotelInfo);
				    
	 writer.setOpenAction(PdfAction.gotoLocalPage(1, new PdfDestination(
							PdfDestination.XYZ, 0, 10000, 1), writer));
									
								     
							       
		document.close();
	}

}