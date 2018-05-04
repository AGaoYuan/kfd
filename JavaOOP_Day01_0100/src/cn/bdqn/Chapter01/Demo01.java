package cn.bdqn.Chapter01;

import java.util.Scanner;

public class Demo01 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Dog dog = new Dog();
		System.out.println("欢迎来到宠物店");
		System.out.println("请输入要领养的宠物名字：");
		String Name = in.next();
		dog.setName(Name);
		System.out.println("请选择要领养的宠物类型：(1、狗狗   2、企鹅)");
		int num =in.nextInt();
		switch (num) {
		case 1:
			dog.print();
			break;
		case 2:
			Penguin pe = new Penguin();
			System.out.println("请输入企鹅性别：(1、雄  2、雌)");
			pe.setName(Name);
			int sex = in.nextInt();
			if (sex == 1) {
				pe.sex = pe.SEX_MALE;
			}
			else if(sex == 2) {
				pe.sex = pe.SEX_FEMALE;
			}
			pe.print();
			break;

		default:
			break;
		}
		
		
		
	}

}
