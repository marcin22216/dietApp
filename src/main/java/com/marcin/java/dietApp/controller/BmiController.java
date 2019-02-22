package com.marcin.java.dietApp.controller;

import com.marcin.java.dietApp.bean.User;
import com.marcin.java.dietApp.comonent.Calculator;
import com.marcin.java.dietApp.comonent.DataBase;
import com.marcin.java.dietApp.comonent.FindOnlineUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BmiController {
    @Autowired
    private DataBase dataBase;
    @Autowired
    private Calculator calculator;
    @Autowired
    private FindOnlineUser findOnlineUser;

    @GetMapping("/calcutaleBMI")
    public String calculateBMI(Model model)
    {
        model.addAttribute("UserB", new User());
        return "BMI/calculator";
    }

    @PostMapping("/calculating")
    public String calculating(Model model, User userSize)
    {
        findOnlineUser.findUser(dataBase);
        double bmi = calculator.calculateBMI(userSize);
        model.addAttribute("bmi", bmi);


        return "BMI/resultBMI";
    }

    @GetMapping("/signeg")
    public String mainPage()
    {
        return "login/userMain";
    }

}
