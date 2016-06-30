package com.app.service;

import java.util.List;

import com.app.model.Teacher;

public interface TeacherService {

	Teacher findTeacher(int id);
	
	List<Teacher> getAllTeachers();
	
	void saveTeacher(Teacher teacher);
	
	void deleteTeacher(Teacher teacher);
}
