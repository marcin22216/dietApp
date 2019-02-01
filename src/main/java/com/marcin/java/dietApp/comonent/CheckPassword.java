package com.marcin.java.dietApp.comonent;

import com.marcin.java.dietApp.bean.User;
import org.springframework.stereotype.Component;

@Component
public class CheckPassword {

    private int pass;

    public boolean checkPass(User userPass)
    {
        pass = userPass.getPassword().length();
        if (pass<4 || pass>10)
            return false;
        else
            return true;
    }
}
