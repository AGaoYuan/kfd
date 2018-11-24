package com.zyx.dao;

import com.zyx.entity.Problem;

import java.util.List;

public interface IProblemMapper {

    /**
     * 查询
     * @return
     * @throws Exception
     */
    public List<Problem> listShow(Problem problem) throws  Exception;

    //统计总记录数
    public Integer getTotalRecordsCount(Problem problem);
    public List<Problem> findAllPage(Problem problem);



    public  int addpro(Problem problem)throws  Exception;

}
