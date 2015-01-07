package com.gov.nc.services.Impl;

import com.gov.nc.bean.UserEntity;
import com.gov.nc.dao.IUserDao;
import com.gov.nc.services.IUSerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Vincent_2 on 2014/12/19.
 */
@Transactional
@Service(value="UserServices")
public class UserServices implements IUSerService {

    @Autowired
    private IUserDao userDao;

    @Override
    public int validUser(String name ,String pwd) {

        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(name);
        userEntity.setUserPwd(pwd);
        return  userDao.validUser(userEntity);
    }

    @Override
    public boolean insertUser(String name, String pwd,String email) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(name);
        userEntity.setUserPwd(pwd);
        userEntity.setUserEmail(email);
        return userDao.insertUser(userEntity) >0;
    }

    @Override
    public UserEntity usrLogin(UserEntity user) {

        return userDao.userLogin(user);
    }

    @Override
    public UserEntity qryById(int id) {

        return userDao.qryById(id);
    }
}
