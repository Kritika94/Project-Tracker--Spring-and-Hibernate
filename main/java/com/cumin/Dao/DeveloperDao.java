package com.cumin.Dao;

import org.hibernate.Session;

import com.cumin.entity.Developer;
import com.cumin.entity.Project;

public interface DeveloperDao {
public void saveDeveloper(Session session, Developer developer);
public Project finddeveloperproject(Session session, String user);
}
