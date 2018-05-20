package cn.bdqn.Chapter05_SJ01;

import java.util.*;

public class TestPenguin {

	public static void main(String[] args) {
		Penguin penguin = new Penguin("兰兰",10,"Q仔");
		Penguin penguin2 = new Penguin("楠楠",12,"Q妹");
		Penguin penguin3 = new Penguin("小Q",8,"Q仔");
		List list = new ArrayList();
		list.add(penguin);
		list.add(penguin2);
		list.add(penguin3);
		
		if (list.contains(penguin2)) {//判断集合中是否有该元素
			list.remove(penguin2);//删除元素
		}
		System.out.println("企鹅的个数："+list.size());
		for (int i = 0; i < list.size(); i++) {//循环元素个数
			Penguin p = (Penguin)list.get(i);//强制转换成企鹅类型  list.get()方法为Object类型
			System.out.println("企鹅名称:"+p.getName()+"企鹅年龄:"+p.getAge()+"企鹅性别:"+p.getStrain());//打印企鹅的名称
		}
		
		
	}

}
