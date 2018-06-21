package cn.jbit.myschool.service.impl;

import java.util.List;

import cn.jbit.myschool.dao.MySchoolDao;
import cn.jbit.myschool.dao.impl.StudentDaoMySqlImpl;
import cn.jbit.myschool.entity.Student;
import cn.jbit.myschool.service.StudentService;

public class serviceimpl implements StudentService{

	MySchoolDao msd = new StudentDaoMySqlImpl();
	@Override
	public List<Student> findAllStudent() {
		return msd.executeQuery();
	}

	@Override
	public int addStudent(Student student) {
		
		return msd.update(student);
	}

}
