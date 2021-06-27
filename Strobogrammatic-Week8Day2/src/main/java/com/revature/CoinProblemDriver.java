package com.revature;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
    
    /*
     * Complete the 'getWays' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. LONG_INTEGER_ARRAY c
     */
    
    public static long getWays(int n, List<Long> c) {
        // Write your code here
        int counter = 0;
        long res = 0;
        
        
        while(n!=0){
            n-=c.get(counter);
            if(c.contains(n)){
                res+=1;
            }
        }
        
        //if n mod c[i] == 0 then n/c[i] = Multiple ---> Multiple*c[i] or Multiple *...*Multiple(c[i] times)
        //base case 0 no change can be made, n =1 should be 1 and so on.
        for (int i = 0; i < c.size() ; i++) {
            if(n%c.get(i)==0){
                res+=1;
            }
            
        }
        
        return 0;
    
    }
    
}

public class CoinProblemDriver {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        
        int n = Integer.parseInt(firstMultipleInput[0]);
        
        int m = Integer.parseInt(firstMultipleInput[1]);
        
        List<Long> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                             .map(Long::parseLong)
                             .collect(toList());
        
        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'
        
        long ways = Result.getWays(n, c);
        
        bufferedWriter.write(String.valueOf(ways));
        bufferedWriter.newLine();
        
        bufferedReader.close();
        bufferedWriter.close();
    }
}
