package com.revature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution sut;

    @Before
    public void setup() {
        sut = new Solution();
    }

    @After
    public void tearDown() {
        sut = null;
    }

    @Test
    public void test1() {
        List<Integer> testData = Arrays.asList(3, 1, 4, 1);

        int expected = 4311;

        int actual = sut.encodeMessage(testData);

        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        List<Integer> testData = Arrays.asList(3, 1, 4, 1, 5, 9);

        int expected = 94311;

        int actual = sut.encodeMessage(testData);

        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        List<Integer> testData = Arrays.asList(4, 4, 1, 1, 1, 3);

        int expected = 4431;

        int actual = sut.encodeMessage(testData);

        assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        List<Integer> testData = Arrays.asList(5, 5, 5, 3, 9);

        int expected = 95553;

        int actual = sut.encodeMessage(testData);

        assertEquals(expected, actual);
    }

    @Test
    public void test5() {
        List<Integer> testData = Arrays.asList(8, 1, 3, 5, 7, 2);

        int expected = 8751;

        int actual = sut.encodeMessage(testData);

        assertEquals(expected, actual);
    }
}
