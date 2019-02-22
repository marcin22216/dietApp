package com.marcin.java.dietApp.comonent;

import com.marcin.java.dietApp.bean.User;
import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CheckPasswordTest {

    private CheckPassword underTest;

    private User createUser(String password)
    {
        User registeredUser = new User();
        registeredUser.setPassword(password);
        return registeredUser;
    }

    @Before
    public void setUp() {this.underTest = new CheckPassword(); }

    @Test
    public void shouldReturnFalseBecauseTooShortOfLongPassword()
    {
//        given
        List<User> listOfUsers = new ArrayList<>();

        listOfUsers.add(createUser("12345"));
        listOfUsers.add(createUser("qwerty"));
        listOfUsers.add(createUser("marcin1"));

        DataBase dataBase = new DataBase();
        dataBase.setUserList(listOfUsers);

        User userToLog = createUser("123");

        //when
        boolean result = underTest.checkPass(userToLog);

        //then
        Assertions.assertThat(result).isEqualTo(false);
    }

}
