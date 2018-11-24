package cn.school.utils;/**
 * Created by Happy on 2018-10-31.
 */

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 作者：微冷的雨
 *
 * @create 2018-10-31
 * 博客地址:www.cnblogs.com/weilengdeyu
 */
public class MyBatisUtil {
    static String path="mybatis.xml";

    static InputStream is;
    static {
        try {
            is= Resources.getResourceAsStream(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static SqlSessionFactoryBuilder sb=  new SqlSessionFactoryBuilder();
    //一个程序中有一个就够了
    static SqlSessionFactory factory = sb.build(is);
    static SqlSession session;
    //提供两个方法
    //01.,用于向外界提供一个会话对象
    public static SqlSession getSession(){
        session = factory.openSession(true);
        return session;
    }
    //02.用于销毁一个会话对象
    public static void closeSession(){
        session.close();
    }

}
















