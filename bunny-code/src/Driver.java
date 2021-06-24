import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;

public class Driver {
    public static void main(String[] args){

        List<List<Integer>> testList = new ArrayList<>();

        testList.add(Arrays.asList(3, 1, 4, 1));
        testList.add(Arrays.asList(3, 1, 4, 1, 5, 9));
        testList.add(Arrays.asList(4, 4, 1, 1, 1, 3));

        Long totalTimeStart = System.currentTimeMillis();

        Solution solution = new Solution();
        for (List<Integer> plates : testList) {
            Long start = System.currentTimeMillis();
            System.out.println("SOLUTION {" + plates + "}: " + solution.solution(plates) + " MS: " + (System.currentTimeMillis() - start));
        }
        System.out.println("Total Time (MS): " + (System.currentTimeMillis() - totalTimeStart));
    }
}
