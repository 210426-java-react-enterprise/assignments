import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

    Solution sut;

    @Before
    public void setUpTest() {
        sut = new Solution();
    }

    @After
    public void tearDownTest() {
        sut = null;
    }

    @Test
    public void test1() {
        int[] num1 = {1,3};
        int[] num2 = {2};
        double expected = 2;

        double actual = sut.findMedianSortedArrays(num1,num2);

        Assert.assertEquals(expected,actual,.01);
    }

    @Test
    public void test2() {
        int[] num1 = {1,2};
        int[] num2 = {3,4};
        double expected = 2.5;

        double actual = sut.findMedianSortedArrays(num1,num2);

        Assert.assertEquals(expected,actual,.01);
    }

    @Test
    public void test3() {
        int[] num1 = {0,0};
        int[] num2 = {0,0};
        double expected = 0;

        double actual = sut.findMedianSortedArrays(num1,num2);

        Assert.assertEquals(expected,actual,.01);
    }

    @Test
    public void test4() {
        int[] num1 = {};
        int[] num2 = {1};
        double expected = 1;

        double actual = sut.findMedianSortedArrays(num1,num2);

        Assert.assertEquals(expected,actual,.01);
    }

    @Test
    public void test5() {
        int[] num1 = {2};
        int[] num2 = {};
        double expected = 2;

        double actual = sut.findMedianSortedArrays(num1,num2);

        Assert.assertEquals(expected,actual,.01);
    }

    @Test
    public void test6() {
        int[] num1 = {1,3,5,7,8,9,10,12,13,14,16,17,17,23,25,29,30,31,35};
        int[] num2 = {2,4,6,11,15,16,18,19,20,22,22,24,28,33,34,39};
        double expected = 17;

        double actual = sut.findMedianSortedArrays(num1,num2);

        Assert.assertEquals(expected,actual,.01);
    }
}
