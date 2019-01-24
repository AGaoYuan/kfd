package com.kfd.dao;

import com.kfd.model.RealEstate;
import com.kfd.model.Users;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: 咖啡豆
 * @Date: 2018/12/14 9:40
 * @Description:
 */
@Repository
public interface IRealEstateDAO {

    @Select("select * from real_estate")
    public List<RealEstate> findAll();


}
