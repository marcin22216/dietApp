package com.marcin.java.dietApp.comonent;

import com.marcin.java.dietApp.bean.User;
import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CheckLoginLogTest {

    private CheckLoginLog underTest;

    @Before
    public void setUp() { this.underTest = new CheckLoginLog(); }

    //TODO: check if method's name is correct
    //TODO: this test does not pass !!!!!
    @Test
    public void shouldRetornTruIfLoginIsCorrect()
    {
        //given
        List<User> listOfUsers;
        listOfUsers = new ArrayList<>();
        User userToTest = new User();
        User userToTest2 = new User();
        DataBase listToTest = new DataBase();
        userToTest.setLogin("marcin");
        listToTest.setUserList(listOfUsers);
        listOfUsers.add(userToTest);
        userToTest2.setLogin("marcin1");

        //when
        boolean result = underTest.correctLog(listToTest, userToTest2);

        //then
        Assertions.assertThat(result).isEqualTo(true);
    }

    // after my corrections
//    @Test
//    public void shouldReturnTruIfLoginIsCorrect()
//    {
//        given
//        User registeredUser = new User();
//        registeredUser.setLogin("marcin");
//
//        List<User> listOfUsers = new ArrayList<>();
//        listOfUsers.add(registeredUser);
//
//        DataBase dataBase = new DataBase();
//        dataBase.setUserList(listOfUsers);
//
//        User userToLog = new User();
//        userToLog.setLogin("marcin");
//
//        when
//        boolean result = underTest.correctLog(dataBase, userToLog);
//
//        then
//        Assertions.assertThat(result).isEqualTo(true);
//    }

    //TODO: add test! Check what happen when login is incorrect and other scenario

}
