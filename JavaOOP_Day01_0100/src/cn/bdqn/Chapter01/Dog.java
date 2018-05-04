package cn.bdqn.Chapter01;

/**
 * 狗类
 * @author Mr.Gao
 *
 */
public class Dog {

	private String Name = "无名氏";//姓名
	private int Health = 100;//健康值
	private int Love = 0;//亲密度
	private String Strain = "聪明的拉不拉多犬";//品种
	
	public Dog() {}

	public Dog(String name, int health, int love, String strain) {
		Name = name;
		Health = health;
		Love = love;
		Strain = strain;
	}
	
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getHealth() {
		return Health;
	}
	public void setHealth(int health) {
		Health = health;
	}
	public int getLove() {
		return Love;
	}
	public void setLove(int love) {
		this.Love = love;
	}
	public String getStrain() {
		return Strain;
	}
	public void setStrain(String strain) {
		this.Strain = strain;
	}
	
	public void eat() {
		if (Health >= 100) {
			System.out.println("狗狗需要多运动啊");
		}else {
			Health = Health + 3;
			System.out.println("狗狗吃饱饭了！");
		}
	}
	
	public void play() {
		if (Health < 60) {
			System.out.println("狗狗生病了！");
		} else {
			System.out.println("狗狗正在和主人玩耍。");
			Health += -10;
			Love += +3;
		}
	}
	
	public void print() {
		System.out.println("宠物自白：\n我的名字叫"+this.Name
				+"健康值是"+this.Health+"和主人的亲密度是"+this.Love+"我是一只"+this.Strain);
	}
	
	
}
