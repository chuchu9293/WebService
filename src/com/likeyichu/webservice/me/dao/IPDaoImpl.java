package com.likeyichu.webservice.me.dao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;


public class IPDaoImpl {
	static String utf8Deal(String str){
		//此时str是:{"country":"\u4e2d\u56fd" 这样的形式，需要转换
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
	
static String httpGet(String ip){
		RestTemplate client=new RestTemplate();
		String url="http://api.map.baidu.com/location/ip?ak=3GFi2F04wXaVuwmGu8fN49kL&ip="+ip;
		String  str=client.getForObject(url, String.class);
		return str;
	}
	public static String getIpInfo(String ip) {
		String str=httpGet(ip);
		if(str.contains("\"status\":200"))
			return "error";
		int pos1=str.indexOf(":");
		int pos2=str.indexOf(",");
		str=str.substring(pos1+2, pos2-1);
		str=utf8Deal(str);
		String [] strArray=str.split("\\|");//注意regex里"|"也是特殊字符
		String country=strArray[0].equals("CN")?"中国":strArray[0];
		String province=strArray[1];
		String city=strArray[2];
		String isp=strArray[4];
		switch(isp){
		case "CMNET":
			isp="移动";
			break;
		case "CHINANET":
			isp="电信";
			break;
		case "UNICOM":
			isp="联通";
			break;
		case "CERNET":
			isp="教育网";
		}
		
		return country+","+province+","+city+","+isp;
	}
	@Test
	public void test() {
		System.out.println(getIpInfo("120.218.27.2"));
	}
	
	public static void main(String[] args) {
		System.out.println(IPDaoImpl.getIpInfo("120.218.27.2"));
	}
}
