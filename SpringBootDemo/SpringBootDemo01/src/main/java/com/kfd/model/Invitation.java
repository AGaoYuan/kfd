package com.kfd.model;

import lombok.Data;

import java.util.Date;

/**
 * @Author: 咖啡豆
 * @Date: 2018/12/28 9:42
 * @Description:
 */
@Data
public class Invitation {

    private Integer id;
    private String title;
    private String summary;
    private String author;
    private String createdate;

}
