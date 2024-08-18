import java.util.*;
import java.lang.Thread;

class Solution {
    
    private static char[][] maze;
    private static final int[] increaseValue = {1, 0, -1, 0};
    private static int toLTime;
    private static int toETime;
    
    public int solution(String[] maps) throws InterruptedException {
        int height = maps.length;
        int width = maps[0].length();
        char c;
        
        int[][] places = new int[3][2];
        maze = new char[height][width];
        
        // 시작위치, 레버위치, 출구위치 찾으면서 지도 그리기
        for (int i=0; i<height; i++) {
            for (int j=0; j<width; j++) {
                c = maps[i].charAt(j);
                maze[i][j] = c;
                
                switch (c) {
                    case 'S':
                        places[0][0] = i;
                        places[0][1] = j;
                        break;
                    case 'L':
                        places[1][0] = i;
                        places[1][1] = j;
                        break;
                    case 'E':
                        places[2][0] = i;
                        places[2][1] = j;
                        break;
                }
            }
        }
        
        Thread toLThread = new Thread(() -> {
            toLTime = findShortestPath(places[0], places[1]);
        });
        
        Thread toEThread = new Thread(() -> {
            toETime = findShortestPath(places[1], places[2]);
        });
        
        toLThread.run();
        toEThread.run();
        
        toLThread.join();
        toEThread.join();
        
        return toLTime == -1 || toETime == -1 ? -1 : toLTime + toETime;
    }
    
    private int findShortestPath(int[] start, int[] dest) {
        int height = maze.length;
        int width = maze[0].length;
        
        int[] cur = {start[0], start[1], 0};
        int[] next = {};
        boolean[][] isVisited = new boolean[height][width];
        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(cur);
        
        while (!queue.isEmpty()) {
            cur = queue.poll();
            
            if (cur[0] >= height || cur[0] < 0 || cur[1] >= width || cur[1] < 0)
                continue;
            if (maze[cur[0]][cur[1]] == 'X')
                continue;
            if (isVisited[cur[0]][cur[1]])
                continue;
            
            if (cur[0] == dest[0] && cur[1] == dest[1])
                return cur[2];
            
            isVisited[cur[0]][cur[1]] = true;
            
            for (int i=0; i<4; i++) {
                next = new int[3];
                next[0] = cur[0] + increaseValue[i];
                next[1] = cur[1] + increaseValue[(i + 1) % 4];
                next[2] = cur[2] + 1;
                queue.add(next);
            }
        }
        
        return -1;
    }
}