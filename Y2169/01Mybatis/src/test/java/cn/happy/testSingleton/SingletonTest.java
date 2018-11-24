package cn.happy.testSingleton;

/**
 * @Author: 咖啡豆
 * @Date: 2018/10/17 9:04
 * @Description:
 */
public class SingletonTest {
    private static SingletonTest ourInstance;

    public static synchronized SingletonTest getInstance() {
        if(ourInstance==null) ourInstance = new SingletonTest();
        return ourInstance;
    }

    private SingletonTest() {
    }
}
