package cn.spring.day20jdbcTemplate.dao;

import cn.spring.day20jdbcTemplate.model.Book;

import java.util.List;

/**
 * @Author: 咖啡豆
 * @Date: 2018/10/20 14:05
 * @Description:
 */
public interface IBookDAO {

    //查询全部图书
    public List<Book> findAllBooks();






}
