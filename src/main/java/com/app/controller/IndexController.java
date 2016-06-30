package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.model.Teacher;
import com.app.service.TeacherService;

@Controller
@RequestMapping("/")
public class IndexController {

	@Autowired
	private TeacherService teacherService;
	
	@RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
	public String getTeachers(ModelMap model){
		
		List<Teacher> teachers = teacherService.getAllTeachers();
		model.addAttribute("teachers", teachers);
		return "allteachers";
	}
	
	@RequestMapping(value = {"/new"}, method = RequestMethod.GET)
	public String newTeacher(ModelMap model){
		
		Teacher teacher = new Teacher();
		model.addAttribute("teacher", teacher);
		model.addAttribute("edit", false);
		return "registration";
	}
	
	@RequestMapping(value = {"/edit-{id}-teacher"}, method = RequestMethod.POST)
	public String updateTeacher(@Valid Teacher teacher, BindingResult result, ModelMap model, @PathVariable int id){
		
		if(result.hasErrors()){
			return "registration";
		}
		
		teacherService.updateTeacher(teacher);
		
		model.addAttribute("success", "Teacher "+teacher.getName()+" updated!!!");
		return "success";
	}
	
	@RequestMapping(value = {"/delete-{id}-teacher"}, method = RequestMethod.POST)
	public String updateTeacher(@PathVariable int id){
		
		teacherService.deleteTeacher(id);
		
		return "redirect:/list";
	}
}
