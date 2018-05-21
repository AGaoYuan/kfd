package cn.bdqn.Chapter01;

import java.io.*;
import java.util.Scanner;

public class fileMain {

	public static void main(String[] args) {
		File file = new File("F:\\Java\\1.txt");
		/*if (file.exists()) {
			System.out.println("当前文件存在");
		}else{
			System.out.println("当前文件不存在！");
		}*/
		if (file.isDirectory()) {
			System.out.println("当前为文件夹！！！");
		}else{
			System.out.println("当前文件的属性为：");
			
			System.out.println("文件的绝对路径"+file.getAbsolutePath());
			System.out.println("文件名为："+file.getName());
			System.out.println("文件的相对路径："+file.getPath());
			System.out.println("文件的上一级目录："+file.getParent());
			System.out.println("文件的长度："+file.length());
		}
		System.out.println("请按1删除完成操作：");
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		if (num == 1) {
			boolean delete = file.delete();
			if (delete) {
				System.out.println("删除成功！");
			}
		}else{
			System.out.println("删除失败！");
		}
		
		
		

	}

}
