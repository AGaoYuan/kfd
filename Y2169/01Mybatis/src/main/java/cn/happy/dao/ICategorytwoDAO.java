package cn.happy.dao;

import cn.happy.entity.Categorytwo;

import java.util.List;

/**
 * @Author: 咖啡豆
 * @Date: 2018/11/8 14:31
 * @Description:
 */
public interface ICategorytwoDAO {

    public List<Categorytwo> getCategorytwo(int pid);

    //02.根据cid检索该分类的所有父分类，包括父分类的父分类
    public List<Categorytwo> getCategoriesByCid(int cid) throws Exception;

}
