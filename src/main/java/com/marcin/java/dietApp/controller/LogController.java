package com.marcin.java.dietApp.controller;

import com.marcin.java.dietApp.bean.User;
import com.marcin.java.dietApp.comonent.DataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LogController {

    @Autowired
    private DataBase dataBase;

    @GetMapping("/login")
    public String login(Model model)
    {
        model.addAttribute("user", new User());
        return "login/loginPage";
    }
    @PostMapping("/signed")
    public String signed(User userToLog)
    {
        for (int i=0; i <= dataBase.getUserList().size(); i++)
        {
            if (dataBase.getUserList().get(i).getLogin().equals(userToLog.getLogin()))
            {
                for (int j=0; i<= dataBase.getUserList().size(); j++)
                {
                    if (dataBase.getUserList().get(j).getPassword().equals(userToLog.getPassword()))
                    {
                        return "login/userMain";
                    }
                    else
                        return "login/signErrorPass";
                }
            }
            else
            {
                return "login/signErrorLog";
            }
        }
        return "login/loginPage";
    }

}
