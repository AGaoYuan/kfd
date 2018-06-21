package cn.bdqn.ThreadDemo01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThread {

	public static void main(String[] args) {
		//创建缓冲线程池，使用Executors实现类的newCachedThreadPool静态方法，返回类型为ExecutorService接口类型
		ExecutorService cach = Executors.newCachedThreadPool();
		//循环10次任务
		for (int i = 0; i < 10; i++) {
			//开启线程
			cach.execute(new MyRunnalbe(i));
		}
		//关闭线程池
		cach.shutdown();
	}

}

class MyRunnalbe implements Runnable{

	int num;
	
	//带参构造
	public MyRunnalbe(int num){
		this.num = num;
	}
	
	//获取对象并打印执行次数
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+":"+num);
		
	}
	
}



