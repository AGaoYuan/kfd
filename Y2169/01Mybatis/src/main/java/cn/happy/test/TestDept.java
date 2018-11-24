package cn.happy.test;

import cn.happy.dao.ICategorytwoDAO;
import cn.happy.dao.IDeptDAO;
import cn.happy.dao.IEmpDAO;
import cn.happy.dao.IStudentDAO;
import cn.happy.entity.Categorytwo;
import cn.happy.entity.Dept;
import cn.happy.entity.Emp;
import cn.happy.entity.Student;
import cn.happy.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @Author: 咖啡豆
 * @Date: 2018/11/8 14:32
 * @Description:
 */
public class TestDept {

    /**
     * 一对多 单挑SQL
     */
    @Test
    public void t1(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        IDeptDAO dao = sqlSession.getMapper(IDeptDAO.class);
        Dept deptByEmp = dao.getDeptByEmp(1);
        System.out.println(deptByEmp.getDeptname());
        for (Emp item:deptByEmp.getList()) {
            System.out.println(item.getEmpname());
        }
        //MyBatisUtil.closeSqlSession(sqlSession);
        System.out.println("----------------");
        SqlSession Session = MyBatisUtil.getSqlSession();
        IDeptDAO mapper = Session.getMapper(IDeptDAO.class);
        Dept deptByEmp1 = mapper.getDeptByEmp(1);
        for (Emp item:deptByEmp1.getList()) {
            System.out.println(item.getEmpname());
        }
        MyBatisUtil.closeSqlSession(sqlSession);
    }

    /**
     * 一对多  多条SQL
     */
    @Test
    public void t2(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        IDeptDAO dao = sqlSession.getMapper(IDeptDAO.class);
        Dept deptByEmp = dao.getDeptByEmpMultiSQL(1);
        System.out.println(deptByEmp.getDeptname());
        for (Emp item:deptByEmp.getList()) {
            System.out.println(item.getEmpname());
        }
    }

    /**
     * 多对一  单挑SQL
     */
    @Test
    public void t3(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        IEmpDAO dao = sqlSession.getMapper(IEmpDAO.class);
        Emp deptByEmp = dao.getEmpByNo(1);
        System.out.println(deptByEmp.getEmpname());
        System.out.println(deptByEmp.getDept().getDeptname());
    }

    /**
     * 多对一  多条SQL的方案
     */
    @Test
    public void t4(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        IEmpDAO dao = sqlSession.getMapper(IEmpDAO.class);
        Emp deptByEmp = dao.getEmpMultiSQL(3);
        System.out.println(deptByEmp.getEmpname());
        //System.out.println(deptByEmp.getDept().getDeptname());
    }

    /**
     * 自关联    递归
     */
    @Test
    public void t5(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        ICategorytwoDAO dao = sqlSession.getMapper(ICategorytwoDAO.class);
        List<Categorytwo> categorytwo = dao.getCategorytwo(1);
        System.out.println(categorytwo);
    }

    /**
     * 自关联    递归  Two
     */
    @Test
    public void t6() throws Exception {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        ICategorytwoDAO dao = sqlSession.getMapper(ICategorytwoDAO.class);
        List<Categorytwo> categorytwo = dao.getCategoriesByCid(4);
        System.out.println(categorytwo);

    }


    /**
     * 多对多   学生  AND 老师
     */
    @Test
    public void t7() throws Exception {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        IStudentDAO dao = sqlSession.getMapper(IStudentDAO.class);
        List<Student> list = dao.getStudentByPid(2);
        for (Student item:list) {
            System.out.println(item.getSname());
        }

    }




}
