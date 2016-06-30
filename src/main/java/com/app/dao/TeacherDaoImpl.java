package com.app.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.app.model.Teacher;

@Repository("TeacherDao")
public class TeacherDaoImpl extends AbstractDao<Teacher, Integer> implements TeacherDao {

	public Teacher findTeacher(int id) {
		return getByKey(id);
	}

	public List<Teacher> getAllTeachers() {
		
		Criteria criteria = createEntityCriteria().setFetchMode("subjects", FetchMode.JOIN).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return (List<Teacher>) criteria.list();
	}

	public void saveTeacher(Teacher teacher) {
		persist(teacher);
	}

	public void deleteTeacher(int id) {
		
		Query query = getSession().createSQLQuery("delete from Teacher where id = :id ");
		query.setInteger("id", id);
		query.executeUpdate();
	}

}
