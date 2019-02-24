package com.marcin.java.dietApp.comonent;

import com.marcin.java.dietApp.bean.User;
import org.springframework.stereotype.Component;

@Component
public class CheckLogin {

    private String login;
    private int lenghtName;

    public boolean checkName(DataBase dataBase, User userToRegister)
    {
        login = userToRegister.getLogin();
        lenghtName = userToRegister.getLogin().length();
        if (lenghtName<4 || lenghtName >10)
        {
            return false;
        }

        for (User user : dataBase.getUserList()) {
            if (userToRegister.getLogin().equals(user.getLogin()));
            {
                return false;
            }
        }
            return true;

    }

}
