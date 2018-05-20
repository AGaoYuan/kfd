package cn.bdqn.Chapter03;

import java.util.*;

public class Day01 {

	public static void main(String[] args) {
		List<Fruit> list = new ArrayList<Fruit>();
		Fruit fruit =new Fruit();
		fruit.setFruitName("ÁñÁ«");
		Fruit fruit2 =new Fruit();
		fruit2.setFruitName("Æ»¹û");
		Fruit fruit3 =new Fruit();
		fruit3.setFruitName("Î÷¹Ï");
		
		list.add(fruit);
		list.add(fruit2);
		list.add(fruit3);
		
		//list.remove(fruit);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getFruitName());
		}
		
		//LinkedList list2 = new LinkedList();
		
		
		

	}

}
