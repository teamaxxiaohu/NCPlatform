package com.gov.nc.service.test;

import com.gov.nc.bean.Account;
import com.gov.nc.dao.IUserDao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by Vincent_2 on 2015/1/13.
 */
public class TestUserSerivce {

    @Autowired
    private IUserDao  iUserDao;

    @Test
    public void testUserLogin(){
        System.out.println("iUserDao :"+iUserDao);
        Account account = iUserDao.findUserByNameAndPwd("xiaohu","xiaohu");
        System.out.println(account.getScore());
    }

    @Test
    public void testInsertUser(){
        Account account = new Account();
        account.setAccount("JUnit");
        account.setPassword("JUnit");
        account.setNickName("JUnit");
        iUserDao.save(account);
    }
}
