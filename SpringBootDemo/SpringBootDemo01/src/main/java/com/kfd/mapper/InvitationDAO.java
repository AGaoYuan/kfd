package com.kfd.mapper;

import com.kfd.model.Invitation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: 咖啡豆
 * @Date: 2018/12/28 9:44
 * @Description:
 */
@Repository
public interface InvitationDAO {

    public List<Invitation> userList(@Param("title") String title);

}
