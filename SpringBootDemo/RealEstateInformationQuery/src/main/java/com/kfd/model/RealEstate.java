package com.kfd.model;

import lombok.Data;

import java.util.Date;

/**
 * @Author: 咖啡豆
 * @Date: 2018/12/14 9:34
 * @Description:
 */
@Data
public class RealEstate {

    private int id;
    private String cardId;
    private String projectName;
    private String address;
    private String houseType;
    private int area;
    private Date buildTime;
    private String name;


}
