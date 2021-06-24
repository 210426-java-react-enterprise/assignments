import java.util.ArrayList;
import java.util.List;

public class SolarSquares {
    public List<Integer> findSquares(Integer n) {
        List<Integer> solution = new ArrayList<Integer>();
        Integer remaining = n;
        while(remaining > 0) {
            Integer square = cutSquare(remaining);
            solution.add(square);
            remaining -= (square);
        }
        return solution;
    }

    public Integer cutSquare(Integer area) {
        Integer length = (int)Math.floor(Math.sqrt(area));
        return (length*length);
    }
}