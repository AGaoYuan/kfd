package cn.happy.test;

import org.junit.Test;

/**
 * @Author: 咖啡豆
 * @Date: 2018/10/24 9:32
 * @Description:
 */
public class TestDemo {

    public static void main(String[] args) {
        //System.out.println(isAutoMorphicNum(1000000));

        long begin = System.currentTimeMillis();
        for (int i=0;i<10000000;i++){
            int num = i*i;
            int result = i%10;
            if (result!=0&&result!=1&&result!=5&&result!=6) continue;
            if (num%10==i||num%100==i||num%1000==i||num%10000==i||num%100000==i){
                System.out.println("数字本身："+i+"数字的平方："+num);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end-begin);
    }


    @Test
    public void test(){
        /**
         * 需要8块钱
         * 剩余5 2 1块    5角
         */
        int money = 80;
        for (int i = 0;i<=money/50;i++){
            for (int j = 0;j<=money/20;j++){
                for (int x = 0;x<=money/10;x++){
                    if ((i*50+j*20+x*10)<0) break;
                    int d = (i*50+j*20+x*10)/5;
                        if (i*50+j*20+x*10+d == money){
                            System.out.println("5 "+i + "\t2 "+j+"\t1 "+x+"\t 0.5 \t"+d);
                     }
                }
            }
        }

    }


    /**
     *       A
     *      ABC
     *     ABCD
     *    ABCDE
     *   ABCDEF
     */
    @Test
    public void test2(){
        int a,b = 0;
        a = 5;
        b = 2;
        for(int i=1;i<=a;i++) {
            //根据外层行号，输出星号左边空格
            for (int j = 1; j <= a - i; j++){
                System.out.print(" ");//根据外层行号，输出星号个数
            }
            for (int k = 1; k <= b * i - 1; k++){
                if (k<i){
                    System.out.print((char) ('A'+k));
                }else{
                    System.out.print((char) ('A'+i-(k-i)));
                }
            }
            System.out.print("\n");
        }

    }

    @Test
    public void test3(){
        for (int i = 0; i < 5; i++) { //行数
            for (int j = 0; j < 5-i; j++) System.out.print(" ");
            for (int k = 0; k <= i; k++) System.out.print((char) ('A'+k));
            for (int y = i-1; y >= 0; y--) System.out.print((char) ('A'+y));
            System.out.println();
        }

    }




  /* public static String isAutoMorphicNum(int num)
    {


        String input = num + "";//5
        String power = num * num + "";//25
        if (input.equals(power.substring(power.length() - input.length()))) {
            return power.substring(power.length() - input.length());
        }
        return power;
    }*/


}
