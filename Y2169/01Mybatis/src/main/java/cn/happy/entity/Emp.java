package cn.happy.entity;

import java.io.Serializable;

/**
 * @Author: 咖啡豆
 * @Date: 2018/11/8 14:23
 * @Description:
 */
public class Emp implements Serializable{

    private Integer empno;
    private String empname;
    private Integer deptno;

    private Dept dept;


    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }
}
