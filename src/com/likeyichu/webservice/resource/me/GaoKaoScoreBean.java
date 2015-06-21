package com.likeyichu.webservice.resource.me;

public class GaoKaoScoreBean {
	//报名序号
	String no;
	String name;
	String idCard;
	String type;
	String kaoShengHao;
	int chinese,math,comprehensive,english;
	//裸分，照顾分，裸分+照顾分
	int total,zhaoGuFen,luoFenplusZhaoGuFen;
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
	public String getKaoShengHao() {
		return kaoShengHao;
	}
	public void setKaoShengHao(String kaoShengHao) {
		this.kaoShengHao = kaoShengHao;
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
	public int getZhaoGuFen() {
		return zhaoGuFen;
	}
	public void setZhaoGuFen(int zhaoGuFen) {
		this.zhaoGuFen = zhaoGuFen;
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
