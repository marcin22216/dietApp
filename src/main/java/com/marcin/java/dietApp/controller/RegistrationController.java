package com.marcin.java.dietApp.controller;

import com.marcin.java.dietApp.bean.User;
import com.marcin.java.dietApp.comonent.DataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    @Autowired
    private DataBase dataBase;

    @GetMapping("/registration")
    public String registration(Model model)
    {
        model.addAttribute("user", new User());

        return "registration/registerPage";
    }

    @PostMapping("/register")
    public String register(User userToRegister)
    {
        if (userToRegister.getLogin().length()<4)
        {
            return "registration/loginError";
        }
        else
            this.dataBase.getUserList().add(userToRegister);
        return "index";
    }

}
