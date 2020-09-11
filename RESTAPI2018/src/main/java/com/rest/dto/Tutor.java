package com.rest.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
@Entity
@XmlRootElement
public class Tutor {
@Id
@GeneratedValue
private int tutorId;
private String tutorName;
private String tutorMail;
private String tutorPassword;
private int tutorMobileNo;
private int coursesOffered;
private String workingInstitute;

@OneToMany
@JoinTable(name="TutorsAssigned",
joinColumns={@JoinColumn(name="tutorId")},
inverseJoinColumns={@JoinColumn(name="courseId")})
private List<Course> tutorCourseList = new ArrayList<Course>();

public Tutor() {
super();
}

public Tutor(int tutorId, String tutorName, String tutorMail, String tutorPassword, int tutorMobileNo,
int coursesOffered, String workingInstitute, List<Course> tutorCourseList) {
super();
this.tutorId = tutorId;
this.tutorName = tutorName;
this.tutorMail = tutorMail;
this.tutorPassword = tutorPassword;
this.tutorMobileNo = tutorMobileNo;
this.coursesOffered = coursesOffered;
this.workingInstitute = workingInstitute;
this.tutorCourseList = tutorCourseList;
}

public int getTutorId() {
return tutorId;
}

public void setTutorId(int tutorId) {
this.tutorId = tutorId;
}

public String getTutorName() {
return tutorName;
}

public void setTutorName(String tutorName) {
this.tutorName = tutorName;
}

public String getTutorMail() {
return tutorMail;
}

public void setTutorMail(String tutorMail) {
this.tutorMail = tutorMail;
}

public String getTutorPassword() {
return tutorPassword;
}

public void setTutorPassword(String tutorPassword) {
this.tutorPassword = tutorPassword;
}

public int getTutorMobileNo() {
return tutorMobileNo;
}

public void setTutorMobileNo(int tutorMobileNo) {
this.tutorMobileNo = tutorMobileNo;
}

public int getCoursesOffered() {
return coursesOffered;
}

public void setCoursesOffered(int coursesOffered) {
this.coursesOffered = coursesOffered;
}

public String getWorkingInstitute() {
return workingInstitute;
}

public void setWorkingInstitute(String workingInstitute) {
this.workingInstitute = workingInstitute;
}

public List<Course> getTutorCourseList() {
return tutorCourseList;
}

public void setTutorCourseList(List<Course> tutorCourseList) {
this.tutorCourseList = tutorCourseList;
}

}
