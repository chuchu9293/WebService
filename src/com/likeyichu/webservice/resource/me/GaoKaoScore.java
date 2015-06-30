package com.likeyichu.webservice.resource.me;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.likeyichu.webservice.me.bean.GaoKaoScoreBean;
import com.likeyichu.webservice.me.dao.GaoKaoScoreDaoImpl;

@Path("gaoKaoScore")
public class GaoKaoScore {
	public static List<GaoKaoScoreBean> artsList;
	public static List<GaoKaoScoreBean> scienceList;
	static{
		init();
	}
	
	static void init(){
		GaoKaoScoreDaoImpl obj=new GaoKaoScoreDaoImpl();
		//从数据库中读数据
		obj.initializeData();
		scienceList = obj.getScienceData();
		artsList = obj.getArtsData();
	}
	
	
	@Path("science")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<GaoKaoScoreBean> fun1(@QueryParam("from") int from,
			@QueryParam("to") int to) {
		return scienceList.subList(from - 1, to);
	}

	@Path("arts")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<GaoKaoScoreBean> fun2(@QueryParam("from") int from,
			@QueryParam("to") int to) {
		return artsList.subList(from - 1, to);
	}

	@Path("{fuzzyQuery}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<GaoKaoScoreBean> fun3(
			@PathParam(value = "fuzzyQuery") String name) {
		String regularExpression = ".*" + name + ".*";
		List<GaoKaoScoreBean> list = new ArrayList<>();
		//理科生查找
		for (GaoKaoScoreBean gaoKaoScoreBean : scienceList)
			if (gaoKaoScoreBean.getName().matches(regularExpression))
				list.add(gaoKaoScoreBean);
		//文科生查找
		for (GaoKaoScoreBean gaoKaoScoreBean : artsList)
			if (gaoKaoScoreBean.getName().matches(regularExpression))
				list.add(gaoKaoScoreBean);
		return list;
	}
}
