package commanderLambda;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Lambda {



    public static void main(String[] args) {
        //int[] testInputs = {17};
        List<List<Integer>> answers = new ArrayList<>();


            answers.add(makeSquares(27));
            System.out.println(answers);



    }

    public static List<Integer> makeSquares(int testInput){
        List<Integer> answer = new ArrayList<>();
        int counter = testInput;
        while(counter>0){
            double sqrt = Math.sqrt(counter);
            if(sqrt - Math.floor(sqrt) == 0){
                answer.add(counter);
                counter = testInput - counter;
                testInput = counter;

            }else{
                counter--;

            }
        }
        return answer;


    }



}
