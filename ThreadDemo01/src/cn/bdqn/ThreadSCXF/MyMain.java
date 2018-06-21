package cn.bdqn.ThreadSCXF;

public class MyMain {

	public static void main(String[] args) {
		Movie movie = new Movie();
		Thread t1 = new Thread(new Producer(movie));
		Thread t2 = new Thread(new Consumer(movie));
		t1.start();
		t2.start();
		
		

	}

}
