
package com.ts.dao;

import java.util.List;


import com.rest.dto.Student;
import com.ts.db.HibernateTemplate;

public class StudentDAO {

	
	
	public int register(Student student) {
		//java.util.Date utilDate = new java.sql.Date(student.getJoinDate().getTime()); 
		return HibernateTemplate.addObject(student);
	}
	
	public List<Student> getAllStudents() {
		List<Student> students=(List)HibernateTemplate.getObjectListByQuery("From Student");
		System.out.println("Inside All Students ..."+students);
		return students;	
	}

	public Student loginVerification(String studentName) {
		// TODO Auto-generated method stub
		System.out.println("Inside All Students ..."+studentName);
		return (Student)HibernateTemplate.getObjectByUserId(Student.class,studentName);
		
	}

	public int
	updateStudent(Student student) {
		// TODO Auto-generated method stub
		System.out.println("Inside All student..."+student);
		return HibernateTemplate.updateObject(student);
	}
}
