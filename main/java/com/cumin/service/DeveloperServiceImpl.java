package com.cumin.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cumin.Dao.DeveloperDao;
import com.cumin.Dao.DeveloperDaoImpl;
import com.cumin.entity.Developer;
import com.cumin.entity.Project;
@Service
public class DeveloperServiceImpl implements DeveloperService {
	@Autowired 
	SessionFactory sessionFactory;
	@Autowired
	DeveloperDao dao;
	Session session;
	public void Savedeveloper(Developer developer) {
    		session=sessionFactory.openSession();
    	    Transaction tx=session.beginTransaction();
    	    dao.saveDeveloper(session, developer);
    	   tx.commit();
    	   session.close();
	}
	public Project finddeveloperproject(String user) {
		session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
     	Project project=dao.finddeveloperproject(session, user);
		tx.commit();
		session.close();
		return project;
	}

}
