																																																package com.rest.dto;
																																																																																					
																																																																																					
																																																																																					
																																																																																					
																																																																												
																																																																																																																																																																										
																																																																																					
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Course {
@Id
@GeneratedValue
private int courseId;
private String courseName;
private String description;
private String level;
private int duration;
private String offeredByTutor;
private String offeredByInstitute;
private double price;
private int noOfEnrollment;

private String imageName;





@ManyToOne
@JoinTable(name="StudentRegistrations",
joinColumns={@JoinColumn(name="courseId")},
inverseJoinColumns={@JoinColumn(name="studentId")})
private Student student;

@ManyToOne
@JoinTable(name="TutorsAssigned",
joinColumns={@JoinColumn(name="courseId")},
inverseJoinColumns={@JoinColumn(name="tutorId")})
private Tutor tutor;


public Course() {
super();
}


public Course(int courseId, String courseName, String description, String level, int duration, String offeredByTutor,
		String offeredByInstitute, double price, int noOfEnrollment, String imageName, Student student, Tutor tutor) {
	super();
	this.courseId = courseId;
	this.courseName = courseName;
	this.description = description;
	this.level = level;
	this.duration = duration;
	this.offeredByTutor = offeredByTutor;
	this.offeredByInstitute = offeredByInstitute;
	this.price = price;
	this.noOfEnrollment = noOfEnrollment;
	this.imageName = imageName;
	this.student = student;
	this.tutor = tutor;
}


public int getCourseId() {
	return courseId;
}


public void setCourseId(int courseId) {
	this.courseId = courseId;
}


public String getCourseName() {
	return courseName;
}


public void setCourseName(String courseName) {
	this.courseName = courseName;
}


public String getDescription() {
	return description;
}


public void setDescription(String description) {
	this.description = description;
}


public String getLevel() {
	return level;
}


public void setLevel(String level) {
	this.level = level;
}


public int getDuration() {
	return duration;
}


public void setDuration(int duration) {
	this.duration = duration;
}


public String getOfferedByTutor() {
	return offeredByTutor;
}


public void setOfferedByTutor(String offeredByTutor) {
	this.offeredByTutor = offeredByTutor;
}


public String getOfferedByInstitute() {
	return offeredByInstitute;
}


public void setOfferedByInstitute(String offeredByInstitute) {
	this.offeredByInstitute = offeredByInstitute;
}


public double getPrice() {
	return price;
}


public void setPrice(double price) {
	this.price = price;
}


public int getNoOfEnrollment() {
	return noOfEnrollment;
}


public void setNoOfEnrollment(int noOfEnrollment) {
	this.noOfEnrollment = noOfEnrollment;
}


public String getImageName() {
	return imageName;
}


public void setImageName(String imageName) {
	this.imageName = imageName;
}


public Student getStudent() {
	return student;
}


public void setStudent(Student student) {
	this.student = student;
}


public Tutor getTutor() {
	return tutor;
}


public void setTutor(Tutor tutor) {
	this.tutor = tutor;
}


@Override
public String toString() {
	return "Course [courseId=" + courseId + ", courseName=" + courseName + ", description=" + description + ", level="
			+ level + ", duration=" + duration + ", offeredByTutor=" + offeredByTutor + ", offeredByInstitute="
			+ offeredByInstitute + ", price=" + price + ", noOfEnrollment=" + noOfEnrollment + ", imageName="
			+ imageName + ", student=" + student + ", tutor=" + tutor + "]";
}


}

