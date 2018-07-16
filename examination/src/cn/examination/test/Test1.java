package cn.examination.test;

import java.io.UnsupportedEncodingException;

public class Test1 {
/*
 * 
	1).编写一个截取字符串的函数，
	输入为一个字符串和字节数，
	输出为按字节截取的字符串，
	但要保证汉字不被截取半个，
	如“我ABC”，4，应该截取“我AB”，
	输入“我ABC汉DEF”，6，应该输出“我ABC”，
	而不是“我ABC+汉的半个”。
	
 */
	public static void main(String[] args) {
		 	String s = "我ABC汉DEF";   
	        System.out.println("原始字符串：" + s);   
	        try { 
	            System.out.println("截取前4位：" + Test1.substring(s, 4));   
	            System.out.println("截取前6位：" + Test1.substring(s, 6));   
	        } catch (UnsupportedEncodingException e) {   
	            e.printStackTrace();   
	        }   
	        
	}  
	
	public static boolean isChineseChar(char c) throws UnsupportedEncodingException{
		return String.valueOf(c).getBytes("GBK").length<2;
	}
	
	 public static String substring(String Character, int count)   
	            throws UnsupportedEncodingException {   
	        // 原始字符不为null，也不是空字符串   
	        if (Character != null && !"".equals(Character)) {   
	            // 将原始字符串转换为GBK编码格式   
	        	Character = new String(Character.getBytes(), "GBK");   
	            // 要截取的字节数大于0，且小于原始字符串的字节数   
	            if (count > 0 && count < Character.getBytes("GBK").length) {   
	                StringBuffer buff = new StringBuffer();   
	                char c;   
	                for (int i = 0; i < count; i++) {   
	                    c = Character.charAt(i);   
	                    buff.append(c);   
	                    if (Test1.isChineseChar(c)) {   
	                        // 遇到中文汉字，截取字节总数减1   
	                        --count;   
	                    }   
	                }   
	                return buff.toString();   
	            }   
	        }   
	        return Character;   
	 }
	 
	 

}
