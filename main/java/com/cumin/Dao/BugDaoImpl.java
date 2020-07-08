package com.cumin.Dao;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.cumin.entity.Bugs;
import com.cumin.entity.Project;
@Repository
public class BugDaoImpl implements BugDao {

	public void createBug(Session session,Bugs bugs) {
		session.save(bugs);
		
	}

	@Override
	public Bugs viewBug(Session session, String bug_id) {
		String b=bug_id;
		Query query=session.createQuery("from Bugs where bug_id=:b");
		query.setParameter("b", b);
		Bugs bug=(Bugs)query.uniqueResult();
		System.out.println(bug);
		return bug;
	}

	@Override
	public void statusChange(Session session, String bug_id, String status) {
		String b=bug_id;
		String a=null;
	    if(status.equals("Open")) {
	    	a="Assigned";
	    }
	    if(status.equals("Assigned")) {
	    	a="Inprogress";
	    }
	    if(status.equals("Inprogress")) {
	    	a="Closed";
	    }
	    if(status.equals("Closed")) {
	    	a="Open";
	    }
		Query query=session.createSQLQuery("update Bugs set bug_status=:a where bug_id=:b");
		query.setParameter("b", b);
		query.setParameter("a", a);
		query.executeUpdate();
	}

	@Override
	public void setAssignee(Session session, String bug_id, String Assignee) {
		String b=bug_id;
		String a=Assignee;
		Query query=session.createSQLQuery("update Bugs set Assignee=:a where bug_id=:b");
		query.setParameter("b", b);
		query.setParameter("a", a);
		query.executeUpdate();
	}

	@Override
	public Project findTesterProject(Session session, String user) {
		String b=user;
		Query query=session.createQuery("select project_id from Tester where name=:b");
        query.setParameter("b", b);
        Project project=(Project)query.uniqueResult();
        System.out.println(project);
		return project;
	}
	
	
}
