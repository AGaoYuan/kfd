package cn.happy.test;

import java.io.FileWriter;
import java.io.Writer;

/**
 *  Writer  字符输出流
 */
public class TestWriter {

    public static void main(String[] args) throws Exception {
        //创建输出对象 Writer
        Writer w = new FileWriter("E:/a.txt");
        //准备测试文本
        String str = "大家好，..........";
        //准备写出
        w.write(str);
        //写出并关闭流
        w.close();
    }

}
