package com.zyx.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtil {
    private  static SqlSessionFactory factory;
    static {
        try {
            //获取mybatis_config.xml文件的输入流
            InputStream  is = Resources.getResourceAsStream("mybatis_config.xml");
            //完成对输入流的配置文件读取
             factory= new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static  SqlSession sqlSession;

    /**
     *  创建sqlSession
     * @return
     */
    public  static SqlSession cerateSqlSession(){
        sqlSession=factory.openSession(true);
        return sqlSession ;
    }

    /**
     * 关闭sqlsesion
     *
     */
    public  static  void  closeSqlSession(){
        if (sqlSession!=null){
            sqlSession.close();
        }
    }
}
