package com.cumin.service;

import 	org.hibernate.Transaction;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cumin.Dao.CuminTicketDao;
import com.cumin.entity.cumin_ticket;

@Service
public class Cumin_ticketservice implements CuminTicketService {
@Autowired
CuminTicketDao dao;
@Autowired 
private SessionFactory  sf;
Session session;
public void createStory(cumin_ticket cumin) {
session=sf.openSession();
Transaction tx=session.beginTransaction();
dao.createStory(cumin,session);
tx.commit();
session.flush();
session.close();
	
}
public List<String> showList(String reporter) {
	session=sf.openSession();
	Transaction tx=session.beginTransaction();
	List<String> l=dao.showStory(session,reporter);
	tx.commit();
	session.flush();
	session.close();
    return l;

}
public cumin_ticket getStory(String cumin_number) {
	session=sf.openSession();
	Transaction tx=session.beginTransaction();
	cumin_ticket cumin=dao.getStory(session,cumin_number);
	tx.commit();
	session.close();
	return cumin;
}

public void LogWork(String cumin_number, int remaining_hrs, String log_work) {
	session=sf.openSession();
	Transaction tx=session.beginTransaction();
	dao.LogWork(session, cumin_number, remaining_hrs, log_work);
	tx.commit();
	session.close();
	
	
}
public void saveDevUnderstanding(String cumin_number, String DevUnderstanding) {
	session=sf.openSession();
	Transaction tx=session.beginTransaction();
	dao.saveDevUnderstanding(session, cumin_number, DevUnderstanding);
	tx.commit();
	session.close();	
}
public void cuminstatus(String cumin_number, String status) {
	session=sf.openSession();
	Transaction tx=session.beginTransaction();
	dao.cuminstatus(session, cumin_number, status);
	tx.commit();
	session.close();
}
public List<String> showAssigneeList(String Assignee) {
	session=sf.openSession();
	Transaction tx=session.beginTransaction();
	List<String>list= dao.showAssigneeList(session, Assignee);
	tx.commit();
	session.close();
	return list;
}
public void saveAssignee(String cumin_number, String assignee) {
	session=sf.openSession();
	Transaction tx=session.beginTransaction();
	dao.saveAssignee(session, cumin_number, assignee);
	tx.commit();
	session.close();	
}
public void saveLogWork(String cumin_number, String log_work) {
	session=sf.openSession();
	Transaction tx=session.beginTransaction();
	dao.saveWorkLogs(session, cumin_number, log_work);
	tx.commit();
	session.close();
	
}




}
