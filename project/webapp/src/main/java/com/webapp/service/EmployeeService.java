package com.webapp.service;

import com.webapp.exception.DAOException;
import com.webapp.web.vo.EmployeeVo;

public interface EmployeeService {

	public void addEmployee(EmployeeVo obj) throws DAOException;
}
