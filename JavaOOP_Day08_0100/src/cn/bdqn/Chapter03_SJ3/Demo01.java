package cn.bdqn.Chapter03_SJ3;

import java.io.*;

public class Demo01 {

	public static void main(String[] args) throws Exception {
		Reader fr = new FileReader("E:/pet.template");
		Writer fw = new FileWriter("F:/MyDoc.txt",true);
		BufferedReader reader = new BufferedReader(fr);
		BufferedWriter writer = new BufferedWriter(fw);
		String line = null;
		StringBuffer sbf = new StringBuffer();
		while((line=reader.readLine())!=null){
			sbf.append(line);
		}
		System.out.println("Ìæ»»Ç°£º"+sbf);
		String newString = sbf.toString().replace("{name}", "Å·Å·");
		newString = newString.replace("{type}", "¹·¹·");
		newString = newString.replace("{master}", "ÀîÎ°");
		System.out.println("Ìæ»»ºó£º"+newString);
		writer.write(newString.toString());
		System.out.println("Ìæ»»³É¹¦£¡");
		
		writer.close();
		reader.close();
		fw.close();
		fr.close();
		
		

	}

}
