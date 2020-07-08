package com.cumin.controller;
import java.security.Principal;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestScope;
import org.springframework.web.context.request.SessionScope;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.cumin.Dao.CuminTicketDao;
import com.cumin.entity.Bugs;
import com.cumin.entity.cumin_ticket;
import com.cumin.service.CuminTicketService;
import com.cumin.service.ProjectService;
import com.cumin.service.ReportService;
import com.cumin.service.TesterService;
import com.cumin.service.TesterServiceImpl;

@Controller

public class AddController {
	@Autowired
	private CuminTicketService daos;
	@Autowired
	private ProjectService service;
	 @Autowired
	 private TesterService testservice;
     @Autowired
     private ReportService reportservice;
	 
	@RequestMapping("/")
	public ModelAndView hello(Principal principal, HttpServletRequest request) {
		HttpSession session =request.getSession();
		ModelAndView mv= new ModelAndView();
		String name=principal.getName();
		session.setAttribute("user", name);
		List<String> Assigned=daos.showAssigneeList(name);
		List<String> AssignedBugs=testservice.showAssigneeList(name);
		List<String>dao=daos.showList(name);
		mv.addObject("Assigned",Assigned);
		mv.addObject("AssignedBugs",AssignedBugs);
		mv.addObject("list", dao);
		mv.setViewName("/CuminDashboard");
		return mv;
	}
@GetMapping("/Managers")
public ModelAndView Manager(Principal principal, HttpServletRequest request) {
	HttpSession session =request.getSession();
	ModelAndView mv= new ModelAndView();
	String name=principal.getName();
	session.setAttribute("user", name);
	int id=service.findManager(name);
	System.out.println(id);
    mv.addObject("emp_id", id);
    session.setAttribute("emp_id", id);
	mv.setViewName("/ProjectHome");
	return mv; 
}
@GetMapping("/Testers")
public ModelAndView Testers(Principal principal, HttpServletRequest request) {
	HttpSession session =request.getSession();
	ModelAndView mv= new ModelAndView();
	String name=principal.getName();
	session.setAttribute("user", name);
	List<String> Assigned=testservice.showAssigneeList(name);
	List<String>dao=testservice.showList(name);
	List<String> AssignedTicket=daos.showAssigneeList(name);
	mv.addObject("Assignee",Assigned);
	mv.addObject("AssignedTicket",AssignedTicket);
	mv.addObject("list", dao);
	mv.setViewName("/Tester");
	return mv; 
}





@GetMapping("/createStory")
public String createStory() {
	return "CreateStory";
}
@GetMapping("/dashboard")
public ModelAndView cuminDashboard(HttpSession sess) {
	ModelAndView mv=new ModelAndView();
	String reporter=(String)sess.getAttribute("user");
	List<String> Assigned=daos.showAssigneeList(reporter);
	List<String> AssignedBugs=testservice.showAssigneeList(reporter);
	List<String>dao=daos.showList(reporter);
	mv.addObject("Assigned",Assigned);
	mv.addObject("list", dao);
	mv.addObject("AssignedBugs",AssignedBugs);
	mv.setViewName("/CuminDashboard");
	return mv;
}

@GetMapping("/ProjectStatus")
public String ProjectStatus() {
	return "ProjectStatusManage";
}
@GetMapping("/Reports")
public ModelAndView Reports(@RequestParam("value") String value) {
	
	ModelAndView mv=new ModelAndView();
	if (value.equals("BugReport")) {
		List<Bugs> BugReport=reportservice.ShowBugs();
		
		mv.addObject("BugReport", BugReport);
	}
	if (value.equals("CuminStatus")) {
List<cumin_ticket> cumins=reportservice.Showcumin_ticket();
		
		mv.addObject("cumins", cumins);
	}
	if (value.equals("ProjectReport")) {
		List<cumin_ticket> cumins=reportservice.Showcumin_ticket();
		int size=cumins.size();
		Integer counter=reportservice.counter();
		mv.addObject("counter", counter);
		mv.addObject("size", size);
	}
		
		
    mv.addObject("value", value);
	mv.setViewName("Reports");
	return mv;
}


}
