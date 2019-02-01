package com.marcin.java.dietApp.comonent;

import com.marcin.java.dietApp.bean.User;
import org.springframework.stereotype.Component;

@Component
public class CheckLogin {

    private int name;

    public boolean checkName(User userToRegister)
    {
        name = userToRegister.getLogin().length();
        if (name<4 || name >10)
        {
            return false;
        }
        else
            return true;
    }

}
