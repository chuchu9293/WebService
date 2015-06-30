package com.likeyichu.webservice.me.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class DaoBase {
	static SessionFactory sf;
	
	static{
		//加载src/hibernate.cfg.xml作为配置
				Configuration conf=new Configuration().configure();
				//so long,annoying
				ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
				sf=conf.buildSessionFactory(serviceRegistry);
	}
}
