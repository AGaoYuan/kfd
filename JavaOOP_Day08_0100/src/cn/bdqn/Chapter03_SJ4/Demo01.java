package cn.bdqn.Chapter03_SJ4;

import java.io.*;

public class Demo01 {

	public static void main(String[] args) throws Exception {
		//上机四：复制图片
		InputStream is = new FileInputStream("F:\\图片\\ee951300ba2ce0f9d6ffe122c29e14bb.jpg");
		DataInputStream dis = new DataInputStream(is);
		
		OutputStream os = new FileOutputStream("E:/KeNan.jpg");
		DataOutputStream dos = new DataOutputStream(os);
		byte [] bytes = new byte[1024];
		int data;
		while((data=dis.read(bytes))!=-1){
			dos.write(bytes,0,data);
		}
		dos.close();
		dis.close();
		os.close();
		is.close();
		
		File file = new File("E:/KeNan.jpg");
		if (file.exists()) {
			System.out.println("Copy Success！");
		}else{
			System.out.println("file does not exist！");
		}
		
		
		

	}

}
