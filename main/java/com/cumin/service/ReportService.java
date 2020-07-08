package com.cumin.service;

import java.util.List;

import org.hibernate.Session;

import com.cumin.entity.Bugs;
import com.cumin.entity.cumin_ticket;

public interface ReportService {
	public List<Bugs> ShowBugs();
	public List<cumin_ticket> Showcumin_ticket();
	public int counter();

}
