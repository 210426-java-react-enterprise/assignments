package com.revature.bunnies;

public class BunnyCode {

    public int Solution(int[] L) {
         /*
            This solution is based on the following two realizations:
            1. The code will be divisible by 3 if the number produced by the sum of its digits is divisible by 3
            2. If the code is not divisible by 3, its sum has to either be 1 or 2 away from a number that is

            Thus, if the code isn't divisible by 3, but is Y away from being divisible by 3,
              the lowest digit or at most two digits X or X + Z where X or X + Z % 3 = Y
              are the digit(s) to be removed to find the solution
         */

        // convert L to array list and sort in reverse order for easy largest number manipulation

        // create a parallel array list with the new number modulo 3 to determine what digits should be removed

        // check whether the number is divisible by 3, if so, return it

        // if not, check difference

        // if difference is 1, check if there are any 1s in the modulo array and if so, remove the corresponding digit and return the remaining as a number

        // if difference is 2, check if there are any 2s and remove corresponding digit and returnr

        // if still not, check if there are multiple ones and remove the two corresponding digits earliest in array

        // if still not, return 0
        return 0;
    }
}
