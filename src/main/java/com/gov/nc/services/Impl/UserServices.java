package com.gov.nc.services.Impl;

import com.gov.nc.bean.Account;
import com.gov.nc.dao.IUserDao;
import com.gov.nc.services.IUSerService;
import com.gov.nc.utils.StringUtil;
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

    @Autowired
    private IUserDao  iUserDao;

    /**
     * add a new user to database , in this step you should notice the fellows:<br>
     * 1.if property <code>emailAddress</code> is not blank, set value to <code>emailAddress</code> <br>
     * 2.if property <code>phoneNum</code> is not blank, set '1' to <code>bindPhone</code> and set value
     * to <code>phoneNum</code> as well; else set '0' to <code>bindPhone</code> <br>
     * 3. set value '0' to property <code>score</code> <br>
     * 4.set value 1 to property <code>level</code> <br>
     * @param account user need to be added.
     * @return operation result : <code>true</code> while success and <code>false</code> while failed.
     */
    @Override
    public void insertUser(Account account) {

        /* check the value of phone number ,and set default value : 0 for unbind, 1 for bind */
        if(StringUtil.isNotBlank(account.getPhoneNum())){
            account.setBindPhone(1);
        }else{
            account.setBindPhone(0);
        }
        /* set default value for new user
         * all the new users' account should be 0 score and level 1
         */
        account.setScore(0);
        account.setLevel(1);

        iUserDao.save(account) ;

    }

    @Override
    public Account userLogin(String account, String password) {

        return iUserDao.userLogin(account,password);
    }
}
