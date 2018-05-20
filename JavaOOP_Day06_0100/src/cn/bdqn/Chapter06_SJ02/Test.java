package cn.bdqn.Chapter06_SJ02;

import java.util.*;

public class Test {

	public static void main(String[] args) {
		
		Dog dog = new Dog("大黄",20,"拉布拉多");
		Dog dog2 = new Dog("小黄",12,"哈士奇");
		Dog dog3 = new Dog("旺财",8,"小狗");
		System.out.println("");
		Map<String,Dog> map = new HashMap<String,Dog>();
		map.put(dog.getName(), dog);
		map.put(dog2.getName(), dog2);
		map.put(dog3.getName(), dog3);
		
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
			System.out.println(key);
			Dog dog4 = map.get(key);
			System.out.println("名称为："+dog4.getName()+"年龄为："+dog4.getAge()+"品种为："+dog4.getStrain());
		}
		
		

	}

}
