package cn.jbit.myschool.impl;

import java.awt.List;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
/**
 * 工具类
 * @author 21600
 *
 */
public class BaseDao {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	static{//静态代码块，在类加载的时候执行
		init();
	}
	/**
	 * 初始化连接参数，从配置文件里获得
	 */
	public static void init(){
		Properties params = new Properties();
		String configFile = "database.properties";//配置文件路径
		InputStream iS = BaseDao.class.getClassLoader().getResourceAsStream(configFile);
		try {
			params.load(iS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver= params.getProperty("driver");
		url = params.getProperty("url");
		user = params.getProperty("user");
		password = params.getProperty("password");
		
	}
	/**
	 * 获取数据库连接对象
	 * @return
	 */
	public Connection getConnection() {
		if (conn==null) {
			//获取连接并捕获异常
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url,user,password);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return conn;
	}
	/**
	 * 关闭数据库连接
	 * @param conn 数据库连接对象
	 * @param stmt Statement对象 (操作数据库一些增、删、改的对象)
	 * @param rs 返回的结果集对象
	 */
	public void closeAll(Connection conn,Statement stmt,ResultSet rs){
		//若结果集对象不为空，则关闭
		try {
			if (rs != null) {
				rs.close();
			}else if (stmt != null) {
				stmt.close();
			}else if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 增、删、改的操作
	 * @param preparedSql 预编译的SQL语句
	 * @param param 参数的字符串数组
	 * @return 返回受影响的行数
	 */
	public int exceuteUpdate(String preparedSql,Object [] param){
		int num = 0;
		conn = getConnection();
		try {
			ps = conn.prepareStatement(preparedSql);
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					//为预编译sql设置参数
					ps.setObject(i+1, param[i]);
				}
			}
			num = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeAll(conn, ps, null);
		}
		return num;
	}
	
	/**
	 * 返回结果集
	 * @param sql
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public ResultSet getResultSet(String sql,Object...obj){
		conn = getConnection();
		try {
			ps = conn.prepareStatement(sql);
			if (ps!= null) {
				for (int i = 0; i < obj.length; i++) {
					ps.setObject(i+1, obj[i]);
				}
				rs = ps.executeQuery();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			closeAll(conn, ps, rs);
		}
		
		return rs;
	}
	
	
	
	
	
}
