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

}
