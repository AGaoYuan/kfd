package cn.bdqn.ThreadDeadlock;

/**
 * ËÀËø°¸Àý
 * @author 21600
 *
 */
public class Test {

	public static void main(String[] args) {
		Object bobby = new Object();
		Object duck = new Object();
		Thread t1 = new Thread(new Tangtang(bobby, duck));
		Thread d2 = new Thread(new Doudou(bobby, duck));
		t1.start();
		d2.start();
	}

}

class Tangtang implements Runnable{
	Object bobby;
	Object duck;
	public Tangtang(Object bobby, Object duck) {
		this.bobby = bobby;
		this.duck = duck;
	}
	@Override
	public void run() {
		synchronized(bobby){
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized (duck) {
					
				}
			System.out.println("ÌÇÌÇ°Ñ°Å±È¸ø¶¹¶¹Íæ£¡");
		}
	}
}

class Doudou implements Runnable{
	Object bobby;//°Å±È
	Object duck;//Íæ¾ßÑ¼
	public Doudou(Object bobby, Object duck) {
		this.bobby = bobby;
		this.duck = duck;
	}
	
	@Override
	public void run() {
		synchronized(duck){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (bobby) {
				
			}
			System.out.println("¶¹¶¹°ÑÍæ¾ßÑ¼¸øÌÇÌÇÍæ£¡");
		}
		
	}
}
