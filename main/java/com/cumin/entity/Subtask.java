package com.cumin.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Subtask {
@Id
private String subtask_id;
@ManyToOne
private cumin_ticket cumins;	
private String title;
private String Description;
public String getSubtask_id() {
	return subtask_id;
}
public void setSubtask_id(String subtask_id) {
	this.subtask_id = subtask_id;
}
public cumin_ticket getCumins() {
	return cumins;
}
public void setCumins(cumin_ticket cumins) {
	this.cumins = cumins;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getDescription() {
	return Description;
}
public void setDescription(String description) {
	Description = description;
}
	
	
	
}
