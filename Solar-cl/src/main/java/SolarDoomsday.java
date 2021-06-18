import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolarDoomsday {
    public static void main(String[] args) {
        int areas[] = {12, 15324, 47};


        {for (int i = 0; i < 3; i++) {
            System.out.println(solution(areas[i]));
        }
        }
    }




    public static List<Integer> solution(int area){
        List<Integer> listAns = new ArrayList<>();
        while (area != 0){
            double root = Math.sqrt(area);
            int largest = (int)Math.floor(root);
            area = area - (largest*largest);
            listAns.add(largest*largest);
        }

        return listAns;
    }
}
