package cn.bdqn.ThreadSCXF;

/**
 * Ïû·ÑÕß
 * @author 21600
 *
 */
public class Consumer implements Runnable{

	private Movie movie = null;
	public Consumer(Movie movie) {
		this.movie = movie;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				this.movie.get();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	
	
	
	
}
