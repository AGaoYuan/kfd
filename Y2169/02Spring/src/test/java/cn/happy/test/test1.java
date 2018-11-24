package cn.happy.test;

import java.util.Scanner;

/**
 * @Author: 咖啡豆
 * @Date: 2018/11/21 9:03
 * @Description:
 */
public class test1 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("减法");
        System.out.println("加法");
        System.out.println("请选择：");
        int i = in.nextInt();
        switch (i){
            case 1:
                Less l = new Less();
                l.numberA=2;
                l.numberB=2;
                System.out.println(l.GetResult());
                break;
            case 2:
                break;
        }

    }

}
