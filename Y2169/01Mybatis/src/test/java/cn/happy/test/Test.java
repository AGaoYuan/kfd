package cn.happy.test;

/**
 * @Author: 咖啡豆
 * @Date: 2018/10/15 10:14
 * @Description:  位运算
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(2<<2);
        System.out.println("0000 1010 " +
                "         0000 0010" +
                "           0000 1000");

        /*String trimHtml = getTrimHtml("<html><body>4<5</body></html>");
        System.out.println(trimHtml);*/

    }
    public static String getTrimHtml(String str){
        /**
         * 考虑到JDK问题  JDK1.7及以下split方法的不同
         * String str = "abc"
         * 使用1.7及以下的JDK版本 split方法的结果为
         * str = str.split("")
         * str = ["","a","b","c"]
         * 使用1.8及以下的JDK版本 split方法的结果为
         * str = str.split("")
         * str = ["a","b","c"]
         *
         * 使用char [] tempstr = str.toCharArray();这种方法可以解决JDK版本不同的问题
         * JDK1.8及以上版本可以使用str.split("");方法
         */
        char [] tempstr = str.toCharArray();
        //String [] ss = str.split("");
        String result = str;
        int begin = -1;
        for(int i=0;i<str.length();i++){
            if (tempstr[i]=='<'){
                begin = i;
            }
            if (tempstr[i]=='>' && begin!=-1){
                result= result.replace(str.substring(begin,i+1),"");
                begin = -1;
            }
        }
        return result;
    }

}
