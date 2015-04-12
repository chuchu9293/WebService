package com.likeyichu.webservice;

import javax.ws.rs.GET;
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
