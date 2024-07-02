import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        int room, line, seat;
        boolean isCovid = false;
        Stack<Character> stack = new Stack<>();
        
        Arrays.fill(answer, 1);
        
        // 방
        for (room=0; room<5; room++) {
            // 줄
            for (line=0; line<5; line++) {
                // 자리
                for (seat=0; seat<5; seat++) {
                    // 사람이 앉아있는 자리 발견
                    if (places[room][line].charAt(seat) == 'P') {
                        if (checkCovid(seat, line, 0, -1, places[room], stack)) {
                            isCovid = true;
                            break;
                        }
                    }
                }
                if (isCovid)
                    break;
            }
            if (isCovid) {
                answer[room]--;
                isCovid = false;
            }
        }
        
        return answer;
    }
    
    boolean checkCovid(int x, int y, int depth, int beforeCode, String[] lines, Stack<Character> stack) {
        // 3칸 이상 움직이면 돌아감
        if (depth > 2)
            return false;
        
        // 방 범위를 벗어나면 return false
        if (x < 0 || x > 4 || y < 0 || y > 4)
            return false;
        
        // 사람 발견하면 사이에 벽이 있는지 확인
        if (lines[y].charAt(x) == 'P' && depth > 0) {
            if (stack.peek() != 'X')
                return true;
        }
        
        // stack에 현재 자리 push
        stack.push(lines[y].charAt(x));
        
        for (int i=0; i<4; i++) {
            // 이전에 온 방향으로 돌아가지 않도록 함
            if (i == (3 - beforeCode))
                continue;
            
            switch (i) {
                case 0:
                    // 우측으로 1칸
                    if (checkCovid(x + 1, y, depth + 1, i, lines, stack))
                        return true;
                    break;
                case 1:
                    // 아래로 1칸
                    if (checkCovid(x, y - 1, depth + 1, i, lines, stack))
                        return true;
                    break;
                case 2:
                    // 위로 1칸
                    if (checkCovid(x, y + 1, depth + 1, i, lines, stack))
                        return true;
                    break;
                case 3:
                    // 좌측으로 1칸
                    if (checkCovid(x - 1, y, depth + 1, i, lines, stack))
                        return true;
                    break;
            }
        }
        
        stack.pop();
        
        return false;
    }
}