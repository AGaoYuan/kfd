package cn.bdqn.Chapter04;

public class Dog {
	
	private String name;
	private int age;
	
	/*@Override
	public int hashCode() {
		int h = 63;
		h = 31*h+age;
		return h;
	}*/
	
	
	@Override
	public boolean equals(Object obj) {
		Dog dog = (Dog)obj;
		if (dog.getAge()==this.age) {
			return true;
		}else{
			return false;
		}
	}
	
	public Dog(){}
	public Dog(String name,int age){
		this.name = name;
		this.age = age;
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
	
	

}
