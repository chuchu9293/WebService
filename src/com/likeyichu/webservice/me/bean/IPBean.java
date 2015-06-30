package com.likeyichu.webservice.me.bean;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class IPBean {
	String ip;
	String ipInfo;
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getIpInfo() {
		return ipInfo;
	}
	public void setIpInfo(String ipInfo) {
		this.ipInfo = ipInfo;
	}
}
