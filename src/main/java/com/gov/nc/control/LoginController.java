package com.gov.nc.control;

import com.gov.nc.bean.Account;
import com.gov.nc.services.IUSerService;
import com.gov.nc.utils.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by Vincent_2 on 2014/12/24.
 */

@Controller
public class LoginController {

    @Resource( name = "UserServices")
    private IUSerService iuSerService;

    @RequestMapping(value = "/doLogin",method = RequestMethod.POST)
    public String usrLogin(String account ,  String password){

        if(StringUtil.isNotBlank(account) && StringUtil.isNotBlank(password)){
           iuSerService.userLogin(account, password);
        }

        return "index";
    }

}
