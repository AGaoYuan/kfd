package cn.happy.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 序列化   反序列化
 */
public class StudentDemo {

    public static void main(String[] args) throws Exception {
        //serialize();//序列化
        Deserialize();//反序列化

    }

    //反序列化
    private static void Deserialize() throws Exception{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("E:/Student.txt"));
        Student stu = (Student) ois.readObject();
        System.out.println(stu);
        ois.close();
    }

    //序列化
    private static void serialize() throws Exception{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("E:/Student.txt"));
        Student student = new Student();
        student.setStuid(1);
        student.setName("大黑");
        student.setStuAge(50);
        oos.writeObject(student);

        oos.close();
    }

}
