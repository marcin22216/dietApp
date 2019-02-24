package com.marcin.java.dietApp.comonent;

import com.marcin.java.dietApp.bean.User;
import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

//Testuje klase (czyli de facto obiekty) CheckLogin
public class CheckLoginTest {

    // zmienna referencyjna obiektu ktory jest testowany
    private CheckLogin underTest;

    @Before
    public void setUp()
    {
        this.underTest = new CheckLogin();
    }

    @Test
    public void shouldReturnFalseBecauseToLongLogin()
    {
        // given
        User userToTest = new User();
        userToTest.setLogin("dupadupaduapdu");
        DataBase dataBase = new DataBase();

        // when
        boolean result = underTest.checkName(dataBase, userToTest);

        // then
        Assertions.assertThat(result).isFalse();

    }

    @Test
    public void shouldReturnFalseBecauseToShortLogin()
    {
        // given
        User userToTest = new User();
        userToTest.setLogin("a");
        DataBase dataBase = new DataBase();

        // when
        boolean result = underTest.checkName(dataBase, userToTest);

        // then
        Assertions.assertThat(result).isFalse();

    }

    @Test
    public void shouldReturnTrue()
    {
        // given
        User userToTest = new User();
        userToTest.setLogin("Marcin");
        DataBase dataBase = new DataBase();

        // when
        boolean result = underTest.checkName(dataBase, userToTest);

        // then
        Assertions.assertThat(result).isTrue();

    }

}