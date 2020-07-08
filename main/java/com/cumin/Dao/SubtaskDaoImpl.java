package com.cumin.Dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import org.springframework.stereotype.Repository;

import com.cumin.entity.Subtask;
@Repository
public class SubtaskDaoImpl implements subtaskdao {

	public void createsubtask(Session session,Subtask subtask) {
	session.save(subtask);
	}

	public List<String> getSubtask(Session session, String cumin_number) {
		String b=cumin_number;
		SQLQuery query=session.createSQLQuery("select description from subtask where cumins_cumin_number=:b");
		query.setParameter("b", b);
		List<String> list=(List<String>)query.list();
		System.out.println(list);
		return list;
	}

}
