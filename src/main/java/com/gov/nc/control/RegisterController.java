package com.gov.nc.control;

import com.gov.nc.bean.UserEntity;
import com.gov.nc.services.IUSerService;
import com.gov.nc.utils.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
     * Valid user's input information.
     * @param userEntity  user entity
     * @return page info.
     */
    @RequestMapping(value="/doRegister",method = RequestMethod.POST )
    public String doRegister( UserEntity userEntity,ModelMap modelMap){

        if(StringUtil.isNotBlank(userEntity.getUserName()) && StringUtil.isNotBlank(userEntity.getUserPwd())){
          if (userService.insertUser(userEntity.getUserName(),userEntity.getUserPwd(),userEntity.getUserEmail()));
            modelMap.put("user","Register success!!!");
            return "success";
        }
        return "";
    }

    @RequestMapping(value = "/test/{id}")
    @ResponseBody
    public  UserEntity  getRESTfulInfo(@PathVariable(value = "id") Integer uid){
            return  userService.qryById(uid);
    }
}


