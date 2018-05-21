package cn.bdqn.Chapter02;

import java.io.*;
import java.util.Scanner;


public class FileOutStreamDemo {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		OutputStream fis = null;
		try {
			fis = new FileOutputStream(new File("F:/Java/1.txt"),true);
			StringBuilder sb = new StringBuilder();
			System.out.println("请输入您要写入的内容：");
			String str = in.next();
			sb.append(str);
			byte[] bytes = sb.toString().getBytes();
			try {
				if (bytes!=null) {
					fis.write(bytes);
					System.out.println("添加成功！");
				}
			} catch (IOException e) {
				System.out.println("出错！");
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		

	}
}
