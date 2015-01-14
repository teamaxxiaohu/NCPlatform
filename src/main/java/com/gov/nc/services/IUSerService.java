package com.gov.nc.services;


import com.gov.nc.bean.Account;
import org.springframework.stereotype.Component;

/**
 * Created by Vincent_2 on 2014/12/19.
 */
@Component
public interface IUSerService {


    /**
     * add new user
     * @param account new user object
     */
    public void insertUser(Account account);

    /**
     * do user login operate -- if login success , add 5 scores to user's account
     * @param account
     * @param password
     * @return
     */
    public Account userLogin(String account,String  password);
}
