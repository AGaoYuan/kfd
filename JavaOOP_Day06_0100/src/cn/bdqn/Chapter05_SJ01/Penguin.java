package cn.bdqn.Chapter05_SJ01;

public class Penguin {
	
	private String name;
	private int age;
	private String sex;
	
	public Penguin(){}
	public Penguin(String name,int age,String sex){
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getStrain() {
		return sex;
	}
	public void setStrain(String sex) {
		this.sex = sex;
	}
	
	
	
	

}
