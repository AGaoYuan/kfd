package com.kfd.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: 咖啡豆
 * @Date: 2018/12/14 9:36
 * @Description:
 */
@Data
public class Users {

    private String cardId;
    private String name;
    private int gender;
    private Date createTime;
    private String password;
    private int status;

    private List<RealEstate> list = new ArrayList<RealEstate>();

}
