package cn.happy.test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 二进制流
 */
public class TestDataInputStream {

    public static void main(String[] args) throws Exception {
        DataInputStream dis = new DataInputStream(new FileInputStream("F:\\图片\\1.jpg"));
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("F:/a.jpg"));
        int temp = 0;
        while((temp=dis.read())!=-1){
            dos.write(temp);
        }
        dos.close();
        dis.close();

    }

}
