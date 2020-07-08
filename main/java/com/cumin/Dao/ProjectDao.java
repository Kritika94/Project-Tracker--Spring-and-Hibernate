package com.cumin.Dao;

import org.hibernate.Session;

import com.cumin.entity.Project;
import com.cumin.entity.Project_Manager;

public interface ProjectDao {
public void addManager(Session session, Project_Manager manager);
public int findManager(Session session,String user );
public void addProject(Session session,Project project);
public Project_Manager getManager(Session session,String name);
public Project getProject(Session session,int id);
}
