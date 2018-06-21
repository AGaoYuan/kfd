package cn.jbit.myschool.entity;

import java.util.Date;

/**
 * 学生实体类
 * @author 21600
 *
 */
public class Student {
	private int stuNo;//学号
	private String stuName;//姓名
	private int stuGradeid;//年级编号
	private int stuGender;//性别
	private Date stuBirthday;//出生日期
	private String stuPhone;//联系人手机号
	private String stuEmail;//邮箱地址
	private String stuAddress;//住址
	private String stupassword;//密码
	
	
	public String getStupassword() {
		return stupassword;
	}
	public void setStupassword(String stupassword) {
		this.stupassword = stupassword;
	}
	public int getStuNo() {
		return stuNo;
	}
	public void setStuNo(int stuNo) {
		this.stuNo = stuNo;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public int getStuGradeid() {
		return stuGradeid;
	}
	public void setStuGradeid(int stuGradeid) {
		this.stuGradeid = stuGradeid;
	}
	public int getStuGender() {
		return stuGender;
	}
	public void setStuGender(int stuGender) {
		this.stuGender = stuGender;
	}
	public Date getStuBirthday() {
		return stuBirthday;
	}
	public void setStuBirthday(Date stuBirthday) {
		this.stuBirthday = stuBirthday;
	}
	public String getStuPhone() {
		return stuPhone;
	}
	public void setStuPhone(String stuPhone) {
		this.stuPhone = stuPhone;
	}
	public String getStuEmail() {
		return stuEmail;
	}
	public void setStuEmail(String stuEmail) {
		this.stuEmail = stuEmail;
	}
	public String getStuAddress() {
		return stuAddress;
	}
	public void setStuAddress(String stuAddress) {
		this.stuAddress = stuAddress;
	}
	
	
	
	
	
}
