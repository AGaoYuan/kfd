package cn.soso.biz;

import java.util.*;

import cn.soso.entity.MobileCard;
import cn.soso.entity.ServicePackage;
import cn.soso.utils.CardUtil;

public class SosoMgr {

	Scanner in = new Scanner(System.in);

	CardUtil utils = new CardUtil();

	public static void main(String[] args) {
		
		
		
		SosoMgr soso = new SosoMgr();

		soso.paintMainMeun();

		System.out.println("谢谢使用！");

	}

	public void paintMainMeun() {
		// 定义菜单选择序号变量
		int meunChoose = 0;
		// 定义存储手机卡号变量
		String mobileNumber = "";
		// 定义密码
		String password = "";

		/*
		 * 调用初始化信息的方法
		 */
		utils.init();
		utils.initScene();

		do {
			System.out.println("\n***********欢迎使用嗖嗖移动业务大厅***********");
			System.out.println("1.用户登录       2.用户注册    3.使用嗖嗖    4.话费充值   5.资费说明   6.退出系统");
			System.out.println("请选择：");
			meunChoose = in.nextInt();
			switch (meunChoose) {
			case 1:
				System.out.println("请输入手机卡号：");
				mobileNumber = in.next();
				System.out.println("请输入密码：");
				password = in.next();
				if (utils.isExistCard(mobileNumber, password)) {
					CardMenu(mobileNumber);
				} else {
					System.err.println("对不起，您输入的信息有误，无法登陆！(如果还没有手机号，请先去注册！)");
				}
				continue;
			case 2:
				registCard();
				
				continue;
			case 3:
				System.out.println("请输入手机号：");
				mobileNumber = in.next();

				if (utils.isExistCard(mobileNumber)) {
					try {
						utils.useSoso(mobileNumber);
					} catch (Exception e) {
						System.err.println(e.getMessage());
					}
				} else {
					System.out.println("对不起，该卡号未注册，不能使用！");
				}
				continue;
			case 4:
				System.out.println("请输入充值卡号：");
				mobileNumber = in.next();
				if (utils.isExistCard(mobileNumber)) {
					System.out.println("请输入充值金额：");
					double money = in.nextDouble();
					utils.chargeMoney(mobileNumber, money);
				} else {
					System.out.println("对不起，要充值的卡号未注册，无法充值！");
				}

				continue;
			case 5:
				utils.showDescription();
				continue;
			case 6:
				System.out.println("谢谢使用！");
				System.exit(1);
				break;
			default:
				System.out.println("请输入正确的数字！");
				break;
			}
		} while (true);

	}

	public int CardMenu(String mobileNumber) {
		int menuChoose = 0;
		do {
			System.out.println("\n*****嗖嗖移动用户菜单*****");
			System.out.println("1.本月账单查询");
			System.out.println("2.套餐余量查询");
			System.out.println("3.打印消费详单");
			System.out.println("4.套餐变更");
			System.out.println("5.办理退网");
			System.out.println("请选择(输入1~5选择功能，其他键返回上一级)：");
			menuChoose = in.nextInt();
			switch (menuChoose) {
			case 1:
				System.out.println("\n*****本月账单查询*****");
				utils.showAmountDetaul(mobileNumber);
				continue;
			case 2:
				System.out.println("\n*****套餐余量查询*****");
				utils.showRemainDetail(mobileNumber);
				continue;
			case 3:
				System.out.println("\n*****消费详单查询*****");
				utils.printConsumInfo(mobileNumber);
				continue;
			case 4:
				System.out.println("\n*****套餐变更*****");
				System.out.println("1.话痨套餐  2.网虫套餐  3.超人套餐  请选择(序号)：");
				int num = in.nextInt();
				if (num!=1&&num!=2&&num!=3) {
					System.err.println("请输入指定套餐！");
					continue;
				}else {
					utils.changingPack(mobileNumber, num);
				}
				
				continue;
			case 5:
				System.out.println("\n*****办理退网*****");
				utils.delCard(mobileNumber);
				System.out.println("谢谢使用！");
				System.exit(1);
			}
			break;
		} while (true);
		return menuChoose;
	}

	public void registCard() {
		String[] newNumbers = utils.getNewNumbers(9);
		System.out.println("*****可选择的卡号*****");

		for (int i = 0; i < 9; i++) {
			System.out.print((i + 1) + "." + newNumbers[i] + "\t\t");
			if ((i + 1) % 3 == 0) {
				System.out.println();
			}
		}
		System.out.println("请选择卡号(输入1~9的序号)：");
		String number = newNumbers[in.nextInt() - 1];
		System.out.println("1.话痨套餐  2.网虫套餐  3.超人套餐 ，请选择套餐(输入序号)：");
		ServicePackage pack = utils.createPack(in.nextInt());
		System.out.println("请输入姓名：");
		String name = in.next();

		System.out.println("请输入密码：");
		String password = in.next();

		double money = 0;
		System.out.println("请输入预存话费金额：");
		money = in.nextDouble();
		while (money < pack.getPrice()) {
			System.out.println("您预存的话费金额不足以支付本月固定套餐资费，请重新充值：");
			money = in.nextDouble();
		}
		MobileCard mobileCard = new MobileCard
				(name, password, number, pack, pack.getPrice(), money - pack.getPrice());
		utils.addCard(mobileCard);

	}

}
