package com.rest.dto;
import javax.xml.bind.annotation.XmlRootElement;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
@XmlRootElement
public class Student {
@Id
@GeneratedValue
private int studentId;
private String studentName;
private String collegeName;
private int yearOfGraduation;
private Date dob;
private String studentMail;
private String studentPassword;
private String studentMobileNo;

@OneToMany
@JoinTable(name="StudentRegistrations",
joinColumns={@JoinColumn(name="studentId")},
inverseJoinColumns={@JoinColumn(name="courseId")})

private List<Course> courseList = new ArrayList<Course>();

public Student() {
super();
}



public Student(int studentId, String studentName, String collegeName, int yearOfGraduation, Date dob,
		String studentMail, String studentPassword, String studentMobileNo, List<Course> courseList) {
	super();
	this.studentId = studentId;
	this.studentName = studentName;
	this.collegeName = collegeName;
	this.yearOfGraduation = yearOfGraduation;
	this.dob = dob;
	this.studentMail = studentMail;
	this.studentPassword = studentPassword;
	this.studentMobileNo = studentMobileNo;
	this.courseList = courseList;
}



public int getStudentId() {
return studentId;
}

public void setStudentId(int studentId) {
this.studentId = studentId;
}

public String getStudentName() {
return studentName;
}

public void setStudentName(String studentName) {
this.studentName = studentName;
}

public String getCollegeName() {
return collegeName;
}

public void setCollegeName(String collegeName) {
this.collegeName = collegeName;
}

public int getYearOfGraduation() {
return yearOfGraduation;
}

public void setYearOfGraduation(int yearOfGraduation) {
this.yearOfGraduation = yearOfGraduation;
}

public Date getDob() {
return dob;
}

public void setDob(Date i) {
this.dob = i;
}

public String getStudentMail() {
return studentMail;
}

public void setStudentMail(String studentMail) {
this.studentMail = studentMail;
}

public String getStudentPassword() {
return studentPassword;
}

public void setStudentPassword(String studentPassword) {
this.studentPassword = studentPassword;
}

public String getStudentMobileNo() {
return studentMobileNo;
}

public void setStudentMobileNo(String string) {
this.studentMobileNo = string;
}

public List<Course> getCourseList() {
return courseList;
}

public void setCourseList(List<Course> courseList) {
this.courseList = courseList;
}

}
