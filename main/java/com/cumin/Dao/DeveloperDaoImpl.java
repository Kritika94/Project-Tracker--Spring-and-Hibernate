package com.cumin.Dao;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.cumin.entity.Developer;
import com.cumin.entity.Project;
@Repository
public class DeveloperDaoImpl implements DeveloperDao {

	public void saveDeveloper(Session session, Developer developer) {
		session.save(developer);
		
	}

	public Project finddeveloperproject(Session session,String user) {
		String b=user;
		Query query=session.createQuery("select project_id from Developer where name=:b");
        query.setParameter("b", b);
        Project project=(Project)query.uniqueResult();
        System.out.println(project);
		return project;
	}

}
