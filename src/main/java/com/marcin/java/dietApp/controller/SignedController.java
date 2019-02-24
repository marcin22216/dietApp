package com.marcin.java.dietApp.controller;

import com.marcin.java.dietApp.bean.User;
import com.marcin.java.dietApp.comonent.*;
import com.sun.beans.finder.FieldFinder;
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
    @Autowired
    private AddName addName;
    @Autowired
    private AddSurname addSurname;
    @Autowired
    private LogOut logOut;
    @Autowired
    private FindOnlineUser findOnlineUser;

    @GetMapping("/addUserData")
    public String addUserData(Model model)
    {
        model.addAttribute("userD", new User());
        return "personalData/addPersonal";
    }

    @PostMapping("/adding")
    public String adding(Model model, User userPersonal)
    {
        User loggedUser = findOnlineUser.findUser(dataBase);
        loggedUser.setName(userPersonal.getName());
        loggedUser.setSurname(userPersonal.getSurname());

        findOnlineUser.findUser(dataBase);
            String name = loggedUser.getName();
            model.addAttribute("name", name);
            String surname = loggedUser.getSurname();
            model.addAttribute("surname", surname);
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
        logOut.logout(dataBase);
        return "/index";
    }

}
