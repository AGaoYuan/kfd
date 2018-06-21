package cn.bdqn.ThreadSCXF;


public class Movie {

	private String name;
	private String Info;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInfo() {
		return Info;
	}
	public void setInfo(String info) {
		Info = info;
	}
	
	private boolean flag = true;
	public synchronized void set(String name,String info) throws Exception{
		if (!flag) {
			super.wait();
		}
		this.name=name;
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated c2atch block
			e.printStackTrace();
		}
		this.Info=info;
		flag = false;
		super.notify();
	}
	
	public synchronized void get() throws Exception{
		if (flag) {
			super.wait();
		}
		System.out.println(this.name+":"+this.Info);
		flag = true;
		super.notify();
	}
	
	
}
