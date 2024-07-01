import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int curPrice = 0;
        
        for (int i=0; i<prices.length-1; i++) {
            curPrice = prices[i];
            for (int j=i+1; j<prices.length; j++) {
                answer[i]++;
                if (curPrice > prices[j]) {
                    break;
                }
            }
        }
        
        return answer;
    }
}