package cn.bdqn.ThreadDemo01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThread {

	public static void main(String[] args) {
		//是用ExecutorService接口来接收Executors类创建的newFixedThreadPool线程池
		ExecutorService cach = Executors.newFixedThreadPool(3);//限定线程数为3
		
		for (int i = 0; i < 10; i++) {
			//执行MyRunnable线程类
			cach.execute(new MyRunnalbes2(i));
		}
		cach.shutdown();
		

	}

}
class MyRunnalbes2 implements Runnable{

	int num;
	
	public MyRunnalbes2(int num){
		this.num = num;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+":"+num);
		
	}
}
