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
    public String login(){
        return "login";
    }
//    public ModelAndView login() {
//        User user = new User();
//        user.setFirstName("li");
//        user.setLastName("meng");
//        return new ModelAndView("login").addObject(user);
//    }

    @ModelAttribute
    public User addUser(){
        User user = new User();
        user.setFirstName("li");
        user.setLastName("meng");
        return user;
    }

    @RequestMapping("/test")
    public String test(@ModelAttribute User user) {
        return user.getFirstName();
    }
}
