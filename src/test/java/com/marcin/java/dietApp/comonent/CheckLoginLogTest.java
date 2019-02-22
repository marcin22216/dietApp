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
    public void shouldReturnTruIfLoginIsCorrect()
    {
        //given
//        List<User> listOfUsers = new ArrayList<>();
//        listOfUsers = new ArrayList<>();
//        User userToTest = new User();
//        User userToTest2 = new User();
//        DataBase listToTest = new DataBase();
//        userToTest.setLogin("marcin");
//        listToTest.setUserList(listOfUsers);
//        listOfUsers.add(userToTest);
//        userToTest2.setLogin("marcin");

        User registeredUser = createUser("marcin");

        List<User> listOfUsers = new ArrayList<>();
        User registeredUser2 = createUser("szymon");
        listOfUsers.add(registeredUser);
        listOfUsers.add(registeredUser2);

        DataBase dataBase = new DataBase();
        dataBase.setUserList(listOfUsers);

        User userToLog = createUser("marcin");


        //when
        boolean result = underTest.correctLog(dataBase, userToLog);

        //then
        Assertions.assertThat(result).isEqualTo(true);
    }

    @Test
    public void shouldReturnFalseIfLoginIsIncorrect()
    {
//        given
        List<User> listOfUsers = new ArrayList<>();

        listOfUsers.add(createUser("marcin"));
        listOfUsers.add(createUser("pawel"));
        listOfUsers.add(createUser("szymon"));

        DataBase dataBase = new DataBase();

        dataBase.setUserList(listOfUsers);

        User userToLog = createUser("koniu");

//        when
        boolean result = underTest.correctLog(dataBase, userToLog);

//        then
        Assertions.assertThat(result).isEqualTo(false);
    }

    @Test
    public void shouldReturnFalseIfListIsEmpty()
    {
//        given
        List<User> listOfUsers = new ArrayList<>();

        DataBase dataBase = new DataBase();

        dataBase.setUserList(listOfUsers);

        User userToLog = createUser("marcin");

//        when
        boolean result = underTest.correctLog(dataBase, userToLog);

//        then
        Assertions.assertThat(result).isEqualTo(false);
    }



    // after my corrections
    @Test
    public void shouldReturnTruIfLoginIsCorrect2()
    {
//        given
        User registeredUser_2 = createUser("pawel");

        List<User> listOfUsers = new ArrayList<>();
        listOfUsers.add(createUser("marcin"));
        listOfUsers.add(registeredUser_2);

        DataBase dataBase = new DataBase();
        dataBase.setUserList(listOfUsers);

        User userToLog = createUser("marcin");

        //ctrl + alt + m

//        when
        boolean result = underTest.correctLog(dataBase, userToLog);

//        then
        Assertions.assertThat(result).isEqualTo(true);
    }

    private User createUser(String login) {
        User registeredUser = new User();
        registeredUser.setLogin(login);
        return registeredUser;
    }

    //TODO: add test! Check what happen when login is incorrect and other scenario

}
