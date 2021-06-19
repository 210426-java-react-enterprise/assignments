import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;

/**
 * Created by IntelliJ IDEA.
 * User: Jbialon
 * Date: 6/18/2021
 * Time: 4:58 PM
 * Description: {Insert Description}
 */
public class Solution {

    public Solution() {super();}

    public List<Integer> solution(int area) {

        List<Integer> returnList = new ArrayList<>();

        while (area >= 1) {
            Integer sqrt = (int) pow(floor(sqrt(area)), 2);
            returnList.add(sqrt);
            area = (area - sqrt);
        }

        return returnList;
    }

}
