package cn.happy.day02jdbcTemplate;

import cn.spring.day20jdbcTemplate.model.Book;
import cn.spring.day20jdbcTemplate.service.IBookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Author: 咖啡豆
 * @Date: 2018/10/20 14:49
 * @Description:
 */
public class TestJDBCTemplate {

    @Test
    public void Test01(){
        //获取上下文
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-day019jdbcTemplate.xml");
        IBookService service = (IBookService) context.getBean("bookService");

        List<Book> list = service.findAllBooks();

        for (Book item:list) {
            System.out.print(item.getBookid());
            System.out.print(item.getBookName());
            System.out.print(item.getBookAuthor());
            System.out.println(item.getBookPrice());
        }


    }

}
