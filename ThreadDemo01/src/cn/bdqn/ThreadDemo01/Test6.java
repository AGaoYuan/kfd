package cn.bdqn.ThreadDemo01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test6 {
	public static void main(String[] args) {
		//newFixedThreadPool静态方法，限定该线程池内只能有3个线程执行任务
		 ExecutorService fixed = Executors.newFixedThreadPool(3);
		 //循环10次
		 for (int i = 0; i < 10; i++) {
			 //开启线程池
			 fixed.execute(new MyRunnableFixed(i));
			 
		 }
		 //关闭线程池
		 fixed.shutdown();
	}
}
class MyRunnableFixed implements Runnable{

	int num;
	public MyRunnableFixed(int num){
		this.num = num;
	}
	
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+":"+num);
		
	}
	
	
}