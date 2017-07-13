package com.businessTravel.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.businessTravel.dao.AttachmentDao;
import com.businessTravel.dao.CompanyDao;
import com.businessTravel.domain.Attachment;
import com.businessTravel.domain.CompanyInfo;
import com.businessTravel.domain.Employee;
import com.businessTravel.service.AttachmentService;
import com.businessTravel.service.DeptAndCompanyService;
import com.businessTravel.service.EmployeeService;
import com.businessTravel.util.MailUtil;
import com.businessTravel.util.common.EmployeeUtils;

import static com.businessTravel.util.BusinessConstant.*;






@Controller
@SessionAttributes("employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    
    @Autowired
    private CompanyDao companyDao;
    
    @Autowired
    private AttachmentService attachmentService;
    
    @Autowired
    private DeptAndCompanyService deptAndCompanyService;
    
    @RequestMapping(value="/login")
    public ModelAndView login( String loginName,String password,HttpSession session,HttpServletRequest request){
    	
    //	sessionStatus.setComplete();
    	
    	Employee employee=employeeService.login(loginName, password);
    	ModelAndView mv=new ModelAndView();
    	if(employee!=null)
    	{
    		
    		//request.getSession().removeAttribute("employee");
    		session.setAttribute("employee", employee);
    		
    		session.setAttribute("path", request.getServletContext().getRealPath("/resources/"));
    		
    		//mv.setView(new RedirectView("/BusinessTravel/main"));
    		if(employee.getEmployeeNumber()==null||employee.getDept()==null)
    		{
    			mv.setViewName("bind-info");
    		}else{
    		    mv.setViewName("frameWork");
    		}
    	}else{
    		mv.addObject("message","用户名或密码错误");
    		mv.setViewName("index");
    	}
    	return mv;
    	
    }
    
    
    
    @RequestMapping(value="logOut")
    public ModelAndView logOut(HttpSession session,SessionStatus sessionStatus){
    	ModelAndView mv=new ModelAndView();
    	session.removeAttribute("employee");
    	sessionStatus.setComplete();  
        mv.setViewName("index");	
    	return mv;
    }
    
    
   /* @RequestMapping("/pdf")  
    public  ModelAndView handleRequestInternal(HttpServletRequest request,
    	      HttpServletResponse response) throws Exception {
    	      //user data
    	      Map<String,String> userData = new HashMap<String,String>();
    	      userData.put("100", "Xiao.Lu");
    	      userData.put("102", "User 102");
    	      userData.put("301", "User 301");
    	      userData.put("400", "User 400");
    	      return new ModelAndView("UserSummary","userData",userData);
    	   }*/
    
    
    
     @RequestMapping(value="goToChangeInfo",method=RequestMethod.GET)
     public ModelAndView goToChangeInfo(HttpSession session) 
     throws Exception{
    	 //String pageId,
    	ModelAndView mv=new ModelAndView();
    	//Employee employee=(Employee)session.getAttribute("employee"); 
    //	Employee employee=employeeService.getOneByName("谭佳");
    	Employee employee=(Employee)session.getAttribute("employee");
    	mv.addObject("employee", employee);
        Attachment attachment=employee.getAttachment();
     if(attachment!=null)
     {  String imagePath=attachment.getFileAddress()+File.separator+attachment.getFileName()+"."+attachment.getFileType();
    	 
        /* InputStream inputStream=new FileInputStream(new File(imagePath));
        
         String outPutPath="F:\\Ecilps j2ee\\J2eeProjects\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\BusinessTravel\\images"+File.separator+attachment.getFileName()+"."+attachment.getFileType();

         OutputStream outputStream=new FileOutputStream(
           new File("F:\\Ecilps j2ee\\J2eeProjects\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\BusinessTravel\\images"+File.separator+attachment.getFileName()+"."+attachment.getFileType()));
        int len=0;
        while((len=inputStream.read())!=-1){
        	outputStream.write(len);        	
        }
        
        inputStream.close();
        outputStream.close();*/
      
        mv.addObject("fileName", attachment.getFileName()+"."+attachment.getFileType());     
        // employeeService.updateEmployee(employee);
        mv.addObject("imagePath", imagePath);
     }
    	mv.setViewName("change-info");    	 
    	  return mv;
     }
    
    
     @RequestMapping(value="changeInfoComplete")
     public ModelAndView changeInfoComplete(HttpServletRequest request,HttpSession session,@ModelAttribute Employee employee,
    		    @RequestParam("file")MultipartFile file)throws Exception{    	
    	/*  if(!file.isEmpty()){
   		   String fileName=file.getOriginalFilename();
   		   String path=request.getServletContext().getRealPath("/resources/");
   		   int pre=(int)System.currentTimeMillis();
   		   System.out.println(path);
   		   fileName=pre+fileName;
   		   
   		    File filePath=new File(path,fileName);
   		    if(!filePath.getParentFile().exists()){
   		 	  filePath.getParentFile().mkdirs();			  
   		  }
   		    
   		  request.setAttribute("fileName",fileName );
   		  file.transferTo(new File(path+File.separator+fileName));
   		
   		   int index=fileName.indexOf(".");
		   System.out.println(index);
		//  String fileType=fileName.substring(index);
		  Attachment attachment=new Attachment();
		  attachment.setFileSize(String.valueOf(file.getSize()));
		  attachment.setFileAddress(path);
		  attachment.setFileName(fileName.substring(0, index));		  
		  attachment.setFileType(fileName.substring(index+1));
		  attachmentService.saveAttachment(attachment);
   		  
		 Attachment attachementUpdate= attachmentService.getOneByName(fileName.substring(0, index));
		 employee.setAttachment(attachementUpdate);
		  
   	      }*/
    	  
    	 ModelAndView mv=new ModelAndView();
    	 employeeService.updateEmployee(employee);
    	 employee=employeeService.getOneByName(employee.getName());
    	 session.setAttribute("employee", employee);
    	 mv.setViewName("frameWork");
    	 return mv;
     }
     
     
     
     @RequestMapping(value="closeChangeInfoToFrame",method=RequestMethod.GET)
     public String closeChangeInfoToFrame(){
    	   return "frameWork";
     }
    
    @RequestMapping(value="getAll")
    public ModelAndView getAll(ModelAndView mv,HttpSession session){
    	List<CompanyInfo>  companys=companyDao.selectAll();
    	
    	for(CompanyInfo s:companys){
    		System.out.println(s.getName());
    		
    	}
    	
    	mv.setViewName("index");
    	return mv;
    	
    }
    
    
    @RequestMapping(value="signUp")
    public ModelAndView signUp(String loginName,String password,String email,HttpServletRequest request,ModelAndView mv,HttpSession session)
    {
    	
    	Employee employee=employeeService.getOneByEmail(email);
    	
    	System.out.println(loginName);
    	
    	if(employee!=null)
    	{
    		mv.setViewName("sign-up");
    		String msg="该邮件已被注册";
    		mv.addObject("msg", msg);
    		return mv;	
    	}
    	
    	employee=employeeService.getOneByName(loginName);
    	if(employee!=null){
    		mv.setViewName("sign-up");
    		String msg="该用户名已存在";
    		mv.addObject("msg", msg);
    		return mv;		
    	}
    	
    	employee=new Employee();
    	employee.setEmail(email);
    	employee.setName(loginName);
    	employee.setPassword(password);
    	employee.setActiveStatus(ACTIVEN);
    	int count=employeeService.getAmountOfEmployee();
    	employee.setEmployeeNumber(EmployeeUtils.createEmployeeNumber(count));
    	//employeeService.saveEmployee(employee);
    	
    	 try{
      	   String secretKey=UUID.randomUUID().toString();
      	   Timestamp outDate=new Timestamp(System.currentTimeMillis()+30*60*1000);
      	   long date=outDate.getTime()/1000*1000;
      	   employee.setValidateCode(secretKey);
      	   employee.setRegisterDate(date);
      	    
      	   //employeeService.updateEmployee(employee);
      	   employeeService.saveEmployee(employee);
      	   String key=employee.getName()+"$"+date+"$"+secretKey;
      	   String digitalSignature=DigestUtils.md5Hex(key);
      	   
      	   String emailTile="BusinessTravel 注册检验";
      	   String path=request.getContextPath();
      	   String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
      	   String resetHerf=basePath+"comfirmSignUp?sid="+digitalSignature+"&userName="+employee.getName();
      	   String emailContent="此邮件用于注册验证<br/><a href="+resetHerf+" target='_BLANK'>"+resetHerf+"点此验证</a>";
      	   System.out.println(resetHerf);
      	   
      	   String[]to=new String[]{email};
      	   
      	   MailUtil.htmlMail(to, emailTile, emailContent);
      	   
      	   System.out.println("已成功发送");
      	   
         }catch(Exception e){
      	   e.printStackTrace();
         }	 
    	mv.setViewName("index"); 
    	String signUpTips="您已申请注册，请查看邮箱激活";
    	mv.addObject("signUpTips", signUpTips);
    	return  mv;
    			
    }
    
    
    @RequestMapping(value="comfirmSignUp",method=RequestMethod.GET,produces = "text/html;charset=UTF-8")
     public ModelAndView comfirmSignUp(ModelAndView mv,String sid,String userName,
    		HttpServletRequest request,HttpServletResponse response){
    	
    	
    	String msg="";
        System.out.println(userName);
        
        if("".equals(sid)||"".equals(userName)){
        	msg="链接不完全，请重新获取";
        	mv.setViewName("sign-up");
        	mv.addObject("msg", msg);
        	return mv;
        	
        }
        
        Employee employee=employeeService.getOneByName(userName);
        if(employee==null)
        {
        	msg="用户名不存在，请重新获取";
        	mv.addObject("msg", msg);
        	mv.setViewName("sign-up");
        	return mv;
        	
        }
    	Timestamp outDate=new Timestamp(employee.getRegisterDate());
    	if(outDate.getTime()<System.currentTimeMillis()){
    		msg="链接失效";
    		mv.addObject("msg", msg);
    		mv.setViewName("sign-up");
    		return mv;
    	}
    	String key=employee.getName()+"$"+outDate.getTime()/1000*1000+"$"+employee.getValidateCode();
    	String digitalSignature=DigestUtils.md5Hex(key);
    	
    	if(!digitalSignature.equals(sid)){
    		msg="验证码不匹配，请确认是否是本人操作";
    		mv.setViewName("sign-up");
    		mv.addObject("msg", msg);
    		return mv;
    		
    	}
    	employee.setActiveStatus(ACTIVEY);
    	employeeService.updateEmployee(employee);
    	
    	msg="已注册成功，请登录";
    	mv.setViewName("re-info");
    	mv.addObject("msg", msg);
    	mv.addObject("loginName", employee.getName());
    	mv.addObject("password", employee.getPassword());    	
        return mv;
        
        
    }
    
    
    
    
    
    
    
    @RequestMapping(value="forgetPassword")
    public ModelAndView forgetPassword(ModelAndView mv,HttpSession session,HttpServletRequest request,String email)
    {
    
   //  Pattern  pattern=Pattern.compile("^1[3|4|5|8][0-9]\\d{8}$ "); ֤
    // Pattern  patternQq=Pattern.compile("^[1-9]\\d{4,11}");
   //  Pattern  patternPhone=Pattern.compile("^1[3|4|5|8][0-9]\\d{8}$");
   //  Pattern  patternEmail=Pattern.compile("^[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}$ ");
   //  Pattern  patternEmail2=Pattern.compile("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$");
      
   //    Matcher matcher=pattern.matcher(userName);
       
       System.out.println(request.getServletContext().getRealPath("/resources/"));
      Employee employee=employeeService.getOneByEmail(email);
       String msg="";
       if(employee==null){
    	   msg="该邮件未中注册，输入正确的邮箱";
    	   mv.addObject("msg", msg);
    	   mv.setViewName("forgot");
    	   return mv;
       }
       try{
    	   String secretKey=UUID.randomUUID().toString();
    	   Timestamp outDate=new Timestamp(System.currentTimeMillis()+30*60*1000);
    	   long date=outDate.getTime()/1000*1000;
    	   employee.setValidateCode(secretKey);
    	   employee.setRegisterDate(date);
    	   employee.setActiveStatus(ACTIVEY);
    	   employeeService.updateEmployee(employee);
    	   String key=employee.getName()+"$"+date+"$"+secretKey;
    	   String digitalSignature=DigestUtils.md5Hex(key);
    	   
    	   String emailTile="BusinessTravel 忘记密码验证";
    	   String path=request.getContextPath();
    	   String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    	   String resetHerf=basePath+"resetPassword?sid="+digitalSignature+"&userName="+employee.getName();
    	   String emailContent="此邮件用于密码忘记验证<br/><a href="+resetHerf+" target='_BLANK'>"+resetHerf+"点我验证</a>";
    	   System.out.println(resetHerf);
    	   
    	   String[]to=new String[]{employee.getEmail()};
    	   
    	   MailUtil.htmlMail(to, emailTile, emailContent);
    	   
    	   System.out.println("已成功发送邮件");
    	   
       }catch(Exception e){
    	   e.printStackTrace();
    	   msg="邮件发送失败";
       }
       mv.setViewName("index");
       mv.addObject("msg", msg);
    	
    	return  mv;
    			
    }
    
    @RequestMapping(value="resetPassword",method=RequestMethod.GET,produces = "text/html;charset=UTF-8" )
    public ModelAndView resetPassword(ModelAndView mv,String sid,String userName,
    		HttpServletRequest request,HttpServletResponse response){
        
    	try {
			    request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	String msg="";
        System.out.println(userName);
        
        if("".equals(sid)||"".equals(userName)){
        	msg="链接信息不完全，请重新获取";
        	mv.setViewName("forgot");
        	mv.addObject("msg", msg);
        	return mv;
        	
        }
        
        Employee employee=employeeService.getOneByName(userName);
        if(employee==null)
        {
        	msg="用户名未注册，请重新注册";
        	mv.addObject("msg", msg);
        	mv.setViewName("forgot");
        	return mv;
        	
        }
    	Timestamp outDate=new Timestamp(employee.getRegisterDate());
    	if(outDate.getTime()<System.currentTimeMillis()){
    		msg="链接已失效，请重新获取";
    		mv.addObject("msg", msg);
    		mv.setViewName("forgot");
    		return mv;
    	}
    	String key=employee.getName()+"$"+outDate.getTime()/1000*1000+"$"+employee.getValidateCode();
    	String digitalSignature=DigestUtils.md5Hex(key);
    	
    	if(!digitalSignature.equals(sid)){
    		msg="验证不匹配，请确认是否是本人操作";
    		mv.setViewName("forgot");
    		mv.addObject("msg", msg);
    		return mv;
    		
    	}
    	
    	 mv.setViewName("confirmMail");
    	 mv.addObject("userName", userName);
    	 return mv;
    
    }
    
    
    
    @RequestMapping(value="modifyPassword") 
    public ModelAndView modifyPassword(ModelAndView mv,HttpSession session,HttpServletRequest request,String password,String userName){
    
       Employee employee= employeeService.getOneByName(userName);
       if(employee==null){
    	   String msg="用户名不存在";
    	   mv.addObject("msg", msg);
    	  
    	  mv.setViewName("confirmMail"); 
    	  return mv;
    	   
       }
       
       employee.setPassword(password);
       employeeService.updateEmployee(employee);   	
       mv.setViewName("index");
       return mv;
    }
    
    
    @RequestMapping("bindInfoAlready")
    public ModelAndView bindInfoAlready(HttpSession session,String workeId,Integer deptId){
    	Employee employee=(Employee)session.getAttribute("employee");
    	employee.setDept(deptAndCompanyService.getOneDeptById(deptId));
    	employee.setEmployeeNumber(workeId);
    	employeeService.updateEmployee(employee);
    	employee=employeeService.getOneByName(employee.getName());
    	session.removeAttribute("employee");
    	session.setAttribute("employee", employee);
    	ModelAndView mv=new ModelAndView("frameWork");
    	
    	return mv;  
    	
    	}
    
   
    @RequestMapping("changePassword")
    public ModelAndView chnagePassword(String password ,SessionStatus sessionStatus,HttpSession session){
    	ModelAndView mv=new ModelAndView("index");
    	Employee employee=(Employee)session.getAttribute("employee");
    	employee.setPassword(password);
    	employeeService.updateEmployee(employee);
    	sessionStatus.setComplete();
    	String changeMsg="您已经修改密码成功,请登录";
    	mv.addObject("changeMsg", changeMsg);
    	return mv;
    }
    
    
    
    
    
}
