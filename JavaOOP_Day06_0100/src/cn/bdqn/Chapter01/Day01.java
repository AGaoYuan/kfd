package cn.bdqn.Chapter01;

import java.util.*;

public class Day01 {

	public static void main(String[] args) {
		Dog dog = new Dog("欧欧","雪纳瑞");
		Dog dog2 = new Dog("亚亚","拉布拉多");
		Dog dog3 = new Dog("菲菲","拉布拉多");
		Dog dog4 = new Dog("美美","雪纳瑞");
		Map dogs = new HashMap();
		dogs.put(dog.getName(), dog);
		dogs.put(dog2.getName(), dog2);
		dogs.put(dog3.getName(), dog3);
		dogs.put(dog4.getName(), dog4);
		Set keys = dogs.keySet();
		Iterator it= keys.iterator();
		while(it.hasNext()){
			String key = (String)it.next();
			System.out.println(key);
			Dog dog5 = (Dog) dogs.get(key);
		}
		
		/*for (Object key : keys) {
			System.out.println(key);
		}*/
		
		
		/*System.out.println("共计有 "+dogs.size()+"条狗狗。");
		System.out.println("分别是");
		if (dogs.contains(dog2)) {
			dogs.remove(dog2);
		}
		
		for (int i = 0; i < dogs.size(); i++) {
			Dog dog5 = (Dog) dogs.get(i);
			
			System.out.println(dog5.getName()+"\t"+dog5.getStrain());
		}
		System.out.println("                                   ");
		
		
		for (Object obj : dogs) {
			System.out.println(((Dog)obj).getName());
		}*/
		

	}

}
