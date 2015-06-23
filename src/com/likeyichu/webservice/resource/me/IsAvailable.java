package com.likeyichu.webservice.resource.me;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("me")
public class IsAvailable {
	@Path("isAvailable")
	@GET
	public String fun() {
		return "true";
	}
}
