package com.gov.nc.services.Impl;

import com.gov.nc.bean.UserEntity;
import com.gov.nc.dao.IUserDao;
import com.gov.nc.services.IUSerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Vincent_2 on 2014/12/19.
 */
@Transactional
@Service(value="UserServices")
public class UserServices implements IUSerService {

    @Resource(name = "")
    private IUserDao userDao;

    @Override
    public int validUser(String name ,String pwd) {
        return 0 ;
    }

    @Override
    public boolean insertUser(String name, String pwd,String email) {
        return false;
    }

    @Override
    public UserEntity usrLogin(UserEntity user) {
        return null;
    }

    @Override
    public UserEntity qryById(int id) {
        return  null;
    }
}
