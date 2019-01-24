package com.kfd.service;

import com.kfd.model.RealEstate;

import java.util.List;

/**
 * @Author: 咖啡豆
 * @Date: 2018/12/14 10:36
 * @Description:
 */
public interface IRealEstateService {

    public List<RealEstate> findAll(int pageIdex,int pageSize);

}
