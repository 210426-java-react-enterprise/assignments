package com.revature;

import java.util.Scanner;

public class Driver {
    
    
    public static void main(String[] args) {
        System.out.println(1/2);
        System.out.println("Strobogrammatic number: " );
        
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        
        System.out.print(number);
        System.out.println();
        System.out.println("Is it Strobogrammatic: "+isStrobogrammatic(number));
    
    }
    
    public static boolean isStrobogrammatic(String n){
        String[] numStr = n.split("");
        if (numStr.length==0) {
            return false;
        } else if(numStr.length==1 && (numStr[0].equals("1")|| numStr[0].equals("6")|| numStr[0].equals("0")|| numStr[0].equals("8"))|| numStr[0].equals("9")){
            return true;
        }else if(numStr.length==1){
            return false;
        }
        
        for(int i =0; i<numStr.length/2;i++){
            
            String digit1= numStr[i];
            String digit2 = numStr[(numStr.length)-1-i];
            System.out.println(digit1+" "+digit2);
            
            if(digit1.equals("1") && digit2.equals("1")){
                continue;
            }else if(digit1.equals("8") && digit2.equals("8")){
                continue;
            }else if(digit1.equals("0") && digit2.equals("0")){
                continue;
            }else if(digit1.equals("9") && digit2.equals("6")){
                continue;
            }else if(digit1.equals("6") && digit2.equals("9")){
                continue;
            }else{
                return false;
            }
        }
        return true;
        
    }
}

//0, 1, 6, 8, 9


//test cases

 /*
    -- so numbers are 0,1,6,8,9 to check for
        - additionally we can check for pairs of 9 and 6,
        - for others we need to blanket a number with the same ex) 101 or 10801
        
        -- just iterate to the center and match up the numbers iterate half way from the array
        -- we start from the front and back.
    
    -800
    -808
    -96
    -69
    -10801
    
  */
