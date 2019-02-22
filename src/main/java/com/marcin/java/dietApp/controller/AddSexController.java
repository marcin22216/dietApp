package com.marcin.java.dietApp.controller;

import com.marcin.java.dietApp.bean.User;
import com.marcin.java.dietApp.comonent.DataBase;
import com.marcin.java.dietApp.comonent.FindOnlineUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddSexController {

    @Autowired
    private FindOnlineUser findOnlineUser;
    @Autowired
    private DataBase dataBase;

    @GetMapping("/addSex")
    public String addSex(Model model)
    {
        model.addAttribute("userS", new User());
        return "personalData/sexAdding";
    }

    @PostMapping("/sexAdding")
    public String sexAdding(Model model, User userSex)
    {
        User loggedUser = findOnlineUser.findUser(dataBase);

        loggedUser.setSex(userSex.getSex());

        String sex = userSex.getSex();
        model.addAttribute("sex", sex);
        return "personalData/confirmAdd";
    }


}
