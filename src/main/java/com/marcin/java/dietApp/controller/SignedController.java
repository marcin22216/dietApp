package com.marcin.java.dietApp.controller;

import com.marcin.java.dietApp.bean.User;
import com.marcin.java.dietApp.comonent.DataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public String adding(Model model, @ModelAttribute(name = "name") User userPersonal)
    {
        for (int i=0; i<dataBase.getUserList().size(); i++)
        {
            if (dataBase.getUserList().get(i).isLogged())
            {
                dataBase.getUserList().get(i).setName(userPersonal.getName());
                dataBase.getUserList().get(i).setSurname(userPersonal.getSurname());
            }
        }
        for (int i=0; i<dataBase.getUserList().size(); i++)
        {
            String name = dataBase.getUserList().get(i).getName();
            model.addAttribute("name", name);
            String surname = dataBase.getUserList().get(i).getSurname();
            model.addAttribute("surname", surname);
        }
        return "personalData/confirmAdd";
    }

    @GetMapping("/signed")
    public String dupa()
    {
        return "login/userMain";
    }

    @GetMapping("/logout")
    public String logout()
    {
        for (int i=0; i<dataBase.getUserList().size(); i++)
        {
            if (dataBase.getUserList().get(i).isLogged())
            {
                dataBase.getUserList().get(i).setLogged(false);
            }
        }
        return "/index";
    }
}
