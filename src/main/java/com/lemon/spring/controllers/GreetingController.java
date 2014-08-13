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
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetingController {

    @RequestMapping("/greeting/{userName}")
    public String greeting(@PathVariable(value = "userName") String name) {
        return name;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public Model login() {
        User user = new User();
        //返回类型是interface, ExtendedModelMap是实现Model接口的一个类.
        //addAttribute往model中增加一个object.
        //也可以不传key, 使用默认名字.
        //不能定义view的名字,使用当前view(login)的名字.
        return new ExtendedModelMap().addAttribute("user", user);
    }
//    public ModelAndView login() {
//        User user = new User();
//        //构造函数可以指定view的名字,addObject往model中增加一个object.
//        return new ModelAndView("login_new").addObject(user);
//    }
//    public String login() {
//        return "login";
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
