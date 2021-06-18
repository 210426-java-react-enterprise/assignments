import java.util.ArrayList;
import java.util.Arrays;

/**
 * PROJECT created on: IntelliJ IDEA
 * Created by Ann-Aisha Louis-Charles
 * Date: 18 Jun, 2021
 * Time: 5:26 PM
 */
public class solarDoomsDay {
//    Who would've guessed? Doomsday devices take a LOT of power. Commander Lambda wants to supplement the LAMBCHOP's quantum antimatter reactor core with solar arrays,
//    and you've been tasked with setting up the solar panels.
//    Due to the nature of the space station's outer paneling, all of its solar panels must be squares.
//    Fortunately, you have one very large and flat area of solar material, a pair of industrial-strength scissors, and enough MegaCorp Solar Tape(TM) to piece together any excess panel material into more squares.
//
//    For example, if you had a total area of 12 square yards of solar material, you would be able to make one 3x3 square panel (with a total area of 9).
//    That would leave 3 square yards, so you can turn those into three 1x1 square solar panels.
//
//    Write a function solution(area) that takes as its input a single unit of measure representing the total area of solar panels you have (between 1 and 1000000 inclusive) and
//    returns a list of the areas of the largest squares you could make out of those panels, starting with the largest squares first.
//
//    So, following the example above, solution(12) would return [9, 1, 1, 1].
//    Test cases
//    Create a test suite that includes the below base test cases. Include any others you would like to test your solution against.
//            Input: 12
//    Output: [9,1,1,1]
//
//    Input: 15324
//    Output: [15129,169,25,1]


    public static void main(String[] args) {
        int test1 = 12;
        int[] expected1 = new int[]{9,1,1,1};
        int[] result1 = solution(test1);
        if(Arrays.equals(expected1,result1)){
            System.out.println("Passes Test 1");
        }else{
            System.out.println("Fails Test 1");

        }

        int test2 = 15324;
        int[] expected2 = new int[]{15129,169,25,1};
        int[] result2 = solution(test2);
        if(Arrays.equals(expected2,result2)){
            System.out.println("Passes Test 2");
        }else{
            System.out.println("Fails Test 2");

        }


        int test3 = 3614;
        int[] expected3 = new int[]{3600,9,4,1};
        int[] result3 = solution(test3);
        if(Arrays.equals(expected3,result3)){
            System.out.println("Passes Test 3");
        }else{
            System.out.println("Fails Test 3");

        }

        int test4 = 987;
        int[] expected4 = new int[]{961,25,1};
        int[] result4 = solution(test4);
        if(Arrays.equals(expected4,result4)){
            System.out.println("Passes Test 4");
        }else{
            System.out.println("Fails Test 4");
        }

    }

    public static int[] solution(int area){
        int newArea = 0;

        //initialized list
        ArrayList<Integer> test = new ArrayList<>();

        do{
            //step 1: Square root the area, cast the double into an int (int division drops the decimal value)
            //i.e. sqrt(987) = 31
            int squareRoot = ((int) Math.sqrt(area));

            //step 2: Raise the remainder of sqrt(area) to power 2. (i.e 31^2 = 961)
            //step 3: Subtract area from that value = newArea. (i.e. 987-961 = 26)
            //step 4: cast to int
            newArea = (int) (area - Math.pow(squareRoot,2));


            //Step 5: reset value of area to equal newArea.
            area = newArea;

            //Step 6: values added to arrayList
            test.add((int) Math.pow(squareRoot,2));


            // Repeat so long as value is greater than 0.
        }while (area > 0);
        int[] returnArray = new int[test.size()];
        for (int i = 0; i < test.size(); i++) {
            returnArray[i] = test.get(i);
        }
        return returnArray;
    }

}
