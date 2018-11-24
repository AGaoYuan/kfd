package cn.happy.testreflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @Author: 咖啡豆
 * @Date: 2018/10/17 11:11
 * @Description:
 */
public class ReflectTest {

    @Test
    public void test01() throws Exception {
        Class stu = Class.forName("cn.happy.testreflect.Student");
        System.out.println(stu.getName());
        System.out.println(stu.getSimpleName());
        System.out.println(stu.getPackage().getName());

        //获取类中字段的访问修饰符
        int num = stu.getModifiers();
        System.out.println(num+"---->"+Modifier.toString(num));

    }

    /**
     * 获取属性的名称 和修饰符
     * @throws Exception
     */
    @Test
    public void test02() throws Exception {
        Class stu = Class.forName("cn.happy.testreflect.Student");
        Field[] fields = stu.getDeclaredFields();
        for (int i = 0; i<fields.length;i++){
            System.out.println("获取所有属性名称："+fields[i].getName());
        }
        for (int i = 0; i<fields.length;i++){
            System.out.println(Modifier.toString(fields[i].getModifiers()));
        }
    }

    /**
     * 获取方法的名称和访问修饰符
     * @throws Exception
     */
    @Test
    public void test03() throws Exception {
        Class stu = Class.forName("cn.happy.testreflect.Student");
        Method[] methods = stu.getDeclaredMethods();
        for (int i = 0; i<methods.length;i++){
            System.out.println("获取所有方法名称："+methods[i].getName());
        }
        System.out.println("===============分隔符==============");
        for (int i = 0; i<methods.length;i++){
            System.out.println(Modifier.toString(methods[i].getModifiers()));
            System.out.println(methods[i].getReturnType());
        }
    }


    /**
     * 获取构造方法的名称和访问修饰符
     * @throws Exception
     */
    @Test
    public void test04() throws Exception {
        Class stu = Class.forName("cn.happy.testreflect.Student");
        Constructor[] constructors = stu.getDeclaredConstructors();
        for (int i = 0; i<constructors.length;i++){
            System.out.println("获取所有构造方法名称："+constructors[i].getName());
        }
        System.out.println("===============分隔符==============");
        for (int i = 0; i<constructors.length;i++){
            System.out.println(Modifier.toString(constructors[i].getModifiers()));
        }
    }

    /**
     * 获取类中的私有构造方法并进行执行
     * @throws Exception
     */
    @Test
    public void test05() throws Exception {
        Class stu = Class.forName("cn.happy.testreflect.Student");
        Student student = (Student) stu.newInstance();
        Field field = stu.getDeclaredField("userName");
        System.out.println("字段名称："+field.getName());
        //打开开关
        field.setAccessible(true);
        System.out.println("字段的值："+field.get(student));

        //获取私有方法
        Method method = stu.getDeclaredMethod("getSum",double.class);
        method.setAccessible(true);
        double result = (double) method.invoke(student, 50.5);
        System.out.println(result);
    }





}
