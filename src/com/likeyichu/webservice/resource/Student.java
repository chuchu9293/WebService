package com.likeyichu.webservice.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.server.JSONP;
import org.glassfish.jersey.server.internal.JsonWithPaddingInterceptor;


@Path("student")
public class Student {
	private String name = "xiaoMing";
	private String age = "13";
	private Book book = new Book();
	
	
	@Path("post")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)  //因为这行，wsStudent3()的形参remoteStudent会被jersey注入。
	//注意请求的头部必须有 ContentType:application/json  否则tomcat会报错
	@Produces(MediaType.APPLICATION_JSON)
	public Student wsStudent3(Student remoteStudent) {
		Student student= new Student();
		student.setName(student.getName()+remoteStudent.getName());
		return student;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Student wsStudent() {
		return new Student();
	}
	
	@Path("jsonp")
	@GET
	@JSONP(queryParam="callback")
	@Produces("application/x-javascript")
	public Student wsStudent2(@QueryParam("callback") String callback) {
		return new Student();
	}
	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	public static void main(String[] args) {
		Student s=new Student();
		System.out.println(s);
	}
}
