import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int min, max, center;
        
        Arrays.sort(citations);
        
        min = 0;
        max = 10000;
        
        while (true) {
            center = (min + max) / 2;
            
            if (center <= min || center >= max)
                break;
            
            if (validate(citations, center)) {
                answer = center;
                min = center;
            } else
                max = center;
        }
        
        return answer;
    }
    
    private boolean validate(int[] citations, int h) {
        int less = 0, more = 0;
        
        for (int i=0; i<citations.length; i++) {
            if (citations[i] >= h) {
                more++;
                continue;
            }
            if (citations[i] <= h)
                less++;
        }
        
        return less <= h && more >= h;
    }
}