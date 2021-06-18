package com.revature;

public class DoomsDayDriver {
}


/*
    Notes to solve:
        - first note that all large areas are perfect squares #makeSense
            + so we should check up to the square root + 1 of the total area in question
            
            ex)
                total area 12 and the largest square we can make call it x
                    - so then  1<= x <= 12^(1/2) + 1 ------> 1<= x <= 4
                        +1**2 == 1 comparing these values to 12!
                        +2**2 == 4 we can still keep going
                        +3**2 == 9 perfect
                        +4**2 == 16 way to big!
                - so then now we have 12 - 9 = 3
                    - so then 1 <= x <= 3**(1/2) +1 ---> 1<= x <=2
                        + 1**2 == 1 perfect
                        + 2**2 == 4 too big
                        
                - while doing these examples, things to consider
                    + one is a base case
                    + what about a perfect square, if it is a perfect square done
                    + prime numbers will be an issue 
 */

/*

    Solar Doomsday
Who would've guessed? Doomsday devices take a LOT of power. Commander Lambda wants to supplement the LAMBCHOP's
quantum antimatter reactor core with solar arrays, and you've been tasked with setting up the solar panels.
Due to the nature of the space station's outer paneling, all of its solar panels must be squares.
Fortunately, you have one very large and flat area of solar material, a pair of industrial-strength scissors, and
enough MegaCorp Solar Tape(TM) to piece together any excess panel material into more squares.
 For example, if you had a total area of 12 square yards of solar material, you would be able to make one 3x3 square
 panel (with a total area of 9).
 That would leave 3 square yards, so you can turn those into three 1x1 square solar panels.
Write a function solution(area) that takes as its input a single unit of measure representing the total area of solar
panels you have (between 1 and 1000000 inclusive) and
returns a list of the areas of the largest squares you could make out of those panels, starting with the largest squares
 first. So, following the example above, solution(12) would return [9, 1, 1, 1].
Test cases
Create a test suite that includes the below base test cases. Include any others you would like to test your solution against.
Input: 12
Output: [9,1,1,1]
Input: 15324
Output: [15129,169,25,1]
    
    Test Case:
        input: 12 ---> output: [9,1,1,1]
        
        input: 15324 ---> output [15129,169,25,1]
       
       
 */



 