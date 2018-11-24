package cn.spring.day21tx.model;

/**
 * @Author: 咖啡豆
 * @Date: 2018/10/26 10:14
 * @Description:
 */
public class Stock {
    private Integer sid;
    private String sname;
    private Integer scount;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getScount() {
        return scount;
    }

    public void setScount(Integer scount) {
        this.scount = scount;
    }
}
