package com.cumin.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Tester {
	
	@Id
	private int emp_id;
	private String name;
	private String p_password;
	private String experience;
	private String skills;
	@OneToOne
	private Project project_id;
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
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public String getP_password() {
		return p_password;
	}
	public void setP_password(String p_password) {
		this.p_password = p_password;
	}
	public Project getProject_id() {
		return project_id;
	}
	public void setProject_id(Project project_id) {
		this.project_id = project_id;
	}

}


