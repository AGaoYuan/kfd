package cn.jbit.myschool.service;


import java.util.List;

import cn.jbit.myschool.entity.*;

public interface StudentService {

	public List<Student> findAllStudent();
	
	
	public int addStudent(Student student);
	
}
