package com.marcin.java.dietApp.comonent;

import com.marcin.java.dietApp.bean.User;
import org.springframework.stereotype.Component;

@Component
public class AddName {
    public void addName(DataBase dataBase, User user)
    {
        for (User user1 : dataBase.getUserList())
        {
            if (user1.isLogged())
            {
                user1.setName(user.getName());
            }
        }
    }
}
