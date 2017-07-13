package com.businessTravel.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.businessTravel.dao.CompanyDao;
import com.businessTravel.dao.DeptDao;
import com.businessTravel.domain.CompanyInfo;
import com.businessTravel.domain.Dept;
import com.businessTravel.domain.Employee;
import com.businessTravel.domain.RoleInfo;
import com.businessTravel.service.DeptAndCompanyService;
import com.businessTravel.service.EmployeeService;
import com.sun.org.apache.bcel.internal.generic.RETURN;

import static com.businessTravel.util.BusinessConstant.*;

@Controller
public class UserController {
   
	 @Autowired
	 private EmployeeService employeeService;
	 
	 @Autowired
	 private DeptAndCompanyService deptAndCompanyService;
	 
	 @Autowired
	 private DeptDao deptDao;
	 
	@Autowired
	private CompanyDao companyDao;
	 
	  @RequestMapping(value="/userAdminManage",method=RequestMethod.GET)
	  public ModelAndView userAdminManage(HttpSession session){
		   ModelAndView mv=new ModelAndView();
		    
		   List<Employee>employeeList=employeeService.getAllEmployee();
		   List<Dept>depts=deptAndCompanyService.getAllDept();
		   
		   mv.addObject("depts", depts);
		   mv.addObject("employeeList", employeeList);
		   mv.setViewName("userManage");
		   return mv;
		  
	  }
	  
	  @RequestMapping("modifyEmployeeInfo")
	  public ModelAndView modifyEmployeeInfo(String userDetailName,String userDetailRoleCode,
			  Integer userDetailDept,String userDetailRole,String userDetailStatus,HttpSession  session){
		 // ModelAndView mv=new ModelAndView();
		  Employee employee=employeeService.getOneByName(userDetailName);
		  Dept dept=deptAndCompanyService.getOneDeptById(userDetailDept);
		  RoleInfo roleInfo=deptAndCompanyService.getOneRoleByName(userDetailRole);
		  employee.setDept(dept);
		  employee.setRoleInfo(roleInfo);
		  employee.setActiveStatus(userDetailStatus);
		  employeeService.updateEmployee(employee);
		  
		  return userAdminManage(session);
	  }
	  
	  
	  
	  
	  @RequestMapping(value="goToNewUserManage",method=RequestMethod.GET)
		public ModelAndView goToNewUserManage(){
		    ModelAndView mv=new ModelAndView("newUserManage");
		    List<Employee> employeesActiveN=employeeService.getEmployeeActiveN();
		    mv.addObject("employeesActiveN", employeesActiveN);	    
		    return mv;
		  
		  
	  }
		  
		  
	  
	  
	  
	   @RequestMapping(value="doNewUserManage",method=RequestMethod.GET)	  
       public ModelAndView  doNewUserManage(Integer id){
		 Employee employee=employeeService.getOneById(id);
		 employee.setActiveStatus(ACTIVEY);
		 employeeService.updateEmployee(employee); 		  
		 return goToNewUserManage();
	  }
	   
	   
	  @RequestMapping(value="goToAddDept",method=RequestMethod.GET)
	  public ModelAndView goToAddDept(){
		  ModelAndView mv=new ModelAndView("addDept");
		  List<Dept>depts=deptDao.selectAllDept();
		  mv.addObject("depts",depts);		  
		  return mv;  
	  }
	  
	 @RequestMapping("addDeptMessage")
	 public ModelAndView addDeptMessage(String addDeptName,String addDeptCode,String addCompanyCode,String description){
		 
		 Dept dept=new Dept();
		 dept.setCode(addDeptCode);
		 dept.setName(addDeptName);
		 dept.setDescription(description);
		 CompanyInfo companyInfo=null;
		 if(addCompanyCode!=null)
		 {   
			 Integer id=Integer.parseInt(addCompanyCode);
			 companyInfo=companyDao.selectById(id);
		 }
		 dept.setCompanyInfo(companyInfo);
		 deptDao.saveDept(dept);
		 
		 return goToAddDept();
	 }
	 
	 
	@RequestMapping("modifyDept")
	public ModelAndView modifyDept(String dept_Description,Integer deptId){
		
		 Dept dept=deptDao.selectById(deptId);
		 dept.setDescription(dept_Description);
		 deptDao.updateDept(dept);	
		 return goToAddDept();
		
	}
	  
	  
	   
}
