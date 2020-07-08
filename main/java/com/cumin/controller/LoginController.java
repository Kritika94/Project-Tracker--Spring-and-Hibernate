package com.cumin.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

@RequestMapping(value="/showMyLoginPage", method = RequestMethod.GET )
public String showMyLoginPage(){
	return "CuminLogin";
}







@RequestMapping("/access-denied")
public String showdeniedpage(){
	return "access-denied";
}
}
