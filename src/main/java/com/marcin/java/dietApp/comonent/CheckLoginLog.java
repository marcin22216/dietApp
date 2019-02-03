package com.marcin.java.dietApp.comonent;

import com.marcin.java.dietApp.bean.User;
import org.springframework.stereotype.Component;

@Component
public class CheckLoginLog {
    public boolean correctLog(DataBase userList, User userToLog)
    {
        for (int i=0; i<=userList.getUserList().size(); i++)
        {
            if (userList.getUserList().get(i).getLogin().equals(userToLog.getLogin()))
            {
                return true;
            }
            else
                return false;
        }
        return true;

    }
}