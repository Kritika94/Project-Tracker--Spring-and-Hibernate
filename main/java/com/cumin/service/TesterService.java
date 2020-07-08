package com.cumin.service;



import java.util.List;

import com.cumin.entity.Tester;

public interface TesterService {
	public void saveTester(Tester tester);
	public List<String> showAssigneeList(String Assignee);
	public List<String> showList(String reporter);
}
