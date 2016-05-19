package com.webapp.dao.generic;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webapp.dao.util.HibernateUtil;
import com.webapp.modal.Course;
@Repository
public abstract class GenericDAOImpl<T> implements GenericDAO<T> {

	@Autowired
	SessionFactory sessionFactory;  
	public T add(T t) {
		System.out.println("generic add  " + t.getClass().getCanonicalName());
		Session session=  sessionFactory.openSession();
		session.beginTransaction();
		Course cr2=(Course)session.get(Course.class, 1);
		//System.out.println("cr2"+cr2.getCoursename());
		return null;
	}

	
}
