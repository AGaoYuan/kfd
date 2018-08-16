package cn.news.entity;

import java.util.Date;

/**
 * 新闻内容实体类
 * @author 21600
 *
 */
public class NewsInfo {
	
	private int newsid;
	private String newstitle;
	private String newssummary;
	private String newscontent;
	private Date newsdate;
	private String newsowner;
	private int newscate;
	private String newspic;
	private int newsclickcount;
	
	public int getNewsid() {
		return newsid;
	}
	public void setNewsid(int newsid) {
		this.newsid = newsid;
	}
	public String getNewstitle() {
		return newstitle;
	}
	public void setNewstitle(String newstitle) {
		this.newstitle = newstitle;
	}
	public String getNewssummary() {
		return newssummary;
	}
	public void setNewssummary(String newssummary) {
		this.newssummary = newssummary;
	}
	public String getNewscontent() {
		return newscontent;
	}
	public void setNewscontent(String newscontent) {
		this.newscontent = newscontent;
	}
	public Date getNewsdate() {
		return newsdate;
	}
	public void setNewsdate(Date newsdate) {
		this.newsdate = newsdate;
	}
	public String getNewsowner() {
		return newsowner;
	}
	public void setNewsowner(String newsowner) {
		this.newsowner = newsowner;
	}
	public int getNewscate() {
		return newscate;
	}
	public void setNewscate(int newscate) {
		this.newscate = newscate;
	}
	public String getNewspic() {
		return newspic;
	}
	public void setNewspic(String newspic) {
		this.newspic = newspic;
	}
	public int getNewsclickcount() {
		return newsclickcount;
	}
	public void setNewsclickcount(int newsclickcount) {
		this.newsclickcount = newsclickcount;
	}
	
	
	
	
}
