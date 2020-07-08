package com.cumin.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cumin.Dao.BugDao;
import com.cumin.entity.Bugs;
import com.cumin.entity.Project;

@Service
public class Cumin_Bug implements CreateBugservice{
	private Session session;
	@Autowired
	private SessionFactory sf;
	@Autowired
	private BugDao bug;
	

	public void savebug(Bugs bugs) {
		session =sf.openSession();
		Transaction tx=session.beginTransaction();
		bug.createBug(session, bugs);
		tx.commit();
		session.close();
	}
	
	
	@Override
	public Bugs viewBug(String bug_id) {
		session=sf.openSession();
		Transaction tx=session.beginTransaction();
		Bugs bugs=bug.viewBug(session, bug_id);
		tx.commit();
		session.close();
		return bugs;
	}


	@Override
	public void statusChange(String bug_id, String status) {
		session=sf.openSession();
		Transaction tx=session.beginTransaction();
		bug.statusChange(session,bug_id,status);
		tx.commit();
		session.close();
		
	}


	@Override
	public void setAssignee(String bug_id, String Assignee) {
		session=sf.openSession();
		Transaction tx=session.beginTransaction();
		bug.setAssignee(session,bug_id,Assignee);
		tx.commit();
		session.close();
	}


	@Override
	public Project findTesterProject(String user) {
		session=sf.openSession();
		Transaction tx=session.beginTransaction();
		Project project=bug.findTesterProject(session,user);
		tx.commit();
		session.close();
		return project;
	}
	
	
	

}
