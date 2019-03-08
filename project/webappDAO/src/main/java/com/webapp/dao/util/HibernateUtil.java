package com.webapp.dao.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * @author dhiraj
 *
 */
@Component
public class HibernateUtil {
	 
	
	public HibernateUtil() {
		System.out.println("creating HibernateUtil");
	}
	@Autowired
	private static SessionFactory sessionFactory;
/**
 * According to Hibernate 4.0 API docs, the Configuration class’ buildSessionFactory() method is deprecated 
 * and it recommends developers to use the buildSessionFactory(ServiceRegistry) instead. 
 * Here is the new recommended code snippet that builds the SessionFactorybased on a ServiceRegistry 
 * and obtains the Session:
 * @return
 */
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration().configure();
            ServiceRegistryBuilder registry = new ServiceRegistryBuilder();
            registry.applySettings(configuration.getProperties());
            ServiceRegistry serviceRegistry = registry.buildServiceRegistry();
             
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);           
        }
         
        return sessionFactory;
    }
   

	    
	    
}
