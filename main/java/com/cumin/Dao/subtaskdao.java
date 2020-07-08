package com.cumin.Dao;

import java.util.List;

import org.hibernate.Session;

import com.cumin.entity.Subtask;

public interface subtaskdao {
public void createsubtask(Session session, Subtask subtask);
	
public List<String> getSubtask(Session session, String cumin_number);	
}
