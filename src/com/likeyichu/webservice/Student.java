package com.likeyichu.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("student")
public class Student {
	private String name = "xiaoMing";
	private String age = "13";
	private Book book = new Book();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Student wsStudent() {
		Student s=new Student();
		return s;
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
