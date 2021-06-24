import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Jbialon
 * Date: 6/24/2021
 * Time: 10:14 AM
 * Description: {Insert Description}
 */
public class SolutionTests {

    Solution sut = new Solution();
    /*
        Input: `Solution.solution({3, 1, 4, 1})`
        Output: 4311
        Input: `Solution.solution({3, 1, 4, 1, 5, 9})`
        Output: 94311
        Input: `Solution.solution({4, 4, 1, 1, 1, 3}`
        Output: 4431
     */

    @Test
    public void testWith3141() {

        List<Integer> sutList = new ArrayList<>();
        sutList.add(3);
        sutList.add(1);
        sutList.add(4);
        sutList.add(1);

        int result = sut.solution(sutList);

        Assert.assertEquals(4311, result);

    }

    @Test
    public void testWith314159() {

        List<Integer> sutList = new ArrayList<>();
        sutList.add(3);
        sutList.add(1);
        sutList.add(4);
        sutList.add(1);
        sutList.add(5);
        sutList.add(9);

        int result = sut.solution(sutList);

        Assert.assertEquals(94311, result);

    }

    @Test
    public void testWith441113() {

        List<Integer> sutList = new ArrayList<>();
        sutList.add(4);
        sutList.add(4);
        sutList.add(1);
        sutList.add(1);
        sutList.add(1);
        sutList.add(3);

        int result = sut.solution(sutList);

        Assert.assertEquals(4431, result);

    }

}
