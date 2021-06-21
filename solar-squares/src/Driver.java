import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Driver {


    public static void main(String[] args) {
        Map<Integer, List<Integer>> testMap = new HashMap<>();
        testMap.put(1, Arrays.asList(1));
        testMap.put(12, Arrays.asList(9,1,1,1));
        testMap.put(13, Arrays.asList(9,4));
        testMap.put(15324, Arrays.asList(15129,169,25,1));
        /*
        When building these I put the roots in by mistake.
        testMap.put(32400, Arrays.asList(180));//oops, I put the roots in here
        testMap.put(555555, Arrays.asList(745,23,1));//oops, I put the roots in here
        testMap.put(666666, Arrays.asList(816,28,5,1));//oops, I put the roots in here
        testMap.put(777777, Arrays.asList(881,40,4));//oops, I put the roots in here
        testMap.put(1000000, Arrays.asList(1000));//oops, I put the roots in here
         */
        testMap.put(32400, Arrays.asList(32400));
        testMap.put(555555, Arrays.asList(555025,529,1));
        testMap.put(666666, Arrays.asList(665856,784,25,1));
        testMap.put(777777, Arrays.asList(776161,1600,16));
        testMap.put(1000000, Arrays.asList(1000000));


        SolarSquares solarSquares = new SolarSquares();


        boolean flag = true;
        for (Map.Entry<Integer, List<Integer>> entry: testMap.entrySet()) {
            List<Integer> sol = solarSquares.findSquares(entry.getKey());
            System.out.println("Map: " + testMap.get(entry.getKey()));
            System.out.println("Sol: " + sol);
            if(!(entry.getValue().equals(sol))) {
                flag = false;
            }
        }

        if(flag) {
            System.out.println("\n===============\n Tests passed! \n===============");
        }

    }
}
