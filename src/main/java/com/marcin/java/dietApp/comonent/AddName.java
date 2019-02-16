package com.marcin.java.dietApp.comonent;

import com.marcin.java.dietApp.bean.User;
import org.springframework.stereotype.Component;

@Component
public class AddName {
    public void addName(DataBase dataBase, User user)
    {
        for (int i=0; i<dataBase.getUserList().size(); i++)
        {
            if (dataBase.getUserList().get(i).isLogged())
            {
                dataBase.getUserList().get(i).setName(user.getName());
            }
        }
    }
}
