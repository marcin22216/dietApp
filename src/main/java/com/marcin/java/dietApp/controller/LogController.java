package com.marcin.java.dietApp.controller;

import com.marcin.java.dietApp.bean.User;
import com.marcin.java.dietApp.comonent.CheckLoginLog;
import com.marcin.java.dietApp.comonent.CheckPasswordLog;
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
    @Autowired
    private CheckLoginLog checkLoginLog;
    @Autowired
    private CheckPasswordLog checkPasswordLog;

    @GetMapping("/login")
    public String login(Model model)
    {
        model.addAttribute("user", new User());
        return "login/loginPage";
    }
    @PostMapping("/signed")
    public String signed(User userToLog)
    {
        if (this.checkLoginLog.correctLog(dataBase, userToLog))
        {
            if (this.checkPasswordLog.correctPassword(dataBase, userToLog))
            {
                return "login/userMain";
            }
            else return "login/signErrorPass";
        }
        else return "login/signErrorLog";

    }

}
