package com.businessTravel.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.businessTravel.dao.DeptDao;
import com.businessTravel.dao.RoleDao;
import com.businessTravel.domain.Dept;
import com.businessTravel.domain.RoleInfo;
import com.businessTravel.service.DeptAndCompanyService;

@Service
public class DeptAndCompanyServiceImpl implements DeptAndCompanyService {
    @Autowired
    private DeptDao deptDao;
    
    @Autowired
    private RoleDao roleDao;

	@Override
	public List<Dept> getAllDept() {
		// TODO Auto-generated method stub
		return deptDao.selectAllDept();
	}

	@Override
	public Dept getOneDeptById(Integer id) {
		// TODO Auto-generated method stub
		return deptDao.selectById(id);
	}

	@Override
	public RoleInfo getOneRoleByName(String name) {
		// TODO Auto-generated method stub
		return roleDao.rgetRoleInfoByName(name);
	}
    
	
}
