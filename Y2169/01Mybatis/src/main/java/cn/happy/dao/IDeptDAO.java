package cn.happy.dao;

import cn.happy.entity.Dept;

/**
 * @Author: 咖啡豆
 * @Date: 2018/11/8 14:31
 * @Description:
 */
public interface IDeptDAO {

    public Dept getDeptByEmp(int deptno);

    public Dept getDeptByEmpMultiSQL(int deptno);
}
