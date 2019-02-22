package com.marcin.java.dietApp.comonent;

import com.marcin.java.dietApp.bean.User;
import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;
import sun.nio.cs.US_ASCII;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

public class CheckPasswordLogTest {

    private CheckPasswordLog underTest;

    private User createUser(String password)
    {
        User registeredUser = new User();
        registeredUser.setPassword(password);
        return registeredUser;
    }

    @Before
    public void setUp()
    {
        this.underTest = new CheckPasswordLog();
    }

    @Test
    public void shouldReturnTrueIfPasswordIsCorrect()
    {
        //given
//        List<User> dataBase;
//        dataBase = new ArrayList<>();
//        User userToTest = new User();
//        User userToTest2 = new User();
//        DataBase userListInDataBase = new DataBase();
//        userListInDataBase.setUserList(dataBase);
//        userToTest.setPassword("dupa");
//        dataBase.add(userToTest);
//        userToTest2.setPassword("dupa");
        List<User> listOfUsers = new ArrayList<>();

        listOfUsers.add(createUser("12345"));
        listOfUsers.add(createUser("qwerty"));
        listOfUsers.add(createUser("marcin1"));

        DataBase dataBase = new DataBase();
        dataBase.setUserList(listOfUsers);

        User userToLog = createUser("12345");

        //when
        boolean result = underTest.correctPassword(dataBase, userToLog);

        //then
        Assertions.assertThat(result).isEqualTo(true);
    }

    @Test
    public void shouldReturnFalseIfPasswordIsIncorrect()
    {
        //given
//        User userToTest = new User();
//        User userToTest2 = new User();
//        List<User> dataBase;
//        dataBase = new ArrayList<>();
//        DataBase userListInDataBase = new DataBase();
//        userListInDataBase.setUserList(dataBase);
//        dataBase.add(userToTest);
//        userToTest.setPassword("dupa");
//        userToTest2.setPassword("dupa");

        List<User> listOfUsers = new ArrayList<>();
        listOfUsers.add(createUser("12345"));
        listOfUsers.add(createUser("marcin1"));

        DataBase dataBase = new DataBase();
        dataBase.setUserList(listOfUsers);

        User userToLog = createUser("aiorujnhailhjuvb");

        //when
        boolean result = underTest.correctPassword(dataBase, userToLog);

        //then
        Assertions.assertThat(result).isEqualTo(false);

    }

    @Test
    public void shouldReturnFalseIfListIsEmpty()
    {
//        given
        List<User> listOfUsers = new ArrayList<>();

        DataBase dataBase = new DataBase();
        dataBase.setUserList(listOfUsers);

        User userToLog = createUser("123450");

//        when
        boolean result = underTest.correctPassword(dataBase, userToLog);

//        then
        Assertions.assertThat(result).isEqualTo(false);
    }

}
