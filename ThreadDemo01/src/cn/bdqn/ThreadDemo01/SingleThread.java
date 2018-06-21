package cn.bdqn.ThreadDemo01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThread {

	public static void main(String[] args) {
		//创建单线程池，是使用Executors实现类的newSingThreadExecutor静态方法，该线程池只有一个线程执行
		ExecutorService cach = Executors.newSingleThreadExecutor();
		//同样执行10次任务
		for (int i = 0; i < 10; i++) {
			//启动线程
			cach.execute(new MyRunnalbes(i));
		}
		//关闭线程池
		cach.shutdown();

	}

}
class MyRunnalbes implements Runnable{

	int num;
	
	public MyRunnalbes(int num){
		this.num = num;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+":"+num);
		
	}
}
