package com.scm.scm.controller;

import com.scm.scm.forms.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @GetMapping("/register")
    public String register(Model model){

        UserForm userForm =new UserForm();
        
        model.addAttribute("userForm",userForm);
        return "register";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }

    @RequestMapping(value = "/do-register",method = RequestMethod.POST)
    public String processRegister(){
        System.out.println("processing Registraction");

        return "redirect:/register";
    }


}
