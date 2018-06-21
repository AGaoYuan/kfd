package cn.bdqn.ThreadCallable;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestThreadCallnable {

	public static void main(String[] args) throws Exception {
		//创建线程池
		ExecutorService exec=Executors.newCachedThreadPool();
		//创建线程容器
		ArrayList<Future<String>> result=new ArrayList<Future<String>>();
		//执行任务后返回结果,假如只有10个线程
		for(int i=0;i<10;i++){
		Future<String> f=exec.submit(new TestResultThread(i));
		result.add(f);
		}
		//遍历执行完成后的线程
		for(Future<String> ft:result){
		//判断是否执行完成
		if(ft.isDone()){
		System.out.println("完成的线程："+ft.get());
		}else{
		System.out.println("未完成的线程："+ft);
		}
	}
		//关闭线程池
		exec.shutdown();
		
		
		
		

	}

}
