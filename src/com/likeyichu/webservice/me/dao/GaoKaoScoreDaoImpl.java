package com.likeyichu.webservice.me.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

import com.likeyichu.webservice.me.bean.GaoKaoScoreBean;


public class GaoKaoScoreDaoImpl extends DaoBase{
	List<GaoKaoScoreBean> artsList;
	List<GaoKaoScoreBean> scienceList;
	
	@SuppressWarnings("unchecked")
	@Test
	public void getOriginData(){
//		scienceList=new ArrayList<>();
//		GaoKaoScoreBean gaoKaoScoreBeannew =new GaoKaoScoreBean();
//		gaoKaoScoreBeannew.setIdCard("410421199209300030");
//		gaoKaoScoreBeannew.setName("杜易初");
//		gaoKaoScoreBeannew.setLuoFenplusZhaoGuFen(610);
//		scienceList.add(gaoKaoScoreBeannew);
		
		Session sess=sf.openSession();
		scienceList=sess.createQuery("from GaoKaoScoreBean as t where t.type = '普通理科' order by t.total desc").list();
		artsList=sess.createQuery("from GaoKaoScoreBean as t where t.type = '普通文科' order by t.total desc").list();
		//List<GaoKaoScoreBean> list=sess.createQuery("from GaoKaoScoreBean as t where t.name like  '杜%' order by t.total desc").list();
		System.out.println(scienceList.size());
		System.out.println(artsList.size());
		sess.close();
	}
	
	public void initializeData(){
		getOriginData();
		for(int i=0;i<scienceList.size();i++){
			String old=scienceList.get(i).getIdCard();
			String newStr=old.substring(0, 10)+"*******"+old.substring(17,18);
			scienceList.get(i).setIdCard(newStr);
			scienceList.get(i).setRanking(i+1);
		}
		for(int i=0;i<artsList.size();i++){
			String old=artsList.get(i).getIdCard();
			String newStr=old.substring(0, 10)+"*******"+old.substring(17,18);
			artsList.get(i).setIdCard(newStr);
			artsList.get(i).setRanking(i+1);
		}
	}
	
	public List<GaoKaoScoreBean> getScienceData(){
		return scienceList;
	}

	public List<GaoKaoScoreBean> getArtsData() {
		return artsList;
	}
	
	public static void main(String[] args) {
		new GaoKaoScoreDaoImpl().getOriginData();
	}

}
