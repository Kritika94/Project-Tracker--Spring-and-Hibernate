package com.cumin.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cumin.Dao.ProjectDao;
import com.cumin.entity.Project;
import com.cumin.entity.Project_Manager;
@Service
public class ProjectServiceImpl implements ProjectService {
@Autowired
SessionFactory sessionFactory;
@Autowired
ProjectDao dao;
Session session;
	public void addManager(Project_Manager manager) {
	session=sessionFactory.openSession();
	Transaction tx=session.beginTransaction();
	dao.addManager(session, manager);
	tx.commit();
	session.close();
	}
	public int findManager(String user) {
		session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
        int id=dao.findManager(session, user);
		tx.commit();
		session.close();
		return id;
		
	}
	public void addProject(Project project) {
		session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
        dao.addProject(session, project);
		tx.commit();
		session.close();
	}
	public Project_Manager getManager(String user) {
		session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
        Project_Manager manager=dao.getManager(session, user);
		tx.commit();
		session.close();
		return manager;		
	}
	public Project getProject(int id) {
		session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
        Project project=dao.getProject(session, id);
		tx.commit();
		session.close();
		return project;	
	}
	
	
	
	
	

}
