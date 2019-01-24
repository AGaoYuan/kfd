package com.kfd.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kfd.dao.IRealEstateDAO;
import com.kfd.model.RealEstate;
import com.kfd.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * @Author: 咖啡豆
 * @Date: 2018/12/14 10:36
 * @Description:
 */
@Service
public class RealEstateServiceImpl implements IRealEstateService {

    @Autowired
    private IRealEstateDAO dao;

    @Override
    public List<RealEstate> findAll(int pageIdex,int pageSize) {
        PageHelper.startPage(pageIdex, pageSize);
        return dao.findAll();
    }

}
