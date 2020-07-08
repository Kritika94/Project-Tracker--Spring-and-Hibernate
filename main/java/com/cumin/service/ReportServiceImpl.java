package com.cumin.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cumin.Dao.ReportsDao;
import com.cumin.entity.Bugs;
import com.cumin.entity.cumin_ticket;
@Service
public class ReportServiceImpl implements ReportService {
	private Session session;
	@Autowired
	private SessionFactory sf;
	@Autowired
	private ReportsDao report;
	@Override
	public List<Bugs> ShowBugs() {
		session =sf.openSession();
		Transaction tx=session.beginTransaction();
		List<Bugs> list=report.ShowBugs(session);
		tx.commit();
		session.close();
		return list;
	}

	@Override
	public List<cumin_ticket> Showcumin_ticket() {
		session=sf.openSession();
		Transaction tx=session.beginTransaction();
		List<cumin_ticket> list=report.Showcumin_ticket(session);
		tx.commit();
		session.close();
		return list;
		
	}

	@Override
	public int counter() {
		session=sf.openSession();
		Transaction tx=session.beginTransaction();
		Integer counter=report.counter(session);
		tx.commit();
		session.close();
		return counter;
	}

}
