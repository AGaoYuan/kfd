package cn.bdqn.Chapter;

import java.awt.image.renderable.RenderableImage;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class IOTest {
	
	public static void main(String[] args) throws IOException {
		
		Reader fis = new FileReader("F:\\Java\\嗖嗖\\套餐资费说明.txt");
		
		BufferedReader bfr = new BufferedReader(fis);
		
		String readLine = bfr.readLine();
		while(readLine!=null){
			System.out.println(readLine);
			readLine = bfr.readLine();
		}
		
		bfr.close();
		fis.close();
		
		
		
	}
}
