package cn.school.utils;

import java.util.List;

public class PageUtil<T> {
	
	//��ǰҳ��
	private Integer pageIndex;
	//ÿҳ��ʾ�ļ�¼��
	private int pageSize;
	//�ܼ�¼��
	private int totalRecords;
	//��ҳ��
	private int totalPages;
	//���ݱ���
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
