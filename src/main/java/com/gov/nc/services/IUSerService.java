package com.gov.nc.services;


import com.gov.nc.bean.Account;
import org.springframework.stereotype.Component;

/**
 * Created by Vincent_2 on 2014/12/19.
 */
@Component
public interface IUSerService {


    public void insertUser(Account account);

    public Account userLogin(String account,String  password);
}
