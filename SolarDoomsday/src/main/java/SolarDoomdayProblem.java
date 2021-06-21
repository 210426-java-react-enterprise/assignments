import java.util.ArrayList;
import java.util.List;

public class SolarDoomdayProblem {

    public List<Integer> solution(int area){
        List<Integer> tiles = new ArrayList<>();

        while(area > 0){
            int t = (int) Math.sqrt(area);
            t *= t;

            tiles.add(t);
            area -= t;
        }

        return tiles;
    }
}
