package com.revature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public int encodeMessage(List<Integer> message) {
        List<Integer> newList = new ArrayList<>(message);
        Collections.sort(newList);
        int size = newList.size();
        
        //may as well handle this obvious edge case.
        if(message.size() == 1) { 
            if(message.get(0) % 3 == 0) {
                return message.get(0);
            } else {
                return 0;
            }
        }
        
        //compute the sum of the list.
        //A rule in math is if the total of the digits of a number is divisible by 3, then the number itself is divisible by 3.
        int sum = getSumOfList(newList); 
        if(sum % 3 == 0) {
            Collections.reverse(newList);
            return joinListAsNumber(newList);
        }
        
        //test the sum of all the list with one element removed at a time.
        //if no sum here is divisible by 3, remove the lowest number of the list and try again.
        int round = 0;
        while (round < size) {
            int newSum = getSumOfList(newList);
            for (int i = 0; i < newList.size(); i++) {
                int num = newList.get(i);
                int difference = newSum - num;
                if (difference % 3 == 0) {
                    newList.remove(i);
                    Collections.reverse(newList);
                    return joinListAsNumber(newList);
                }
            }
            newList.remove(0);
            round++;
        }
        return 0;
    }

    private int getSumOfList(List<Integer> list) {
        int total = 0;
        for(int i: list) {
            total += i;
        }
        return total;
    }

    private int joinListAsNumber(List<Integer> list) {
        StringBuilder sb = new StringBuilder();

        for(int i: list) {
            sb.append(i);
        }

        if(sb.length() == 0) sb.append("0"); //gross, but handles cases where no combination of numbers is divisible by 3

        return Integer.parseInt(sb.toString());
    }

}
