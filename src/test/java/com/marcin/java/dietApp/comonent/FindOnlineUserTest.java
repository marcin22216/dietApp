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

    @Before
    public void setUp() {
        this.underTest = new FindOnlineUser();
    }

    @Test
    public void shouldReturnUserWhenisLog() {
        //given
        List<User> listToTest;
        listToTest = new ArrayList<>();
        User userToTest = new User();
        User userToTest2 = new User();
        DataBase dataBaseTest = new DataBase();
        userToTest.setLogged(true);
        userToTest2.setLogged(false);
        listToTest.add(userToTest);
        listToTest.add(userToTest2);
        dataBaseTest.setUserList(listToTest);

        //when
        User result = underTest.findUser(dataBaseTest, userToTest);

        //then
        Assertions.assertThat(result).isEqualTo(userToTest);
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
        User result = underTest.findUser(dataBaseTest, userToTest);

        //then
        Assertions.assertThat(result).isEqualTo(null);
    }

}