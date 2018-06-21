package cn.cms.entity;

import java.util.Date;

/**
 * 书籍实体类
 * @author 21600
 *
 */
public class News {
	private int id;//书籍编号
	private String title;//书籍名
	private String author;//书籍作者
	private Date createTime;//发行日期
	private String content;//书籍描述
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
	
}
