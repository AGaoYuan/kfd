package cn.book.model;

import java.util.Date;

/**
 * @Author: 咖啡豆
 * @Date: 2018/11/21 16:01
 * @Description:
 */
public class Book {

    private Integer bookid;
    private String bookname;
    private Integer bookcategory;
    private Double bookprice;
    private String bookauthor;
    private String bookabout;
    private Date bookdatetime;
    private String bookpicture;


    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public Integer getBookcategory() {
        return bookcategory;
    }

    public void setBookcategory(Integer bookcategory) {
        this.bookcategory = bookcategory;
    }

    public Double getBookprice() {
        return bookprice;
    }

    public void setBookprice(Double bookprice) {
        this.bookprice = bookprice;
    }

    public String getBookauthor() {
        return bookauthor;
    }

    public void setBookauthor(String bookauthor) {
        this.bookauthor = bookauthor;
    }

    public String getBookabout() {
        return bookabout;
    }

    public void setBookabout(String bookabout) {
        this.bookabout = bookabout;
    }

    public Date getBookdatetime() {
        return bookdatetime;
    }

    public void setBookdatetime(Date bookdatetime) {
        this.bookdatetime = bookdatetime;
    }

    public String getBookpicture() {
        return bookpicture;
    }

    public void setBookpicture(String bookpicture) {
        this.bookpicture = bookpicture;
    }


}
