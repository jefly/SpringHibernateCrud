package com.app.service;

import java.util.List;

import com.app.model.Teacher;

public interface TeacherService {

	Teacher findTeacher(int id);
	
	List<Teacher> getAllTeachers();
	
	void saveTeacher(Teacher teacher);
	
	void updateTeacher(Teacher teacher);
	
	void deleteTeacher(int id);
}
