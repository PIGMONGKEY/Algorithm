import java.util.*;

class Solution {
    
    public int solution(String[] maps) {
        int lever = 0;
        int end = 0;
        int time = 0;
        int height = maps.length;
        int width = maps[0].length();
        char c;
        
        int[] cur = {};
        int[] next = {};
        int[] increaseValue = {1, 0, -1, 0};
        int[][] places = new int[3][3];
        char[][] maze = new char[height][width];
        boolean[][] isVisited = new boolean[height][width];
        
        Queue<int[]> queue = new LinkedList<>();
        
        // char 2차원 배열에 저장
        for (int i=0; i<height; i++) {
            for (int j=0; j<width; j++) {
                c = maps[i].charAt(j);
                maze[i][j] = c;
                
                switch (c) {
                    case 'S':
                        places[0][0] = i;
                        places[0][1] = j;
                        places[0][2] = 0;
                        break;
                    case 'L':
                        places[1][0] = i;
                        places[1][1] = j;
                        places[1][2] = 0;
                        break;
                    case 'E':
                        places[2][0] = i;
                        places[2][1] = j;
                        places[2][2] = 0;
                        break;
                }
            }
        }
        
        // 레버까지 길 찾기
        queue.add(places[0]);
        
        while (!queue.isEmpty()) {
            cur = queue.poll();
            
            // 미로 범위를 벗어난 경우 continue
            if (cur[0] >= height || cur[0] < 0 || cur[1] >= width || cur[1] < 0)
                continue;
            
            // 벽인 경우 continue
            if (maze[cur[0]][cur[1]] == 'X')
                continue;
            
            // 이미 방문한 곳인 경우 continue
            if (isVisited[cur[0]][cur[1]])
                continue;
            else
                isVisited[cur[0]][cur[1]] = true;
            
            if (cur[0] == places[1][0] && cur[1] == places[1][1]) {
                lever += cur[2];
                end = lever;
                break;
            }
            
            for (int i=0; i<increaseValue.length; i++) {
                next = new int[3];
                next[0] = cur[0] + increaseValue[i];
                next[1] = cur[1] + increaseValue[(i + 1) % increaseValue.length];
                next[2] = cur[2] + 1;
                queue.add(next);
            }
        }
        
        queue.clear();
        
        for (int i=0; i<height; i++)
            Arrays.fill(isVisited[i], false);
        
        // 레버에서 출구까지 길 찾기
        queue.add(places[1]);
        
        while (!queue.isEmpty()) {
            cur = queue.poll();
            
            // 미로 범위를 벗어난 경우 continue
            if (cur[0] >= height || cur[0] < 0 || cur[1] >= width || cur[1] < 0)
                continue;
            
            // 벽인 경우 continue
            if (maze[cur[0]][cur[1]] == 'X')
                continue;
            
            // 이미 방문한 곳인 경우 continue
            if (isVisited[cur[0]][cur[1]])
                continue;
            else
                isVisited[cur[0]][cur[1]] = true;
            
            if (cur[0] == places[2][0] && cur[1] == places[2][1]) {
                end += cur[2];
                break;
            }
            
            for (int i=0; i<increaseValue.length; i++) {
                next = new int[3];
                next[0] = cur[0] + increaseValue[i];
                next[1] = cur[1] + increaseValue[(i + 1) % increaseValue.length];
                next[2] = cur[2] + 1;
                queue.add(next);
            }
        }
        
        queue.clear();
        
        if (lever == 0 || lever == end || end == 0)
            return -1;
        else
            return end;
    }
}