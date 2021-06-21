import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionTest {

    private SolarDoomdayProblem sut;

    @Before
    public void setUp(){
        sut = new SolarDoomdayProblem();
    }

    @After
    public void tearDown(){
        sut = null;
    }

    @Test
    public void test_case1(){
        List<Integer> expected = Arrays.asList(9, 1,1,1);

        List<Integer> actual;
        actual = sut.solution(12);

        Assert.assertTrue(expected.equals(actual));
    }

    @Test
    public void test_case2(){
        List<Integer> expected = Arrays.asList(15129, 169,25,1);

        List<Integer> actual;
        actual = sut.solution(15324);

        Assert.assertTrue(expected.equals(actual));
    }

}
