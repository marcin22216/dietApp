package com.marcin.java.dietApp.controller;

import com.marcin.java.dietApp.bean.User;
import com.marcin.java.dietApp.comonent.DataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignedController {
    @Autowired
    private DataBase dataBase;

    @GetMapping("/addUserData")
    public String addUserData(Model model)
    {
        model.addAttribute("userD", new User());
        return "personalData/addPersonal";
    }

    @PostMapping("/adding")
    public String adding(User userPersonal)
    {
        for (int i=0; i<=dataBase.getUserList().size(); i++)
        {
            if (dataBase.getUserList().get(i).isLogged() == true)
            {

            }
        }
        return "personalData/confirmAdd";
    }
}
