package cn.happy.dao;

import cn.happy.entity.Emp;

/**
 * @Author: 咖啡豆
 * @Date: 2018/11/8 14:31
 * @Description:
 */
public interface IEmpDAO {

    public Emp getEmpByNo(int empno);

    public Emp getEmpMultiSQL(int deptno);
}
