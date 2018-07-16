package cn.examination.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDAO {
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql:///schooldb";
	private static final String user = "root";
	private static final String password = "root";

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	// 连接数据库
	public Connection getConnection() throws Exception {
		Class.forName(driver);
		if (con == null || con.isClosed()) {
			con = DriverManager.getConnection(url, user, password);
		}
		return con;
	}

	// 增删改
	public int executeUpdate(String sql, Object... objects) throws Exception {
		con = getConnection();
		ps = con.prepareStatement(sql);
		for (int i = 0; i < objects.length; i++) {
			ps.setObject(i + 1, objects[i]);
		}
		int count = ps.executeUpdate();
		return count;
	}

	// 查询
	public ResultSet executeQuery(String sql, Object... objects) throws Exception {
		getConnection();
		ps = con.prepareStatement(sql);
		for (int i = 0; i < objects.length; i++) {
			ps.setObject(i + 1, objects[i]);
		}
		rs = ps.executeQuery();
		return rs;
	}

	// 资源释放
	public void CloseAll() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
