package com.ts.dao;

import java.util.List;



import com.rest.dto.Tutor;
import com.ts.db.HibernateTemplate;


public class TutorDAO {
    
	
	public int register(Tutor tutor) {
		//java.util.Date utilDate = new java.sql.Date(staff.getJoinDate().getTime()); 
		
		return HibernateTemplate.addObject(tutor);
	}
	
	public List<Tutor> getAllTutors() {
		List<Tutor>tutors =(List)HibernateTemplate.getObjectListByQuery("From Tutor");
		System.out.println("Inside All staff ..."+tutors);
		return tutors;	
	}
}
