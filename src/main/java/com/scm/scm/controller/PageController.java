package com.scm.scm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("/home")
    public String home(Model model){
        System.out.println("Home Page handler");
        model.addAttribute("name", "Sameer Randive");
        model.addAttribute("github", "https://github.com/sammy171207");
        return "home";
    }

  ////about
    @RequestMapping("/about")
    public String aboutPage(){
        System.out.println("About page loading");
        return "about";
    }



    ///service
    @RequestMapping("/services")
    public String servicesPage(){
        System.out.println("service page loading");
        return "service";
    }

}
