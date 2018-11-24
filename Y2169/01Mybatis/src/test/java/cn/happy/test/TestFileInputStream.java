package cn.happy.test;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 *  FileInputStream 字节输入流
 */
public class TestFileInputStream {

    public static void main(String[] args) throws Exception {
        //创建输入对象
        InputStream is = new FileInputStream("E:/a.txt");
        int num = 0;
        while((num=is.read())!=-1){
            System.out.println((char) num);
        }
        is.close();
    }

}
