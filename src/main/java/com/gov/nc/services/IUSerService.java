package com.gov.nc.services;


import com.gov.nc.bean.UserEntity;
import org.springframework.stereotype.Component;

/**
 * Created by Vincent_2 on 2014/12/19.
 */
@Component
public interface IUSerService {

    /**
     * validate user's information
     * @param name user name
     * @param pwd user password
     */
    public int validUser(String name, String pwd);

    /**
     * add new  System User.
     * @param name user's name
     * @param pwd  user's pwd
     * @return
     */
    public boolean insertUser(String name, String pwd, String email);

    public UserEntity usrLogin(UserEntity user);
    public UserEntity qryById(int id);
}
