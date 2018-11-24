package com.zyx.test;

import com.github.pagehelper.PageHelper;
import com.zyx.dao.IProblemMapper;
import com.zyx.entity.Problem;
import com.zyx.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @Author: 咖啡豆
 * @Date: 2018/11/9 9:21
 * @Description:
 */
public class Test01 {

    @Test
    public void t1(){
        SqlSession sqlSession = MyBatisUtil.cerateSqlSession();
        IProblemMapper dao = sqlSession.getMapper(IProblemMapper.class);
        PageHelper.startPage(1,3);
        Problem p = new Problem();
        p.setTitle("Java");
        List<Problem> list = dao.findAllPage(p);
        for (Problem item:list) {
            System.out.println(item.getTitle());
        }

    }

}
