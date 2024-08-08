import java.util.*;

class Solution {
    public int solution(String[] board) {
        int answer = -1;
        
        String line;
        
        int[] cur = {};
        int[] next = {};
        int[] before = {};
        int[] start = new int[3];
        int[] dest = new int[2];
        int[] increaseValue = {1, 0, -1, 0};
        char[][] cBoard = new char[board.length][board[0].length()];
        boolean[][] visited = new boolean[board.length][board[0].length()];
        Queue<int[]> queue = new LinkedList<>();
        
        // character 2차원 배열로 변경
        // 출발지, 목적지 찾아서 저장
        for (int i=0; i<board.length; i++) {
            line = board[i];
            cBoard[i] = line.toCharArray();
            
            for (int j=0; j<cBoard[i].length; j++) {
                if (cBoard[i][j] == 'R') {
                    start[0] = i;
                    start[1] = j;
                }
                if (cBoard[i][j] == 'G') {
                    dest[0] = i;
                    dest[1] = j;
                }
            }
        }
        
        queue.add(start);
        
        // BFS
        while (!queue.isEmpty()) {
            cur = queue.poll();
            
            // 목적지 도착
            if (cur[0] == dest[0] && cur[1] == dest[1])
                return cur[2];
            
            // 이미 방문한 곳 
            if (visited[cur[0]][cur[1]])
                continue;
            
            // 방문 표시
            visited[cur[0]][cur[1]] = true;
            
            // 모든 방향으로 벽이나 장애물에 만날때까지 전진하여 queue에 삽입
            for (int i=0; i<4; i++) {
                before = new int[] {cur[0], cur[1], cur[2]};
                next = new int[] {before[0] + increaseValue[i], before[1] + increaseValue[(i + 1) % 4], before[2]};
                
                while (true) {
                    if (next[0] >= cBoard.length || next[0] < 0 || next[1] < 0 || next[1] >= cBoard[next[0]].length || cBoard[next[0]][next[1]] == 'D')
                        break;
                    
                    before[0] = next[0];
                    before[1] = next[1];
                    before[2] = next[2];
                    next = new int[] {before[0] + increaseValue[i], before[1] + increaseValue[(i + 1) % 4], before[2]};
                }
                
                if (before[0] == cur[0] && before[1] == cur[1])
                    continue;
                
                before[2]++;
                
                queue.add(before);
            }
        }
        
        return answer;
    }
}