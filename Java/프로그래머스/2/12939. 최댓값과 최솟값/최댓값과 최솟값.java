import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        StringBuffer sb = new StringBuffer();
        
        for (String number : s.split(" ")) {
            int n = Integer.parseInt(number);
            if (n > max)
                max = n;
            if (n < min)
                min = n;
        }
        
        sb.append(min);
        sb.append(" ");
        sb.append(max);
        
        answer = sb.toString();
        
        return answer;
    }
}