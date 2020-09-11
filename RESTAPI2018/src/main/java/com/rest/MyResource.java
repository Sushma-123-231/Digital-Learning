package com.rest;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition.FormDataContentDispositionBuilder;
import org.glassfish.jersey.media.multipart.FormDataParam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.dto.Course;

import com.rest.dto.Student;
import com.rest.dto.Tutor;
import com.ts.dao.CourseDAO;

import com.ts.dao.StudentDAO;
import com.ts.dao.TutorDAO;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
	
	@Path("Hello")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getHello() {
		return "Hello ! Welcome to REST API";
	}
	
	@Path("Hyy")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
	
	@Path("getAllStudents")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getAllStudents(){
		System.out.println("Recieved in getAllStudents : " ); 
		StudentDAO studentDao = new StudentDAO();
		List<Student> stuList = studentDao.getAllStudents();	
		return stuList;
	}
	
	@Path("getAllTutors")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Tutor> getAllTutors(){
		System.out.println("Recieved in getAllTutors : " ); 
		TutorDAO tutor = new TutorDAO();
		List<Tutor> tutorList = tutor.getAllTutors();	
		return tutorList;
	}
	
	@Path("getAllCourses")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Course> getAllCourses(){
		System.out.println("Recieved in getAllCourses : " ); 
		CourseDAO course = new CourseDAO();
		List<Course> courseList = course.getAllCourses();	
		return courseList;
	}
	
	@Path("registerStudent")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void registerStudent(Student student) {
		System.out.println("Data Recieved in Register : " + student); 
		StudentDAO stu = new StudentDAO();
	    stu.register(student);
		
	}
	/*public void registerStudent(){
		Student student = new Student();
		student.setStudentId(101);
		student.setStudentName("sushma");
		student.setCollegeName("bvrit hyderabad");
		student.setYearOfGraduation(2022);
		student.setDob(new Date(07/06/2001));
		student.setStudentMail("18wh1a0231@bvrithyderabad.edu.in");
		student.setStudentPassword("18wh1a0231");
		student.setStudentMobileNo("9381450326");
		StudentDAO stu = new StudentDAO();
		stu.register(student);
	}*/
	@Path("uploadCourse")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void uploadCourse(Course course) {
		System.out.println("Data Recieved in Register : " + course); 
		CourseDAO cour = new CourseDAO();
	    cour.courseUpload(course);
		
	}
	
	
	
	
	@Path("loginVerification/{studentName}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Student loginVerification(@PathParam("studentName") String studentName){
		System.out.println("Data Recieved in Register : " + studentName); 
		StudentDAO student = new StudentDAO();
		Student stu = student.loginVerification(studentName);
		return(stu);
	}
	
	
	@Path("registerTutor")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void resisterTutor(Tutor tutor) {
		System.out.println("Data Recieved in Register : " + tutor); 
		TutorDAO tut = new TutorDAO();
		tut.register(tutor); 
	}
	
	@Path("getCourseByName/{courseName}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Course getCourseByName(@PathParam("courseName") String courseName){
		System.out.println("Recieved in getCourseByName : " + courseName); 
		CourseDAO coursedao = new CourseDAO();
		Course course = coursedao.getCourseByName(courseName);	
		System.out.println(course); 
		return course;
	}
	
	@Path("deleteCourse/{courseId}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteCourse(@PathParam("courseId") int courseId){
		System.out.println("Data Recieved in delete : " + courseId);
		CourseDAO coursedao = new CourseDAO();
		coursedao.deleteCourse(courseId);
	
	}	
	@Path("updateCourse")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateCourse(Course course){
		System.out.println("Data Recieved in update : " + course); 
		CourseDAO coursedao = new CourseDAO();
		coursedao.updateCourse(course);
		
	}
	
	
    @Path("updateStudent")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateStudent(Student student){
	     System.out.println("Data Recieved in update : " + student); 
	    StudentDAO stu = new StudentDAO();
	    stu.updateStudent(student);
	
  }
	
	/*@POST
	@Path("uploadImage")
	@Consumes({MediaType.MULTIPART_FORM_DATA})
	public void upoadImage(@FormDataParam("Image") InputStream fileInputStream,@FormDataParam("Image") FormDataContentDisposition formDataContentDispostion, 
			               @FormDataParam("courseName") String courseName, @FormDataParam("description") String description, @FormDataParam("level") String level,
			               @FormDataParam("duration") int duration,  @FormDataParam("offeredByTutor") String offeredByTutor,
			               @FormDataParam("offeredByInstitute") String offeredByInstitute, @FormDataParam("price") double price)throws Exception {
		
		int read = 0;
		
		byte[] bytes = new byte[1024];
		String path = this.getClass().getClassLoader().getResource("").getPath();
		String pathArr[] = path.split("/WEB-INF/classes/");
		FileOutputStream out = new FileOutputStream(new File(pathArr[0] + "/image" + formDataContentDispostion.getFileName()));
		
		while((read = fileInputStream.read(bytes)) != -1) {
			out.write(bytes, 0, read);
		}
		out.flush();
		out.close();
		
		Course course = new Course();
		course.setCourseName(courseName);
		course.setDescription(description);
		course.setLevel(level);
		course.setDuration(duration);
		course.setOfferedByTutor(offeredByTutor);
		course.setOfferedByInstitute(offeredByInstitute);
		course.setPrice(price);
		course.setImageName(/);
		CourseDAO coursedao = new CourseDAO();
		coursedao.courseUpload(course);
		System.out.println(course);
		System.out.println("FileName:"+ formDataContentDispostion.getFileName());
		
		
	}
	*/
	@POST
	@Path("uploadImage")
	@Consumes({MediaType.MULTIPART_FORM_DATA})
	public void uploadImage(@FormDataParam("Image")InputStream fileInputStream,
			                @FormDataParam("Image")FormDataContentDisposition formDataContentDisposition,
			                @FormDataParam("courseName")String courseName,
	                        @FormDataParam("description")String description,
	                        @FormDataParam("level")String level,
	                        @FormDataParam("duration")int duration,
	                        @FormDataParam("offeredByTutor")String offeredByTutor,
	                        @FormDataParam("offeredByInstitue")String offeredByInstitute,
	                        @FormDataParam("price")double price)throws IOException{
		
		
        int read = 0;
		
		byte[] bytes = new byte[1024];
		String path = this.getClass().getClassLoader().getResource("").getPath();
		String pathArr[] = path.split("/WEB-INF/classes/");
		FileOutputStream out = new FileOutputStream(new File(pathArr[0] + "/image/" + formDataContentDisposition.getFileName()));
		
		while((read = fileInputStream.read(bytes)) != -1) {
			out.write(bytes, 0, read);
		}
		out.flush();
		out.close();
		
		Course course = new Course();
		course.setCourseName(courseName);
		course.setDescription(description);
		course.setLevel(level);
		course.setDuration(duration);
		course.setOfferedByTutor(offeredByTutor);
		course.setOfferedByInstitute(offeredByInstitute);
		course.setPrice(price);
		course.setImageName(formDataContentDisposition.getFileName());
		CourseDAO coursedao = new CourseDAO();
		coursedao.courseUpload(course);
		System.out.println(course);
		
		
	}

}
