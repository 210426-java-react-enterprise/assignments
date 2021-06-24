import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Driver {
    public static void main(String[] args){

        List<List<Integer>> testList = new ArrayList<>();

        testList.add(Arrays.asList(3, 1, 4, 1));
        testList.add(Arrays.asList(3, 1, 4, 1, 5, 9));
        testList.add(Arrays.asList(4, 4, 1, 1, 1, 3));

        Solution solution = new Solution();
        for (List<Integer> plates : testList) {
            System.out.println("SOLUTION {" + plates + "}: " + solution.solution(plates));
        }
    }
}
