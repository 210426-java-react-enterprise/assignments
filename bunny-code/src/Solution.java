import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int solution(List<Integer> plates) {
        return recursivecodeSearch(0, plates);
    }

    private int recursivecodeSearch(int currentPermutation, List<Integer> remaining){
        int codeCandidate = 0;
        if(currentPermutation % 3 == 0) {
            codeCandidate = currentPermutation;
            //System.out.println("DEBUG: Candidate found: " + codeCandidate);
        }
        if(remaining.size() == 0) {
            return codeCandidate;
        }

        for (int i : remaining) {
            int newPermutation = (currentPermutation * 10) + i;
            List<Integer> nowRemaining = new ArrayList<Integer>(remaining);
            nowRemaining.remove((Integer)i);
            int newCandidate = recursivecodeSearch(newPermutation, nowRemaining);
            if(newCandidate > codeCandidate) {
                codeCandidate = newCandidate;
            }
        }

        return codeCandidate;
    }


}
