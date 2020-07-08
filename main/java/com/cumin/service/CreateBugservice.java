package com.cumin.service;

import com.cumin.entity.Bugs;
import com.cumin.entity.Project;

public interface CreateBugservice {
public void savebug(Bugs bug);
public Bugs viewBug(String bug_id);
public void statusChange(String bug_id, String status);
public void setAssignee(String bug_id, String Assignee);
public Project findTesterProject(String user);


}
