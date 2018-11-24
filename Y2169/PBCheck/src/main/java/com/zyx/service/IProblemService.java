package com.zyx.service;

import com.github.pagehelper.PageInfo;
import com.zyx.entity.Problem;
import com.zyx.util.PageUtil;

import java.util.List;

public interface IProblemService {

    /**
     * 查询
     * @return
     * @throws Exception
     */
    public List<Problem> listShow(Problem problem) throws  Exception;


    public List<Problem> findAllPage(Problem problem);

    //查询全部记录数
    public Integer getTotalRecordsCount(Problem problem);

    public  int addpro( Problem problem)throws  Exception;

}
