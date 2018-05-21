package cn.bdqn.Chapter02;

import java.io.Serializable;

public class Book implements Serializable{

	private String BookName;
	private int Price;
	
	public Book(){}
	
	public Book(String bookName, int price) {
		BookName = bookName;
		Price = price;
	}
	
	
	public String getBookName() {
		return BookName;
	}
	public void setBookName(String bookName) {
		BookName = bookName;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}

	
	
	
}
