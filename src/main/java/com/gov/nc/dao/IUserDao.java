package com.gov.nc.dao;

/**
 * @Author: Vincent_2
 * 2014/12/19.
 * @version 1.0
 */

import com.gov.nc.bean.Account;

/**
 * This interface contains several methods to manage account info.
 * it's not only contains commonly method like CURD, but find by condition(s) as well.
 * you can even use those methods to update account status . such as  bind phone number , update card number etc.
 */
public interface IUserDao{

    /**
     * add a new user, the parameter should contains some required properties.
     * such as account password  and nickname.
     * @param account user info.
     */
    void save(Account account);

    /**
     * default delete method , delete by user id.
     * @param account user need to be deleted.
     */
    void delete(Account account);

    void deleteByName(String name);




}
