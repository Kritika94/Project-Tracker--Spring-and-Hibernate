package com.cumin.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Project_Manager {
@Id
int emp_id;
String name;
String email;
String experience;
String uname;
@OneToOne(mappedBy = "manager_id")
private Project project;

public int getEmp_id() {
	return emp_id;
}
public void setEmp_id(int emp_id) {
	this.emp_id = emp_id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getExperience() {
	return experience;
}
public void setExperience(String experience) {
	this.experience = experience;
}
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
@Override
public String toString() {
	return "Project_Manager [emp_id=" + emp_id + ", name=" + name + ", email=" + email + ", experience=" + experience
			+ ", uname=" + uname + "]";
}



}
