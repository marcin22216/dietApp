package com.marcin.java.dietApp.controller;

import com.marcin.java.dietApp.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.jws.soap.SOAPBinding;

@Controller
public class RegistrationController {

    @GetMapping("/registration")
    public String registration(Model model)
    {
        model.addAttribute("user", new User());

        return "registration/registerPage";
    }

    @PostMapping("/register")
    public String register(User userToRegister)
    {

        return "index";
    }

}
