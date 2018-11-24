package cn.happy.testSingleton;

/**
 * @Author: 咖啡豆
 * @Date: 2018/10/17 9:04
 * @Description: 双重校验锁
 */
public class SingletonTest1 {
    private static SingletonTest1 ourInstance;

    public static synchronized SingletonTest1 getInstance() {
        if(ourInstance==null){
            synchronized (SingletonTest1.class){
                if (ourInstance==null){
                    ourInstance = new SingletonTest1();
                }
            }
        }
        return ourInstance;
    }

    private SingletonTest1() {
    }
}
