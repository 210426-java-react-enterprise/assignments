package commanderLambda;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Lambda {



    public static void main(String[] args) {
        int[] testInputs = {9, 17, 45, 123, 575};
        List<List<Integer>> answers = new ArrayList<>();

        for(int i = 0; i<testInputs.length; i++){

            answers.add(makeSquares(testInputs[i]));
        }
        for(List answer: answers) {
            System.out.println(answer);
        }

    }

    public static List<Integer> makeSquares(int testInput){
        List<Integer> answer = new ArrayList<>();
        int counter = testInput;
        while(counter>0){
            double sqrt = Math.sqrt(counter);
            if(sqrt - Math.floor(sqrt) == 0){
                answer.add(counter);
                counter = testInput - counter;
            }else{
                counter--;
            }
        }
        return answer;


    }



}
