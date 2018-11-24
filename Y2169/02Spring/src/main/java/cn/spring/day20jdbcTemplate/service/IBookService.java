package cn.spring.day20jdbcTemplate.service;

import cn.spring.day20jdbcTemplate.model.Book;

import java.util.List;

/**
 * @Author: 咖啡豆
 * @Date: 2018/10/20 14:24
 * @Description:
 */
public interface IBookService {

    //查询全部图书
    public List<Book> findAllBooks();

}
