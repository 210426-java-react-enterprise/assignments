package com.revature;

import java.util.*;
import java.util.stream.Collectors;

public class CodedMessageDriver {

    public static void main(String[] args) {
        System.out.println(2%3);
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<10;i++){
            if( i%2!=0){
                continue;
            }
            sb.append(i);
        }
        System.out.println(sb);

        /*
            Input: `Solution.solution({3, 1, 4, 1})`
            Output: 4311
            Input: `Solution.solution({3, 1, 4, 1, 5, 9})`
            Output: 94311
            Input: `Solution.solution({4, 4, 1, 1, 1, 3}`
            Output: 4431
         */
        Integer result = solution(new int[]{3, 1, 4, 1, 5, 9});
        System.out.println("Solution is "+result);

    }

    public static Integer solution(int[] plates){

        List<Integer> listPlates = Arrays.stream(plates).boxed().collect(Collectors.toList());

        //sorting, descending order for largest digit first.
        listPlates.sort(Collections.reverseOrder());
        int size = listPlates.size()-1;
        System.out.println("list original"+listPlates);


        //iterate through list and sum them up to check if divible by 3
        //if not chop it off and move on
        for(int i=size; i>=0 ; i--){
            int summation = 0;
            StringBuilder sb = new StringBuilder();
            List<Integer> tmp = new ArrayList<>();
            System.out.println("____________________");
            int reverser = i;
            for(int j = i; j >= 0 ;j--){
                System.out.println(listPlates.get(j));
                tmp.add(listPlates.get(Math.abs(reverser-j)));
                summation += listPlates.get(j);
                sb.append(String.valueOf(listPlates.get(Math.abs(reverser-j))));
            }
            System.out.println("temp list :"+ tmp);

            if(summation%3 == 0) {

                return Integer.parseInt(sb.toString());
            }
        }
        for(int i:listPlates){
            if(i%3==0){
                return i;
            }
        }
        return 0;
    }


}
/*
    Please Pass the Coded Messages
==============================
You need to pass a message to the bunny workers, but to avoid detection, the code you agreed to use is... obscure,
to say the least. The bunnies are given food on standard-issue plates that are stamped with the numbers 0-9 for
easier sorting, and you need to combine sets of plates to create the numbers in the code. The signal that a number
is part of the code is that it is divisible by 3. You can do smaller numbers like 15 and 45 easily, but bigger numbers
like 144 and 414 are a little trickier. Write a program to help yourself quickly create large numbers for use in the
code, given a limited number of plates to work with.
You have L, a list containing some digits (0 to 9). Write a function solution(L) which finds the largest number that
can be made from some or all of these digits and is divisible by 3. If it is not possible to make such a number, return 0 as the solution.
L will contain anywhere from 1 to 9 digits.  The same digit may appear multiple times in the list, but each element in the list may only be used once.
Test cases
==========
Your code should pass the following test cases.
Note that it may also be run against hidden test cases not shown here.


 */