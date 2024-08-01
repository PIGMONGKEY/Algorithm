import java.util.*;

class Solution {
    
    // 블럭들 각 칸 좌표들을 이어서 저장
    // ex) block1:[0,0][0,1][1,0]
    ArrayList<ArrayList<int[]>> blocks;
    ArrayList<ArrayList<int[]>> emptySpaces;
    boolean[][] visited;
    int[] increaseValue = {1, 0, -1, 0};
    
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0, emptySpacesSize;
        
        // 블럭 저장
        blocks = new ArrayList<>();
        // 빈 칸 저장
        emptySpaces = new ArrayList<>();
        // 방문 체크
        visited = new boolean[table.length][table[0].length];
        // 블럭과 빈 칸 찾을 때 사용할 list
        ArrayList<int[]> temp, space, block;
        
        // table에서 블럭을 찾아서 저장
        for (int i=0; i<table.length; i++) {
            for (int j=0; j<table[i].length; j++) {
                if (visited[i][j] || table[i][j] == 0)
                    continue;
                temp = new ArrayList<>();
                // dfs로 블럭 찾아 temp에 저장
                saveBlockLocation(table, new int[] {i, j}, temp, 0);
                // 첫번째 좌표가 0,0을 향하도록 위치 변경
                makeCertainPointTo00(temp, 0);
                // 블럭 리스트에 추가
                blocks.add(temp);
            }
        }
        
        // visited false로 초기화
        for (boolean[] v : visited)
            Arrays.fill(v, false);
        
        // game_board에서 빈 칸을 찾아 저장
        for (int i=0; i<game_board.length; i++) {
            for (int j=0; j<game_board[i].length; j++) {
                if (visited[i][j] || game_board[i][j] == 1)
                    continue;
                temp = new ArrayList<>();
                // dfs로 빈 칸 찾아 temp에 저장
                saveBlockLocation(game_board, new int[] {i, j}, temp, 1);
                // 첫번째 좌표가 0,0을 향하도록 위치 변경
                makeCertainPointTo00(temp, 0);
                // 빈 칸 리스트에 추가
                emptySpaces.add(temp);
            }
        }
        
//         emptySpaces.forEach(es -> {
//             es.forEach(s -> {
//                 System.out.print(s[0] + " " + s[1] + " / ");
//             });
//             System.out.println();
//         });
        
//         blocks.forEach(es -> {
//             es.forEach(s -> {
//                 System.out.print(s[0] + " " + s[1] + " / ");
//             });
//             System.out.println();
//         });
        
        for (int i=0; i<emptySpaces.size(); i++) {
            space = emptySpaces.get(i);
            for (int j=0; j<blocks.size(); j++) {
                block = blocks.get(j);
                
                if (fitCheck(space, block)) {
                    answer += space.size();
                    blocks.remove(block);
                    break;
                }
            }
        }
        
        return answer;
    }
    
    // dfs로 블럭을 찾아 저장
    void saveBlockLocation(int[][] table, int[] cur, ArrayList<int[]> temp, int isEmptyValue) {
        // table 밖으로 벗어나거나
        // 빈 칸이거나
        // 이미 방문한 곳이라면 return
        if (cur[0] < 0 || cur[0] >= table.length || cur[1] < 0 || cur[1] >= table[0].length || table[cur[0]][cur[1]] == isEmptyValue || visited[cur[0]][cur[1]])
            return;
        
        // 방문 표시
        visited[cur[0]][cur[1]] = true;
        // 블록 칸 저장
        temp.add(cur);
        
        // 다음 칸으로 이동
        for (int i=0; i<4; i++) {
            int[] next = {cur[0] + increaseValue[i], cur[1] + increaseValue[(i + 1) % 4]};
            saveBlockLocation(table, next, temp, isEmptyValue);
        }
    }
    
    // 어떤 블럭 혹은 빈 칸 덩어리의 index 좌표가 0,0을 향하도록 위치 변경
    void makeCertainPointTo00(ArrayList<int[]> block, int index) {
        int[] point = block.get(index);
        int yMove = 0 - point[0];
        int xMove = 0 - point[1];
        
        for (int i=0; i<block.size(); i++) {
            point = block.get(i);
            point[0] += yMove;
            point[1] += xMove;
        }
    }
    
    // 어떤 블럭 혹은 빈 칸 덩어리를 90도 회전 시킴
    // 0,0을 기준으로 회전시킴으로 반드시 makeCertainPointTo00을 실행한 이후에 실행할 것
    void rotate90Degree(ArrayList<int[]> block) {
        int temp;
        int[] point;
        for (int i=0; i<block.size(); i++) {
            point = block.get(i);
            temp = point[0];
            point[0] = 0 - (0 - point[1]);
            point[1] = 0 + (0 - temp);
        }
    }
    
    // 빈 칸에 블럭이 딱 알맞게 들어가는지 확인
    boolean fitCheck(ArrayList<int[]> emptySpace, ArrayList<int[]> block) {
        boolean haveSamePoint = false;
        int[] spacePoint, blockPoint;
        
        // 빈 칸과 블럭의 좌표 길이가 다르면 return false
        if (emptySpace.size() != block.size())
            return false;
        
//         System.out.print("target : ");
//         emptySpace.forEach(b -> {
//             System.out.print(b[0] + " " + b[1] + " / ");
//         });
//         System.out.println();
        
//         System.out.print("origin : ");
//         block.forEach(b -> {
//             System.out.print(b[0] + " " + b[1] + " / ");
//         });
//         System.out.println();
        
        // 블럭의 모든 좌표를 0,0 으로 만들어보면서 확인
        for (int i=0; i<block.size(); i++) {
            makeCertainPointTo00(block, i);
            // 블럭을 90도씩 회전시키면서 확인
            for (int j=0; j<4; j++) {
                // block.forEach(b -> {
                //     System.out.print(b[0] + " " + b[1] + " / ");
                // });
                // System.out.println();
                // 만약 모든 좌표가 일치하면 return true;
                if (haveSamePoints(emptySpace, block))
                    return true;
                rotate90Degree(block);
            }
        }
        
        // 일치하지 않는 좌표가 존재하면 return false;
        return false;
    }
    
    // 빈 칸의 모든 좌표가 블럭에 존재하는지 확인
    // 빈 칸에 있는 좌표가 블럭에 하나라도 없다면 return false
    boolean haveSamePoints(ArrayList<int[]> emptySpace, ArrayList<int[]> block) {
        boolean haveSamePoint = false;
        int[] spacePoint, blockPoint;
        
        for (int i=0; i<emptySpace.size(); i++) {
            spacePoint = emptySpace.get(i);
            for (int j=0; j<block.size(); j++) {
                blockPoint= block.get(j);
                if (spacePoint[0] == blockPoint[0] && spacePoint[1] == blockPoint[1]) {
                    haveSamePoint = true;
                    break;
                }
            }
            
            if (!haveSamePoint)
                return false;
            
            haveSamePoint = false;
        }
        
        return true;
    }
}