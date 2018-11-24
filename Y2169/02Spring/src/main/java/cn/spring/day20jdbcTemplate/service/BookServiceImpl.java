package cn.spring.day20jdbcTemplate.service;

import cn.spring.day20jdbcTemplate.dao.BookDAOImpl;
import cn.spring.day20jdbcTemplate.dao.IBookDAO;
import cn.spring.day20jdbcTemplate.model.Book;

import java.util.List;

/**
 * @Author: 咖啡豆
 * @Date: 2018/10/20 14:25
 * @Description:
 */
public class BookServiceImpl implements IBookService{

    IBookDAO dao = new BookDAOImpl();

    @Override
    public List<Book> findAllBooks() {
        return dao.findAllBooks();
    }





    public IBookDAO getDao() {
        return dao;
    }

    public void setDao(IBookDAO dao) {
        this.dao = dao;
    }
}
