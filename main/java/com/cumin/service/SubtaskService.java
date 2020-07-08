package com.cumin.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cumin.Dao.subtaskdao;
import com.cumin.entity.Subtask;
@Service
public class SubtaskService implements SubtaskServiceInterface {
@Autowired 
SessionFactory sf;
@Autowired
subtaskdao dao;
Session session;
	
	public void subtask(Subtask subtask) {
		session=sf.openSession();
		Transaction tx=session.beginTransaction();
		dao.createsubtask(session, subtask);
		tx.commit();
		session.close();
		
	}

	public List<String> getSubtask(String cumin_number) {
		session=sf.openSession();
		Transaction tx=session.beginTransaction();
     	List<String>list=dao.getSubtask(session, cumin_number);
		tx.commit();
		session.close();
		return list;
	}

	
	
	

}
