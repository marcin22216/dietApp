package com.marcin.java.dietApp.comonent;

import com.marcin.java.dietApp.bean.User;
import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

public class CheckPasswordTest {

    private CheckPassword underTest;

    @Before
    public void setUp() {this.underTest = new CheckPassword(); }

    @Test
    public void shouldReturnFalseBecauseTooShortOfLongPassword()
    {
        User userToTest = new User();
        userToTest.setPassword("ww");

        boolean result = underTest.checkPass(userToTest);

        Assertions.assertThat(result).isEqualTo(false);
    }

}
