package com.cumin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cumin.entity.Project;
import com.cumin.entity.Project_Manager;
import com.cumin.service.ProjectService;

@Controller
@RequestMapping("/Project")
public class ProjectController {
	@Autowired
	ProjectService service;
	

@RequestMapping("/addProject")
public String addProject(Project Project) {
	return "ProjectRegister";
}
	
@PostMapping("/Manager")
public String addManager(Project_Manager manager) {
	service.addManager(manager);	
 return "redirect:/Project/Project_Home";
}



	@RequestMapping(value="/saveProject",method = RequestMethod.POST)
	public String SaveProject(Project project , @RequestParam("manager") String user) {
		Project_Manager manager=service.getManager(user);
		project.setManager_id(manager);
		service.addProject(project);
		return "redirect:/Project/Project_Home";
	}
	
	@GetMapping("/AboutProject/{emp_id}")
	public ModelAndView AboutProject(@PathVariable("emp_id") int id) {
		Project project=service.getProject(id);
		ModelAndView mv =new ModelAndView();
		mv.addObject("Project", project);
		mv.setViewName("AboutProjectManage");
		return mv;
	}
	
	@GetMapping("/Project_Home")
	public String ProjectHome() {
		return "ProjectHome";
	}	
	
	@GetMapping("/addDeveloper")
	public String developer() {
		
		return "AddDeveloper"; 
			
		
		
	}
}

