package com.likeyichu.webservice.resource.me;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.likeyichu.webservice.resource.me.dao.GaoKaoScoreBean;
import com.likeyichu.webservice.resource.me.dao.GaoKaoScoreDaoImpl;

@Path("gaoKaoScore")
public class GaoKaoScore {
	public static List<GaoKaoScoreBean> artsList;
	public static List<GaoKaoScoreBean> ScienceList;
	
	@Path("science")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<GaoKaoScoreBean> fun1(@QueryParam("from" )int from,@QueryParam("to") int to){
		if(ScienceList==null)
			ScienceList=new GaoKaoScoreDaoImpl().getScienceData();
		return ScienceList.subList(from-1,to);
	}
	
}
