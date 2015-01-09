package com.gov.nc.dao;

import com.gov.nc.bean.UserEntity;
import org.springframework.stereotype.Component;

/**
 * Created by Vincent_2 on 2014/12/19.
 */

public interface IUserDao {

    /**
     * Valid the given information is a rightful account or not.
     * @param usr
     * @return
     */
    public int validUser(UserEntity usr);

    /**
     * add a new user record
     * @param usr user object
     * @return operate result
     */
    public int insertUser(UserEntity usr);


    public UserEntity userLogin(UserEntity usr);

    public UserEntity qryById(int id);

}
