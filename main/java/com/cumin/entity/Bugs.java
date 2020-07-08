package com.cumin.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Bugs {
private String bug_reporter;
private String bug_type;
private String bug_status;
@Id
private String bug_id;
private String Assignee;
private String bugs_header;
private String description;
@ManyToOne
private cumin_ticket cumin_ticket;
public String getBug_reporter() {
	return bug_reporter;
}
public void setBug_reporter(String bug_reporter) {
	this.bug_reporter = bug_reporter;
}
public String getBug_type() {
	return bug_type;
}
public void setBug_type(String bug_type) {
	this.bug_type = bug_type;
}
public String getBug_status() {
	return bug_status;
}
public void setBug_status(String bug_status) {
	this.bug_status = bug_status;
}
public String getBug_id() {
	return bug_id;
}
public void setBug_id(String bug_id) {
	this.bug_id = bug_id;
}
public String getAssignee() {
	return Assignee;
}
public void setAssignee(String assignee) {
	Assignee = assignee;
}
public String getBugs_header() {
	return bugs_header;
}
public void setBugs_header(String bugs_header) {
	this.bugs_header = bugs_header;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public cumin_ticket getCumin_ticket() {
	return cumin_ticket;
}
public void setCumin_ticket(cumin_ticket cumin_ticket) {
	this.cumin_ticket = cumin_ticket;
}
@Override
public String toString() {
	return "Bugs [bug_reporter=" + bug_reporter + ", bug_type=" + bug_type + ", bug_status=" + bug_status + ", bug_id="
			+ bug_id + ", Assignee=" + Assignee + ", bugs_header=" + bugs_header + ", description=" + description
			+ ", cumin_ticket=" + cumin_ticket + "]";
}






}
