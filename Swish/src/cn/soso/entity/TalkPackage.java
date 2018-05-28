package cn.soso.entity;


import cn.soso.common.Common;
import cn.soso.service.CallService;
import cn.soso.service.SendService;

/**
 * 话痨套餐
 * @author Mr.Gao
 *
 */
public class TalkPackage extends ServicePackage implements CallService,SendService{
	
	private int talkTime; //通话时长（分钟）
	private int smsCount; //短信条数（条）
	
	public TalkPackage(){
		this.talkTime = 500;
		this.smsCount = 30;
		this.price = 58.0;
	}
	
	
	public TalkPackage(int talkTime, int smsCount) {
		
		this.talkTime = talkTime;
		this.smsCount = smsCount;
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

	//抽象父类中的方法
	@Override
	public void showInfo() {
		System.out.println("话痨套餐：通话 时长为"+this.talkTime+"分钟/月，短信条数为"+
	this.smsCount+"条/月，资费为"+super.price);
		
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
