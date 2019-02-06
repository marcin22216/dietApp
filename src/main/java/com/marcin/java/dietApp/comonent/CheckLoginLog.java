package com.marcin.java.dietApp.comonent;

import com.marcin.java.dietApp.bean.User;
import org.springframework.stereotype.Component;

@Component
public class CheckLoginLog {
    public boolean correctLog(DataBase userList, User userToLog)
    {
        for (User userX : userList.getUserList())
        {
            if (userX.getLogin().equals(userToLog.getLogin()))
            {
                return true;
            }
            else
                return false;
        }
        return false;
    }
}