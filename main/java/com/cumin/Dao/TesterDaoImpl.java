package com.cumin.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.cumin.entity.Tester;
@Repository
public class TesterDaoImpl implements TesterDao{

	public void testerSave(Session session,Tester tester) {
		 session.save(tester);
	}
	@Override
	public List<String> showAssigneeList(Session session, String Assignee) {
		System.out.println(Assignee);
		String a=Assignee;
		Query query= session.createSQLQuery("select bug_id  from bugs where Assignee=:a and (bug_status='Assigned' or bug_status='Inprogress')");
		query.setParameter("a", a);
		List<String> list=query.list();
		return list;
	}
	public List<String> showStory(Session session,String reporter) {
		String b=reporter;
		SQLQuery query=session.createSQLQuery("select bug_id from bugs where bug_reporter=:b");
		query.setParameter("b",b);
		List<String>list=(List<String>)query.list();
		for(String l:list) {
			System.out.println(l);
		}
		return list;
	
	

}
}