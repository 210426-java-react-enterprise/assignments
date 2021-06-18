package com.revature.coding;
import java.util.*;
public class SolarDoomsdayProblem {
    public static void main(String[] args){
        int area1 = 12;
        int area2 = 4;
        int area3 = 5;
        int area4 = 15324;

        List<Integer> array1 = new ArrayList<>();
        array1.add(9);
        array1.add(1);
        array1.add(1);
        array1.add(1);
        List<Integer> array2 = new ArrayList<>();
        array2.add(4);
        List<Integer> array3 = new ArrayList<>();
        array3.add(4);
        array3.add(1);
        List<Integer> array4 = new ArrayList<>();
        array4.add(15129);
        array4.add(169);
        array4.add(25);
        array4.add(1);

        System.out.println("Expected1: " + array1);
        System.out.println("Actual1: " + solution(area1));
        System.out.println("Expected2: " + array2);
        System.out.println("Actual2: " + solution(area2));
        System.out.println("Expected3: " + array3);
        System.out.println("Actual3: " + solution(area3));
        System.out.println("Expected4: " + array4);
        System.out.println("Actual4: " + solution(area4));


    }
    public static List<Integer> solution(int area){
        //possible squares range from 1 to 1,000,000
        List<Integer> squares = new ArrayList<>();

        return squares;
    }
}
