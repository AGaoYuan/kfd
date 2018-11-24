package cn.spring.day21tx.model;

/**
 * @Author: 咖啡豆
 * @Date: 2018/10/26 10:13
 * @Description:
 */
public class Account {
    private Integer aid;
    private String aname;
    private Integer abalance; //账户余额


    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public Integer getAbalance() {
        return abalance;
    }

    public void setAbalance(Integer abalance) {
        this.abalance = abalance;
    }
}
