package com.likeyichu.webservice.filter;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.likeyichu.webservice.me.dao.IPDaoImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *1.用于执行response.addHeader("Access-Control-Allow-Origin", "*");以便跨域服务
 *2.统计ip访问, 若一个ip十分钟内访问过，不予记录
 */
public class WebServiceFilter implements Filter {
	static Map <String,Long> ipRecordMap=new HashMap<String,Long>();
	
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String path = ((HttpServletRequest)request).getRequestURI();
       
        if (path != null && (path.startsWith("/webService/"))) {
             HttpServletResponse res = (HttpServletResponse) response;
             res.addHeader("Access-Control-Allow-Origin", "*");
             res.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS");
             res.addHeader("Access-Control-Allow-Headers", "Content-Type");
             //对结果的过滤也要放在doFilter()前面
             chain.doFilter(request, response);
        } 
        String ip=request.getRemoteAddr();
        System.out.println("gain ip:"+ip);
        addIpVisit(ip);
    }
    void addIpVisit(String ip){
    	//若一个ip十分钟内访问过，不予记录
		long currentTime=new Date().getTime();
		//如果该ip第一次访问
		if(ipRecordMap.get(ip)==null)
			ipRecordMap.put(ip, 0L);
		boolean isFresh=(currentTime-ipRecordMap.get(ip))/1000/60>10;
		if(isFresh){
			//更新
			ipRecordMap.put(ip, currentTime);
			IPDaoImpl.addIPVisit(ip);
		}
    }
	@Override
	public void destroy() {
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
}
