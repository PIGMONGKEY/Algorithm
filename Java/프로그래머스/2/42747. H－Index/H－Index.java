import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0, sum = 0;
        
        int[] memo = new int[10001];
        
        for (int h : citations)
            memo[h]++;
        
        for (int i=10000; i>=0; i--) {
            sum += memo[i];
            
            if (sum >= i) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}