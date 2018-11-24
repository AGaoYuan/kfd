package cn.book.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtil {
	//定义工厂实例
	private static SqlSessionFactory factory;

	/**
	 * 初始化SqlSessionFactory工厂对象
	 */
	static{
		try {
			//创建输入流 读取mybatis-config.xml配置文件
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
			//创建工厂对象
			factory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 打开会话  返回会话对象
	 * @return
	 */
	public static SqlSession getSqlSession(){
		return factory.openSession();
	}

	/**
	 * 关闭会话
	 * @param
	 */
	public static void closeSqlSession(SqlSession sqlSession){
		if (null!=sqlSession)
		sqlSession.close();
	}


}
