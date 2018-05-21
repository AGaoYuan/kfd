package cn.bdqn.Chapter02;

import java.io.*;
import java.util.*;

public class Day01 {

	public static void main(String[] args) throws Exception {
		
		
		
		
		
		
		
		/**
		 * 序列化到硬盘
		 * OutputStream os = new FileOutputStream("E:/1.txt");
		ObjectOutputStream oos = new ObjectOutputStream(os);
		ArrayList<Book> list = new ArrayList<Book>();
		Book b1 = new Book("大话设计模式",45);
		Book b2 = new Book("书虫",20);
		list.add(b1);
		list.add(b2);
		
		oos.writeObject(list);
		System.out.println("序列化成功！");*/
		
		/**
		 * 反序列化到内存
		 * InputStream is = new FileInputStream("E:/1.txt");
		ObjectInputStream ois = new ObjectInputStream(is);
		ArrayList<Book> books= (ArrayList<Book>) ois.readObject();
		for (Book book2 : books) {
			System.out.println(book2.getBookName());
		}*/
		
		
		//readerDemo();
		//writerDemo();
	}
	
	
	
	public void dataDemo() throws Exception{
		InputStream is = new FileInputStream("F:/图片/775e777001824dd1bfb22ffe2af2990f.jpg");
		DataInputStream dis = new DataInputStream(is);
		
		OutputStream os = new FileOutputStream("E:/KENAN.jpg");
		DataOutputStream dos = new DataOutputStream(os); 
		byte [] bytes = new byte[1024];
		int data = 0;
		while((data=dis.read(bytes))!=-1){
			dos.write(bytes,0,data);
		}
		dos.close();
		dis.close();
		os.close();
		is.close();
		System.out.println("Copy 成功！");
	}

	private static void writerDemo() throws Exception {
		Writer writer = new FileWriter("F:/Java/1.txt",true);
		BufferedWriter bw = new BufferedWriter(writer);
		bw.write("\n好人");
		bw.newLine();
		bw.write("坏人");
		
		System.out.println("写入成功！");
		bw.close();
		writer.close();
		
	}

	private static void readerDemo() throws Exception {
		Reader reader = new FileReader("F:/Java/1.txt");
		BufferedReader br = new BufferedReader(reader);
		String readLine = br.readLine();
		while(readLine!=null){
			System.out.println(readLine);
			readLine = br.readLine();
		}
		br.close();
		reader.close();
		
		
	}
	
	
	
}
