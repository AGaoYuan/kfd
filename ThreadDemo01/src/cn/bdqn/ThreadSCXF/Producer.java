package cn.bdqn.ThreadSCXF;

/**
 * 生产者
 * @author 21600
 *
 */
public class Producer implements Runnable{

	private Movie movie = null;
	
	private boolean flag = false;
	
	public Producer(Movie movie) {
		
		this.movie = movie;
	}


	@Override
	public void run() {
		//循环录入电影数据
		for (int i = 0; i < 50; i++) {
			if (flag) {
				try {
					this.movie.set("变形金刚", "一部科幻电影");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				flag = false;
			}else{
				try {
					this.movie.set("神偷奶爸", "一部3D动画电影");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				flag = true;
			}
		}
		
		
	}
	
	
	
	
	
}
