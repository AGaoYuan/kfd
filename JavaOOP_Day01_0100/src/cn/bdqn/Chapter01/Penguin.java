package cn.bdqn.Chapter01;

/**
 * 企鹅类
 * @author Mr.Gao
 *
 */
public class Penguin {

	private String Name = "无名氏";//姓名
	private int Health = 100;//健康值
	private int Love = 0;//亲密度
	final String SEX_MALE = "雄";
	final String SEX_FEMALE = "雌";
	String sex = SEX_MALE;
	
	
	public Penguin(String name, int health, int love, String sex) {
		Name = name;
		Health = health;
		Love = love;
		this.sex = sex;
	}
	public Penguin() {
		
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
		Love = love;
	}
	
	
	public void print() {
		System.out.println("宠物自白：\n我的名字叫"+this.Name
				+"健康值是"+this.Health+"和主人的亲密度是"+this.Love+"性别是"+this.sex+"。");
	}
	
	
	
}
