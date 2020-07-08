package com.cumin.Dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.cumin.entity.cumin_ticket;


public interface CuminTicketDao {
public void createStory(cumin_ticket cumin,Session session);
public List<String> showStory(Session session, String reporter);
public cumin_ticket getStory(Session session, String cumin_number);
public void LogWork(Session session, String cumin_number, int remaining_hrs,String log_work);
public void saveDevUnderstanding(Session session, String cumin_number,  String DevUnderstanding);
public void saveAssignee(Session session, String cumin_number,String assignee);
public void saveWorkLogs(Session session, String cumin_number,String log_work);
public void cuminstatus(Session session, String cumin_number,  String status);
public List<String> showAssigneeList(Session session, String Assignee);

}