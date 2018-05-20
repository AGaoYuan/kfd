package cn.bdqn.Chapter06_SJ02;

public class Dog {
	
	private String name;
	private int age;
	private String strain;
	
	public Dog(){}
	
	public Dog(String name, int age, String strain) {
		this.name = name;
		this.age = age;
		this.strain = strain;
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
		return strain;
	}
	public void setStrain(String strain) {
		this.strain = strain;
	}
	
	
	
	

}
