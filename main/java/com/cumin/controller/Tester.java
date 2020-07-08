package com.cumin.controller;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cumin.entity.Bugs;
import com.cumin.entity.Project;
import com.cumin.entity.cumin_ticket;
import com.cumin.service.CreateBugservice;
import com.cumin.service.CuminTicketService;

@Controller
@RequestMapping("/Tester")
public class Tester {
	@Autowired
	CreateBugservice service;
	@Autowired
	private CuminTicketService daos;
	
	@RequestMapping("/CreateBug")
	public String Testers(Bugs bugs) {
		return "CreateBugs";
	}
	
	@PostMapping("/SaveBug")
	public String createBug(@RequestParam("bug_type") String bug_type,@RequestParam("description") String description,@RequestParam("bug_reporter") String bug_reporter,@RequestParam("Assignee") String Assignee,@RequestParam("bugs_header") String bugs_header, @RequestParam("cumin_ticket") String cumin,HttpSession session) {
		Bugs bug=new Bugs();
		Random r =new Random();
		String bugs_id="EmmBugs"+r.nextInt(453733);
		bug.setAssignee(Assignee);
		bug.setBug_type(bug_type);
		bug.setBugs_header(bugs_header);
		bug.setDescription(description);
		bug.setBug_id(bugs_id);
		bug.setBug_status("Open");
		cumin_ticket cumin_ticket=daos.getStory(cumin);
		bug.setCumin_ticket(cumin_ticket);
		bug.setBug_reporter(bug_reporter);
		service.savebug(bug);
		System.out.println(bug);
		ModelAndView mv=new ModelAndView();
		mv.addObject("bug",bug);
		return "redirect:/Testers";
	}
	
	@GetMapping("/viewBug/{bug_id}")
	public ModelAndView viewBug(@PathVariable("bug_id") String Id) {
		ModelAndView mv =new ModelAndView();
		Bugs bugs=service.viewBug(Id);
		mv.addObject("bugs", bugs);
		mv.setViewName("viewBug");
		return mv;
		
	}
	
	@GetMapping("/statusChange")
	public String statusChange(@RequestParam ("bug_id") String bug_id ,@RequestParam ("bug_status") String status) {
	service.statusChange(bug_id, status);
	return "redirect:/Tester/viewBug/"+bug_id;
	}
	@GetMapping("/SetAssignee")
	public String SetAssignee(@RequestParam ("bug_id") String bug_id ,@RequestParam ("Assignee") String Assignee) {
		service.setAssignee(bug_id, Assignee);
		return "redirect:/Tester/viewBug/"+bug_id;	
	}
	
	@GetMapping("/AboutProjectTester")
	public ModelAndView AboutProject(HttpSession session) {
		String user=(String)session.getAttribute("user");
		Project project=service.findTesterProject(user);
		ModelAndView mv= new ModelAndView();
		mv.addObject("Project", project);
		mv.setViewName("AboutProjectTester");
		return mv;
	}
	
}
	
	
	

