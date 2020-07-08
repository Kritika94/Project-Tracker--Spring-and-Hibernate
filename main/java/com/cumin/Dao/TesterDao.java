package com.cumin.Dao;

import java.util.List;

import org.hibernate.Session;

import com.cumin.entity.Tester;

public interface TesterDao {
public void testerSave(Session session,Tester tester);
public List<String> showAssigneeList(Session session, String Assignee);
public List<String> showStory(Session session,String reporter);
}
