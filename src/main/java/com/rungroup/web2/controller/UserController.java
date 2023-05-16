package com.rungroup.web2.controller;

import com.rungroup.web2.model.User;
import com.rungroup.web2.service.Impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/signup")
    public String signup(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "signup";
    }

    @PostMapping("/signup")
    public String signupSave(User user){
        userService.saveUser(user);
       // return "redirect:/login";

        return "login";

    }

    @GetMapping("/login")
    public String login(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "login";
    }

    @PostMapping("/login")
    public String loginCheck(@ModelAttribute("user") User user){
       String results = userService.logConfirmation(user.getEmail(),user.getPassword());

        return results;
    }




}
