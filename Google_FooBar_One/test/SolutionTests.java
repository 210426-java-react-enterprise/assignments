import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by IntelliJ IDEA.
 * User: Jbialon
 * Date: 6/18/2021
 * Time: 4:58 PM
 * Description: {Insert Description}
 */
public class SolutionTests {

    Solution solution = new Solution();

    /*
        Input: 12
        Output: [9,1,1,1]
        Input: 15324
        Output: [15129,169,25,1]
     */

    @Test
    public void testWith12() {

        List<Integer> result = solution.solution(12);
        List<Integer> comparison = new ArrayList<>();
        comparison.add(9);
        comparison.add(1);
        comparison.add(1);
        comparison.add(1);

        Assert.assertEquals(comparison, result);

    }

    @Test
    public void testWith15324() {

        List<Integer> result = solution.solution(15324);
        List<Integer> comparison = new ArrayList<>();
        comparison.add(15129);
        comparison.add(169);
        comparison.add(25);
        comparison.add(1);

        Assert.assertEquals(comparison, result);

    }


}
