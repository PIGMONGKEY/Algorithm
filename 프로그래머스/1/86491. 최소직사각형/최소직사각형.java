import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int[] answers;
        
        answers = Arrays.stream(sizes)
            .reduce(new int[2], (o1, o2) -> new int[] {
                Math.max(o1[0], Math.max(o2[0], o2[1])), Math.max(o1[1], Math.min(o2[0], o2[1]))
            });
        
        answer = answers[0] * answers[1];
    
        return answer;
    }
}