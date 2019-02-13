package com.marcin.java.dietApp.comonent;

import com.marcin.java.dietApp.bean.User;
import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

public class CheckPasswordLogTest {

    private CheckPasswordLog underTest;

    @Before
    public void setUp()
    {
        this.underTest = new CheckPasswordLog();
    }

    @Test
    public void shouldReturnTrueIfPasswordIsCorrect()
    {
        //given
        List<User> dataBase;
        dataBase = new ArrayList<>();
        User userToTest = new User();
        User userToTest2 = new User();
        DataBase userListInDataBase = new DataBase();
        userListInDataBase.setUserList(dataBase);
        userToTest.setPassword("dupa");
        dataBase.add(userToTest);
        userToTest2.setPassword("dupa");

        //when
        boolean result = underTest.correctPassword(userListInDataBase, userToTest2);

        //then
        Assertions.assertThat(result).isEqualTo(true);
    }



}
