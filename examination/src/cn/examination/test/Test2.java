package cn.examination.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test2 {

	/*
	 * 2) 从类似如下的文本文件中读取出所有的姓名，并打印出重复的姓名和重复的次数，并按重复次数排序：
	 */
	public static void main(String[] args) throws Exception {
		//调度方法
		readerAll();
		
		
	}
	
	public static void readerAll() throws Exception{
		BufferedReader bf = new BufferedReader(new FileReader("E:/pk/2.txt"));
		String str = bf.readLine();
		List<String> names = new ArrayList<String>();
		while (str != null) {
			//以逗号切割字符串
			String[] st = str.split(",");
			names.add(st[1]);
			str = bf.readLine();
		}
		Set<String> name = new HashSet<String>(names);
		for (String set : name) {
			String temp = set;
			int num = 0;
			for (String s : names) {
				if (temp.equals(s)) {
					num++;
				}

			}
			if (num >= 2) {
				System.out.println(temp + "重复次数：" + num);

			}
		}
		bf.close();
		
	}
	

}
