package cn.soso.entity;


import cn.soso.common.Common;
import cn.soso.service.CallService;
import cn.soso.service.NetService;
import cn.soso.service.SendService;

/**
 * 超人套餐
 * @author Mr.Gao
 *
 */
public class SuperPackage extends ServicePackage implements CallService,SendService,NetService{
	
	private int talkTime; //通话时长（分钟）
	private int smsCount; //短信条数（条）
	private int flow; //上网流量（MB）
	
	public SuperPackage(){
		this.talkTime = 200;
		this.smsCount = 50;
		this.flow = 1*1024;
		this.price = 78.0;
		
	}
	
	public SuperPackage(double price, int talkTime, int smsCount, int flow) {
		super(price);
		this.talkTime = talkTime;
		this.smsCount = smsCount;
		this.flow = flow;
	}

	public int getTalkTime() {
		return talkTime;
	}

	public void setTalkTime(int talkTime) {
		this.talkTime = talkTime;
	}

	public int getSmsCount() {
		return smsCount;
	}

	public void setSmsCount(int smsCount) {
		this.smsCount = smsCount;
	}

	public int getFlow() {
		return flow;
	}

	public void setFlow(int flow) {
		this.flow = flow;
	}
	
	//抽象父类中的方法
	@Override
	public void showInfo() {
		System.out.println("超人套餐：通话时长为"+this.talkTime
				+"分钟/月，短信条数为"+this.smsCount
				+"条/月，上网流量为"+this.flow/1024+"GB/月。");
	}
	
	//上网接口中的方法
	@Override
	public int netPlay(int flow, MobileCard card) throws Exception {
		int temp = flow;
		for (int i = 0; i < flow; i++) {
			if (this.flow-card.getRealFlow()>=1) {
				card.setRealFlow(card.getRealFlow()+1);
			}else if (card.getMoney()>=0.1) {
				card.setRealFlow(card.getRealFlow()+1);
				card.setMoney(Common.sub(card.getMoney(), 0.1));
				card.setConsumAmount(card.getConsumAmount()+0.1);
			}else {
				temp = i;
				throw new Exception("本次已使用流量"+i+"MB，您的余额不足，请充值后再使用！");
			}
		}
		
		return temp;
	}

	//发送短信接口中的方法
	@Override
	public int send(int Count, MobileCard card) throws Exception {
		int temp = smsCount;
		for (int i = 0; i < smsCount; i++) {
			if (this.smsCount-card.getRealSMSCount()>=1) {
				card.setRealSMSCount(card.getRealSMSCount()+1);
			}else if (card.getMoney()>=0.1) {
				card.setRealSMSCount(card.getRealSMSCount()+1);
				card.setMoney(Common.sub(card.getMoney(), 0.1));
				card.setConsumAmount(card.getConsumAmount()+0.1);
			}else {
				temp = i;
				throw new Exception("本次已发送短信"+i+"条，您的余额不足，请充值后在使用 ！");
			}
		}
		return temp;
	}

	//通话接口中的方法
	@Override
	public int call(int minCount, MobileCard card) throws Exception {
		int temp = minCount;
		for (int i = 0; i < minCount; i++) {
			if (this.talkTime-card.getRealTalkTime()>=1) {
				card.setRealTalkTime(card.getRealTalkTime()+1);
			}else if (card.getMoney()>=0.2) {
				card.setRealTalkTime(card.getRealTalkTime()+1);
				card.setMoney(Common.sub(card.getMoney(),0.2));
				card.setConsumAmount(card.getConsumAmount()+0.2);
			}else {
				temp = i;
				throw new Exception("本次已通话"+i+"分钟，您的余额不足，请充值后在使用！");
			}
		}
		
		return temp;
	}
	
	
}
