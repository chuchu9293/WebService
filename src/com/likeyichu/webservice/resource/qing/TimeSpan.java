package com.likeyichu.webservice.resource.qing;

import java.util.Calendar;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.server.JSONP;
@Path("qing")
public class TimeSpan {
	private static TimeSpan timespan=new TimeSpan();
	private int days(){
		Calendar theDay = Calendar.getInstance();
		Calendar now = Calendar.getInstance();
		theDay.set(2015,3-1,8,20,00,00); //2015-3-8 20:00:00
		int timeSpanBySeconds = (int) ((now.getTimeInMillis()-theDay.getTimeInMillis() ) / 1000);
		int days = timeSpanBySeconds / (3600 * 24);
		return days;
	}
	@Path("timeSpanJsonp")
	@GET
	@JSONP(queryParam="callback")
	@Produces("application/x-javascript")
	public int wsDays1(){
		return timespan.days();
	}
	
	@Path("timeSpan")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public int wsDays2(){
		return timespan.days();
	}
	
}
