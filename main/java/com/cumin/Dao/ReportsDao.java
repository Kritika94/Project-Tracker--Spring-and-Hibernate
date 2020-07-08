package com.cumin.Dao;

import java.util.List;

import org.hibernate.Session;

import com.cumin.entity.Bugs;
import com.cumin.entity.cumin_ticket;

public interface ReportsDao {
public List<Bugs> ShowBugs(Session session);
public List<cumin_ticket> Showcumin_ticket(Session session);
public int counter(Session session);

}
