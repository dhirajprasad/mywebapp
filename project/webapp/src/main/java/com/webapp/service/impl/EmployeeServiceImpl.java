package com.webapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.dao.EmployeeDAO;
import com.webapp.dao.generic.TestDAO;
import com.webapp.exception.DAOException;
import com.webapp.service.EmployeeService;
import com.webapp.web.vo.EmployeeVo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@SuppressWarnings("rawtypes")
	@Autowired
	EmployeeDAO employeeDao;
	
	
	@SuppressWarnings("unchecked")
	public void addEmployee(EmployeeVo obj) throws DAOException {
		employeeDao.add(obj);
	}
}
