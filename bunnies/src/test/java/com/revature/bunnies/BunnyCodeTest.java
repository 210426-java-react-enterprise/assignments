package com.revature.bunnies;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BunnyCodeTest {

    BunnyCode sut;

    @Before
    public void setUp() {
        sut = new BunnyCode();
    }

    @After
    public void tearDown() {
        sut = null;
    }

    @Test
    public void test1() {

        // Arrange
        int expected = 4311;

        // Act
        int actual = sut.solution({3, 1, 4, 1});

        // Assert
        assertEquals(expected, actual);

    }

    @Test
    public void test2() {

        // Arrange
        int expected = 94311;

        // Act
        int actual = sut.solution({3, 1, 4, 1, 5, 9});

        // Assert
        assertEquals(expected, actual);

    }

    @Test
    public void test3() {

        // Arrange
        int expected = 4431;

        // Act
        int actual = sut.solution({4, 4, 1, 1, 1, 3});

        // Assert
        assertEquals(expected, actual);

    }

    @Test
    public void test4() {
        // Arrange
        int expected = 0;

        // Act
        int actual = sut.solution({2, 2});

        // Assert
        assertEquals(expected, actual);

    }

    @Test
    public void test5() {

        // Arrange
        int expected = 9875442;

        // Act
        int actual = sut.solution({5, 7, 2, 9, 8, 4, 2, 4});

        // Assert
        assertEquals(expected, actual);

    }

    @Test
    public void test6() {

        // Arrange
        int expected = 65533200;

        // Act
        int actual = sut.solution({0, 3, 5, 2, 0, 7, 6, 3, 5});

        // Assert
        assertEquals(expected, actual);

    }
}
