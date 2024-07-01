import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0, sum = 0;
        int[] hCounts = new int[10001];
        
        for (int i=0; i<citations.length; i++)
            hCounts[citations[i]]++;
        
        for (int i=0; i<hCounts.length; i++) {
            sum = 0;
            for (int j=i; j<hCounts.length; j++)
                sum += hCounts[j];
            
            hCounts[i] = sum;
            if (hCounts[i] >= i)
                answer = i;
        }
        
        
        
        return answer;
    }
}