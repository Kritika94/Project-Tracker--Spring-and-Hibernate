package com.cumin.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cumin.Dao.TesterDao;

import com.cumin.entity.Tester;
@Service
public class TesterServiceImpl implements TesterService {
	@Autowired 
	SessionFactory sessionFactory;
	@Autowired
	TesterDao dao;
	Session session;
	public void saveTester(Tester tester) {
    		session=sessionFactory.openSession();
    	    Transaction tx=session.beginTransaction();
    	    dao.testerSave(session, tester);
    	    tx.commit();
    	    session.close();
	}
	public List<String> showAssigneeList(String Assignee) {
		session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		List<String>list= dao.showAssigneeList(session, Assignee);
		tx.commit();
		session.close();
		return list;
	}
	public List<String> showList(String reporter) {
		session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		List<String> l=dao.showStory(session,reporter);
		tx.commit();
		session.flush();
		session.close();
	    return l;

	}


}
