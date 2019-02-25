package com.marcin.java.dietApp.comonent;

import com.marcin.java.dietApp.bean.User;
import org.springframework.stereotype.Component;

@Component
public class AnalysisBMI {

    private String underweight = "underweight";
    private String correctWeight = "correct weight";
    private String overweight = "overweight";
    private String obesity = "obesity";
    private User user;

    public String analyzingBmi(User user)
    {
        if (user.getBmi()<18)
        {
            return underweight;
        }
        else if (user.getBmi()>=18 & user.getBmi()<25)
        {
            return correctWeight;
        }
        else if (user.getBmi()>=25 & user.getBmi()<30)
        {
            return overweight;
        }
        else if (user.getBmi()>=30)
        {
            return obesity;
        }
        return null;

    }

    public String getUnderweight() {
        return underweight;
    }

    public void setUnderweight(String underweight) {
        this.underweight = underweight;
    }

    public String getCorrectWeight() {
        return correctWeight;
    }

    public void setCorrectWeight(String correctWeight) {
        this.correctWeight = correctWeight;
    }

    public String getOverweight() {
        return overweight;
    }

    public void setOverweight(String overweight) {
        this.overweight = overweight;
    }

    public String getObesity() {
        return obesity;
    }

    public void setObesity(String obesity) {
        this.obesity = obesity;
    }
}
