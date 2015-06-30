package com.likeyichu.webservice.me.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.animation.KeyValue.Type;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.type.IntegerType;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import com.likeyichu.webservice.me.bean.IPBean;

public class IPDaoImpl extends DaoBase{
	static String utf8Deal(String str) {
		// 此时str是:{"country":"\u4e2d\u56fd" 这样的形式，需要转换
		Pattern reUnicode = Pattern.compile("\\\\u([0-9a-zA-Z]{4})");
		Matcher m = reUnicode.matcher(str);
		StringBuffer sb = new StringBuffer(str.length());
		while (m.find()) {
			m.appendReplacement(sb,
					Character.toString((char) Integer.parseInt(m.group(1), 16)));
		}
		m.appendTail(sb);
		return sb.toString();
	}
	
	/**通过百度地图解析IP信息*/
	public static String getIpInfo(String ip) {
		RestTemplate client = new RestTemplate();
		String url = "http://api.map.baidu.com/location/ip?ak=3GFi2F04wXaVuwmGu8fN49kL&ip="
				+ ip;
		String str = client.getForObject(url, String.class);
		System.out.println("fain from baiduMap:"+str);
		if (str.contains("\"status\":200"))
			return "error";
		int pos1 = str.indexOf(":");
		int pos2 = str.indexOf(",");
		str = str.substring(pos1 + 2, pos2 - 1);
		str = utf8Deal(str);
		String[] strArray = str.split("\\|");// 注意regex里"|"也是特殊字符
		String country = strArray[0].equals("CN") ? "中国" : strArray[0];
		String province = strArray[1];
		String city = strArray[2];
		String isp = strArray[4];
		switch (isp) {
		case "CMNET":
			isp = "移动";
			break;
		case "CHINANET":
			isp = "电信";
			break;
		case "UNICOM":
			isp = "联通";
			break;
		case "CERNET":
			isp = "教育网";
		}
		return country + "," + province + "," + city + "," + isp;
	}

	/**数据库读取最后50条*/
	public static List<IPBean> getLast50Elements() {
		Session sess=sf.openSession();
		@SuppressWarnings("unchecked")
		List<Object> list=null;
		int x=(int) sess.createSQLQuery("select max(id) from ipVisitTable").uniqueResult();
		int min=(int) x-50;
		List<IPBean> list2=sess.createQuery("from IPBean as t where t.id > "+min).list();
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
		for (IPBean ipBean : list2) {
			ipBean.setDateStr(format1.format(ipBean.getDate()));
		}
		List<IPBean> list3=new ArrayList<>();
		for(int i=list2.size()-1;i>=0;i--)
			list3.add(list2.get(i));
		//最新访问的排在前面
		return list3;
	}
	
	/**数据库添加*/
	public static boolean addIPVisit(String ip) {
		IPBean bean=new IPBean();
		bean.setIp(ip);
		bean.setIpInfo(getIpInfo(ip));
		Session sess=sf.openSession();
		Transaction ts=sess.beginTransaction();
		sess.save(bean);
		ts.commit();
		sess.close();
		return false;
	}
	
	@Test
	public void test() {
		System.out.println(getIpInfo("120.218.27.2"));
		addIPVisit("120.218.27.2");
	}

	public static void main(String[] args) {
		System.out.println(IPDaoImpl.getIpInfo("120.218.27.2"));
		addIPVisit("120.218.27.2");
		getLast50Elements();
	}
}
