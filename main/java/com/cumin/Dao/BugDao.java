package com.cumin.Dao;

import org.hibernate.Session;

import com.cumin.entity.Bugs;
import com.cumin.entity.Project;

public interface BugDao {
public void createBug(Session session,Bugs bugs); 
public Bugs viewBug(Session session, String bug_id);
public void statusChange(Session session, String bug_id,String status);
public void setAssignee(Session session, String bug_id,String Assignee);
public Project findTesterProject(Session session, String user);

}
