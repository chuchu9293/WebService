package com.likeyichu.webservice.me.bean;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.junit.Test;

@Entity
@Table(name="ipVisitTable")
public class IPBean {
	@Id
	int id;
	//以下三个都同名
	String ip;//ipV4
	String ipInfo;//中国,河南,开封,移动
	Date date;//2015-6-30 12:10:10
	@Transient
	String dateStr;
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
		
	}
	public String getDateStr() {
		return dateStr;
	}
	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public int getId() {
		return id;
	}
}
