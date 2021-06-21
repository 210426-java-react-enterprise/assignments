import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Driver {
    Map<Integer, List<Integer>> testMap = new HashMap<>();


    public void main(String[] args) {
        testMap.put(1, Arrays.asList(1));
        testMap.put(12, Arrays.asList(9,1,1,1));
        testMap.put(13, Arrays.asList(9,4));
        testMap.put(15324, Arrays.asList(15129,169,25,1));
        testMap.put(32400, Arrays.asList(180));
        testMap.put(555555, Arrays.asList(745,23,1));
        testMap.put(666666, Arrays.asList(816,28,5,1));
        testMap.put(777777, Arrays.asList(881,40,4));
        testMap.put(1000000, Arrays.asList(1000));

    }
}
