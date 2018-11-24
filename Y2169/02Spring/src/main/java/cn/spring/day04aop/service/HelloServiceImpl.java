package cn.spring.day04aop.service;

import cn.spring.day04aop.dao.IHelloDAO;

public class HelloServiceImpl implements IHelloService {

    IHelloDAO dao;

    public void doSome() {
        dao.doSome();
    }


    public IHelloDAO getDao() {
        return dao;
    }

    public void setDao(IHelloDAO dao) {
        this.dao = dao;
    }



}
