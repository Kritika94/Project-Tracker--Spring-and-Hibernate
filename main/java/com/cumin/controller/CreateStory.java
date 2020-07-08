package com.cumin.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cumin.entity.Subtask;
import com.cumin.entity.cumin_ticket;
import com.cumin.service.CuminTicketService;
import com.cumin.service.SubtaskServiceInterface;

@Controller
@RequestMapping(value="/create")
public class CreateStory {

	@Autowired
	private CuminTicketService daos;
	@Autowired
	private SubtaskServiceInterface subdao;

	@RequestMapping(value="/saveStory" ,method=RequestMethod.POST)
	public String saveStory(cumin_ticket cumin) {
		Random r=new Random();
		String cumin_number="EmmGDCCX"+r.nextInt(48748);
		cumin.setCumin_number(cumin_number);
		cumin.setStatus("open");
		ModelAndView mv =new ModelAndView();	
		System.out.println(cumin);
		daos.createStory(cumin);
		mv.addObject(cumin);
		return "redirect:/dashboard";
	}
	
	@GetMapping(value="/viewstory")
	public ModelAndView ViewStory(@RequestParam("cumin_number") String cumin_number) {
		ModelAndView mv =new ModelAndView();
		cumin_ticket cumin=daos.getStory(cumin_number);
		System.out.println(cumin);
		List<String> description=subdao.getSubtask(cumin_number);
		mv.addObject("description",description);
		mv.addObject("cumin",cumin);
		mv.setViewName("/ViewTicket");
		return mv;
	}
	
	
	
	@PostMapping(value="/Subtask")
	public String subtask(Subtask subtask,@RequestParam("cumin") String cumin_number) {
	ModelAndView mv=new ModelAndView();
	Random r=new Random();
	cumin_ticket cumin=daos.getStory(cumin_number);
	String Subtask_id="EmmSubtask"+r.nextInt(48748);
	subtask.setSubtask_id(Subtask_id);
	subtask.setCumins(cumin);
	mv.addObject("cumin",cumin);
	subdao.subtask(subtask);
	List<String> description=subdao.getSubtask(cumin_number);
	mv.addObject("description",description);
	return "redirect:/create/viewstory?cumin_number="+cumin.getCumin_number();
	}
	@PostMapping(value="/LogWork")
	public String LogWork(@RequestParam("cumin_number") String cumin_number,@RequestParam("log_work") String log_work, @RequestParam("remaining_hrs") int remaining_hrs) {
		daos.LogWork(cumin_number, remaining_hrs, log_work);
		return "redirect:/create/viewstory?cumin_number="+cumin_number;
		}
	
	@RequestMapping(value="/save")
	public String save(@RequestParam("cumin_number") String cumin_number,@RequestParam("DevUnderstanding") String DevUnderstanding) {
		daos.saveDevUnderstanding(cumin_number, DevUnderstanding);
		return "redirect:/create/viewstory?cumin_number="+cumin_number;		
	}
	@RequestMapping(value="/statusChange")
	public String savestatus(@RequestParam("cumin_number") String cumin_number,@RequestParam("status") String status) {
		daos.cuminstatus(cumin_number, status);
		return "redirect:/create/viewstory?cumin_number="+cumin_number;		
	}
	@RequestMapping(value="/saveAssignee")
	public String saveAssignee(@RequestParam("cumin_number") String cumin_number,@RequestParam("assignee") String assignee) {
		daos.saveAssignee(cumin_number, assignee);
		return "redirect:/create/viewstory?cumin_number="+cumin_number;		
	}
	@RequestMapping(value="/saveWorkLog")
	public String saveWorkLogs(@RequestParam("cumin_number") String cumin_number,@RequestParam("log_work") String log_work) {
		daos.saveLogWork(cumin_number, log_work);
		return "redirect:/create/viewstory?cumin_number="+cumin_number;		
	}
	
}
