package com.likeyichu.webservice.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("book")
public class Book {
	public String name = "Physics";
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Book wsBook(){
		return new Book();
	}
}