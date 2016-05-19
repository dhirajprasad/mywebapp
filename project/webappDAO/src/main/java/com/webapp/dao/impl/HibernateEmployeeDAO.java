package com.webapp.dao.impl;

import org.springframework.stereotype.Repository;

import com.webapp.dao.EmployeeDAO;
import com.webapp.dao.generic.GenericDAOImpl;
import com.webapp.modal.Employee;

@Repository
public class HibernateEmployeeDAO extends GenericDAOImpl<Employee> implements EmployeeDAO<Employee> {

	

}
