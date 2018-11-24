package cn.happy.test;

import cn.happy.dao.UserInfoMapper;
import cn.happy.entity.UserInfo;
import cn.happy.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class TestUserInfoMapper {

      //public Logger logger = Logger.getLogger(TestUserInfoMapper.class);
      Logger logger = LoggerFactory.getLogger(TestUserInfoMapper.class);
    private SqlSession sqlSession = null;
    @Test
    public void test() {
        List<UserInfo> list = null;
        sqlSession = null;
        try {
            //创建会话对象
            sqlSession = MyBatisUtil.getSqlSession();
            //调用mapper文件对数据进行操作
            //list = sqlSession.selectList("cn.happy.dao.userinfo.UserInfoMapper.getUserList");
            UserInfoMapper dao = sqlSession.getMapper(UserInfoMapper.class);
            //List<UserInfo> tempList = new ArrayList<UserInfo>();
            UserInfo userInfo = new UserInfo();
            userInfo.setUname("小黑");
            userInfo.setUpwd("123456");
            /*UserInfo u2 = new UserInfo();
            userInfo.setUid(8);
            u2.setUid(12);
            tempList.add(userInfo);
            tempList.add(u2);
            list = dao.FindListUserInfo(tempList);*/
            int i = dao.saveUser(userInfo);
            sqlSession.commit();
            System.out.println(i);
            /*for (UserInfo item : list) {
                //logger.debug(item.getUname());
                System.err.println("数据输出位置："+item.getUname());
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }

    }

    @Test
    public void t1(){
        sqlSession = MyBatisUtil.getSqlSession();
        //调用mapper文件对数据进行操作
        UserInfoMapper dao = sqlSession.getMapper(UserInfoMapper.class);
        List<UserInfo> templist = new ArrayList<UserInfo>();
        UserInfo u1 = new UserInfo();
        UserInfo u2 = new UserInfo();
        u1.setUid(8);
        u2.setUid(12);
        templist.add(u1);
        templist.add(u2);
        
        List<UserInfo> list = dao.FindListUserInfo(templist);
        for (UserInfo item:list) {
            System.out.println(item.getUname());
        }
    }


}
