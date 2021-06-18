package com.revature;

//Solar Doomsday
//        Who would've guessed? Doomsday devices take a LOT of power. Commander Lambda wants to supplement the LAMBCHOP's
//        quantum antimatter reactor core with solar arrays, and you've been tasked with setting up the solar panels.
//        Due to the nature of the space station's outer paneling, all of its solar panels must be squares. Fortunately,
//        you have one very large and flat area of solar material, a pair of industrial-strength scissors,
//        and enough MegaCorp Solar Tape(TM) to piece together any excess panel material into more squares.
//        For example, if you had a total area of 12 square yards of solar material,
//        you would be able to make one 3x3 square panel (with a total area of 9).
//        That would leave 3 square yards, so you can turn those into three 1x1 square solar panels.
//        Write a function solution(area) that takes as its input a single unit of measure representing
//        the total area of solar panels you have (between 1 and 1000000 inclusive) and returns a list of the areas
//        of the largest squares you could make out of those panels, starting with the largest squares first.
//        So, following the example above, solution(12) would return [9, 1, 1, 1].
//        Test cases
//        Create a test suite that includes the below base test cases. Include any others you would like to test your solution against.
//        Input: 12
//        Output: [9,1,1,1]
//        Input: 15324
//        Output: [15129,169,25,1]
//        Atttribution: This problem originated from Google's secret Foobar Coding Challenge.


import java.util.*;

public class Solar {
    public static void main(String[] args) {
        solutionSet();


    }

    public static int[] solution(int area){
        List<Integer> result = new ArrayList<Integer>();
        while (area > 0) {
            int next = maxSquare(area, 1, 1000);
            result.add(next);
            area -= next;
        }

        int[] answer = new int[result.size()];

        for (int i = 0; i < answer.length ; i++)
            answer[i] = result.get(i);

        return answer;
    }

    public static void solutionSet(){

        int[] data = new int[]{15129,169,25,1};
        int test= 15324;

        int[] actual = solution(test);

        System.out.println(Arrays.toString(data)+"\n\n");
        System.out.println(Arrays.toString(actual)+"\n\n");
        System.out.println("==========================");




        data = new int[]{9,1,1,1};
       test = 12;
        actual = solution(test);

        System.out.println(Arrays.toString(data)+"\n\n");
        System.out.println(Arrays.toString(actual)+"\n\n");
        System.out.println("==========================");

        data = new int[]{144,4,1,1};
       test = 150;
        actual = solution(test);

        System.out.println(Arrays.toString(data)+"\n\n");
        System.out.println(Arrays.toString(actual)+"\n\n");
        System.out.println("==========================");

        data = new int[]{169,9,4,1};
        test = 183;
        actual = solution(test);

        System.out.println(Arrays.toString(data)+"\n\n");
        System.out.println(Arrays.toString(actual)+"\n\n");
        System.out.println("==========================");

        data = new int[]{169,16,1,1};
       test = 187;
        actual = solution(test);

        System.out.println(Arrays.toString(data)+"\n\n");
        System.out.println(Arrays.toString(actual)+"\n\n");
        System.out.println("==========================");

        data = new int[]{961,25,1,1};
        test = 988;
        actual = solution(test);

        System.out.println(Arrays.toString(data)+"\n\n");
        System.out.println(Arrays.toString(actual)+"\n\n");
        System.out.println("==========================");

        data = new int[]{784,25,4,1};
        test = 814;
        actual = solution(test);

        System.out.println(Arrays.toString(data)+"\n\n");
        System.out.println(Arrays.toString(actual)+"\n\n");
        System.out.println("==========================");


    }

    public static int maxSquare(int number, int start, int end) {
        int mid =  (start+end) / 2;
        int mid2 = mid * mid;

        if (end - start == 1 || start - end == 1) {
            if ((mid+1)*(mid+1) <= number)
                return (mid+1)*(mid+1);
            else
                return mid2;
        } else {
            if (mid2 < number)
                return maxSquare(number, mid, end);
            else if (mid2 > number)
                return maxSquare(number, start, mid);
            else if (mid2 == number) {
                return mid2;
            }
        }

        return 0;
    }


}

