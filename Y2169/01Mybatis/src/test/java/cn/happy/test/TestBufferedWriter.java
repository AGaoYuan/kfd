package cn.happy.test;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * 缓冲区输出流   BufferedWriter
 */
public class TestBufferedWriter {

    public static void main(String[] args) throws Exception {
        //创建输出流，并追加字符串
        BufferedWriter bw = new BufferedWriter(new FileWriter("E:/a.txt",true));
        String str1 = "大家好，我是BufferedWriter1";
        String str2 = "大家好，我是BufferedWriter2";
        //写入第一段字符串
        bw.write(str1);
        //清除缓存，（快速添加到文本文件）
        bw.flush();
        //线程休眠5秒
        Thread.sleep(5000);
        //换行
        bw.newLine();
        //写入第二段字符串
        bw.write(str2);
        //关流
        bw.close();
    }

}
