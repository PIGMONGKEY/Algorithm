import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int count, answer = 0;
        double x, y;
        boolean flag = false;
        double[] cur = new double[] {characterX, characterY, 0};
        ArrayList<double[]> visited = new ArrayList<>();
        Queue<double[]> queue = new LinkedList<>();
        
        // 1씩 이동하면, 이어진 길이 아닌데도, 점프 느낌으로 건너가기에, 0.7씩 이동함으로써 가는 곳이 길인지 아닌지 판별
        double[] xIncrease = {0.7, 0, -0.7, 0};
        double[] yIncrease = {0, 0.7, 0, -0.7};
        
        queue.offer(cur);
        
        // BFS
        while (!queue.isEmpty()) {
            cur = queue.poll();
            x = cur[0];
            y = cur[1];
            count = (int) cur[2];
            flag = true;
            
            // 이미 방문한 곳인지 확인
            for (double[] visit : visited) {
                if (visit[0] == Math.round(x) && visit[1] == Math.round(y)) {
                    flag = false;
                    break;
                }
            }
            
            if (!flag)
                continue;
            else
                flag = false;
            
            for (int[] rect : rectangle) {
                // 다른 네모 속에 있는지 확인
                if ((x > rect[0] && x < rect[2]) && (y > rect[1] && y < rect[3])) {
                    flag = false;
                    break;
                }
                
                // 테두리인지 확인
                if (Math.round(x) == x && (Math.round(x) == rect[0] || Math.round(x) == rect[2]) && (y >= rect[1] && y <= rect[3]))
                    flag = true;
                
                if (Math.round(y) == y && (Math.round(y) == rect[1] || Math.round(y) == rect[3]) && (x >= rect[0] && x <= rect[2]))
                    flag = true;
            }
            
            if (!flag)
                continue;
            
            // 0.7씩 더하거나 밴 좌표값을 1씩 더하거나 뺀 값으로 변경
            x = Math.round(x);
            y = Math.round(y);
            
            // 방문 리스트에 저장
            visited.add(new double[] {x, y});
            
            // 도착인지 확인
            if (x == itemX && y == itemY)
                return count;
            
            // 이동한 좌표 queue에 삽입
            for (int i=0; i<4; i++)
                queue.offer(new double[] {x + xIncrease[i], y + yIncrease[i], count + 1});
        }
        
        return answer;
    }
}