package cn.bdqn.ThreadCallable;

import java.util.concurrent.Callable;

/**
 * 使用Callable泛型接口创建线程类
 * @author 21600
 *
 */
class TestResultThread implements Callable<String>{

	private int id;
	//有参数构造方法
	public TestResultThread(int id){
	this.id=id;
	}
	
	@Override
	public String call() throws Exception {
		
		return "线程任务返回值"+id;
	}
	
	
}
