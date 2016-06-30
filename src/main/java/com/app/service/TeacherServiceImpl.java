package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.TeacherDao;
import com.app.model.Teacher;

@Service("TeacherService")
public class TeacherServiceImpl implements TeacherService{

	@Autowired
	private TeacherDao dao;
	
	public Teacher findTeacher(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Teacher> getAllTeachers() {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		
	}

	public void updateTeacher(Teacher teacher){
		
	}
	
	public void deleteTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		
	}

}
