package cn.book.dao;

import cn.book.model.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: 咖啡豆
 * @Date: 2018/11/21 16:06
 * @Description:
 */
public interface IBookDAO {

    public List<Book> getBookAndCategoryList(@Param("bookname") String bookname,@Param("catename") String catename);



}
