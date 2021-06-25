package com.revature.bunnies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BunnyCode {

    public Integer solution(Integer[] L) {
         /*
            This solution is based on the following two realizations:
            1. The code will be divisible by 3 if the number produced by the sum of its digits is divisible by 3
            2. If the code is not divisible by 3, its sum has to either be 1 or 2 away from a number that is

            Thus, if the code isn't divisible by 3, but is Y away from being divisible by 3,
              the lowest digit or at most two digits X or X + Z where X or X + Z % 3 = Y
              are the digit(s) to be removed to find the solution
         */

        // convert L to array list and sort in reverse order for easy largest number manipulation
        List<Integer> sortedL = new ArrayList<>(Arrays.asList(L));
        Collections.sort(sortedL, Collections.reverseOrder());

        // create a parallel array list with the new number modulo 3 to determine what digits should be removed
        List<Integer> modulos = sortedL.stream().map((num) -> {
            return num % 3;
        })
                .collect(Collectors.toCollection(ArrayList::new));

        // check whether the number is divisible by 3, if so, return it
        Integer sum = sortedL.stream()
                              .reduce(0, (a, b) -> a + b);

        int difference = sum % 3;

        if (difference == 0) {
            return arrayToNum(sortedL);
        }

        // record number of digits that are 1 or 2 away from being divisible by 3
        int numOfOnes = 0;
        int numOfTwos = 0;
        for (Integer i : modulos) {
            if (i == 1) {
                numOfOnes++;
            } else if (i == 2) {
                numOfTwos++;
            }
        }

        // if difference is 1, check if there are any 1s in the modulo array and if so, remove the corresponding digit and return the remaining as a number
        if (difference == 1 && numOfOnes > 0) {
            int smallest = modulos.lastIndexOf(1);
            sortedL.remove(smallest);
            return arrayToNum(sortedL);
        }

        if (difference == 1 && numOfTwos > 1 &&  sortedL.size() > 2) {
            int smallest = modulos.lastIndexOf(2);
            sortedL.remove(smallest);
            modulos.remove(smallest);
            smallest = modulos.lastIndexOf(2);
            sortedL.remove(smallest);
            modulos.remove(smallest);
            return arrayToNum(sortedL);
        }

        // if difference is 2, check if there are any 2s and remove corresponding digit and return
        if (difference == 2 && numOfTwos > 0) {
            int smallest = modulos.lastIndexOf(2);
            sortedL.remove(smallest);
            return arrayToNum(sortedL);
        }

        if (difference == 2 && numOfOnes > 1 && sortedL.size() > 2) {
            int smallest = modulos.lastIndexOf(1);
            sortedL.remove(smallest);
            modulos.remove(smallest);
            smallest = modulos.lastIndexOf(1);
            sortedL.remove(smallest);
            modulos.remove(smallest);
            return arrayToNum(sortedL);
        }

        // if still not, return 0
        return 0;
    }

    public int arrayToNum(List<Integer> L) {
        String stringNum = "";
        for (Integer i : L) {
            stringNum += i;
        }

        return Integer.parseInt(stringNum);
    }
}
