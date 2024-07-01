import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int x, y;
        int[] answer = {maps[0].length - 1, maps.length - 1};
        int[] cur = {0, 0, 1};
        int[] xIncrease = {0, 1, 0, -1};
        int[] yIncrease = {1, 0, -1, 0};
        int[][] flag = new int[maps.length][maps[0].length];
        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(cur);
        
        while (!queue.isEmpty()) {
            cur = queue.poll();
            
            if (cur[0] < 0 || cur[1] < 0 || cur[0] > answer[0] || cur[1] > answer[1] || flag[cur[1]][cur[0]] > 0 || maps[cur[1]][cur[0]] == 0)
                continue;
            
            if (cur[0] == answer[0] && cur[1] == answer[1])
                return cur[2];
            
            flag[cur[1]][cur[0]]++;
            
            for (int i=0; i<4; i++) {
                x = cur[0] + xIncrease[i];
                y = cur[1] + yIncrease[i];
                
//                 if (x < 0 || y < 0 || x > answer[0] || y > answer[1] || flag[y][x] > 0 || maps[y][x] == 0)
//                     continue;
                
//                 if (x == answer[0] && y == answer[1])
//                     return cur[2] + 1;
                
                queue.add(new int[] {x, y, cur[2] + 1});
            }
        }
        
        return -1;
    }
}