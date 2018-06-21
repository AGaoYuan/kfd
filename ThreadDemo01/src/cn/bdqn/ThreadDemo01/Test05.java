package cn.bdqn.ThreadDemo01;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 自定义线程池
 * @author 21600
 *
 */
public class Test05 {
	public static void main(String[] args) {
		//创建自定义线程池 线程数为5 最大线程数为7 销毁临时线程的时间为300毫秒，创建队列容纳任务数为4
		ThreadPoolExecutor executor = new 
		ThreadPoolExecutor(5, 7, 300, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(4));
		for (int i = 1; i < 12; i++) {
			//启动MyRunnable线程
			executor.execute(new MyRunnabless(i));
			//打印线程池中的线程数，队列中等待的任务数，已经执行完的任务数
			System.out.println("线程池中线程数："+executor.getPoolSize()+"队列中等待的任务数："
			+executor.getQueue().size()+"已经执行完的任务数："+executor.getCompletedTaskCount());
		}
		//结束线程池
		executor.shutdown();
		
	}
}
class MyRunnabless implements Runnable{

	int num;
	public MyRunnabless(int num){
		this.num = num;
	}
	
	@Override
	public void run() {
		System.out.println("正在执行任务："+num);
		try {
			//休眠2秒
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("执行完毕："+num);
		
	}
}