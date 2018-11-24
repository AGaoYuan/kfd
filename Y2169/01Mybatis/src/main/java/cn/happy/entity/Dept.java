package cn.happy.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 咖啡豆
 * @Date: 2018/11/8 14:24
 * @Description:
 */
public class Dept implements Serializable{

    private Integer deptno;
    private String deptname;
    private List<Emp> list = new ArrayList<Emp>();

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public List<Emp> getList() {
        return list;
    }

    public void setList(List<Emp> list) {
        this.list = list;
    }
}
