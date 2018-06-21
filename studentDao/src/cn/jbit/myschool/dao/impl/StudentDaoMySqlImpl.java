package cn.jbit.myschool.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.jbit.myschool.dao.MySchoolDao;
import cn.jbit.myschool.entity.Student;
import cn.jbit.myschool.impl.BaseDao;
/**
 * 接口实现类
 * @author 21600
 *
 */
public class StudentDaoMySqlImpl extends BaseDao implements MySchoolDao{

	@Override
	public int save(Student student) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int del(Student student) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Student student) {
		String sql = "update student set stuName = '微冷的雨'"+" where stuNo = ? ";
		Object [] param = {student.getStuNo()};
		int result = this.exceuteUpdate(sql, param);
		System.out.println("修改成功！");
		return result;
	}
	
	public List<Student> executeQuery() {
		List<Student> list = new ArrayList<Student>();
		String sql = "select * from student";
		ResultSet rs = getResultSet(sql);
		try {
			if (rs!=null) {
				while(rs.next()){
					Student stu = new Student();
					stu.setStuName(rs.getString("stuName"));
					stu.setStuNo(rs.getInt("stuNo"));
					list.add(stu);
				}
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	

	@Override
	public Student getByName(String name) {
		
		return null;
	}

	@Override
	public List<Student> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> findBytype(String type) {
		// TODO Auto-generated method stub
		return null;
	}

}
