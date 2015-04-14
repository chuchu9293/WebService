package com.likeyichu.webservice.resource;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**Webservice资源*/
@Path("helloworld")
public class HelloWorldResource {
    public static final String CLICHED_MESSAGE = "Hello World!";
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String wsHello() {
        return CLICHED_MESSAGE;
    }

}
