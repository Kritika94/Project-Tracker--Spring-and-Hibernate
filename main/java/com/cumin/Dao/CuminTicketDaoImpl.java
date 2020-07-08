package com.cumin.Dao;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;


import com.cumin.entity.cumin_ticket;

@Repository
public class CuminTicketDaoImpl implements CuminTicketDao{


public void createStory(cumin_ticket cumin,Session session) {
	session.save(cumin);
}

public List<String> showStory(Session session,String reporter) {
	String b=reporter;
	SQLQuery query=session.createSQLQuery("select cumin_number from cumin_ticket where reporter_name=:b");
	query.setParameter("b",b);
	List<String>list=(List<String>)query.list();
	for(String l:list) {
		System.out.println(l);
	}
	return list;
}

public cumin_ticket getStory(Session session,String cumin_number) {
	String b=cumin_number;
	Query query=session.createQuery("from cumin_ticket where cumin_number=:b");
	query.setParameter("b", b);
	cumin_ticket cumin=(cumin_ticket)query.uniqueResult();
	return cumin;
}

public void LogWork(Session session, String cumin_number, int remaining_hrs, String log_work) {
	String b=cumin_number;
    String a=log_work;
    int c=remaining_hrs;
	SQLQuery query=session.createSQLQuery("update cumin_ticket set log_work=:a , remaining_hrs=:c where cumin_number=:b");
    query.setParameter("b", b);
    query.setParameter("a", a);
    query.setParameter("c",c);
    query.executeUpdate();
	
}

public void saveDevUnderstanding(Session session, String cumin_number, String DevUnderstanding) {
	String b=cumin_number;
    String a=DevUnderstanding;
	SQLQuery query=session.createSQLQuery("update cumin_ticket set DevUnderstanding=:a where cumin_number=:b");
	 query.setParameter("b", b);
	 query.setParameter("a", a);
	 query.executeUpdate();
}

public void cuminstatus(Session session, String cumin_number, String status) {
	String b=cumin_number;
	String a=null;
    if(status.equals("open")) {
    	a="Assigned";
    }
    if(status.equals("Assigned")) {
    	a="Inprogress";
    }
    if(status.equals("Inprogress")) {
    	a="Closed";
    }
    if(status.equals("Closed")) {
    	a="open";
    }
    SQLQuery query=session.createSQLQuery("update cumin_ticket set status=:a where cumin_number=:b");
	query.setParameter("b", b);
	query.setParameter("a", a);
	query.executeUpdate();
	
}

public List<String> showAssigneeList(Session session, String Assignee) {
	String a=Assignee;
	Query query= session.createSQLQuery("select cumin_number from cumin_ticket where Assignee=:a and (status='Assigned' or status ='Inprogress')");
	query.setParameter("a", a);
	List<String> list=query.list();
	return list;
}

public void saveAssignee(Session session, String cumin_number, String assignee) {
	String a=assignee;
	String b=cumin_number;
	Query query= session.createSQLQuery("update cumin_ticket set assignee=:a where cumin_number=:b");
	query.setParameter("a", a);
	query.setParameter("b", b);
	query.executeUpdate();
}

public void saveWorkLogs(Session session, String cumin_number, String log_work) {
	String a=log_work;
	String b=cumin_number;
	Query query= session.createSQLQuery("update cumin_ticket set log_work=:a where cumin_number=:b");
	query.setParameter("a", a);
	query.setParameter("b", b);
	query.executeUpdate();
}
}
