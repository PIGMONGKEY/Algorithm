import java.util.*;
import java.util.stream.*;

class Solution {
    int[] visited;
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        int min;
        visited = new int[dungeons.length];
        min = Arrays.stream(dungeons)
            .min(Comparator.comparingInt(o -> o[0]))
            .get()[0];
        
        answer = explore(k, dungeons, min, 0);
        
        return answer;
    }
    
    private int explore(int curT, int[][] dungeons, int minT, int count) {
        int maxCount = count;

        if (curT < minT)
            return maxCount;
        
        for (int i=0; i<dungeons.length; i++) {
            if (visited[i] == 1 || curT < dungeons[i][0])
                continue;
            
            visited[i] = 1;
            maxCount = Math.max(maxCount, explore(curT - dungeons[i][1], dungeons, minT, count + 1));
            visited[i] = 0;
        }
        
        return maxCount;
    }
}