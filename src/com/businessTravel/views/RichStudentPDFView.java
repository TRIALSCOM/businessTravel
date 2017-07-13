package com.businessTravel.views;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.org.eclipse.jdt.internal.compiler.DocumentElementParser;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.businessTravel.domain.Employee;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfAction;
import com.lowagie.text.pdf.PdfDestination;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfWriter;
import com.sun.java.swing.plaf.windows.resources.windows_zh_TW;


public class RichStudentPDFView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model,
			Document document, PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		
		//String filePath = "e://A.pdf";
        //  OutputStream out = new FileOutputStream("e://A.pdf");
       //  PdfWriter.getInstance(document, out);
        
       /* writer.setEncryption(
        	       "Hellow".getBytes(),"tj".getBytes(),PdfWriter.ALLOW_SCREENREADERS,PdfWriter.STANDARD_ENCRYPTION_128);
*/
     
        document.open();
        
        
        
		Employee employee = (Employee) model.get("employee");
		
		
		BaseFont bfChinese=BaseFont.createFont("STSong-Light","UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);
		Font titleFont=new Font(bfChinese,12,Font.BOLD);
		Font contentFont=new Font(bfChinese,12);
		
		
		     /* PdfPCell titleCell=null;
		      titleCell=new PdfPCell(new Paragraph("",titleFont));
			 
			  titleCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			  titleCell.setVerticalAlignment(Element.ALIGN_CENTER);
			  titleCell.setFixedHeight(20.0f);*/
		
			  
			  /*  PdfPCell contentCell=null;
				contentCell.setBorderWidthBottom(0.01f);
				contentCell.setBorderWidthTop(0.0f);
			    contentCell.setFixedHeight(20.0f);*/
			  

		Table table = new Table(2);
		table.addCell("First Name");
		table.addCell("Last Name");

		table.addCell(employee.getName());
		table.addCell(employee.getName());

		
		 titleFont=new Font(bfChinese,36,Font.BOLD);
		 Paragraph title=new Paragraph("员工基本信息",titleFont);
		
		 
		 document.add(title);
		 document.add(table);

		
        // document.addTitle("aa");
        // document.addSubject("aa");
        // to open the PDF in 100% zoom
		writer.setOpenAction(PdfAction.gotoLocalPage(1, new PdfDestination(
				PdfDestination.XYZ, 0, 10000, 1), writer));
		
	     
       
		document.close();
	}
}