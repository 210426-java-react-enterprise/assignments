package com.revature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public int encodeMessage(List<Integer> message) {
        List<Integer> newList = new ArrayList<>(message);
        Collections.sort(newList);
        int size = newList.size();

        if(message.size() == 1) { //may as well handle this obvious edge case.
            if(message.get(0) % 3 == 0) {
                return message.get(0);
            } else {
                return 0;
            }
        }
        int sum = getSumOfList(newList);
        if(sum % 3 == 0) {
            Collections.reverse(newList);
            return joinListAsNumber(newList);
        }
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
