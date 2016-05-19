package com.webapp.dao.util;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class HibernateUtil {
	 
	
	public HibernateUtil() {
		System.out.println("creating HibernateUtil");
	}
	@Autowired
	private static SessionFactory sessionFactory;


	    public static SessionFactory getSessionFactory() {
	        return sessionFactory;
	    }
	    
	    
}
