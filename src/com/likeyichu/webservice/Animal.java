package com.likeyichu.webservice;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;

@Path("animal")
@XmlRootElement 
public class Animal {
	public String species,name;
	public int age;
	public static Animal animal=new Animal();
	
	@GET
	@Path("{species}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Animal wsAnimal(@PathParam("species") String species,
			@QueryParam("name") String name,
			@QueryParam("age") int age
			){
		animal.species=species;
		animal.name=name;
		animal.age=  age==0?2:age;
		return animal;
	}
}
