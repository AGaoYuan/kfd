package cn.happy.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * 缓冲区输入流  BufferedReader
 */
public class TestBufferedReader {

    public static void main(String[] args) throws Exception {
        //设置编码格式
        InputStreamReader isr = new InputStreamReader(new FileInputStream("E:/a.txt"), "GBK");
        //创建读取对象
        BufferedReader br = new BufferedReader(isr);
        String str = null;
        StringBuffer sb = new StringBuffer();
        while((str=br.readLine())!=null){
            sb.append(str);
        }
        System.out.println(sb.toString());
        br.close();
    }

}
