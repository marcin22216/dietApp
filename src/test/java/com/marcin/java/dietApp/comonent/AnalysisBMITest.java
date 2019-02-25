package com.marcin.java.dietApp.comonent;

import com.marcin.java.dietApp.bean.User;
import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnalysisBMITest {

    private AnalysisBMI underTest;

    private User createUser(double BMI)
    {
        User loggedUser = new User();
        loggedUser.setBmi(BMI);
        return loggedUser;
    }

    @Before
    public void setUp() { this.underTest = new AnalysisBMI(); }

    @Test
    public void shouldReturnCorrectWeightIfBmiIsBetween18And25()
    {
//        given
        User userToAnalyseBMI = createUser(18);

//        when
        String result = underTest.analyzingBmi(userToAnalyseBMI);

//        then
        Assertions.assertThat(result).isEqualTo("correct weight");
    }

    @Test
    public void shouldReturnUnderWeightIfBmiIsUnder18()
    {
//        given
        User userToAnalyseBMI = createUser(15);

//        when
        String result = underTest.analyzingBmi(userToAnalyseBMI);

//        then
        Assertions.assertThat(result).isEqualTo("underweight");
    }

    @Test
    public void shouldReturnOverweightIfBmiIsBetween25and30()
    {
//        given
        User userToAnalyseBMI = createUser(27);

//        when
        String result = underTest.analyzingBmi(userToAnalyseBMI);

//        then
        Assertions.assertThat(result).isEqualTo("overweight");
    }

    @Test
    public void shouldReturnObesityIfBmiIsOver30()
    {
//        given
        User userToAnalyseBmi = createUser(33);

//        when
        String result = underTest.analyzingBmi(userToAnalyseBmi);

//        then
        Assertions.assertThat(result).isEqualTo("obesity");
    }


}