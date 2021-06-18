import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SolarDoomsday {

    static ArrayList<Integer> solution(int area) {

        int remainingArea = area;
        ArrayList<Integer> panels = new ArrayList<Integer>();

        while (remainingArea > 0) {
            int greatestSquare = (int) Math.sqrt(remainingArea);
            int currentPanel = greatestSquare * greatestSquare;
            remainingArea = remainingArea - currentPanel;
            panels.add(currentPanel);
        }

        return panels;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Input: ");
        try {
            int area = Integer.parseInt(br.readLine());
            while (area < 1 || area > 1000000) {
                System.out.println("Number cannot be greater than 1000000 or less than 1");
                System.out.print("Input: ");
                area =Integer.parseInt(br.readLine());
            }
            System.out.println("Output: " + solution(area));
        } catch (NumberFormatException e) {
            System.err.println("Not a Number");
        }
    }
}