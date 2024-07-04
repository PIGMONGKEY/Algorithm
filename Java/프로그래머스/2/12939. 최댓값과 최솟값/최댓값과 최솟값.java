import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] numberStrings = s.split(" ");
        
        Arrays.sort(numberStrings, (o1, o2) -> {
            return Integer.parseInt(o1) - Integer.parseInt(o2);
        });
        
        for (int i=0; i<numberStrings.length; i++) {
            if (i == 0)
                answer += numberStrings[i] + " ";
            if (i == numberStrings.length - 1)
                answer += numberStrings[i];
        }
        
        return answer;
    }
}