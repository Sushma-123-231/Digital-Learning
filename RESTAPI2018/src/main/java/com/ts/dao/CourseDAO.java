package com.ts.dao;

import java.util.List;

import com.rest.dto.Course;
import com.rest.dto.Student;
import com.ts.db.HibernateTemplate;

public class CourseDAO {
	
	      
	public Course getCourseByName(String courseName) {
		
		return (Course)HibernateTemplate.getObjectByName(Course.class,courseName);
		
	}
	
	public Course getCourseBytutor(String offeredByLecture ) {
		return (Course)HibernateTemplate.getObject(Course.class,offeredByLecture );
	}
	
	public Course getCourseByInstitute(String offeredByInstitute) {
		return (Course)HibernateTemplate.getObject(Course.class,offeredByInstitute);
	}
	
	public Course getCourseByDuration(int duration) {
		return (Course)HibernateTemplate.getObject(Course.class,duration);
	}
	
	public List<Course> getAllCourses() {
		List<Course> courses=(List)HibernateTemplate.getObjectListByQuery("From Course");
		System.out.println("Inside All Courses ..."+courses);
		return courses;	
	}

	public int courseUpload(Course course) {
		// TODO Auto-generated method stub
		System.out.println("Inside All Courses ..."+course);
		return HibernateTemplate.addObject(course);
	}
	
	public int updateCourse(Course course){
		System.out.println("Inside All Courses ..."+course);
		return HibernateTemplate.updateObject(course);
	
	}
	
	public int deleteCourse(int courseId){
		System.out.println("Inside All Courses ..."+courseId);
		return HibernateTemplate.deleteObject(Course.class,courseId);
	}
	
	
}
