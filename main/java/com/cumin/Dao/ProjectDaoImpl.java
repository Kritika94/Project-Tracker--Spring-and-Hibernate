package com.cumin.Dao;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.cumin.entity.Project;
import com.cumin.entity.Project_Manager;
@Repository
public class ProjectDaoImpl implements ProjectDao{

	public void addManager(Session session, Project_Manager manager) {
		session.save(manager);
	}

	public int findManager(Session session, String user) {
		String b=user;
		int emp_id=0;
		try{SQLQuery query=session.createSQLQuery("Select emp_id from project_manager where uname=:b");
		query.setParameter("b", b);
		emp_id=(Integer) query.uniqueResult();
		}
		catch(NullPointerException e){
			emp_id=0;
		}

		return emp_id;
	}

	public void addProject(Session session, Project Project){
		session.save(Project);
	}

	public Project_Manager getManager(Session session, String name) {
		String b=name;
		Query q=session.createQuery("from Project_Manager where uname=:b");
		q.setParameter("b",b);
		Project_Manager manager=(Project_Manager)q.uniqueResult();
		return manager;
	}

	public Project getProject(Session session, int id) {
		int b=id;
		Project project;
		try {
			Query query=session.createQuery("from Project where manager_id_emp_id=:b");
			query.setParameter("b", b);
			project=(Project)query.uniqueResult();
		}
		catch(NullPointerException ex) {
			project=null;
		}
		return project;
	}

}
