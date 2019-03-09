package com.webapp.dao.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import com.webapp.modal.Course;
import com.webapp.modal.Result;
import com.webapp.modal.Student;


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
           /* Configuration configuration = new Configuration().configure("webappdao.xml");
            ServiceRegistryBuilder registry = new ServiceRegistryBuilder();
            registry.applySettings(configuration.getProperties());
            ServiceRegistry serviceRegistry = registry.buildServiceRegistry();
             
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);  */         
        }
         
        return sessionFactory;
    }
    
   
    static void executeQuery( Session session ){
    	String sql = "select st.name ,c.coursename from student as st inner join stu_course as cs on cs.student_STUDENT_ID = st.STUDENT_ID "+
    			 " inner join course as c on cs.STU_ID = c.CID;";
    	SQLQuery query = session.createSQLQuery(sql).addScalar("name").addScalar("coursename");
    	query.setResultTransformer(Transformers.aliasToBean(Result.class));
    	List results = query.list();
    	System.out.println(results);
    	for (Object object : results) {
			Result result = (Result) object;
			System.out.println(result.getCourse());
			System.out.println(result.getName());
			/*System.out.println(map.get("name"));
			System.out.println(map.get("coursename"));*/
		}
    	
    }

	    public static void main(String[] args) {
	    	
	      ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("webappdao.xml");
	      SessionFactory sessionfactory =  (SessionFactory) ctx.getBean("sessionFactory");
	      Session session =  sessionfactory.openSession();
	      Set<Student> studentSet = new HashSet<>();
	      Set<Course> course = new HashSet<>();
	      Course java = new Course();
	      java.setCoursename("java");
	      java.setFee((float) 300.00);
	      course.add(java);
	     // TestDAO test = (TestDAO)ctx.getBean("test");
	      Student student = new Student();
	      student.setSname("natu");
	    //  student.setCourse(course);
	      studentSet.add(student);
	      java.setStudent(studentSet);
	      //test.save(student);
	    // Student s= (Student) session.load(Student.class, 1);
	   //  s.setCourse(course);
	      Transaction tx = null;
	      try {
	   	   tx = (Transaction) session.beginTransaction();
	   	  // session.save(java);
	   	 //  Course cours = (Course) session.load(Course.class, 2);
	   	  /* cours.setCoursename("ai");
	   	   cours.setFee(345f);*/
	   	 //  cours.setStudent(studentSet);
	   	executeQuery(session);
	   	   
	   	   tx.commit();
	   	}

	   	catch (Exception e) {
	   	   if (tx!=null)
	   		try {
	   			tx.rollback();
	   		} catch (IllegalStateException e1) {
	   			e1.printStackTrace();
	   		}
	   	   e.printStackTrace(); 
	   	} finally {
	   	   session.close();
	   	}
	    	        
	    	      
		}
	    
}
