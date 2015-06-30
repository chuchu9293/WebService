package com.likeyichu.webservice.me.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="gaoKaoScoreTable")
public class GaoKaoScoreBean {
	//报名序号
	@Id
	@Column(name="考生号")
	String no;
	@Column(name="姓名")
	String name;
	@Column(name="身份证")
	String idCard;
	@Column(name="考生类别")
	String type;
	@Column(name="语文")
	int chinese;
	@Column(name="数学")
	int math;
	@Column(name="综合")
	int comprehensive;
	@Column(name="外语")
	int english;
	@Column(name="总分")
	int total;
	@Column(name="裸分加照顾分")
	int luoFenplusZhaoGuFen;
	@Transient
	int ranking;
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getChinese() {
		return chinese;
	}
	public void setChinese(int chinese) {
		this.chinese = chinese;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getComprehensive() {
		return comprehensive;
	}
	public void setComprehensive(int comprehensive) {
		this.comprehensive = comprehensive;
	}
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		this.english = english;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getLuoFenplusZhaoGuFen() {
		return luoFenplusZhaoGuFen;
	}
	public void setLuoFenplusZhaoGuFen(int luoFenplusZhaoGuFen) {
		this.luoFenplusZhaoGuFen = luoFenplusZhaoGuFen;
	}
	public int getRanking() {
		return ranking;
	}
	public void setRanking(int ranKing) {
		this.ranking = ranKing;
	}
	
	
	
}
