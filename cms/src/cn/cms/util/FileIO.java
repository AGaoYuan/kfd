package cn.cms.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 读取书籍文件类
 * @author 21600
 *
 */
public class FileIO {

	public String readFile(String file) throws Exception{
		InputStreamReader isr = new InputStreamReader(new FileInputStream(file),"GB2312");
		char [] ch = new char[1024];
		int data = 0;
		String str = null;
		StringBuffer sb = new StringBuffer();
		while((data = isr.read(ch))!= -1){
			str = new String(ch, 0, data);
			sb.append(str);
		}
		System.out.println(sb.toString());
		isr.close();
		return str;
		
	}
	
	public String writeFile(String filepath,String str) throws Exception{
		OutputStreamWriter os = new OutputStreamWriter(new FileOutputStream(filepath), "GB2312");
		os.append(str);
		os.close();
		return str;
	}
	
	
	
}
