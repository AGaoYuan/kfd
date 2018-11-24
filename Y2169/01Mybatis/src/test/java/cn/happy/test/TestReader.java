package cn.happy.test;

import java.io.FileReader;
import java.io.Reader;

/**
 *  Reader  字符输入流
 */
public class TestReader {

    public static void main(String[] args) throws Exception {
        /**
         *  出现乱码的话，可以将要读取的文件改为通用的编码（如UTF-8）.如txt的文件可以在另存为中设置编码。
         *  然后读取 显示 写入都是正常的。
         */
        Reader dr = new FileReader("E:/a.txt");
        char [] data = new char[1024];
        int num = 0;
        while((num=dr.read(data))!=-1){
            System.out.println(data);
        }
        dr.close();
    }


}
