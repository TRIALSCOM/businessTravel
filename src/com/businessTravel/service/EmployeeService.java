package com.businessTravel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.businessTravel.domain.Employee;
@Service
public interface EmployeeService {
   Employee login(String loginName,String password);  //登录
   Employee getOneByName(String userName);    
   void updateEmployee(Employee employee);
   Employee getOneByEmail(String email);
   void saveEmployee(Employee employee);
   List<Employee> getAllEmployee();
   int getAmountOfEmployee();
   List<Employee>getEmployeeActiveN();
   Employee getOneById(Integer id);
}
