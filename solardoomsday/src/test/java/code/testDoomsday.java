package code;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class testDoomsday {
    /*
    BASE TEST CASES:
    Input: 12
    Output: [9,1,1,1]

    Input: 15324
    Output: [15129,169,25,1]
     */
    Doomsday sut;

    @Before
    public void setUp() {
        sut = new Doomsday();
    }

    @After
    public void tearDown() {
        sut = null;
    }

    @Test
    public void testCalculateTotalAreaWithValidInputs() {
        //Arrange
        int[] expected1 = {9,1,1,1};
        int[] expected2 = {15129,169,25,1};
        int[] expected3 = {100};
        int[] checkValidity1;
        int[] checkValidity2;
        int[] checkValidity3;

        //Act
        checkValidity1 = sut.calculateTotalArea(12);
        checkValidity2 = sut.calculateTotalArea(15324);
        checkValidity3 = sut.calculateTotalArea(100);

        //Assert
        Assert.assertArrayEquals(checkValidity1, expected1);
        Assert.assertArrayEquals(checkValidity2, expected2);
        Assert.assertArrayEquals(checkValidity3, expected3);
    }
}
