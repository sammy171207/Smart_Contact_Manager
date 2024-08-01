package com.scm.scm.controller;

import com.scm.scm.forms.UserForm;
import com.scm.scm.helper.Message;
import com.scm.scm.helper.MessageType;
import com.scm.scm.model.User;
import com.scm.scm.services.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {


    @Autowired
    private UserService userService;

    @RequestMapping("/home")
    public String home(Model model){
        System.out.println("Home Page handler");
        model.addAttribute("name", "Sameer Randive");
        model.addAttribute("github", "https://github.com/sammy171207");
        return "home";
    }

    @RequestMapping("/about")
    public String aboutPage(){
        System.out.println("About page loading");
        return "about";
    }

    @RequestMapping("/services")
    public String servicesPage(){
        System.out.println("Service page loading");
        return "service";
    }
    @GetMapping("/")
    public String index(){
        System.out.println("Back to Home");
        return "redirect:home";
    }

    @GetMapping("/register")
    public String register(Model model){
        UserForm userForm = new UserForm();
        userForm.setUsername("sameer");
        model.addAttribute("userForm", userForm);
        return "register";
    }

    @RequestMapping(value = "/do-register", method = RequestMethod.POST)
    public String processRegister(@Valid @ModelAttribute UserForm userForm, BindingResult rBindingResult, HttpSession session) throws Exception {
        System.out.println("Processing registration for user: " + userForm);
        // Additional logic for registration can be added here
//        User user=User.builder()
//                .name(userForm.getUsername())
//                .email(userForm.getEmail())
//                .password(userForm.getPassword())
//                .phoneNumber(userForm.getContactNumber())
//                .about(userForm.getAbout())
//                .profilePic("https://images.pexels.com/photos/27355293/pexels-photo-27355293/free-photo-of-portrait-of-an-african-man-wearing-cap.jpeg?auto=compress&cs=tinysrgb&w=600")
//                .build();
        User user =new User();
        user.setName(userForm.getUsername());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getContactNumber());
        user.setProfilePic("https://images.pexels.com/photos/24742511/pexels-photo-24742511/free-photo-of-portrait-of-woman-wearing-silver-armor.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
       User saved=  userService.saveUser(user);
        System.out.println(saved);
//        Message message = Message.builder().content("Registration Successful").type(MessageType.green).build();
//
//        session.setAttribute("message", message);
  if(rBindingResult.hasErrors()){
      return "register";
  }
        // Redirect to a success page or back to the registration form if needed
        return "redirect:/register";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }
}
