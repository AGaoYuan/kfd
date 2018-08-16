package cn.news.util;

import java.util.List;

import cn.news.entity.Category;
import cn.news.entity.NewsInfo;
import cn.news.entity.UserInfo;

public class PageUtil<T> {
	
	//当前页面
	private Integer pageIndex;
	//每页显示的记录数
	private int pageSize;
	//总记录数
	private int totalRecords;
	//总页数
	private int totalPages;
	//数据本身
	private List<T> list;
	
	
	public Integer getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
	
	
}
