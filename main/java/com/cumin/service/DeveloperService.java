package com.cumin.service;

import com.cumin.entity.Developer;
import com.cumin.entity.Project;

public interface DeveloperService {
public void Savedeveloper(Developer developer);
public Project  finddeveloperproject(String user);
}
