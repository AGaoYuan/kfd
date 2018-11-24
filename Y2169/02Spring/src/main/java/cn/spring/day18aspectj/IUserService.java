package cn.spring.day18aspectj;

/**
 * @Author: 咖啡豆
 * @Date: 2018/10/18 16:16
 * @Description:
 */
public interface IUserService {

    public void save();
    public void update();
    public void delete();
    public String select(String sql);

}
