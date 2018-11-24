package cn.happy.test;

import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 *  FileOutputStream 字节输出流
 */
public class TestFileOutputStream {

    public static void main(String[] args) throws Exception {
        //创建输出对象
        OutputStream os = new FileOutputStream("E:/a.txt");
        String str = "abcd";
        os.write(str.getBytes());
        os.close();
    }


}
