package cn.happy.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 咖啡豆
 * @Date: 2018/11/8 16:47
 * @Description:
 */
public class Categorytwo implements Serializable{

    private Integer cid;
    private String cname;
    private Integer pid;

    private List<Categorytwo> cates = new ArrayList<Categorytwo>();

    @Override
    public String toString() {
        return "Categorytwo{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", pid=" + pid +
                ", cates=" + cates +"\n"
                +'}';
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}
