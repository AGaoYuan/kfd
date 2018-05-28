package cn.soso.entity;

/**
 * 三个套餐的抽象父类
 * @author Mr.Gao
 *
 */
public abstract class ServicePackage {
	
	protected double price; //套餐月资费(元)
	
	public ServicePackage(){}
	
	public ServicePackage(double price){
		this.price = price;
	}
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	//显示套餐数据
	public abstract void showInfo();
	
}
