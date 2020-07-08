package com.cumin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cumin.entity.Developer;
import com.cumin.entity.Project;
import com.cumin.entity.Tester;
import com.cumin.service.DeveloperService;
import com.cumin.service.ProjectService;
import com.cumin.service.TesterService;

@Controller
@RequestMapping(value="/Developer")
public class DeveloperController {
@Autowired
DeveloperService daos;	
@Autowired
ProjectService service;
@Autowired
TesterService testerservice;

@PostMapping("/saveDev")
public String saveDeveloper(Developer developer, Tester tester,@RequestParam("id") int id,@RequestParam("DevType") String DevType) {
	Project project=service.getProject(id);
	developer.setProject_id(project);
	System.out.println(DevType);
	if(DevType.equals("Developer")) {
	daos.Savedeveloper(developer);}
	else if(DevType.equals("Tester")) {
		tester.setProject_id(project);
		testerservice.saveTester(tester);
	}
	return "redirect:/Project/Project_Home";
}
@GetMapping("/AboutProject")
public ModelAndView AboutProject(HttpSession session) {
	String user=(String)session.getAttribute("user");
	Project project=daos.finddeveloperproject(user);
	ModelAndView mv= new ModelAndView();
	mv.addObject("Project", project);
	mv.setViewName("AboutProject");
	return mv;
}


}
