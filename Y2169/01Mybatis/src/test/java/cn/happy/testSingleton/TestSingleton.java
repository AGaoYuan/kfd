package cn.happy.testSingleton;

import org.junit.Test;

/**
 * @Author: 咖啡豆
 * @Date: 2018/10/17 9:51
 * @Description:
 */
public class TestSingleton {

    @Test
    public void testSingleton() throws Exception {
        SingletonTest1 s1 = SingletonTest1.getInstance();
        SingletonTest1 s2 = SingletonTest1.getInstance();
        
        System.out.println(s1==s2);
    }

}
