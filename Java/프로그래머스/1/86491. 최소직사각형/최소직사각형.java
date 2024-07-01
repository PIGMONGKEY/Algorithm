import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int h, w, answer = 0;
        
        for (int[] size : sizes) {
            Arrays.sort(size);
        }
        
        Arrays.sort(sizes, (o1, o2) -> {
            if (o1[0] == o2[0])
                return o2[1] - o1[1];
            else
                return o2[0] - o1[0];
        });
        
        h = sizes[0][0];
        
        Arrays.sort(sizes, (o1, o2) -> {
            if (o1[1] == o2[1])
                return o2[0] - o1[0];
            else
                return o2[1] - o1[1];
        });
        
        w = sizes[0][1];
        answer = h*w;
        
        return answer;
    }
}