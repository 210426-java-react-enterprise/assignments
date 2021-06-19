package com.revature.main;


import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@NoArgsConstructor
public class Solution {

    public List<Integer> solve(int area) {
        if(area == 1)
            return Collections.singletonList(area);

        List<Integer> result = new ArrayList<>();

        /*
            while the number is not 0, compute the largest square
            that can be made with that number, then subtract the largest square.
         */
        int number = area;
        while (true) {
            if(number == 0) {
                return result;
            }
            int temp = largestSquare(number);
            result.add(temp);
            number -= temp;
        }
    }

    public int largestSquare(int input) {
        int root = 1;
        int current = 1;
        int previous = 1;
        while (current < input) {
            previous = current;
            current = (int) Math.pow(root, 2);
            root++;
        }
        return previous;
    }
}
