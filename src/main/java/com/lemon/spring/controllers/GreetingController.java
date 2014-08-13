/* 
 * Copyright (c) 2014 General Electric Company. All rights reserved. 
 * 
 * The copyright to the computer software herein is the property of 
 * General Electric Company. The software may be used and/or copied only 
 * with the written permission of General Electric Company or in accordance 
 * with the terms and conditions stipulated in the agreement/contract 
 * under which the software has been supplied. 
 */
package com.lemon.spring.controllers;

import com.lemon.spring.domain.User;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import java.util.HashMap;
import java.util.Map;

@Controller
public class GreetingController {

    @RequestMapping("/greeting/{userName}")
    @ResponseBody
    public String greeting(@PathVariable(value = "userName") String name) {
        return "Hello " + name;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public void login(Model model) {
        //默认也是当前路径.
        //也可以通过声明一个ServletResponse/HttpServletResponse的参数,来直接处理response.
        User user = new User();
        model.addAttribute(user);
    }
//    public String login(Model model) {
//        User user = new User();
//        model.addAttribute(user);
//        return "login_new";
//    }
//    public Map<String, User> login() {
//        User user = new User();
//        Map<String, User> map = new HashMap<String, User>();
//        map.put("user", user);
//        return map;
//    }
//    public Model login() {
//        User user = new User();
//        //返回类型是interface, ExtendedModelMap是实现Model接口的一个类.
//        //addAttribute往model中增加一个object.
//        //也可以不传key, 使用默认名字.
//        //不能定义view的名字,使用当前view(login)的名字.
//        return new ExtendedModelMap().addAttribute("user", user);
//    }
//    public ModelAndView login() {
//        User user = new User();
//        //构造函数可以指定view的名字,addObject往model中增加一个object.
//        return new ModelAndView("login_new").addObject(user);
//    }


//    @ModelAttribute
//    public User addUser() {
//        User user = new User();
//        user.setFirstName("li");
//        user.setLastName("meng");
//        return user;
//    }

    @RequestMapping("/test")
    public String test(User user, Model model) {
        model.addAttribute("name", user.getFirstName());
        return "greeting";
    }
}
