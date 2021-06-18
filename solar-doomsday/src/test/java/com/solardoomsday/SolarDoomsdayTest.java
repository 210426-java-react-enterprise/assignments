package com.solardoomsday;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolarDoomsdayTest {

    private SolarDoomsday sut;

    @Before
    public void setUp() {
        this.sut = new SolarDoomsday();
    }

    @After
    public void tearDown() {
        this.sut = null;
    }

    @Test
    public void test1() {

        // Arrange
        int area = 12;
        List<Integer> expected = new ArrayList<>(Arrays.asList(9, 1, 1, 1));

        // Act
        List<Integer> result = sut.solution(area);

        // Assert
        assertEquals(result, expected);
    }

    @Test
    public void test2() {

        // Arrange
        int area = 15324;
        List<Integer> expected = new ArrayList<>(Arrays.asList(15129, 169, 25, 1));

        // Act
        List<Integer> result = sut.solution(area);

        // Assert
        assertEquals(result, expected);
    }

    @Test
    public void test3() {

        // Arrange
        int area = 1;
        List<Integer> expected = new ArrayList<>(Arrays.asList(1));

        // Act
        List<Integer> result = sut.solution(area);

        // Assert
        assertEquals(result, expected);
    }

    @Test
    public void test4() {

        // Arrange
        int area = 376209;
        List<Integer> expected = new ArrayList<>(Arrays.asList(613, 20, 6, 2));

        // Act
        List<Integer> result = sut.solution(area);

        // Assert
        assertEquals(result, expected);
    }

    @Test
    public void test5() {

        // Arrange
        int area = 24;
        List<Integer> expected = new ArrayList<>(Arrays.asList(4, 2, 2));

        // Act
        List<Integer> result = sut.solution(area);

        // Assert
        assertEquals(result, expected);
    }
}
