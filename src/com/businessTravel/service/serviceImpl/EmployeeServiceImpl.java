package com.businessTravel.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.businessTravel.dao.EmployeeDao;
import com.businessTravel.domain.Employee;
import com.businessTravel.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    
	
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public Employee login(String loginName, String password) {
		// TODO Auto-generated method stub
		return employeeDao.getOneEmployee(loginName, password);
	}
	@Override
	public Employee getOneByName(String userName) {
		// TODO Auto-generated method stub
		return employeeDao.getOneByEmployeeByName(userName);
	}
	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.updateEmployee(employee);
		
	}
	@Override
	public Employee getOneByEmail(String email) {
		// TODO Auto-generated method stub
		return employeeDao.getOneByEmail(email);
	}
	@Override
	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
	    employeeDao.insertEmployee(employee);
	}
	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeDao.getAllEmployee();
	}
	@Override
	public int getAmountOfEmployee() {
		// TODO Auto-generated method stub
		return employeeDao.getEmployeeCount();
	}
	@Override
	public List<Employee> getEmployeeActiveN() {
		// TODO Auto-generated method stub
		return employeeDao.selectEmployeeActiveN();
	}
	@Override
	public Employee getOneById(Integer id) {
		// TODO Auto-generated method stub
		return employeeDao.getOneById(id);
	}
	
	


}
