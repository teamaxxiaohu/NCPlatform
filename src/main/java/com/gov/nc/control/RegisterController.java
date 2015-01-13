package com.gov.nc.control;

import com.gov.nc.bean.Account;
import com.gov.nc.services.IUSerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * Created by Vincent_2 on 2014/12/16.
 */
@Controller
@RequestMapping("/register")
public class RegisterController {

    @Resource(name = "UserServices")
    private IUSerService userService;

    @RequestMapping(method = RequestMethod.GET)
    public  String userReg(){
        return "register";
    }


    /**
     * add a new user
     * @param account  user object
     * @param modelMap
     * @return index page if register success
     */
    @RequestMapping(value="/doRegister",method = RequestMethod.POST )
    public String doRegister( Account account,ModelMap modelMap){

        userService.insertUser(account);
        modelMap.addAttribute("username",account.getAccount());
        return "index";
    }
}


