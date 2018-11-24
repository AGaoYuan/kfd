package cn.kfd.test;


import cn.kfd.model.SmbmsUser;
import cn.kfd.service.IUserService;
import cn.kfd.service.impl.UserServiceImpl;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @Author: 咖啡豆
 * @Date: 2018/11/1 9:09
 * @Description:
 */
public class TestSmbms {

    private Logger logger = LoggerFactory.getLogger(TestSmbms.class);

    @Test
    public void t1(){
        IUserService service = new UserServiceImpl();
        /*SmbmsUser user = new SmbmsUser();
        user.setUserCode("admin");
        user.setUserPassword("1234567");*/
        List<SmbmsUser> list = service.findLikeUser("系统");
        for (SmbmsUser item:list) {
            System.out.println(item.getUserName());
        }

    }


}
