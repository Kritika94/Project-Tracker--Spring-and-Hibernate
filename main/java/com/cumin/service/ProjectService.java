package com.cumin.service;

import org.hibernate.Session;

import com.cumin.entity.Project;
import com.cumin.entity.Project_Manager;

public interface ProjectService {
public void addManager(Project_Manager manager);
public int findManager(String user);
public void addProject(Project project);
public Project_Manager getManager(String user);
public Project getProject(int id);
}
