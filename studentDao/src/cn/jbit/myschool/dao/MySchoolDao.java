package cn.jbit.myschool.dao;


import java.sql.ResultSet;
import java.util.List;

import cn.jbit.myschool.entity.Student;

/**
 * 操作Myschool学校的接口
 * @author 21600
 *
 */
public interface MySchoolDao {
	/**
	 * 添加学生信息
	 * @param student
	 * @return 返回受影响的行数
	 */
	int save(Student student);
	/**
	 * 删除一个学生
	 * @param student
	 * @return 返回受影响的行数
	 */
	int del(Student student);
	/**
	 * 修改一个学生信息
	 * @param student
	 * @return 返回受影响的行数
	 */
	int update(Student student);
	/**
	 * 获取指定昵称的学生，精准查询
	 * @param name 昵称
	 * @return 返回学生对象
	 */
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Student> executeQuery();
	
	Student getByName(String name);
	/**
	 * 获取指定昵称的学生列表，模糊查询
	 * @param name 昵称
	 * @return 学生列表
	 */
	List<Student> findByName(String name);
	
	
	/**
	 * 获取指定年级的学生列表
	 * @param type 年级编号
	 * @return 学生列表
	 */
	List<String> findBytype(String type);
	
	
	
	
	
}
