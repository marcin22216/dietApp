package com.marcin.java.dietApp.comonent;

import com.marcin.java.dietApp.bean.User;
import org.springframework.stereotype.Component;

@Component
public class CheckPasswordLog {

    public boolean correctPassword(DataBase dataBase, User userToPass)
    {
        for (int i=0; i<=dataBase.getUserList().size(); i++)
        {
            if (dataBase.getUserList().get(i).equals(userToPass.getPassword()))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        return true;
    }

}
