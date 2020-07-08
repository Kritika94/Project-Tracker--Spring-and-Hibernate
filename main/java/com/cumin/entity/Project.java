package com.cumin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.UniqueConstraint;

@Entity
public class Project {
private String project_title;
@Id
private int project_id;
@OneToOne
private Project_Manager manager_id;
private int months;
private int years;
private String technology;
private String description;
public String getProject_title() {
	return project_title;
}
public void setProject_title(String project_title) {
	this.project_title = project_title;
}
public int getProject_id() {
	return project_id;
}
public void setProject_id(int project_id) {
	this.project_id = project_id;
}

public Project_Manager getManager_id() {
	return manager_id;
}
public void setManager_id(Project_Manager manager_id) {
	this.manager_id = manager_id;
}
public int getMonths() {
	return months;
}
public void setMonths(int months) {
	this.months = months;
}
public int getYears() {
	return years;
}
public void setYears(int years) {
	this.years = years;
}
public String getTechnology() {
	return technology;
}
public void setTechnology(String technology) {
	this.technology = technology;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
@Override
public String toString() {
	return "Project [project_title=" + project_title + ", project_id=" + project_id + ", months=" + months + ", years=" + years + ", technology=" + technology + ", description=" + description
			+ "]";
}


}
