package cn.spring.day20jdbcTemplate.model;

/**
 * @Author: 咖啡豆
 * @Date: 2018/10/20 14:00
 * @Description:
 */
public class Book {

    private Integer bookid;
    private String bookName;
    private String bookAuthor;
    private Integer bookPrice;



    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public Integer getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Integer bookPrice) {
        this.bookPrice = bookPrice;
    }
}
