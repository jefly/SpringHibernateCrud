package com.app.dao;

import java.util.List;

import com.app.model.Teacher;

public interface TeacherDao {

	Teacher findTeacher(int id);
	
	List<Teacher> getAllTeachers();
	
	void saveTeacher(Teacher teacher);
	
	void deleteTeacher(int id);
}
