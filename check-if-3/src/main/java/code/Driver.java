package code;

import java.util.ArrayList;
import java.util.Collections;

public class Driver {
    /*
     * Please Pass the Coded Messages
     * ==============================
     * You need to pass a message to the bunny workers, but to avoid detection,
     * the code you agreed to use is... obscure, to say the least. The bunnies
     * are given food on standard-issue plates that are stamped with the numbers
     * 0-9 for easier sorting, and you need to combine sets of plates to create
     * the numbers in the code. The signal that a number is part of the code is
     * that it is divisible by 3. You can do smaller numbers like 15 and 45
     * easily, but bigger numbers like 144 and 414 are a little trickier.
     * Write a program to help yourself quickly create large numbers for use in
     * the code, given a limited number of plates to work with.
     *
     * You have L, a list containing some digits (0 to 9). Write a function
     * solution(L) which finds the largest number that can be made from some or
     * all of these digits and is divisible by 3. If it is not possible to make
     * such a number, return 0 as the solution. L will contain anywhere from 1 to
     * 9 digits.  The same digit may appear multiple times in the list, but each
     * element in the list may only be used once.
     *
     * Test cases
     * ==========
     * Your code should pass the following test cases.
     * Note that it may also be run against hidden test cases not shown here.
     * Input: `Solution.solution({3, 1, 4, 1})`
     * Output: 4311
     * Input: `Solution.solution({3, 1, 4, 1, 5, 9})`
     * Output: 94311
     * Input: `Solution.solution({4, 4, 1, 1, 1, 3}`
     * Output: 4431
     */

    public static void main (String[] args) {
        int[] array1 = {3, 1, 4, 1};
        int[] array2 = {3, 1, 4, 1, 5, 9};
        int[] array3 = {4, 4, 1, 1, 1, 3};

        System.out.println(solution(array1));
        System.out.println(solution(array2));
        System.out.println(solution(array3));
    }

    public static int solution(int[] array) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int item : array) {
            list.add(item);
        }
        list.sort(Collections.reverseOrder());
        for(int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }

        int num = createNumberFromArray(array);
        if (divisibleByThree(num)) return num;

        return 1; // WIP
    }

    public static int createNumberFromArray(int[] array) {
        StringBuilder stringOfNums = new StringBuilder();
        int num;

        for (int item : array) {
            stringOfNums.append(item);
        }
        num = Integer.parseInt(stringOfNums.toString());
        return num;
    }

    public static boolean divisibleByThree (int num) {
        return num % 3 == 0;
    }

//    public static int[] findPermutations(int[] array) {
//
//    }

    public static int findNextHighest(int numCurrent, int[] array) {
        int nextHighest = 0;

        for (int item : array) {
            if (item < numCurrent && item > nextHighest) nextHighest = item;
        }
        return nextHighest;
    }
}