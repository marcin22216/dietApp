package com.marcin.java.dietApp.controller;

import com.marcin.java.dietApp.bean.User;
import com.marcin.java.dietApp.comonent.AnalysisBMI;
import com.marcin.java.dietApp.comonent.DataBase;
import com.marcin.java.dietApp.comonent.FindOnlineUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AnalysisBmiController {
    @Autowired
    private FindOnlineUser findOnlineUser;
    @Autowired
    private DataBase dataBase;
    @Autowired
    private AnalysisBMI analysisBMI;

    @GetMapping("/analysisBmi")
    public String analysisBMI(Model model)
    {
        User loggerUser = findOnlineUser.findUser(dataBase);
        analysisBMI.analyzingBmi(loggerUser);
        return "BMI/analyzedBmi";
    }

}
