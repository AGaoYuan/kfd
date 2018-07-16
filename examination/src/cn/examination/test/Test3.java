package cn.examination.test;


public class Test3 {

	/*
	 * 3) 编写程序， 以最快的效率找出一个数组中第二大的数.
	 */
	public static void main(String[] args) {
		//调度方法
		CountNumber();
		
		
	}
	
	public static void CountNumber(){
		int [] number = {10,50,30,90,80};
		
		int max = number[0];
		for (int i = 0; i < number.length; i++) {
			if (number[i]>max) {
				max = number[i];
			}
		}
		
		int two = number[0];
		for (int j = 0; j < number.length; j++) {
			if (number[j] > two && number[j]<max) {
				two = number[j];
			}
		}
		System.out.println("第二大的数："+two);
		
	}
	
	

}
