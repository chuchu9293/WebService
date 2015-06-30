package com.likeyichu.webservice.resource.me;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.likeyichu.webservice.me.bean.IPBean;
import com.likeyichu.webservice.me.dao.IPDaoImpl;

/**统计网站访客*/
@Path("ipVisit")
public class ipVisit {
	
	@Path("add")
	@GET
	//filter会完成具体的操作
	public String fun(){
		return "ok";
	}
	
	@Path("get")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<IPBean> fun1(){
		return IPDaoImpl.getLast50Elements();
	}
}
