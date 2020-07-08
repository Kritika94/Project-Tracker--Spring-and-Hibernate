package com.cumin.service;

import java.util.List;

import org.hibernate.Session;

import com.cumin.entity.Subtask;

public interface SubtaskServiceInterface {
public void subtask(Subtask subtask);
public List<String> getSubtask(String cumin_number);

}
