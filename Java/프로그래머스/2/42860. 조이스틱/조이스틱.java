import java.util.*;

class Solution {
    
    private static int[] counts;
    
    public int solution(String name) {
        int answer = 0, visit = 0, cur = 0, cost = 0, max = 0;
        int[] temp;
        char c;
        counts = new int[name.length()];
        
        for (int i=0; i<name.length(); i++) {
            c = name.charAt(i);
            counts[i] = c - 'A' < ('Z' - c) + 1 ? c - 'A' : ('Z' - c) + 1;
            if (c != 'A') {
                max++;
                answer += counts[i];
            }
        }
        
        return counts[0] > 0 ? dfs(max, 1, answer, 0) : dfs(max, 0, answer, 0);
    }
    
    private int dfs(int max, int visitCount, int count, int cur) {
        int value;
        int temp = counts[cur];
        int left = cur, right = cur, rCount = 0, lCount = 0;
        
        if (visitCount >= max)
            return count;
        
        counts[cur] = 0;
        
        // 왼쪽 방향 가까운 0이 아닌 수 찾기
        while (true) {
            if (counts[left] != 0)
                break;
            left = left - 1 < 0 ? counts.length - 1 : left - 1;
            lCount++;
        }
        
        // 오른쪽 방향 가까운 0이 아닌 수 찾기
        while (true) {
            if (counts[right] != 0)
                break;
            right = right + 1 >= counts.length ? 0 : right + 1;
            rCount++;
        }
        
        value = Math.min(dfs(max, visitCount+1, count+lCount, left), dfs(max, visitCount+1, count+rCount, right));
        
        counts[cur] = temp;
        
        return value;
    }
}