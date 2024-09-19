import java.util.*;

class Solution {
    
    // 방문지 기록
    private static boolean[][] isVisited;
    // x좌표 증가
    private static final int[] xiv = {0, 1, 0, -1};
    // y좌표 증가
    private static final int[] yiv = {1, 0, -1, 0};
    
    public int[] solution(String[] maps) {
        int width = maps[0].length();
        int height = maps.length;
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();
        isVisited = new boolean[height][width];
        
        // 모든 칸을 돌면서 섬으로 이어진 곳 찾음
        // x랑 방문한 곳은 제외함
        for (int i=0; i<height; i++) {
            for (int j=0; j<width; j++) {
                if (maps[i].charAt(j) == 'X' || isVisited[i][j])
                    continue;
                
                list.add(findIsland(j, i, width, height, maps));
            }
        }
        
        // 섬이 없을 경우 -1 삽입
        if (list.isEmpty())
            list.add(-1);
            
        answer = new int[list.size()];
        list.sort((o1, o2) -> { return o1 - o2; });

        for (int i=0; i<list.size(); i++)
            answer[i] = list.get(i);
        
        return answer;
    }
    
    // 너비 우선 탐색
    private int findIsland(int x, int y, int width, int height, String[] maps) {
        int day = 0;
        int[] cur;
        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(new int[] {y, x});
        
        while (!queue.isEmpty()) {
            cur = queue.poll();
            
            // 지도를 벗어나거나, x이거나 방문한 곳이면 continue
            if (cur[0] >= height || cur[0] < 0 || cur[1] >= width || cur[1] < 0 
                    || isVisited[cur[0]][cur[1]] 
                    || maps[cur[0]].charAt(cur[1]) == 'X')
                continue;
            
            day += maps[cur[0]].charAt(cur[1]) - '0';
            isVisited[cur[0]][cur[1]] = true;
            
            for (int i=0; i<4; i++)
                queue.add(new int[] {cur[0] + yiv[i], cur[1] + xiv[i]});
        }
        
        return day;
    }
}