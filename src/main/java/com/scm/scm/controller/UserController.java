package com.scm.scm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {
    ///userdashboard
    @RequestMapping(value = "/dashboard",method = RequestMethod.GET)
    public String userDashboard(){
        System.out.println("user Dashboard");
        return "user/dashboard";
    }

    //useradd

    // userview

    @RequestMapping(value = "/profile",method = RequestMethod.GET)
    public String userProfile(){
        System.out.println("User Profile Page");
        return "user/profile";
    }
    //useredit
    //userdelete
}
