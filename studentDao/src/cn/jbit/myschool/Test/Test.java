package cn.jbit.myschool.Test;

import java.util.List;

import cn.jbit.myschool.dao.MySchoolDao;
import cn.jbit.myschool.dao.impl.StudentDaoMySqlImpl;
import cn.jbit.myschool.entity.Student;
import cn.jbit.myschool.service.StudentService;
import cn.jbit.myschool.service.impl.serviceimpl;

public class Test {

	public static void main(String[] args) {
		//BaseDAO--->StudengDaoImpl--->serviceImpl--->UI
		StudentService ss = new serviceimpl();
		List<Student> list = ss.findAllStudent();
		for (Student student : list) {
			System.out.println(student.getStuName()+"\t"+student.getStuNo());
		}
		
		
		

	}

}
