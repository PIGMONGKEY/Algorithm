import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int max = Arrays.stream(sizes)
            .mapToInt((item) -> {
                return Integer.max(item[0], item[1]);
            })
            .max().getAsInt();
        
        int min = Arrays.stream(sizes)
            .mapToInt((item) -> {
                return Integer.min(item[0], item[1]);
            })
            .max().getAsInt();
        
        answer = max * min;
        
        return answer;
    }
}