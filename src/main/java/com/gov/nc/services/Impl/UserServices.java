package com.gov.nc.services.Impl;

import com.gov.nc.bean.Account;
import com.gov.nc.dao.IUserDao;
import com.gov.nc.services.IUSerService;
import com.gov.nc.utils.CommonStatics;
import com.gov.nc.utils.StringUtil;
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

       Account loginUser =  iUserDao.findUserByNameAndPwd(account, password);

        /* add 5 score for current user and judge whether the level should be modify or not.*/
        if(loginUser != null){
            int currentScore = loginUser.getScore() + 5 ;
            loginUser.setScore(currentScore);
            loginUser.setLevel(modifyLevelByScore(currentScore));
        }

        iUserDao.userLogin(loginUser);

        return loginUser;
    }

    private int modifyLevelByScore(int score){

        int level ;
        if(isInBound(score,0, 50)){
            level = CommonStatics.DEFAULT_LEVEL;
        }else if(isInBound(score,50,100)){
            level = CommonStatics.LEVEL_TWO ;
        }else if(isInBound(score, 100, 200)){
            level = CommonStatics.LEVEL_THREE ;
        }else if(isInBound(score, 200, 500)){
            level = CommonStatics.LEVEL_FOUR ;
        }else {
            level = CommonStatics.TOP_LEVEL ;
        }

        return level;
    }

    /**
     * judge the given score is in bound or not ,some like 5 is between 0 and 50 .
     * @param score current score
     * @param minBound min bound value
     * @param maxBound max bound value
     * @return <code>true</code> -- in the bound ,<code>false</code> otherwise.
     */
    private boolean isInBound(int score,int minBound ,int maxBound){
        return score > minBound && score <= maxBound ;
    }
}
