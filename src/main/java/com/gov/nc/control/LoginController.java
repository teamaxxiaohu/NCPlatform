package com.gov.nc.control;

import com.gov.nc.bean.UserEntity;
import com.gov.nc.services.IUSerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * Created by Vincent_2 on 2014/12/24.
 */

@Controller
public class LoginController {

    @Resource( name = "UserServices")
    private IUSerService iuSerService;

    @RequestMapping( value = "/doLogin" ,method = RequestMethod.POST)
    public String loginIn(UserEntity user ,Model model){
       UserEntity loginUser =  iuSerService.usrLogin(user);
        if (loginUser != null){
            model.addAttribute("loginUser",loginUser);
            return "success";
        } else{
            model.addAttribute("failMsg","The user is not exists !");
            return "failure";
        }

    }
}
