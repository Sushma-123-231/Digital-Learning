package com.ts.db;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import com.rest.dto.Course;
import com.rest.dto.Student;

public class HibernateTemplate {
       
private static SessionFactory sessionFactory;
	
	static {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	
	
	public static int addObject(Object obj){                        
		System.out.println("Inside Template...");
		int result=0;
		
		Transaction tx=null;
		
		try {
			
			Session session=sessionFactory.openSession();
			
			
			session.save(obj);
			tx=session.beginTransaction();
			
			tx.commit();
			
			result=1;
			
		} catch (Exception e) {
		
			tx.rollback();
			
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static Object getObject(Class c,Serializable serializable)
	{
		Object obj=null;
		
		try {			
			return sessionFactory.openSession().get(c,serializable);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return obj;
	}
	
	public static Object getObjectByUserPass(Class<Student> class1, String loginId,String password) {
	
	String queryString = "from student where studentName = :loginId and studentPassword =:password";
	  Query query = sessionFactory.openSession().createQuery(queryString);
	  query.setString("studentName", loginId);
	  query.setString("StudentPassword", password);
	  Object queryResult = query.uniqueResult();
	  Student employee = (Student)queryResult;
	  return employee; 
	}
	public static Object getObjectByUserId(Class<Student> class1, String studentName) {
		
		String queryString = "from Student where studentName = :studentName";
		  Query query = sessionFactory.openSession().createQuery(queryString);
		  query.setString("studentName", studentName);
		  Object queryResult = query.uniqueResult();
		  Student student = (Student)queryResult;
		  System.out.println("Inside All Students ..."+student);
		  return student; 
		}
    public static Object getObjectByName(Class<Course> class1, String courseName) {
    	
		
		String queryString = "from Course where courseName = :courseName";
		  Query query = sessionFactory.openSession().createQuery(queryString);
		  query.setString("courseName", courseName);
		  Object queryResult = query.uniqueResult();
		  Course course = (Course)queryResult;
		  System.out.println("Inside All Courses ..."+course);
		  return course; 
		}
    public static Object getObjectBytutor(String name) {
    	
		
		String queryString = "from Course where tutiorName = :name";
		  Query query = sessionFactory.openSession().createQuery(queryString);
		  query.setString("name", name);
		  Object queryResult = query.uniqueResult();
		  Course course = (Course)queryResult;
		  return course; 
		}
    public static Object getObjectByInstitute(String name) {
    	Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		
		String queryString = "from Course where instituteName = :name";
		  Query query = sessionFactory.openSession().createQuery(queryString);
		  query.setString("name", name);
		  Object queryResult = query.uniqueResult();
		  Course course = (Course)queryResult;
		  return course; 
		}
    public static Object getObjectByDuration(int weeks) {
    	
		
		String queryString = "from Course where duration = :weeks";
		  Query query = sessionFactory.openSession().createQuery(queryString);
		  query.setInteger("weeks", weeks);
		  Object queryResult = query.uniqueResult();
		  Course course = (Course)queryResult;
		  return course; 
		}
	public static List<Object> getObjectListByQuery(String query)
	{
		
		return sessionFactory.openSession().createQuery(query).list();
	}
	
	public static int updateObject(Object obj)
	{
		int result=0;
		
		Transaction tx=null;
		
		try {
			
			Session session=sessionFactory.openSession();
			tx=session.beginTransaction();
			
			session.saveOrUpdate(obj);
			
			tx.commit();
			
			result=1;
			
		} catch (Exception e) {
		
			tx.rollback();
			
			e.printStackTrace();
		}
		System.out.println("Data Recieved in delete : " + result);
		return result;
	}
	
	public static int deleteObject(Class c,Serializable serializable)
	{
		int result=0;
		
		Session session=sessionFactory.openSession();
		
		Transaction tx=session.beginTransaction();
		
		try {
			
			Object obj=session.get(c,serializable);
			
			session.delete(obj);
			
			tx.commit();
			
			result=1;
						
		} catch (Exception e) {
			
			e.printStackTrace();
			
			tx.rollback();
		}
		System.out.println("Data Recieved in delete : " + result);
		return result;
	}

	public static List<Object> getObjectListByName(Class c, String columName, String value) {
		Session session=sessionFactory.openSession();
		  Criteria criteria = session.createCriteria(c);
			Criterion nameCriterion = Restrictions.eq(columName, value);
			criteria.add(nameCriterion);
			return criteria.list();
	}
}
