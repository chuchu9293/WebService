package com.likeyichu.webservice.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@Path("book")
@JsonAutoDetect
@JsonPropertyOrder(value = {"price", "name"})
@JsonIgnoreProperties(value = {"year"})
public class Book {
	public String name = "Physics";
	public String price = "123";
	public String year = "2015";
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Book wsBook(){
		return new Book();
	}
}