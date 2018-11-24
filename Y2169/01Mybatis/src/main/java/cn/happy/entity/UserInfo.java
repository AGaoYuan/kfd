package cn.happy.entity;

/**
 *用户实体类
 */
public class UserInfo {

	//用户字段
	private int uid;
	private String uname;
	private String upwd;


	//gatter and setter方法

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpwd() {
		return upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
}
