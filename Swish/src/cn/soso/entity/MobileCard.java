package cn.soso.entity;

/**
 * 用户类
 * @author Mr.Gao
 *
 */
public class MobileCard {
	
	private String cardNumber;  //手机号
	private String userName;	//用户名称
	private String PassWord;	//密码
	public ServicePackage serPackage;  //套餐父类
	private double consumAmount;	//当月消费金额
	private double money; 		//账户余额
	private int realTalkTime;	//实际通话时长（分钟）
	private int realSMSCount;	//实际发送短信条数（条）
	private int realFlow;	//实际上网流量
	
	//无参构造
	public MobileCard(){}
	
	//带参构造
	public MobileCard(String userName, String passWord,String cardNumber, ServicePackage serPackage,
			double consumAmount, double money) {
		this.userName = userName;
		this.PassWord = passWord;
		this.cardNumber = cardNumber;
		this.serPackage = serPackage;
		this.consumAmount = consumAmount;
		this.money = money;
	}

	public ServicePackage getSerPackage() {
		return serPackage;
	}

	public void setSerPackage(ServicePackage serPackage) {
		this.serPackage = serPackage;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return PassWord;
	}

	public void setPassWord(String passWord) {
		PassWord = passWord;
	}

	public double getConsumAmount() {
		return consumAmount;
	}

	public void setConsumAmount(double consumAmount) {
		this.consumAmount = consumAmount;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public int getRealTalkTime() {
		return realTalkTime;
	}

	public void setRealTalkTime(int realTalkTime) {
		this.realTalkTime = realTalkTime;
	}

	public int getRealSMSCount() {
		return realSMSCount;
	}

	public void setRealSMSCount(int realSMSCount) {
		this.realSMSCount = realSMSCount;
	}

	public int getRealFlow() {
		return realFlow;
	}

	public void setRealFlow(int realFlow) {
		this.realFlow = realFlow;
	}
	
	

	public void showMeg(){
		System.out.println("卡号："+this.cardNumber+"用户名："+this.userName+"当前余额："+this.money+"元");
		this.serPackage.showInfo();
	}
	
	
}
