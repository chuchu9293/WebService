package com.likeyichu.webservice.resource.me;

import java.util.ArrayList;
import java.util.List;

public class GaoKaoScoreDaoImpl {
	List<GaoKaoScoreBean> artsList;
	List<GaoKaoScoreBean> scienceList;
	
	void getOriginData(){
		scienceList=new ArrayList<>();
		GaoKaoScoreBean gaoKaoScoreBeannew =new GaoKaoScoreBean();
		gaoKaoScoreBeannew.setIdCard("410421199209300030");
		gaoKaoScoreBeannew.setName("杜易初");
		gaoKaoScoreBeannew.setLuoFenplusZhaoGuFen(610);
		scienceList.add(gaoKaoScoreBeannew);
	}
	
	void getData(){
		getOriginData();
		int i=1;
		for (GaoKaoScoreBean gaoKaoScoreBean : scienceList) {
			String old=gaoKaoScoreBean.getIdCard();
			String newStr=old.substring(0, 10)+"*******"+old.substring(17,18);
			gaoKaoScoreBean.setIdCard(newStr);
			gaoKaoScoreBean.setRanking(i++);
		}
	}
	
	public List<GaoKaoScoreBean> getScienceData(){
		getData();
		return scienceList;
		
	}
	
	
}
