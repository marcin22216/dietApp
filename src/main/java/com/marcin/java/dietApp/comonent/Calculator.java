package com.marcin.java.dietApp.comonent;

import com.marcin.java.dietApp.bean.User;
import org.springframework.stereotype.Component;

@Component
public class Calculator {
    private double BMI;

    public double getBMI() {
        return BMI;
    }

    public void setBMI(double BMI) {
        this.BMI = BMI;
    }

    public double calculateBMI(User user)
    {
        BMI = (user.getWeight() / ((user.getGrowth())*(user.getGrowth()))) * 10000;
        return BMI;
    }

}
