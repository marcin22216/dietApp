package com.marcin.java.dietApp.comonent;

import com.marcin.java.dietApp.bean.User;
import org.springframework.stereotype.Component;

@Component
public class FindOnlineUser {

    public User findUser(DataBase dataBase)
    {
        for (User user : dataBase.getUserList())

        {
            if (user.isLogged())
            {
                return  user;
            }
            else
            {
                return null;
            }
        }
        return null;
    }













//    public User findLoggedUser(DataBase dataBase)
//    {
//        for (User user : dataBase.getUserList()) {
//
//            if(user.isLogged())
//            {
//                return user;
//            }
//        }
//
//        return null;
//    }

}
