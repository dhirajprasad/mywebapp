package com.webapp.dao.impl;

import org.springframework.stereotype.Repository;

import com.webapp.dao.EmployeeDAO;
import com.webapp.dao.generic.GenericDAOImpl;
import com.webapp.exception.DAOException;
import com.webapp.web.vo.EmployeeVo;

@Repository
public class HibernateEmployeeDAO extends GenericDAOImpl<EmployeeVo> implements EmployeeDAO {

	

}
