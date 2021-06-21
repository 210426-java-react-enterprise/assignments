package code;

import java.util.ArrayList;

public class Doomsday {

    private int totalArea;
    private ArrayList<Integer> areas;

    public Doomsday() {}

    public int[] calculateTotalArea(int totalArea) {
        int differences = totalArea;
        ArrayList<Integer> squares = new ArrayList<>();
        int index = 0;

        do {
            int num = (int)Math.sqrt(differences);
            squares.add(num*num);
            differences -= squares.get(index);
            index++;
        } while(differences > 0);

        int [] array = new int[squares.size()];

        for (int i = 0; i < squares.size(); i++) {
            array[i] = squares.get(i);
        }

        System.out.println("Array of Areas for " + totalArea + " = " + squares);
        return array;
    }
}
