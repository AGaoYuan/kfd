package cn.book.service;

import cn.book.model.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: 咖啡豆
 * @Date: 2018/11/21 16:08
 * @Description:
 */
public interface IBookService {

    //查询全部图书
    public List<Book> getBookAndCategoryList(@Param("bookname") String bookname, @Param("catename") String catename);

}
