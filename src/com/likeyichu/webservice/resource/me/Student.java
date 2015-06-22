package com.likeyichu.webservice.resource.me;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

@Entity
@Table( name = "studentTable")
public class Student {
	@Id
	int id;
	String name;
	boolean isGirl;
	
	@Column(name="time_stamp")
	@Temporal(TemporalType.TIMESTAMP)
	Date timestamp;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getTimeStamp() {
		return timestamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timestamp = timeStamp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isGirl() {
		return isGirl;
	}

	public void setGirl(boolean isGirl) {
		this.isGirl = isGirl;
	}
	public static void main(String[] args) {
		//加载src/hibernate.cfg.xml作为配置
		Configuration conf=new Configuration().configure();
		//so long,annoying
		ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
		SessionFactory sf=conf.buildSessionFactory(serviceRegistry);
		Session sess=sf.openSession();
		Transaction ts=sess.beginTransaction();
		Student student=new Student();
		student.setName("qiqi");
		//添加一行数据
		sess.save(student);
		ts.commit();
		//获得所有女同学，组装成一个list。
		@SuppressWarnings("unchecked")
		List<Student> list=sess.createQuery("from Student as t  where t.isGirl=true").list();
		System.out.println(list);
		sess.close();
		sf.close();
	}
}
