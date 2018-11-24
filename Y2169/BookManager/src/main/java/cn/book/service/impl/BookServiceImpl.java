package cn.book.service.impl;

import cn.book.dao.IBookDAO;
import cn.book.model.Book;
import cn.book.service.IBookService;
import cn.book.utils.MyBatisUtil;

import java.util.List;

/**
 * @Author: 咖啡豆
 * @Date: 2018/11/21 16:08
 * @Description:
 */
public class BookServiceImpl implements IBookService{

    private IBookDAO dao = MyBatisUtil.getSqlSession().getMapper(IBookDAO.class);

    @Override
    public List<Book> getBookAndCategoryList(String bookname, String catename) {
        return dao.getBookAndCategoryList(bookname,catename);
    }
}
