package com.likeyichu.webservice.resource.me.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;


public class GaoKaoScoreDaoImpl {
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
		
		
		//加载src/hibernate.cfg.xml作为配置
		Configuration conf=new Configuration().configure();
		//so long,annoying
		ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
		SessionFactory sf=conf.buildSessionFactory(serviceRegistry);
		Session sess=sf.openSession();
		scienceList=sess.createQuery("from GaoKaoScoreBean as t where t.type = '普通理科' order by t.total desc").list();
		//List<GaoKaoScoreBean> list=sess.createQuery("from GaoKaoScoreBean as t where t.name like  '杜%' order by t.total desc").list();
		System.out.println(scienceList.size());
		sess.close();
		sf.close();
	}
	
	void getData(){
		getOriginData();
		for(int i=0;i<scienceList.size();i++){
			String old=scienceList.get(i).getIdCard();
			String newStr=old.substring(0, 10)+"*******"+old.substring(17,18);
			scienceList.get(i).setIdCard(newStr);
			scienceList.get(i).setRanking(i+1);
		}
	}
	
	public List<GaoKaoScoreBean> getScienceData(){
		getData();
		return scienceList;
		
	}
	
	public static void main(String[] args) {
		new GaoKaoScoreDaoImpl().getOriginData();
	}
}