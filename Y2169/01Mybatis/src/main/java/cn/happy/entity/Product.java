package cn.happy.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: 咖啡豆
 * @Date: 2018/11/1 12:04
 * @Description:
 */
public class Product {

    private Integer pro_id;
    private String pro_type;
    private BigDecimal pro_price;
    private Date pro_date;

    public Integer getPro_id() {
        return pro_id;
    }

    public void setPro_id(Integer pro_id) {
        this.pro_id = pro_id;
    }

    public String getPro_type() {
        return pro_type;
    }

    public void setPro_type(String pro_type) {
        this.pro_type = pro_type;
    }

    public BigDecimal getPro_price() {
        return pro_price;
    }

    public void setPro_price(BigDecimal pro_price) {
        this.pro_price = pro_price;
    }

    public Date getPro_date() {
        return pro_date;
    }

    public void setPro_date(Date pro_date) {
        this.pro_date = pro_date;
    }

}
