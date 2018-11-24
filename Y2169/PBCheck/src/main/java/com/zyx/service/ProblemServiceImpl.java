package com.zyx.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyx.dao.IProblemMapper;
import com.zyx.entity.Problem;
import com.zyx.util.MyBatisUtil;
import com.zyx.util.PageUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ProblemServiceImpl implements  IProblemService{

    IProblemMapper dao;

    public ProblemServiceImpl() {
        SqlSession  session = MyBatisUtil.cerateSqlSession();
        dao = session.getMapper(IProblemMapper.class);
    }

    @Override
    public List<Problem> listShow(Problem problem) throws Exception {
        return dao.listShow(problem);
    }

    @Override
    public List<Problem> findAllPage(Problem problem) {
        return dao.findAllPage(problem);
    }

    @Override
    public Integer getTotalRecordsCount(Problem problem) {
        return dao.getTotalRecordsCount(problem);
    }

    @Override
    public int addpro( Problem problem) throws Exception {
        return dao.addpro(problem);
    }
}
