package com.cumin.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.cumin.entity.cumin_ticket;

public interface CuminTicketService {
	public void createStory(cumin_ticket cumin);
	public List<String> showList(String reporter);
	public cumin_ticket getStory(String cumin_number);
	public void LogWork(String cumin_number, int remaining_hrs, String log_work);
	public void saveAssignee(String cumin_number, String assignee);
	public void saveDevUnderstanding(String cumin_number,  String DevUnderstanding);
	public void cuminstatus(String cumin_number,  String status);
	public List<String> showAssigneeList(String Assignee);
	public void saveLogWork(String cumin_number,String log_work);
}

