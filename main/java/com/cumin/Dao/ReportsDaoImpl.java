package com.cumin.Dao;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.cumin.entity.Bugs;
import com.cumin.entity.cumin_ticket;
@Repository
public class ReportsDaoImpl implements ReportsDao {

	@Override
	public List<Bugs> ShowBugs(Session session) {
		Query query=session.createQuery("from Bugs");
		List<Bugs> list=(List<Bugs>)query.list();
		return list;
	}

	@Override
	public List<cumin_ticket> Showcumin_ticket(Session session) {
		Query query=session.createQuery("from cumin_ticket");
		List<cumin_ticket> list=(List<cumin_ticket>)query.list();
		return list;
	}

	@Override
	public int counter(Session session) {
		Query query=session.createSQLQuery("select count(*) from cumin_ticket where status='Closed'");
		BigInteger counter=(BigInteger)query.uniqueResult();
		return counter.intValue();
	}

}
