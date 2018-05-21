package cn.bdqn.Chapter02;

import java.io.*;

public class FileInputStreamDemo {

	public static void main(String[] args) {
		InputStream in = null;
		OutputStream fos = null;
		
		try {
			in = new FileInputStream("F:\\Java\\1.txt");
			fos = new FileOutputStream("F:\\Java\\2.txt",true);
			int len;
			byte [] words = new byte[1024];
			try {
				while((len=in.read(words))!=-1){
					System.out.print(new String(words,0,len));
					fos.write(words, 0, len);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				if (in!= null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		

	}
}
