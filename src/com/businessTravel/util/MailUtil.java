package com.businessTravel.util;

import java.io.File;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;



public class MailUtil {
   private static final String HOST="smtp.qq.com";
   private static final String SMTP="smtp";
   private static final String USERNAME="378097217@qq.com";
   private static final String PASSWORD="hbevgcwmbvkebhga";
   private static final int PORT=587;
   private static final String DEFAULTENCODING="UTF-8";
   private static JavaMailSenderImpl senderImpl=new JavaMailSenderImpl();
   private static Properties  prop=new  Properties();
   
   
   static{
	   senderImpl.setHost(HOST);
	   senderImpl.setProtocol(SMTP);
	   senderImpl.setUsername(USERNAME);
	   senderImpl.setPassword(PASSWORD);
	   senderImpl.setPort(PORT);
	   senderImpl.setDefaultEncoding(DEFAULTENCODING);
	   
	   
	   prop.put("mail.smtp.auth", "true");
       prop.put("mail.smtp.timeout", 25000);
       
       prop.put("mail.debug", "true");
       
       senderImpl.setJavaMailProperties(prop);	    
   }
   
   
  /* public static void main(String args[]) {
      
//     String[] array = new String[] {"88888@qq.com","666666@qq.com","999999999@qq.com",USERNAME};
       String[] array = new String[] {USERNAME};
       String subject = "Cherish";
       String content="woaini";    
       String html = "<html><head>"+
               "</head><body>"+              
               "<h1>Hello,Nice to meet you!</h1>"+
               "<span style='color:red;font-size:36px;'></span>"+            
               "</body></html>";
     //  boolean result =singleMail(array, subject, content);
         boolean result =htmlMail(array,subject,html);
     

   }*/

   
   
   public static boolean singleMail(String to,String subject,String content){
	   
	   String[]arry=new String []{to};
	   return singleMail(arry,subject,content);
   }
   
   public static boolean singleMail(String[]to,String subject,String content){
	   
	   boolean result=true;
	   SimpleMailMessage mailMessage=new SimpleMailMessage();
	   
	   mailMessage.setTo(to);
	   mailMessage.setFrom(USERNAME);
	   mailMessage.setSubject(subject);
	   mailMessage.setText(content);
	   
	   try{
		   
		   senderImpl.send(mailMessage);
	   }catch(MailException e){
		   e.printStackTrace();
		   result=false;
	   }
	   return result;
   }
   
   public static boolean htmlMail(String[]to,String subject,String html){
	   boolean result=true;
	   
	   MimeMessage mailMessage=senderImpl.createMimeMessage();
	   MimeMessageHelper messageHelper=new MimeMessageHelper(mailMessage);
	   
	   
	   try{
		   messageHelper.setTo(to);
		   messageHelper.setSubject(subject);
		   messageHelper.setFrom(USERNAME);
		   messageHelper.setText(html, true);
		   senderImpl.send(mailMessage);
		   
	   }catch(MessagingException e){
		   result=false;
		   e.printStackTrace();
		   
	   }
	   return result;
	   
   }
   
   
   public static boolean inLineFileMail(String[]to,String subject,String html,String filePath){
	   boolean result=true;
	   MimeMessage mailMessage=senderImpl.createMimeMessage();
	   try{
		   MimeMessageHelper messageHelper=new MimeMessageHelper(mailMessage,true);
		   messageHelper.setTo(to);
		   messageHelper.setSubject(subject);
		   messageHelper.setFrom(USERNAME);
		   messageHelper.setText(html, true);
		   FileSystemResource fileSystemResource=new FileSystemResource(new File(filePath));
		   messageHelper.addInline(fileSystemResource.getFilename(), fileSystemResource);
		   senderImpl.send(mailMessage);
	   }catch(MessagingException e){
		   result=false;
		   e.printStackTrace();
	   }
	   
	   return result;
	   
	   
   }
   
   
   
   public static boolean attachedFileMail(String[]to,String subject,String html,String filePath){
	   boolean result=true;
	   
	   MimeMessage mailMessage=senderImpl.createMimeMessage();
	   try{
		   MimeMessageHelper messageHelper=new MimeMessageHelper(mailMessage, true, "utf-8");
		   
		   messageHelper.setTo(to);
		   messageHelper.setFrom(USERNAME);
		   messageHelper.setSubject(subject);
		   messageHelper.setText(html,true);
		   
		   
		   FileSystemResource fileSystemResource=new FileSystemResource(new File(filePath));
		   messageHelper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);		   
		   senderImpl.send(mailMessage);   
	   }catch(MessagingException e){
		   result =false;
		   e.printStackTrace();
		   
		   
	   }
	   return result;
	   
   }
   
   
   
}
