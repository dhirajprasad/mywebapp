package com.webapp.dao.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.webapp.modal.Answer;
import com.webapp.modal.Course;
import com.webapp.modal.Question;
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
    static void update2(Session session){
	      Transaction tx = null;
	      try {
	   	   tx = (Transaction) session.beginTransaction();
	   	   Course course = (Course) session.load(Course.class, 1);
	   	course.getVersion();
	   	   course.setFee(30400f);
	   	 Thread.sleep(2000);
	   	   session.update(course);
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
	   	}
	   
 }
    static void saveQuestion(Session session,String query,String tile){
    	Question question = new Question();
    	question.setQuestion(query);
    	question.setTitle("java");
    	session.save(question);
    	
    }
   static void saveCourse(Session session){
	   	Set<Student> studentSet = new HashSet<>();
	    Set<Course> course = new HashSet<>();
	      Course javaCourse = new Course();
	      javaCourse.setCoursename("java");
	      javaCourse.setFee((float) 300.00);
	     // course.add(java);
	     // TestDAO test = (TestDAO)ctx.getBean("test");
	      Student student = new Student();
	      student.setSname("natu");
	    //  student.setCourse(course);
	      studentSet.add(student);
	      javaCourse.setStudent(studentSet);
	      session.save(javaCourse);
	      //test.save(student);
	    // Student s= (Student) session.load(Student.class, 1);
	   //  s.setCourse(course);
   }
   static void update(Session session){
	      Transaction tx = null;
	      try {
	   	   tx = (Transaction) session.beginTransaction();
	   	   Course course = (Course) session.load(Course.class, 1);
	   	   course.setFee(3000f);
	   	  
	   	   session.update(course);
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
	   	}
	   
   }
    static void executeQuery( Session session ,String queryToExecute ){
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

    static void query(Session session){
    	Question ques = (Question) session.load(Question.class, 1);
    	Answer ans = new Answer();
    	ans.setAnswer("Java is a widely used programming language expressly designed for use in the distributed environment of the internet.");
    	ans.setQuestion(ques);
    	session.save(ans);
    	
    }
    static void sqlquery(Session session ,String queryToExecute ){
    	SQLQuery query = session.createSQLQuery(queryToExecute);
    			query.setParameter("question", "what is java");
    			
    			
    	/*List results = query.list();
    	for (Object object : results) {
			System.out.println(object);
		}*/
    }
    static void hqlquery(Session session ,String queryToExecute ){
    	Query query = session.createQuery(queryToExecute);
    			query.setParameter("question", "what is java");
    			List<Result> results = query.list();
    			for (Result object : results) {
					System.out.println(object.getAnswer() + " "+object.getQuestion());
				}
    	/*List results = query.list();
    	Object[] rset = (Object[]) results.get(0);
    	for (Object object : rset) {
			System.out.println(object.toString());
		}*/
    }
	    public static void main(String[] args) {
	      ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("webappdao.xml");
	      SessionFactory sessionfactory =  (SessionFactory) ctx.getBean("sessionFactory");
	      Session session =  sessionfactory.openSession();
    	  String sqlquery ="select  ans.aid,qst.question,ans.answer from answer ans, question qst where qst.qid = ans.qid and question = :question ";
    	 // String hqlquery ="select  ans.aid,qst.question,ans.answer from Answer ans inner join ans.question as qst where qst.question = :question ";
    	  String hqlquery ="select  new com.webapp.modal.Result( ans.aid,qst.question,ans.answer) from Answer ans inner join ans.question as qst where qst.question = :question ";

	      Transaction tx = null;
	      try {
	    	  tx=session.beginTransaction();
	    	  Course c = (Course) session.load(Course.class, 4);
	    	  System.out.println(c.getCoursename()+" :course");
	    	  hqlquery(session, hqlquery);
	    	  tx.commit();
	    	  session.close();
	    	  c.setCoursename("c");
	    	  /*Session session2 =  sessionfactory.openSession();
	    	   t=  session2.beginTransaction();
	    	  Course c2 = (Course) session2.get(Course.class	, 4);
	    	  session2.update(c);
	    	  t.commit();*/

	    	 // Query q=session.createQuery("update Employee set age=:age where name=:name");
	    	
	      }

	   	catch (Exception e) {
	   	   if (tx!=null)
	   		try {
	   			//tx.rollback();
	   		} catch (IllegalStateException e1) {
	   			e1.printStackTrace();
	   		}
	   	
	   	   e.printStackTrace(); 
	   	} finally {
	   		if(session.isOpen()==true){
	   	   session.close();
	   	   ctx.close();
	   	   }
	   	}
	    	        
	    	      
		}
	    
}
