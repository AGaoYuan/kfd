package cn.soso.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.*;

import cn.soso.common.Common;
import cn.soso.entity.ConsumInfo;
import cn.soso.entity.MobileCard;
import cn.soso.entity.NetPackage;
import cn.soso.entity.Scene;
import cn.soso.entity.ServicePackage;
import cn.soso.entity.SuperPackage;
import cn.soso.entity.TalkPackage;
import cn.soso.service.CallService;
import cn.soso.service.NetService;
import cn.soso.service.SendService;

/**
 * 工具类
 * 
 * @author Mr.Gao
 *
 */
public class CardUtil {
	public Map<String, MobileCard> cards = new HashMap<String, MobileCard>();
	public Map<String, List<ConsumInfo>> consumInfos = new HashMap<String, List<ConsumInfo>>();

	List<Scene> scenes = new ArrayList<Scene>();

	public void init() {
		MobileCard card1 = new MobileCard("大牛", "123", "13965756432", new TalkPackage(), 58.0, 42.0);

		MobileCard card2 = new MobileCard("小牛", "123", "13956712467", new NetPackage(), 68.0, 32.0);

		MobileCard card3 = new MobileCard("微冷的雨", "123", "13911568956", new SuperPackage(), 78.0, 22.0);

		MobileCard card4 = new MobileCard("张三", "123", "13924221868", new SuperPackage(), 78.0, 2.0);

		card4.setConsumAmount(98.0);
		card4.setRealTalkTime(500);
		card4.setRealSMSCount(100);

		cards.put("13965756432", card1);
		cards.put("13956712467", card2);
		cards.put("13911568956", card3);
		cards.put("13924221868", card4);
	}

	public void initScene() {
		scenes.add(new Scene("通话", 90, "问候客户，谁知其如此难缠 通话90分钟"));
		scenes.add(new Scene("通话", 30, "询问妈妈身体情况 本地通话30分钟"));
		scenes.add(new Scene("短信", 5, "参与环境保护实施方案问卷调查  发送短信5条"));
		scenes.add(new Scene("短信", 50, "通知朋友手机换号，发送短信50条"));
		scenes.add(new Scene("上网", 1 * 1024, "和好基友微信视频聊天   使用流量1G"));
		scenes.add(new Scene("上网", 2 * 1024, "晚上手机在线看韩剧，不留神睡着了！使用流量2G"));

	}

	// 验证用户注册
	public boolean isExistCard(String number, String passWord) {
		Set<String> numbers = cards.keySet();
		Iterator<String> it = numbers.iterator();
		while (it.hasNext()) {
			String searchNum = it.next();
			if (searchNum.equals(number) && (cards.get(searchNum)).getPassWord().equals(passWord)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @param searNumber
	 * @return
	 */
	public boolean isExistCard(String searNumber) {
		Set<String> numbers = cards.keySet();
		for (String number : numbers) {
			if (number.equals(searNumber)) {
				return true;
			}
		}

		return false;
	}

	// 随机生成电话号码
	public String createNumber() {
		Random random = new Random();
		String number = "";
		int num = 0;
		do {
			num = random.nextInt(100000000);
		} while (num<10000000);
		number = "139"+num;
		Set<String> cardNumbers = cards.keySet();
		for (String cardNumber : cardNumbers) {
			if (number.equals(cardNumber)) {
				continue;
			}
		}
		
		return number;
	}

	public String[] getNewNumbers(int count) {
		String [] numbers = new String[count];
		for (int i = 0; i < count; i++) {
			numbers[i] = createNumber();
		}
		return numbers;
	}

	/*
	 * 添加用户
	 */
	public void addCard(MobileCard card) {
		cards.put(card.getCardNumber(), card);
		System.out.println("注册成功！");
		card.showMeg();
	}

	/*
	 * 办理退网
	 */
	public void delCard(String delNumber) {
		if (isExistCard(delNumber)) {
			cards.remove(delNumber);
			System.out.println("卡号：" + delNumber + "办理退网成功！");
		} else {
			System.out.println("对不起，该卡号未注册，不能办理退网！");
		}

	}

	/*
	 * 套餐余量查询
	 */
	public void showRemainDetail(String searNumber) {
		MobileCard mobileCard = cards.get(searNumber);
		MobileCard card;
		int remainTalkTime;
		int remainSmsCount;
		int remainFlow;

		StringBuffer meg = new StringBuffer();
		card = cards.get(searNumber);
		meg.append("您的手机号码是：" + searNumber + "套餐内剩余：\n");
		ServicePackage pack = card.getSerPackage();
		// 向下转型超人类型
		if (pack instanceof SuperPackage) {
			SuperPackage cardPack = (SuperPackage) pack;
			// 查询套餐内剩余的通话时长
			remainTalkTime = cardPack.getTalkTime() > card.getRealTalkTime()
					? cardPack.getTalkTime() - card.getRealTalkTime() : 0;
			meg.append("通话时长：" + remainTalkTime + "分钟 \n");
			// 查询套餐内剩余的短信条数
			remainSmsCount = cardPack.getSmsCount() > card.getRealSMSCount()
					? cardPack.getSmsCount() - card.getRealSMSCount() : 0;
			meg.append("短信条数：" + remainSmsCount + "条\n");
			remainFlow = cardPack.getFlow() > card.getRealFlow() ? cardPack.getFlow() - card.getRealFlow() : 0;
			meg.append("上网流量：" + Common.dataFormat(remainFlow * 1.0 / 1024) + "GB");

			// 向下转型上网套餐
		} else if (pack instanceof NetPackage) {
			NetPackage cardPack = (NetPackage) pack;
			// 查询套餐内剩余的流量
			remainFlow = cardPack.getFlow() > card.getRealFlow() ? cardPack.getFlow() - card.getRealFlow() : 0;

			meg.append("上网流量：" + Common.dataFormat(remainFlow * 1.0 / 1024) + "GB");

			// 向下转型话痨
		} else if (pack instanceof TalkPackage) {
			TalkPackage cardPack = (TalkPackage) pack;
			remainTalkTime = cardPack.getTalkTime() > card.getRealTalkTime()
					? cardPack.getTalkTime() - card.getRealTalkTime() : 0;
			meg.append("通话时长：" + remainTalkTime + "分钟\n");

			remainSmsCount = cardPack.getSmsCount() > card.getRealSMSCount()
					? cardPack.getSmsCount() - card.getRealSMSCount() : 0;
			meg.append("短信条数：" + remainSmsCount + "条");
		}
		System.out.println(meg);
	}

	/*
	 * 本月账单查询
	 */
	public void showAmountDetaul(String searNumber) {
		MobileCard card;
		StringBuffer meg = new StringBuffer();
		card = cards.get(searNumber);
		meg.append("您的卡号：" + card.getCardNumber() + "，当月账单：\n");
		meg.append("套餐资费：" + card.getSerPackage().getPrice() + "元\n");
		meg.append("合计：" + Common.dataFormat(card.getConsumAmount()) + "元\n");
		meg.append("账户余额：" + Common.dataFormat(card.getMoney()) + "元");

		System.out.println(meg);
	}

	// 返回套餐对象，例属于咱们的工厂类
	public ServicePackage createPack(int packId) {
		ServicePackage pack = null;
		switch (packId) {
		case 1:
			pack = new TalkPackage();
			break;
		case 2:
			pack = new NetPackage();
			break;
		case 3:
			pack = new SuperPackage();
			break;
		}
		return pack;
	}

	/**
	 * 添加一条指定卡的消费记录
	 * @param number  要添加消费记录的卡
	 * @param Info  要添加的消费记录
	 */
	public void addConsumInfo(String number, ConsumInfo Info) {
		Set<String> numbers = consumInfos.keySet();
		Iterator<String> it = numbers.iterator();
		List<ConsumInfo> infos = new ArrayList<ConsumInfo>();
		boolean isExist = false;
		while(it.hasNext()){
			if (it.next().equals(number)) {
				infos = consumInfos.get(number);
				infos.add(Info);
				isExist = true;
				System.out.println("已添加一条消费记录。");
				break;
			}
		}
		if (!isExist) {
			infos.add(Info);
			consumInfos.put(number, infos);
			System.err.println("不存在此卡的消费记录，已添加一条消费记录。");
		}
	}

	public void useSoso(String number) {
		MobileCard card = cards.get(number);//获取该卡对象
		ServicePackage pack = card.getSerPackage();
		Random random = new Random();
		int ranNum = 0;
		int temp = 0;
		do {
			ranNum = random.nextInt(6);
			Scene scene = scenes.get(ranNum);
			switch (ranNum) {
			case 0:
			case 1:
				if (pack instanceof CallService) {
					System.out.println(scene.getDescription());
					CallService callService = (CallService) pack;
					try{
						temp = callService.call(scene.getData(), card);
					}catch (Exception e) {
						e.printStackTrace();
					}
					addConsumInfo(number, new ConsumInfo(number,
							scene.getType(),temp));
					break;
				}else {
					continue;
				}
			case 2:
			case 3:
				if (pack instanceof SendService) {
					System.out.println(scene.getDescription());
					SendService sendService = (SendService) pack;
					try {
						temp = sendService.send(scene.getData(), card);
					} catch (Exception e) {
						e.printStackTrace();
					}
					addConsumInfo(number, new ConsumInfo(number,
							scene.getType(),temp));
					break;
				}else {
					continue;
				}
			
			case 4:
			case 5:
				if (pack instanceof NetService) {
					System.out.println(scene.getDescription());
					
					NetService netService = (NetService) pack;
					try {
						temp = netService.netPlay(scene.getData(), card);
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					addConsumInfo(number, new ConsumInfo(number,
							scene.getType(),temp));
					break;
					
				}else {
					continue;
				}
			}
			break;
		} while (true);
	}
	
	/**
	 * 显示资费说明
	 */
	public void showDescription() {
		Reader reader = null;
		try {
			reader = new FileReader("F:\\Java\\嗖嗖\\套餐资费说明.txt");
			char [] content = new char[1024];
			int len = 0;
			StringBuffer sb = new StringBuffer();
			while((len=reader.read(content))!=-1){
				sb.append(content,0,len);
			}
			System.out.println(sb);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * 更换套餐方法
	 * @param number  手机卡号
	 * @param packNum 菜单序号
	 */
	public void changingPack(String number, int packNum) {
		MobileCard card;
		ServicePackage pack;
		if (isExistCard(number)) {
			card = cards.get(number);
			switch (packNum) {
			case 1:
				pack = new TalkPackage();
				break;
			case 2:
				pack = new NetPackage();
				break;

			default:
				pack = new SuperPackage();
				break;
			}
			if (!(card.getSerPackage().getClass().getName().equals(pack.getClass().getName()))) {
				if (card.getMoney() >= pack.getPrice()) {
					card.setMoney(card.getMoney() - pack.getPrice());
					card.setSerPackage(pack);
					card.setRealTalkTime(0);
					card.setRealFlow(0);
					card.setRealSMSCount(0);
					card.setConsumAmount(pack.getPrice());
					System.out.println("更换套餐成功！");
					
					pack.showInfo();
				}else{
					System.out.println("对不起，您的余额不足以支付新套餐本月资费，请充值后再办理更换套餐业务！");
					return;
				}
			}else{
				System.out.println("对不起，您已经是改套餐用户，无需换套餐！");
			}
		}else{
			System.out.println("对不起，该卡号未注册，不能换套餐！");
		}
		
	}

	
	
	public void printConsumInfo(String number) {
		Writer fileWriter = null;
		try {
			fileWriter = new FileWriter(number+"消费记录.txt");
			Set<String> numbers = consumInfos.keySet();
			Iterator<String> it = numbers.iterator();
			List<ConsumInfo> infos = new ArrayList<ConsumInfo>();
			
			boolean isExist = false;
			while(it.hasNext()){
				if (it.next().equals(number)) {
					infos = consumInfos.get(number);
					isExist = true;
					
					break;
				}
			}
			if (isExist) {
				StringBuffer content = new StringBuffer("******"+number+"消费记录******\r\n");
				content.append("\r\n序号\t类型\t数据（通话（条）/上网（MB）/短信（条））\r\n");
				for (int i = 0; i < infos.size(); i++) {
					ConsumInfo info = infos.get(i);
					content.append((i+1)+".\t"+info.getType()+"\t"+info.getConsumData()+"\n");
				}
				fileWriter.write(content.toString());
				fileWriter.flush();
				System.out.println("消费记录打印完毕！");
				
			}else{
				System.out.println("对不起，不存在此号码的消费记录，不能打印！");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (fileWriter!=null) {
				try{
					fileWriter.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
			
		}
		
		
	}

	/*
	 * 话费充值
	 */
	public void chargeMoney(String number,double money) {
		MobileCard card;
		if (money < 50) {
			System.out.println("对不起，最充值金额为50元！");
			return;
		}
		card = cards.get(number);
		card.setMoney(card.getMoney()+money);
		System.out.println("充值成功，当前话费余额为"+Common.dataFormat(card.getMoney())+"元");
		
	}

}
