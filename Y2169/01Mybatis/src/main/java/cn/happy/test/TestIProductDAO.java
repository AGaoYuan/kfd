package cn.happy.test;

import cn.happy.dao.IProductDAO;
import cn.happy.entity.Product;
import cn.happy.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @Author: 咖啡豆
 * @Date: 2018/11/1 12:08
 * @Description:
 */
public class TestIProductDAO {

    @Test
    public void test() {
        List<Product> list = null;
        SqlSession sqlSession = null;
        try {
            //创建会话对象
            sqlSession = MyBatisUtil.getSqlSession();
            //调用mapper文件对数据进行操作
            IProductDAO dao = sqlSession.getMapper(IProductDAO.class);
            list= dao.getProduct();

            for (Product item:list) {
                System.out.println("设备型号："+item.getPro_id()+"出厂价格："+item.getPro_price()+"出厂日期："+item.getPro_date());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }

    }



}
