package com.marcin.java.dietApp.comonent;

import com.marcin.java.dietApp.bean.User;
import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FindOnlineUserTest {

    private FindOnlineUser underTest;

    private User createUser(String login, boolean isLogged)
    {
        User loggedUser = new User();
        loggedUser.setLogged(isLogged);
        loggedUser.setLogin(login);
        return loggedUser;
    }

    @Before
    public void setUp() {
        this.underTest = new FindOnlineUser();
    }

    @Test
    public void shouldReturnUserWhenIsLog() {
        //given
//        List<User> listToTest;
//        listToTest = new ArrayList<>();
//        User userToTest = new User();
//        User userToTest2 = new User();
//        DataBase dataBaseTest = new DataBase();
//        userToTest.setLogged(true);
//        userToTest2.setLogged(false);
//        listToTest.add(userToTest);
//        listToTest.add(userToTest2);
//        dataBaseTest.setUserList(listToTest);
        List<User> userList = new ArrayList<>();
        userList.add(createUser("marcin", true));
        userList.add(createUser("szymon", false));
        userList.add(createUser("pawel", false));
        userList.add(createUser("tomek", false));

        DataBase dataBase = new DataBase();
        dataBase.setUserList(userList);

        //when
        User result = underTest.findUser(dataBase);

        //then
        Assertions.assertThat(result.getLogin()).isEqualTo("marcin");
    }

    @Test
    public void shouldReturnNullWhenListIsEmpty()
    {
        //giver
        List<User> listToTest;
        listToTest = new ArrayList<>();
        DataBase dataBaseTest = new DataBase();
        User userToTest = new User();
        userToTest.setLogged(true);
        dataBaseTest.setUserList(listToTest);

        //when
        User result = underTest.findUser(dataBaseTest);

        //then
        Assertions.assertThat(result).isEqualTo(null);
    }

}