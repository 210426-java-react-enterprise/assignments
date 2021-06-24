import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * User: Jbialon
 * Date: 6/24/2021
 * Time: 10:24 AM
 * Description: {Insert Description}
 */
public class Solution {

    public Solution() {super();}

    public int solution(List<Integer> integerList) {

        int returnVal = 0;
        String intStr = "";

        integerList.sort(Comparator.reverseOrder());

        System.out.println(integerList);

        List<String> strList = integerList.stream()
                .map(i -> String.valueOf(i))
                .collect(Collectors.toList());

        for (int i = 0; i < strList.size(); i++) {
            intStr += strList.get(i);
        }

        returnVal = Integer.parseInt(intStr);

        if (returnVal % 3 == 0) {
            return returnVal;
        }

        System.out.println("9".compareTo("1"));

        return 0;

    }
}
