package cn.bdqn.ThreadDemo02;

public class Test {

	public static void main(String[] args) {
		MyRunnable mr = new MyRunnable();
		Thread t1 = new Thread(mr);
		t1.start();
		//t1.setDaemon(true);
		
		
		
		
		

	}

}
