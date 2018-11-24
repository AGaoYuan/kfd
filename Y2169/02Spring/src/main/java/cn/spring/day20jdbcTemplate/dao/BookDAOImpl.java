package cn.spring.day20jdbcTemplate.dao;

import cn.spring.day20jdbcTemplate.model.Book;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author: 咖啡豆
 * @Date: 2018/10/20 14:09
 * @Description:
 */
public class BookDAOImpl extends JdbcDaoSupport implements IBookDAO {

    @Override
    public List<Book> findAllBooks() {
        String sql = "select * from book";

        List<Book> list = this.getJdbcTemplate().query(sql, new RowMapper<Book>() {
            /**
             *
             * @param resultSet 读取器
             * @param i 索引
             * @return
             * @throws SQLException
             */
            @Override
            public Book mapRow(ResultSet resultSet, int i) throws SQLException {
                Book book = new Book();
                book.setBookid(resultSet.getInt("bookid"));
                book.setBookName(resultSet.getString("bookname"));
                book.setBookAuthor(resultSet.getString("bookpublisher"));
                book.setBookPrice(resultSet.getInt("bookprice"));
                return book;
            }
        });
        return list;
    }

}
