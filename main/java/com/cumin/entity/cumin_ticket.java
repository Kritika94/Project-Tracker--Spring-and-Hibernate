package com.cumin.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class cumin_ticket {
@Id
private String cumin_number;
private String reporter_name;
private String todate;
private String title;
@Column(columnDefinition = "varchar(25) default 'open'")
private String status;
private String DevUnderstanding;
private int Estimated_hrs;
private int remaining_hrs;
private String log_work;
private String assignee;
@OneToMany(mappedBy = "cumins")
private List<Subtask> subtask;
@OneToMany(mappedBy ="cumin_ticket")
private List<Bugs> bugs;
public String getCumin_number() {
	return cumin_number;
}
public void setCumin_number(String cumin_number) {
	this.cumin_number = cumin_number;
}
public String getReporter_name() {
	return reporter_name;
}
public void setReporter_name(String reporter_name) {
	this.reporter_name = reporter_name;
}
public String getTodate() {
	return todate;
}
public void setTodate(String todate) {
	this.todate = todate;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getDevUnderstanding() {
	return DevUnderstanding;
}
public void setDevUnderstanding(String devUnderstanding) {
	DevUnderstanding = devUnderstanding;
}public String getLog_work() {
	return log_work;
}
public int getEstimated_hrs() {
	return Estimated_hrs;
}
public void setEstimated_hrs(int Estimated_hrs) {
	this.Estimated_hrs = Estimated_hrs;
}
public int getRemaining_hrs() {
	return remaining_hrs;
}
public void setRemaining_hrs(int remaining_hrs) {
	this.remaining_hrs = remaining_hrs;
}
public void setLog_work(String log_work) {
	this.log_work = log_work;
}
public String getAssignee() {
	return assignee;
}
public void setAssignee(String assignee) {
	this.assignee = assignee;
}
@Override
public String toString() {
	return "cumin_ticket [cumin_number=" + cumin_number + ", reporter_name=" + reporter_name + ", title=" + title + ", status=" + status + ", DevUnderstanding=" + DevUnderstanding + ", Estimated_hrs="
			 + Estimated_hrs + ", todate=" +todate+ ", remaining_hrs=" + remaining_hrs + ", log_work=" + log_work + ", assignee=" + assignee
			+ "]";
}

 
}
