package com.revature.main;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution sut;

    @Before
    public void setUpTest() {
        sut = new Solution();
    }

    @After
    public void tearDownTest() {
        sut = null;
    }

    @Test
    public void test_1() {
        int testValue = 12;
        List<Integer> expected = Arrays.asList(9, 1, 1, 1);

        List<Integer> actual = sut.solve(testValue);

        assertEquals(expected, actual);
    }

    @Test
    public void test_2() {
        int testValue = 15324;
        List<Integer> expected = Arrays.asList(15129, 169, 25, 1);

        List<Integer> actual = sut.solve(testValue);

        assertEquals(expected, actual);
    }
}
