package com.kfd.service;

import com.kfd.mapper.InvitationDAO;
import com.kfd.model.Invitation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 咖啡豆
 * @Date: 2018/12/28 9:51
 * @Description:
 */
@Service
public class InvitationService {

    @Autowired
    private InvitationDAO dao;

    public List<Invitation> userList(String title){
        return dao.userList(title);
    }


}
