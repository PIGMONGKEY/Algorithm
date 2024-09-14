import java.util.*;

class Solution {
    
    ArrayList<int[]> list;
    
    public int[][] solution(int n) {
        int[][] answer = {};
        list = new ArrayList<>();
        
        move(n, 1, 3, 2);
        
        answer = new int[list.size()][2];
        
        for (int i=0; i<list.size(); i++)
            answer[i] = list.get(i);
        
        return answer;
    }
    
    private void move(int n, int from, int to, int between) {
        if (n == 1) {
            list.add(new int[] {from, to});
            return;
        }
        
        move(n - 1, from, between, to);
        list.add(new int[] {from, to});
        move(n - 1, between, to, from);
    }
}