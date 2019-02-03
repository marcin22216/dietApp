package com.marcin.java.dietApp.comonent;

import com.marcin.java.dietApp.bean.User;
import org.springframework.stereotype.Component;

@Component
public class CheckPasswordLog {

    public boolean correctPassword(DataBase userList, User userToPass)
    {
        for (int i=0; i<=userList.getUserList().size(); i++)
        {
            if (userList.getUserList().get(i).getPassword().equals(userToPass.getPassword()))
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
