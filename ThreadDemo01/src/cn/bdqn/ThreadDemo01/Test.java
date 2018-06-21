package cn.bdqn.ThreadDemo01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test {

	public static void main(String[] args) throws Exception {
		//newScheduLedThreadPool静态方法，限定该线程池内只能有5个线程执行任务
		ScheduledExecutorService ses = null;
		System.out.println("*************开始**************");
		ses = Executors.newScheduledThreadPool(5);
		if (ses!=null) {
			ses.scheduleAtFixedRate(new MyRunnable(), 5, 2, TimeUnit.SECONDS);
		}else{
			ses.shutdown();
		}
		//执行的线程对象，首次执行时间为5秒，其每隔2秒执行一次，设置执行单位为秒
		
		
		//不写shutdown就死循环，写了shutdown就不会显示任何数据
		//ses.shutdown();
		
		
		
	}
}

class MyRunnable implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"首次延迟5s执行，每2s执行一次！");
		
	}
	
}



