package cn.examination.test;

public class Test11 {
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
		//测试方法
		System.out.println(substring("我ABC汉DEF", 6));
		
	}
	//创建截取字符串的方法
	 public static String substring(String Character, int count){
		 //把字符串转换成一个字符数组
	     char[] chars = Character.toCharArray();
	     //计数
	     int sum = 0;
	     //定义StringBuilder对象用来作拼接
	     StringBuilder sb = new StringBuilder();
	     //循环字符长度
		 for (char item : chars) {
			 //转型成为int并判断临界值 ASCII编码没有汉字
			if ((int)item>=128) {
				//转型后如果大于128的话就判断为汉字占两个字节，加2
				sum+=2;
				//判断是否小于128
			}else if ((int)item<=128) {
				//如果小于128的，就代表是一个字节，就让sum++
				sum++;
			}
			//判断是否大于用户需要的截取的字符数
			if (sum>count) {
				//如果大于则跳出循环
				break;
			}
			//追加字符
			sb.append(item);
		 }
		 //转型为String并返回
		 return sb.toString();
	 }
	 
	 

}
