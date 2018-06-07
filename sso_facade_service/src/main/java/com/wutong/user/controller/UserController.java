package com.wutong.user.controller;

import com.alibaba.dubbo.common.json.JSON;
import com.alibaba.dubbo.config.annotation.Reference;
import com.wutong.api.user.UserService;
import com.wutong.user.modle.UserDTO;
import com.wutong.user.redis.RedisClient;
import com.wutong.user.response.LoginResponse;
import com.wutong.user.response.Response;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by zzg on 2018/6/2.
 */


@RestController("/user")
public class UserController {


    @Reference
    private UserService userService;
    @Autowired
    private RedisClient redisClient;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(ModelAndView modelAndView) throws Exception {
        modelAndView.setViewName("login");
        return  modelAndView;
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Response login(@RequestParam("username") String username,
                          @RequestParam("password") String password) {
        //1. 验证用户名密码
        UserDTO userInfo = null;
        try {
            userInfo = userService.getUserByName(username);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.USERNAME_PASSWORD_INVALID;
        }
        if (userInfo == null) {
            return Response.USERNAME_PASSWORD_INVALID;
        }
        if (!userInfo.getPassword().equalsIgnoreCase(password)) {
            return Response.USERNAME_PASSWORD_INVALID;
        }
        //2. 生成token
        String token = UUID.randomUUID().toString().replace("-", "");

        //3. 缓存用户
        redisClient.set(token, userInfo, 3600);

        return new LoginResponse(token);
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(ModelAndView modelAndView) throws Exception {
        return "register";
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView register(@RequestParam("username") String username,
                                 @RequestParam("password") String password,
                                 @RequestParam("realName") String realName,
                                 @RequestParam(value = "mobile", required = false) String mobile,
                                 @RequestParam(value = "email", required = false) String email, ModelAndView modelAndView) {
        modelAndView.setViewName("register");
        modelAndView.addObject("password", password);
        modelAndView.addObject("username", username);
        modelAndView.addObject("realName", realName);
        modelAndView.addObject("mobile", mobile);
        modelAndView.addObject("email", email);
        if (StringUtils.isBlank(mobile) && StringUtils.isBlank(email)) {
            modelAndView.addObject("msg", "邮箱与电话不能为空");
            return modelAndView;
        }

        if (StringUtils.isBlank(username) && StringUtils.isBlank(password)) {
            modelAndView.addObject("msg", "用户名与密码不能为空");
            return modelAndView;
        }

        UserDTO userInfo = new UserDTO();
        userInfo.setUsername(username);
        userInfo.setPassword(password);
        userInfo.setMobile(mobile);
        userInfo.setEmail(email);
        userInfo.setRealName(realName);

        try {
            userService.regiserUser(userInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return modelAndView;
        }
        modelAndView.addObject("msg", "成功注册");
        return modelAndView;
    }

}
