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
		return dao.findTeacher(id);
	}

	public List<Teacher> getAllTeachers() {
		return dao.getAllTeachers();
	}

	public void saveTeacher(Teacher teacher) {
		dao.saveTeacher(teacher);
	}

	public void updateTeacher(Teacher teacher){
		
		Teacher entity = findTeacher(teacher.getId());
		
		if(entity != null){
			
			entity.setName(teacher.getName());
			entity.setSubjects(teacher.getSubjects());
		}
	}
	
	public void deleteTeacher(int id) {
		dao.deleteTeacher(id);
	}

}
